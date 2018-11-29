import React, {Component} from 'react';
import '../../Styles/Login.css'
import {Link} from "react-router-dom";

export default class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            pass: '',
            formErrors: {email: '', pass: ''},
            emailValid: false,
            passValid: false,
            formValid: false
        }
    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        this.setState({[name]: value},
            () => {
                this.validateField(name, value)
            });
    };

    validateForm = () => {
        this.setState({formValid: this.state.emailValid && this.state.passValid});
    };

    handleClick = () => {
        console.log("login successful")
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {emailValid, passValid} = this.state;
        switch (fieldName) {
            case 'email':
                emailValid = value.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
                fieldValidationErrors.email = emailValid ? '' : 'Email is invalid';
                break;

            case 'pass':
                passValid = value.length !== 0;
                fieldValidationErrors.pass = passValid ? '' : 'Password is required';
                break;

            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            emailValid: emailValid,
            passValid: passValid,
        }, this.validateForm);
    };

    render() {
        let {email, pass} = this.state.formErrors;
        return (
            <div className="form-container">
                <div className="wrapper">

                    <div className="login-form">
					<span className="title">
						Member Login
					</span>

                        <div className="wrap-input">
                            <input className="input" type="text" name="email" placeholder="Email"
                                   onChange={this.handleUserInput} value={this.state.email}/>
                            <span className="focus-input"/>
                            <span className="symbol-input">
							<i className="fa fa-envelope" aria-hidden="true"/>
						</span>
                        </div>
                        <p className="error-message">{email}</p>

                        <div className="wrap-input validate-input">
                            <input className="input" type="password" name="pass" placeholder="Password"
                                   onChange={this.handleUserInput} value={this.state.pass}/>
                            <span className="focus-input"/>
                            <span className="symbol-input">
							<i className="fa fa-lock" aria-hidden="true"/>
						</span>
                        </div>
                        <p className="error-message">{pass}</p>
                        <div className="wrap-input remember-me">
                            <label><input type="checkbox" name="rememberMe" />Remember me</label>
                        </div>
                        <div className="container-login-form-btn">
                            <button className="login-form-btn" disabled={!this.state.formValid} onClick={() => this.handleClick()}>
                                Login
                            </button>
                        </div>

                        <div className="text-center space-top-10">
						<span className="gray-text space-right-10">
							Forgot
						</span>
                            <Link to="/forgotPassword" className="black-text">
                                Username / Password?
                            </Link>
                        </div>

                        <div className="text-center space-top-50">
                            <Link to="/registration" className="black">
                                Create your Account
                                <i className="fa fa-long-arrow-right" aria-hidden="true"/>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}