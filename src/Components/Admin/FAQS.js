import React,{ Component } from 'react';
import WebApi from "../../Utils/WebApi";
import ReactTable from "react-table";
import 'react-table/react-table.css'
import RTE from './RTE'
import ReactHtmlParser from 'react-html-parser';

export default class FAQS extends Component{
    state={
        response: [],
        question: '',
        answer: '',
    }
    componentDidMount(){
        this.getFaqs();
    }

    getFaqs = () => {
        WebApi.getFaqs().then(response => response.json()).then(response => {
            this.setState({
                response: response
            })
        })
    }

    onEdit = (props) => {
        console.log("called",ReactHtmlParser(props.original.question))
    }

    onDelete = (props) => {
        console.log("called",props)
    }


  onChange = (value) => {
    this.setState({value});
    this.props.handleChange(value.toString('html'), this.props.type);
  };
    handleChange = (data, type) => {
        this.setState({...this.state,
            [type]: data
        })
    }

    handleSave = () => {
        const data = {
            "id": 0,
            "question": this.state.question,
            "answer": this.state.answer,
            "status": "A"
        }
         WebApi.saveFaqs(data).then(() => {
         this.setState({
                             question: 'question',
                             answer: 'answer',
                         })
            this.getFaqs();

         })
    }

    enableSave = () => {
        return !(this.state.question.length && this.state.answer.length);
    }

    render(){
       const columns = [{
         Header: 'Id',
         accessor: 'id'
       },
       {
         Header: 'Question',
         Cell: props => ReactHtmlParser(props.original.question)
       },
       {
         Header: 'Answer',
         Cell: props => ReactHtmlParser(props.original.answer)
      },
      {
         Header: 'Status',
         accessor: 'status'
      },
      {
        Header: 'Action',
        Cell: props => <button onClick={() => this.onAction(props)}>Edit</button>
    },

     {
       Header: 'Delete',
       Cell: props => <button onClick={() => this.onDelete(props)}>Delete</button>
     }]
        return(
            <div>
               <ReactTable
                 data={this.state.response}
                 columns={columns}
                 defaultPageSize={5}
               />
                <RTE type="question" handleChange={this.handleChange} value={this.state.question}/>
                <RTE type="answer"  handleChange={this.handleChange} value={this.state.answer}/>
                <button onClick={this.handleSave} disabled={this.enableSave()}>Save</button>
               </div>

        )
    }
}