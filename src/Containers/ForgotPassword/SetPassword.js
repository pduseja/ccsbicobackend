import React, {Component} from 'react';
import WebApi from "../../Utils/WebApi";
import {Link} from "react-router-dom";

export class SetPassword extends Component {
    constructor(props) {
        super(props);
        console.log(this.props,"set")
        this.state = {
            password: '',
            confirmPassword: '',
            formErrors: {password: '', confirmPassword: ''},
            passwordValid: false,
            confirmPasswordValid: false,
            formValid: false,
            info: false

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
        let {passwordValid, confirmPasswordValid} = this.state;

        switch (fieldName) {
            case 'password':
                passwordValid = value.length !== 0;
                fieldValidationErrors.password = passwordValid ? '' : 'Please enter a new password; '+
                		'Password should be at least 8 characters with 1 Capital Alphabet and 1 Special character';
                break;

            case 'confirmPassword':
                confirmPasswordValid = value.length !== 0 && value === this.state.password;
                fieldValidationErrors.confirmPassword = confirmPasswordValid ? '' : 'Please confirm your password';
                break;
            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            passwordValid: passwordValid,
            confirmPasswordValid: confirmPasswordValid
        }, this.validateForm);


    };

    validateForm() {
        this.setState({
            formValid: this.state.passwordValid && this.state.confirmPasswordValid
        });

    };

    submit = () => {
        WebApi.changeUserPassword(this.props.userId, this.state.password).then(() =>{
            this.setState({info: true,error:''})
        }).catch(()=>{
            this.setState({
                error: "There seems some issue please contact administrator"
            })
        })
    };

    render() {
        let {password, confirmPassword} = this.state.formErrors;
        return (

            <div className="registration-form forgot-password">
                <span className="title">
						Reset password
					</span>
                {this.state.info && <span className="info">Password changed successfully.Please <Link to="/login">login</Link></span>}
                <span className="error-msg error-message">{this.state.error}</span>
                <div className="col-sm-6 form-group">
                    <label>*Password</label>
                </div>
                <div className="col-sm-6 form-group">
                    <input className="input" type="password" name="password"
                           onChange={this.handleUserInput}/>
                    <p className="error-message">{password}</p>
                </div>
                <div className="col-sm-6 form-group">
                    <label>*Confirm Password</label>
                </div>
                <div className="col-sm-6 form-group">
                    <input className="input" type="password" name="confirmPassword"
                           onChange={this.handleUserInput}/>
                    <p className="error-message">{confirmPassword}</p>
                </div>

                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.submit()}
                            disabled={!this.state.formValid}>Submit
                    </button>
                </div>

            </div>
        )
    }
}