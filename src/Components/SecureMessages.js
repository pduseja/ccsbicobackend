import React from 'react'
import WebApi from "../Utils/WebApi";
import connect from "react-redux/es/connect/connect";
import ReactTable from "react-table";
import {withRouter} from "react-router-dom";

export class SecureMessages extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            messages: []
        }
    }

    componentDidMount(){
        WebApi.getSecureMessageByUserName("RC100038").then(response => response.json()).then(response => {
            this.setState({
                messages: response
            })
        })
    }

    onAction = (props) => {
        this.props.history.push({pathname:"/FollowUpMessageForm",data: props.original})

    }

    render(){
        const columns = [{
                 Header: 'Id',
                 accessor: 'iMessageId'
               },
               {
                 Header: 'Department',
                 accessor: 'department'
               },
               {
                Header: 'Subject',
                accessor: 'subject'
              },
               {
               Header: 'Message',
               accessor: 'message'
             },
             {
                Header: 'Creation date',
                accessor: 'sysDate'
              },
              {
                Header: 'Message status',
                accessor: 'messageStatus'
              },

            {
              Header: 'Read status',
              accessor: 'readStatus'
            },
          {
            Header: 'Response status',
            accessor: 'responseStatus'
          },
          {
            Header: 'Follow up',
            Cell: props => <button className="action" onClick={() => this.onAction(props)}>Follow up</button>
          }
               ];
        return(<div className="common-wrapper">
                  <div className="full-wrapper">
                      <h5 className="title-color">Secure Messages</h5>
                           <ReactTable
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

export default withRouter(connect(mapStateToProps)(SecureMessages));