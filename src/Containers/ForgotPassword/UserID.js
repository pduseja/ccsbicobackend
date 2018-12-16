import React, {Component} from 'react';
import {states} from './States.js';
import WebApi from "../../Utils/WebApi";

export class UserID extends Component {
    constructor(props) {
        super(props);

        this.state = {
            userId: '',
            formErrors: {userId: ''},
            userIdValid: false,
            formValid: false,
            error: ''
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
        let {userIdValid} = this.state;

        switch (fieldName) {
            case 'userId':
                userIdValid = value.length !== 0;
                fieldValidationErrors.userId = userIdValid ? '' : 'Your UserId is required';
                break;
            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            userIdValid: userIdValid,
        }, this.validateForm);

    };

    validateForm() {
        this.setState({
            formValid: this.state.userIdValid
        });

    };

    checkUserExists = () =>{
        WebApi.getDataFromUserId(this.state.userId).then(response => response.json()
        ).then(response => {
            this.setState({error: ''},()=>{
                this.props.next(states.SECURITYQUESTION,response,this.state.userId)
            })
        }).catch(() => {
            this.setState({error: "User does not exist"})
        });

    };

    render() {
        let {userId} = this.state.formErrors;
        return (

            <div className="registration-form forgot-password">
                <span className="title">
						Forgot password
					</span>
                <span className="error-msg error-message">{this.state.error}</span>
                    <div className="col-sm-5 form-group">
                        <label>*User Id</label>
                        <input className="input" type="text" name="userId" placeholder="User id"
                               onChange={this.handleUserInput} value={this.state.userId}/>
                        <p className="error-message">{userId}</p>
                    </div>
                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.checkUserExists()}
                            disabled={!this.state.formValid}>Next
                    </button>
                </div>

            </div>
        )
    }
}