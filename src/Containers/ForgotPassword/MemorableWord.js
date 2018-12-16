import React, {Component} from 'react';
import {states} from './States.js';

export class Retrieve extends Component {
    constructor(props) {
        super(props);
        console.log("retrieve", props)
        const lengthOfWord = this.props.data.memorableWord.length;
        this.state = {
            memorable_char1: '',
            memorable_char2: '',
            randomNumber1: Math.floor(Math.random() * lengthOfWord),
            randomNumber2: Math.floor(Math.random() * lengthOfWord),
            formErrors: {memorable_char1: '',memorable_char2: ''},
            memorable_char1Valid: false,
            memorable_char2Valid: false,
            formValid: false
        };
    }

    _next = () => {
        this.props.next(states.RETRIEVE);
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {memorable_char1Valid,memorable_char2Valid} = this.state;
        switch (fieldName) {

            case 'memorable_char1':
                memorable_char1Valid = value.length !== 0;
                fieldValidationErrors.memorable_char1 = memorable_char1Valid ? '' : 'Please enter the required detail';
                break;
            case 'memorable_char2':
                memorable_char2Valid = value.length !== 0;
                fieldValidationErrors.memorable_char2 = memorable_char2Valid ? '' : 'Please enter the required detail';
                break;
            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            memorable_char1Valid: memorable_char1Valid,
            memorable_char2Valid: memorable_char2Valid
        }, this.validateForm);
    };

    validateForm() {
        this.setState({
            formValid: this.state.memorable_char1Valid && this.state.memorable_char2Valid
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

    checkMemorableWordCharacter = () => {
        let {randomNumber1,randomNumber2} = this.state;
        if(this.props.data.memorableWord[randomNumber1] !== this.state.memorable_char1 ||
            this.props.data.memorableWord[randomNumber2] !== this.state.memorable_char2
        ){
            this.setState({error: 'Please verify your answers'});
        }
        else{
            console.log("set password")
            this.setState({error: ''})
            //this.props.next(states.RETRIEVE)
        }
    };

    getOrdinal_suffix_of(i) {
        let j = i % 10,
            k = i % 100;
        if (j === 1 && k !== 11) {
            return i + "st";
        }
        if (j === 2 && k !== 12) {
            return i + "nd";
        }
        if (j === 3 && k !== 13) {
            return i + "rd";
        }
        return i + "th";
    }

    render() {
        let {memorable_char1,memorable_char2} = this.state.formErrors;
        let {randomNumber1,randomNumber2} = this.state;
        let character1 = this.getOrdinal_suffix_of(randomNumber1+1)
        let character2 = this.getOrdinal_suffix_of(randomNumber2+1)
        return (
            <div className="registration-form forgot-password">
                                <span className="title">
						Forgot password
					</span>
                <span className="error-msg error-message">{this.state.error}</span>
                <div className="col-sm-6 form-group">
                    <label>*Enter the {character1} character of your Memorable word</label>
                    <input className="input" type="text" name="memorable_char1" onChange={this.handleUserInput}/>
                    <p className="error-message">{memorable_char1}</p>
                </div>
                <div className="col-sm-6 form-group">
                    <label>*Enter the {character2} character of your Memorable word</label>
                    <input className="input" type="text" name="memorable_char2" onChange={this.handleUserInput}/>
                    <p className="error-message">{memorable_char2}</p>
                </div>


                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.checkMemorableWordCharacter(randomNumber1,randomNumber2)}
                            disabled={!this.state.formValid}>Submit
                    </button>
                </div>

            </div>
        );
    }
}