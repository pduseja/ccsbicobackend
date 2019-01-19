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
        eraseQuestion: false,
        eraseAnswer: false
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

    onUpdate = (props) => {
        this.setState({...this.state,
            question: props.original.question,
            answer: props.original.answer,
            q: props.original.question,
            a: props.original.answer,
            id: props.original.id
        })
    }

    onDelete = (props) => {

    }

    handleSave = () => {
        const data = {
            "id": this.state.id || 0,
            "question": this.state.question,
            "answer": this.state.answer,
            "status": "A"
        }
         if(this.state.id)
            WebApi.updateFaqs(data).then(() => {
                this.getFaqs();
                this.setState({...this.state,
                eraseQuestion: true,
                eraseAnswer: true,
                id: ''
              })
         })
         else{
            WebApi.saveFaqs(data).then(() => {
                this.getFaqs();
                this.setState({...this.state,
                eraseQuestion: true,
                eraseAnswer: true
            })
         })
         }
    }

    enableSave = () => {
        return !(this.state.question.replace(/<[^>]+>/g, '').length && this.state.answer.replace(/<[^>]+>/g, '').length);
    }

    onChange = (value,type) =>{
        this.setState({...this.state,
            [type]: value,
            eraseQuestion: false,
            eraseAnswer: false
        })
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
        Cell: props => <button onClick={() => this.onUpdate(props)}>Edit</button>
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
                <RTE onChange={this.onChange} type="question" shouldErase={this.state.eraseQuestion} value={this.state.q}/>
                <RTE onChange={this.onChange} type="answer" shouldErase={this.state.eraseAnswer} value={this.state.a}/>
                <button onClick={this.handleSave} disabled={this.enableSave()}>Save</button>
               </div>

        )
    }
}