import React, {Component} from 'react';
import {states} from './States.js';

export class Details extends Component {
    constructor(props) {
        super(props);

        this.state = {
            userId: '',
            formErrors: {userId: ''},
            userIdValid: false,
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

    render() {
        let {userId} = this.state.formErrors;
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
                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.props.next(states.SECURITYQUESTION)}
                            disabled={!this.state.formValid}>Next
                    </button>
                </div>

            </div>
        )
    }
}