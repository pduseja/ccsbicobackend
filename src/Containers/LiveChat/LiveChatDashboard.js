import React from 'react'
import WebApi from "../../Utils/WebApi";
import connect from "react-redux/es/connect/connect";
import ReactTable from "react-table";
import {withRouter} from "react-router-dom";
import Constants from "../../Utils/Constants";

export class LiveChatDashboard extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            messages: []

        }

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
        let popup = window.open('/ChatWindow','_blank',"width=500,height=500")
        popup.data = props;
        popup.currentUser = this.props.details.userName;
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

                  </div>
        </div>)
    }
}

const mapStateToProps = state => ({
    details: state.details
});

export default withRouter(connect(mapStateToProps)(LiveChatDashboard));