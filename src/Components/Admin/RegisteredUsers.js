import React,{ Component } from 'react';
import WebApi from "../../Utils/WebApi";
import ReactTable from "react-table";
import 'react-table/react-table.css'

export default class PendingUsers extends Component{
    state={
        response: []
    }
    componentDidMount(){
        WebApi.getApprovedUsers().then(response => response.json()).then(response => {
        console.log(response)
            this.setState({
                response: response
            })
        })
    }

    onAction = (props) => {
        console.log("called",props)
    }

    onDelete = (props) => {
        console.log("called",props)
    }

    render(){
       const columns = [{
         Header: 'UserId',
         accessor: 'userId'
       },
       {
         Header: 'Name',
         accessor: 'userName'
       },
       {
         Header: 'Gender',
         accessor: 'gender'
      },
      {
         Header: 'Date of Birth',
         accessor: 'dateofbirth'
      },
      {
         Header: 'Nationality',
         accessor: 'nationality'
      },
      {
        Header: 'Action',
        Cell: props => <button onClick={() => this.onAction(props)}>Assign Role</button>
    },

     {
       Header: 'Delete',
       Cell: props => <button onClick={() => this.onDelete(props)}>Delete</button>
     }]
        return(
            <div>
                <h5>Registered Users</h5>
               <ReactTable
                 data={this.state.response}
                 columns={columns}
                 defaultPageSize={5}
               /></div>
        )
    }
}