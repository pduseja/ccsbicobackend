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
        WebApi.getSecureMessageByUserName(this.props.details.userName).then(response => response.json()).then(response => {
            this.setState({
                messages: response
            })
        })
    }

    onAction = (props) => {
        this.props.history.push({pathname:"/FollowUpMessageForm",data: props.original})

    }

    convertToDate = (systemDate) =>{
        var date = new Date(systemDate);
        return date.toLocaleDateString()
    }

    check = (v) =>{
      const followUpColumns = [{
                        Header: 'Follow up Id',
                        accessor: 'iMessageFollowUpId'
                      },{
                        Header: 'Subject',
                        accessor: 'subject'
      },{
                      Header: 'Message',
                      accessor: 'message'
                    },{
                                      Header: 'Creation date',
                                      Cell: props => <span>{this.convertToDate(props.original.sysDate)}</span>
                                    },
                                    {
                                      Header: 'Message reply',
                                      accessor: 'messageReply'
                                    },

                                  {
                                    Header: 'Read status',
                                    accessor: 'readStatus'
                                  },
                                {
                                  Header: 'Response status',
                                  accessor: 'responseStatus'
                                }];
        return(v.original.iMessageFollowUpList ? <ReactTable
            className="inner-table"
             data={v.original.iMessageFollowUpList}
             columns={followUpColumns}
              showPagination ={false}
             defaultPageSize={v.original.iMessageFollowUpList.length} /> : <div className="not-found">No follow up messages</div>)
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
                Cell: props => <span>{this.convertToDate(props.original.sysDate)}</span>
              },
              {
                Header: 'Message reply',
                accessor: 'messageReply'
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
                             className="outer-table"
                             data={this.state.messages}
                             columns={columns}
                             defaultPageSize={5}
                             SubComponent={(v) =>
                                this.check(v)}
                           />
                  </div>
        </div>)
    }
}

const mapStateToProps = state => ({
    details: state.details
});

export default withRouter(connect(mapStateToProps)(SecureMessages));