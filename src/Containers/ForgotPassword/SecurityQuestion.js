import React, {Component} from 'react';
import {states} from './States.js';

export class SecurityQuestion extends Component {
    constructor(props) {
        super(props);
        this.state = {
            formErrors: {security_answer1: '', security_answer2: ''},
            security_answer1Valid: false,
            security_answer2Valid: false,
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
        let {security_answer1Valid, security_answer2Valid} = this.state;

        switch (fieldName) {
            case 'security_answer1':
                security_answer1Valid = value.length !== 0;
                fieldValidationErrors.security_answer1 = security_answer1Valid ? '' : 'Please enter an answer';
                break;

            case 'security_answer2':
                security_answer2Valid = value.length !== 0;
                fieldValidationErrors.security_answer2 = security_answer2Valid ? '' : 'Please enter an answer';
                break;
            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            security_answer1Valid: security_answer1Valid,
            security_answer2Valid: security_answer2Valid
        }, this.validateForm);


    };

    validateForm() {
        this.setState({
            formValid: this.state.security_answer1Valid && this.state.security_answer2Valid
        });

    };

    checkSecurityQuestions = () => {
        if (this.state.security_answer1 !== this.props.data.securityAnswer1 ||
            this.state.security_answer2 !== this.props.data.securityAnswer2) {
            this.setState({error: 'Please verify your answers'});
        } else {
            this.props.next(states.MEMORABLEWORD, this.props.data, this.props.userId)
        }
    };

    render() {
        let {security_answer1, security_answer2} = this.state.formErrors;
        return (

            <div className="registration-form forgot-password">
                <span className="title">
						Forgot password
					</span>
                <span className="error-msg error-message">{this.state.error}</span>
                <div className="col-sm-6 form-group">
                    <label>*Please answer the following Security Question</label>
                    <p>{this.props.data.securityQuestionIdStr1}</p>
                </div>
                <div className="col-sm-6 form-group">
                    <input className="input" type="text" name="security_answer1"
                           onChange={this.handleUserInput}/>
                    <p className="error-message">{security_answer1}</p>
                </div>
                <div className="col-sm-6 form-group">
                    <p>{this.props.data.securityQuestionIdStr2}</p>
                </div>
                <div className="col-sm-6 form-group">
                    <input className="input" type="text" name="security_answer2"
                           onChange={this.handleUserInput}/>
                    <p className="error-message">{security_answer2}</p>
                </div>

                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.checkSecurityQuestions()}
                            disabled={!this.state.formValid}>Next
                    </button>
                </div>

            </div>
        )
    }
}