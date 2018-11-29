import React, {Component} from 'react';
import {states} from './States.js';

export class Retrieve extends Component {
    constructor(props) {
        super(props);
        this.state = {
            memorable_word: '',
            formErrors: {memorable_word: ''},
            memorable_wordValid: false,
            formValid: false
        };
    }

    _next = () => {
        this.props.next(states.RETRIEVE);
    };

    _back = () => {
        this.props.back(states.DETAILS)
    };

    handleSelect = (key) => {
        this.setState({key});
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {memorable_wordValid} = this.state;
        switch (fieldName) {

            case 'memorable_word':
                memorable_wordValid = value.length !== 0;
                fieldValidationErrors.memorable_word = memorable_wordValid? '' : 'Your memorable word is required';
                break;

            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            memorable_wordValid: memorable_wordValid
        }, this.validateForm);
    };

    validateForm() {
        this.setState({
            formValid: this.state.memorable_wordValid
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

    render() {
        let {memorable_word} = this.state.formErrors;
        return (
            <div className="registration-form-step2">
                <div className="col-sm-6 form-group">
                    <label>*Memorable word</label>
                    <input className="input" type="text" name="memorable_word" onChange={this.handleUserInput}/>
                    <p className="error-message">{memorable_word}</p>
                </div>


                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={this._back}>Back</button>
                    <button className="login-form-btn" onClick={() => this.props.next(states.RETRIEVE)}
                            disabled={!this.state.formValid}>Submit
                    </button>
                </div>

            </div>
        );
    }
}