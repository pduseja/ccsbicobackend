import React,{ Component } from 'react';
import WebApi from "../../Utils/WebApi";
import ReactTable from "react-table";
import 'react-table/react-table.css'
import {withRouter} from "react-router-dom";

export class PendingUsers extends Component{
    state={
        response: []
    }
    componentDidMount(){
        WebApi.getPendingUsers().then(response => response.json()).then(response => {
            this.setState({
                response: response
            })
        })
    }

    getUsers = () => {
        WebApi.getPendingUsers().then(response => response.json()).then(response => {
                this.setState({
                    response: response
                })
            })
    }

    onAction = (props) => {
        this.props.history.push({pathname:"/EditRole",data: props.original})

    }

    onDelete = (props) => {
        let data = {
            userName: props.original.userName
        }
        WebApi.deleteUser(data).then(response => {
            this.getUsers();
        })
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
            <h5>Pending Users</h5>
               <ReactTable
                 data={this.state.response}
                 columns={columns}
                 defaultPageSize={5}
               /></div>
        )
    }
}

export default withRouter(PendingUsers)