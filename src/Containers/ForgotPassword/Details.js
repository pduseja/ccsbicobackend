import React, {Component} from 'react';
import {states} from './States.js';
import constants from "../../Utils/Constants";

export class Details extends Component {
    constructor(props) {
        super(props);

        this.state = {
            userId: '',
            formErrors: {userId: '', security_question: '', security_answer: ''},
            userIdValid: false,
            security_questionValid: false,
            security_answerValid: false,
            formValid: false

        }
    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({[name]: value},
            () => {
                this.validateField(name, value)
            });
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {userIdValid, security_questionValid, security_answerValid} = this.state;

        switch (fieldName) {
            case 'userId':
                userIdValid = value.length !== 0;
                fieldValidationErrors.userId = userIdValid ? '' : 'Your UserId is required';
                break;
            case 'security_question':
                security_questionValid = value !== 'Select a security question';
                fieldValidationErrors.security_question = security_questionValid ? '' : 'Please choose a security question';
                break;

            case 'security_answer':
                security_answerValid = value.length !== 0;
                fieldValidationErrors.security_answer = security_answerValid ? '' : 'A security answer is required';
                break;
            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            userIdValid: userIdValid,
            security_questionValid: security_questionValid,
            security_answerValid: security_answerValid
        }, this.validateForm);


    };

    validateForm() {
        this.setState({
            formValid: this.state.userIdValid && this.state.security_question && this.state.security_answerValid
        });

    };

    render() {
        let {userId, security_question, security_answer} = this.state.formErrors;
        return (

            <div className="registration-form">
                <span className="title">
						Forgot password
					</span>
                    <div className="col-sm-5 form-group">
                        <label>*User Id</label>
                        <input className="input" type="text" name="userId" placeholder="User id"
                               onChange={this.handleUserInput} value={this.state.userId}/>
                        <p className="error-message">{userId}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Question</label>
                        <select className="input" name="security_question"
                                onChange={this.handleUserInput}>
                            <option>Select a security question</option>
                            {constants.question.map(a => <option
                                value={a.value} key={a.value}>{a.label}</option>)}</select>
                        <p className="error-message">{security_question}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Answer</label>
                        <input className="input" type="text" name="security_answer"
                               onChange={this.handleUserInput}/>
                        <p className="error-message">{security_answer}</p>
                    </div>


                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.props.next(states.RETRIEVE)}
                            disabled={!this.state.formValid}>Next
                    </button>
                </div>

            </div>
        )
    }
}