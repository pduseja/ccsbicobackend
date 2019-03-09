import React from 'react'
import WebApi from "../../Utils/WebApi";
import connect from "react-redux/es/connect/connect";
import ReactTable from "react-table";
import {withRouter} from "react-router-dom";
import Constants from "../../Utils/Constants";
import moment from 'moment';
import { myFirestore } from '../../Utils/MyFirebase'
import images from '../Chat/Themes/Images'
import { AppString } from './../Chat/Const'
import NewWindow from 'react-new-window'

export class LiveChatDashboard extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            messages: [],
            showWindowPortal: false

        }
        this.listMessage = []
        this.groupChatId = null
        this.removeListener = null
    }
    componentDidMount(){

        const department = Constants.profiles[this.props.details.profileId]
        WebApi.getChatRequestByDepartment(department).then(response => response.json()).then(response => {
            this.setState({...this.state,
                messages: response
            })
        })
    }
      toggleWindowPortal = (props) => {

          this.setState({
            ...this.state,
            showWindowPortal: !this.state.showWindowPortal,
            currentUserId: this.props.details.userName,
            currentPeerUser : props.original.userName
          },()=> {
            this.getListHistory(props);
          });


        }

          getListHistory = (props) => {
          console.log("state", this.state)
           let {currentUserId, currentPeerUser} = this.state
            if (this.removeListener) {
              this.removeListener()
            }
            this.listMessage.length = 0
            this.setState({ isLoading: true })
            if (
              this.hashString(currentUserId) <=
              this.hashString(currentPeerUser)
            ) {
              this.groupChatId = `${currentUserId}-${currentPeerUser}`
            } else {
              this.groupChatId = `${currentPeerUser}-${currentUserId}`
            }

            // Get history and listen new data added
            this.removeListener = myFirestore
              .collection(AppString.NODE_MESSAGES)
              .doc(this.groupChatId)
              .collection(this.groupChatId)
              .onSnapshot(
                snapshot => {
                  snapshot.docChanges().forEach(change => {
                    if (change.type === AppString.DOC_ADDED) {
                      this.listMessage.push(change.doc.data())
                    }
                  })
                  this.setState({ isLoading: false })
                },
                err => {
                  this.props.showToast(0, err.toString())
                }
              )
          }

        onSendMessage = (content, type) => {

          const timestamp = moment()
            .valueOf()
            .toString()

          const itemMessage = {
            idFrom: this.state.currentUserId,
            idTo: this.state.currentPeerUser,
            timestamp: timestamp,
            content: content.trim(),
            type: type
          }

          myFirestore
            .collection(AppString.NODE_MESSAGES)
            .doc(this.groupChatId)
            .collection(this.groupChatId)
            .doc(timestamp)
            .set(itemMessage)
            .then(() => {
              this.setState({ inputValue: '' })
            })
            .catch(err => {
              this.props.showToast(0, err.toString())
            })
        }

          hashString = str => {
            let hash = 0
            for (let i = 0; i < str.length; i++) {
              hash += Math.pow(str.charCodeAt(i) * 31, str.length - i)
              hash = hash & hash // Convert to 32bit integer
            }
            return hash
          }


    renderListMessage = () => {
        let viewListMessage = []

        return viewListMessage;
    }
    render(){
      const columns = [{
                    Header: 'Chat Id',
                    accessor: 'liveChatId'
                  },
                  {
                    Header: 'Name',
                    Cell: props => <span>{props.original.firstName}{props.original.lastName}</span>
                  },
                  {
                    Header: 'Queue',
                    accessor: 'queue'
                  },
                  {
                    Header: 'Reply',
                    Cell: props => <button className="action" onClick={() => this.toggleWindowPortal(props)}>Start Chat</button>
                  }
             ];
        return(<div className="common-wrapper">
                  <div className="full-wrapper">
                      <h5 className="title-color">Live Chat Dashboard</h5>
                         <ReactTable
                              className="outer-table"
                              data={this.state.messages}
                              columns={columns}
                              defaultPageSize={5}

                            />

                  {this.state.showWindowPortal && (<NewWindow>
                        <div className="viewChatBoard">
                            <div className="viewListContentChat">
                              {this.renderListMessage()}

                            </div>
                           <div className="viewBottom">
                             <input
                               className="viewInput"
                               placeholder="Type your message..."
                               value={this.state.inputValue}
                               onChange={event => {
                                 this.setState({ inputValue: event.target.value })
                               }}
                               onKeyPress={this.onKeyboardPress}
                             />
                             <img
                               className="icSend"
                               src={images.ic_send}
                               alt="icon send"
                               onClick={() => this.onSendMessage(this.state.inputValue, 0)}
                             />
                           </div>

                           {/* Loading */}

                         </div></NewWindow>)}

                  </div>
        </div>)
    }
}

const mapStateToProps = state => ({
    details: state.details
});

export default withRouter(connect(mapStateToProps)(LiveChatDashboard));