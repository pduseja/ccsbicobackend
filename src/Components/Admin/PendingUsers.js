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

    convertToDate = (systemDate) =>{
        var date = new Date(systemDate);
        return date.toLocaleDateString()
    }

    render(){
       const columns = [{
         Header: 'Username',
         accessor: 'userName'
       },
       {
         Header: 'Name',
         Cell: props => <span style={{textTransform: 'capitalize'}}>{props.original.firstName+" "+props.original.lastName}</span>

       },
       {
         Header: 'Gender',
         accessor: 'gender'
      },
      {
         Header: 'Date of Birth',
         Cell: props => <span>{this.convertToDate(props.original.dateofbirth)}</span>
      },
      {
         Header: 'Nationality',
         accessor: 'nationality'
      },
      {
        Header: 'Action',
        Cell: props => <button className="action" onClick={() => this.onAction(props)}>Assign Role</button>
    },

     {
       Header: 'Delete',
       Cell: props => <button className="danger" onClick={() => this.onDelete(props)}>Delete</button>
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