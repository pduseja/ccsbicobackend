import React, {Component} from 'react';
import '../../Styles/Login.css'
import {Link} from "react-router-dom";
import WebApi from "../../Utils/WebApi";
import {connect} from "react-redux";
import {addUserName} from "../../Actions/Actions";

export class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            pass: '',
            rememberMe: false,
            formErrors: {email: '', pass: ''},
            emailValid: false,
            passValid: false,
            formValid: false,
            error: ''
        }
    }
    componentDidMount(){
        document.title = "Login"
    }
    handleUserInput = (event) => {
        const name = event.target.name;
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        this.setState({[name]: value},
            () => {
                this.validateField(name, value)
            });
    };

    validateForm = () => {
        this.setState({formValid: this.state.emailValid && this.state.passValid});
    };

    handleClick = () => {
        let {email, pass, rememberMe} = this.state;
        WebApi.getLoginUser(email, pass, rememberMe).then(response => response.json()
        ).then(response => {
            if (response.UsersLoginRecord.rememberMe === true) {
                document.cookie = `token=${response.UsersLoginRecord.token}; expires=${response.cookieExpirytime}`;
                document.cookie = `cookie=${response.UsersLoginRecord.cookie}; expires=${response.cookieExpirytime}`;
            }
            else{
                let res = document.cookie;
                let multiple = res.split(";");
                for(let i = 0; i < multiple.length; i++) {
                    let key = multiple[i].split("=");
                    document.cookie = key[0]+" =; expires = Thu, 01 Jan 1970 00:00:00 UTC";
                }
            }
            this.props.history.push('/');
            this.setState({error: ''})
            this.props.dispatch(addUserName(response.firstName))
        }).catch(() => {
            this.setState({error: "User does not exist"})
        });
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {emailValid, passValid} = this.state;
        switch (fieldName) {
            case 'email':
                emailValid = value.length >= 8;
                fieldValidationErrors.email = emailValid ? '' : 'Username is invalid';
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
                        <div className="block-error">{this.state.error}</div>
                        <div className="wrap-input">
                            <input className="input" type="text" name="email" placeholder="User id"
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
                            <label><input onChange={this.handleUserInput} value={this.state.rememberMe} type="checkbox"
                                          name="rememberMe"/>Remember me</label>
                        </div>
                        <div className="container-login-form-btn">
                            <button className="login-form-btn" disabled={!this.state.formValid}
                                    onClick={() => this.handleClick()}>
                                Login
                            </button>
                        </div>

                        <div className="text-center space-top-10">
                            <Link to="/forgotPassword" className="black-text">
                                Forgot Password
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

export default connect()(Login);