import React, {Component} from 'react';
import {states} from './States.js';
import constants from '../../Utils/Constants';

export class Security extends Component {
    constructor(props) {
        super(props);
        this.state = {
            password: '',
            confirm_password: '',
            security_question: '',
            security_answer: '',
            memorable_word: '',
            formErrors: {password: '', confirm_password: '', security_question: '', security_answer: '', memorable_word: ''},
            passwordValid: false,
            confirm_passwordValid: false,
            security_questionValid: false,
            security_answerValid:false,
            memorable_wordValid: false,
            formValid: false
        };
    }

    _back = (e) => {
        e.preventDefault();
        this.props.back(states.ADDRESS);
    };

    _validate = (e) => {
        e.preventDefault();

        this.props.next(this.props.nextState);
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {passwordValid, confirm_passwordValid, security_questionValid, security_answerValid, memorable_wordValid} = this.state;
        switch (fieldName) {

            case 'password':
                passwordValid = value.length !== 0;
                fieldValidationErrors.password = passwordValid ? '' : 'Your password is required';
            break;

            case 'confirm_password':
                confirm_passwordValid = value.length !== 0;
                fieldValidationErrors.confirm_password = confirm_passwordValid ? '' : 'Please confirm you password';
            break;

            case 'security_question':
                security_questionValid = value !== 'Select a security question';
                fieldValidationErrors.security_question = security_questionValid ? '' : 'Please choose a security question';
            break;

            case 'security_answer':
                security_answerValid = value.length !== 0;
                fieldValidationErrors.security_answer = security_answerValid ? '' : 'A security answer is required';
            break;

            case 'memorable_word':
                memorable_wordValid = value.length !== 0;
                fieldValidationErrors.memorable_word = memorable_wordValid? '' : 'Your memorable word is required';
                break;

            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            passwordValid: passwordValid,
            confirm_passwordValid: confirm_passwordValid,
            security_questionValid: security_questionValid,
            security_answerValid: security_answerValid,
            memorable_wordValid: memorable_wordValid
        }, this.validateForm);
    };

    validateForm() {
        this.setState({
            formValid: this.state.passwordValid && this.state.confirm_passwordValid && this.state.security_questionValid
            && this.state.security_answerValid && this.state.memorable_wordValid
        });

    };

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({[name]: value},
            () => {
                this.validateField(name, value)
            });
    };

    submit = () => {
        console.log("Registered")
    };

    render() {
        let { password, confirm_password, security_question, security_answer, memorable_word  } = this.state.formErrors;
        return (
            <div className="registration-form-step2">
                <div className="col-sm-12 form security">
                    <div className="col-sm-6 form-group">
                        <label>*Password</label>
                        <input className="input" type="password" name="password" onChange={this.handleUserInput}/>
                        <p className="error-message">{password}</p>
                    </div >
                    <div className="col-sm-6 form-group">
                        <label>*Confirm Password</label>
                        <input className="input" type="password" name="confirm_password"
                               onChange={this.handleUserInput}/>
                        <p className="error-message">{confirm_password}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Question</label>
                        <select className="input" name="security_question"
                                onChange={this.handleUserInput}><option>Select a security question</option>
                            {constants.question.map(a => <option
                            value={a.value} key={a.value}>{a.label}</option>)}</select>
                        <p className="error-message">{security_question}</p>
                    </div>

                    <div className="col-sm-6 form-group">
                        <label>*Security Answer</label>
                        <input className="input" type="text" name="security_answer" onChange={this.handleUserInput}/>
                        <p className="error-message">{security_answer}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Memorable word</label>
                        <input className="input" type="text" name="memorable_word" onChange={this.handleUserInput}/>
                        <p className="error-message">{memorable_word}</p>
                    </div>
                </div>
                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={this._back}>Back</button>
                    <button className="login-form-btn" disabled={!this.state.formValid} onClick={() => this.submit()}>Submit</button>
                </div>

            </div>
        );
    }
}



