import React from 'react'
import WebApi from "../../Utils/WebApi";
import moment from 'moment';
import { myFirestore } from '../../Utils/MyFirebase'
import images from '../Chat/Themes/Images'
import { AppString } from './../Chat/Const'

export default class ChatWindow extends React.Component{


        constructor(props){
            super(props)
            this.state={
                inputValue: '',
                currentUserId: window.currentUser,
                currentPeerUser: window.data.original.userName
            }
            this.listMessage = []
            this.groupChatId = null
            this.removeListener = null
        }

        componentDidMount(){
            this.getListHistory()
              WebApi.startNewChat(window.currentUser, window.data.original.userName, window.data.original.department)
                    .then(response => response.json()).then(response => {
              this.setState({
                ...this.state,
                currentUserId: window.currentUser,
                currentPeerUser : window.data.original.userName
              },()=> {
                this.getListHistory();
                 console.log("didmount", this.state )
              });
            })

        }
  componentWillReceiveProps(newProps) {
    if (newProps.currentPeerUser) {
      this.setState({...this.state,currentPeerUser: newProps.currentPeerUser})
      this.getListHistory()
    }
  }
        getListHistory = () => {

                    let {currentUserId,currentPeerUser} = this.state;
                    if (this.removeListener) {
                      this.removeListener()
                    }
                    this.listMessage.length = 0
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
                        },
                        err => {
                          this.props.showToast(0, err.toString())
                        }
                      )
          }

        onSendMessage = (content, type) => {
           let {currentUserId,currentPeerUser} = this.state;

            if (
              this.hashString(currentUserId) <=
              this.hashString(currentPeerUser)
            ) {
              this.groupChatId = `${currentUserId}-${currentPeerUser}`
            } else {
              this.groupChatId = `${currentPeerUser}-${currentUserId}`
            }
          const timestamp = moment()
            .valueOf()
            .toString()
          const itemMessage = {
            idFrom: currentUserId,
            idTo: currentPeerUser,
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
              this.setState({...this.state, inputValue: '' })
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

            isLastMessageLeft(index) {
            if (
              (index + 1 < this.listMessage.length &&
                this.listMessage[index + 1].idFrom === this.currentUserId) ||
              index === this.listMessage.length - 1
            ) {
              return true
            } else {
              return false
            }
            }

      isLastMessageRight(index) {
        if (
          (index + 1 < this.listMessage.length &&
            this.listMessage[index + 1].idFrom !== this.currentUserId) ||
          index === this.listMessage.length - 1
        ) {
          return true
        } else {
          return false
        }
      }

    renderListMessage = () => {
              let viewListMessage = []
              console.log("renderMessage", this.listMessage)
              this.listMessage.forEach((item, index) => {
                if (item.idFrom === this.state.currentUserId) {
                  // Item right (my message)
                  if (item.type === 0) {
                    viewListMessage.push(
                      <div className="viewItemRight" key={item.timestamp}>
                        <span className="textContentItem">{item.content}</span>
                      </div>
                    )
                  } else if (item.type === 1) {
                    viewListMessage.push(
                      <div className="viewItemRight2" key={item.timestamp}>
                        <img
                          className="imgItemRight"
                          src={item.content}
                          alt="content message"
                        />
                      </div>
                    )
                  }
                } else {
                  // Item left (peer message)
                  if (item.type === 0) {
                    viewListMessage.push(
                      <div className="viewWrapItemLeft" key={item.timestamp}>
                        <div className="viewWrapItemLeft3">

                            <div className="viewPaddingLeft" />

                          <div className="viewItemLeft">
                            <span className="textContentItem">{item.content}</span>
                          </div>
                        </div>
                        {this.isLastMessageLeft(index) ? (
                          <span className="textTimeLeft">
                            {moment(Number(item.timestamp)).format('ll')}
                          </span>
                        ) : null}
                      </div>
                    )
                  } else if (item.type === 1) {
                    viewListMessage.push(
                      <div className="viewWrapItemLeft2" key={item.timestamp}>
                        <div className="viewWrapItemLeft3">

                            <div className="viewPaddingLeft" />
                          <div className="viewItemLeft2">
                            <img
                              className="imgItemLeft"
                              src={item.content}
                              alt="content message"
                            />
                          </div>
                        </div>
                        {this.isLastMessageLeft(index) ? (
                          <span className="textTimeLeft">
                            {moment(Number(item.timestamp)).format('ll')}
                          </span>
                        ) : null}
                      </div>
                    )
                  } else {
                    viewListMessage.push(
                      <div className="viewWrapItemLeft2" key={item.timestamp}>
                        <div className="viewWrapItemLeft3">

                            <div className="viewPaddingLeft" />
                        </div>
                        {this.isLastMessageLeft(index) ? (
                          <span className="textTimeLeft">
                            {moment(Number(item.timestamp)).format('ll')}
                          </span>
                        ) : null}
                      </div>
                    )
                  }
                }
              })
              console.log(viewListMessage, "Render")
              return viewListMessage
    }

    render(){

        return(
            <div className="viewChatBoard" >
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
            </div>

        )
    }
}