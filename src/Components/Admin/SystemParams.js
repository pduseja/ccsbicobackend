import React,{ Component } from 'react';
import WebApi from "../../Utils/WebApi";
import ReactTable from "react-table";
import 'react-table/react-table.css'

export default class SystemParams extends Component{
    state={
        response: []
    }
    componentDidMount(){
        WebApi.getSystemParams().then(response => response.json()).then(response => {
            this.setState({
                response: response.filter(r => r.active === "Y")
            })
        })
    }
    render(){
       const columns = [{
         Header: 'Id',
         accessor: 'id'
       },
       {
         Header: 'KeyValue1',
         accessor: 'keyVal1'
       },
       {
         Header: 'KeyValue2',
         accessor: 'keyVal2'
      },
      {
         Header: 'KeyValue3',
         accessor: 'keyVal3'
      },
      {
         Header: 'KeyValue4',
         accessor: 'keyVal4'
      },
      {
         Header: 'KeyValue5',
         accessor: 'keyVal5'
      },
     {
       Header: 'Param1',
       accessor: 'param1'
     },
     {
       Header: 'Param2',
       accessor: 'param2'
    },
    {
       Header: 'Param3',
       accessor: 'param3'
    },
    {
       Header: 'Param4',
       accessor: 'param4'
    },
    {
       Header: 'Param5',
       accessor: 'param5'
    }]
        return(
            <div>

                   <ReactTable
                     data={this.state.response}
                     columns={columns}
                     defaultPageSize={10}
                   /></div>
        )
    }
}