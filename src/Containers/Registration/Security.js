import React, {Component} from 'react';
import {states} from './States.js';
import constants from '../../Utils/Constants';
import {connect} from "react-redux";
import WebApi from "../../Utils/WebApi";

export class Security extends Component {
    constructor(props) {
        super(props);
        this.state = {
            confirmPassword: '',
            formData: {UsersDetails:{
                password: '',
                securityQuestionId1: '',
                securityQuestionId2: '',
                securityAnswer1: '',
                securityAnswer2: '',
                memorableWord: ''
            }},
            formErrors: {
                password: '',
                securityQuestionId1: '',
                securityQuestionId2: '',
                securityAnswer1: '',
                securityAnswer2: '',
                memorableWord: ''
            },
            passwordValid: false,
            confirmPasswordValid: false,
            securityQuestionId1Valid: false,
            securityQuestionId2Valid: false,
            securityAnswer1Valid: false,
            securityAnswer2Valid: false,
            memorableWordValid: false,
            formValid: false
        };
    }

    _back = (e) => {
        e.preventDefault();
        this.props.back(states.ADDRESS);
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {passwordValid, confirmPasswordValid, securityQuestionId1Valid, securityQuestionId2Valid, securityAnswer1Valid, securityAnswer2Valid, memorableWordValid} = this.state;
        switch (fieldName) {
            case 'password':
                passwordValid = value.length !== 0;
                fieldValidationErrors.password = passwordValid ? '' : 'Your password is required';
                break;

            case 'confirmPassword':
                confirmPasswordValid = value.length !== 0 && value === this.state.formData.UsersDetails.password;
                fieldValidationErrors.confirmPassword = confirmPasswordValid ? '' : 'Please confirm your password';
                break;

            case 'securityQuestionId1':
                securityQuestionId1Valid = value !== 'Select 1st security question';
                fieldValidationErrors.securityQuestionId1 = securityQuestionId1Valid ? '' : 'Please choose a' +
                    ' security question';
                break;

            case 'securityQuestionId2':
                securityQuestionId2Valid = value !== 'Select 2nd security question';
                fieldValidationErrors.securityQuestionId2 = securityQuestionId2Valid ? '' : 'Please choose' +
                    ' a security question';
                break;

            case 'securityAnswer1':
                securityAnswer1Valid = value.length !== 0;
                fieldValidationErrors.securityAnswer1 = securityAnswer1Valid ? '' : 'A security answer is required';
                break;

            case 'securityAnswer2':
                securityAnswer2Valid = value.length !== 0;
                fieldValidationErrors.securityAnswer2 = securityAnswer2Valid ? '' : 'A security answer is required';
                break;

            case 'memorableWord':
                memorableWordValid = value.length !== 0;
                fieldValidationErrors.memorableWord = memorableWordValid ? '' : 'Your memorable word is required';
                break;

            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            passwordValid: passwordValid,
            confirmPasswordValid: confirmPasswordValid,
            securityQuestionId1Valid: securityQuestionId1Valid,
            securityQuestionId2Valid: securityQuestionId2Valid,
            securityAnswer1Valid: securityAnswer1Valid,
            securityAnswer2Valid: securityAnswer2Valid,
            memorableWordValid: memorableWordValid
        }, this.validateForm);
    };

    validateForm() {
        this.setState({
            formValid: this.state.passwordValid &&
                this.state.confirmPasswordValid &&
                this.state.securityQuestionId1Valid &&
                this.state.securityAnswer1Valid &&
                this.state.securityQuestionId2Valid &&
                this.state.securityAnswer2Valid &&
                this.state.memorableWordValid
        });

    };

    componentDidUpdate = (prevProps) => {
        if(prevProps.data !== this.props.data)
            WebApi.registerUser(this.props.data,this.props.photo);
    };

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({formData:{UsersDetails:{...this.state.formData.UsersDetails,[name]: value}}},
            () => {
                this.validateField(name, value)
            });
    };

    submit = () => {
        this.props.onAdd(this.state.formData);
    };

    render() {
        let {password, confirmPassword, securityQuestionId1, securityQuestionId2, securityAnswer1, securityAnswer2, memorableWord} = this.state.formErrors;
        return (
            <div className="registration-form-step2">
                <div className="col-sm-12 form security">
                    <div className="col-sm-6 form-group">
                        <label>*Password</label>
                        <input className="input" type="password" name="password" onChange={this.handleUserInput}/>
                        <p className="error-message">{password}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Confirm Password</label>
                        <input className="input" type="password" name="confirmPassword"
                               onChange={this.handleUserInput}/>
                        <p className="error-message">{confirmPassword}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Question</label>
                        <select className="input" name="securityQuestionId1"
                                onChange={this.handleUserInput}>
                            <option>Select a security question</option>
                            {constants.question.map(a => <option
                                value={a.value} key={a.value}>{a.label}</option>)}</select>
                        <p className="error-message">{securityQuestionId1}</p>

                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Answer</label>
                        <input className="input" type="text" name="securityAnswer1" onChange={this.handleUserInput}/>
                        <p className="error-message">{securityAnswer1}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Question</label>
                        <select className="input" name="securityQuestionId2"
                                onChange={this.handleUserInput}>
                            <option>Select a security question</option>
                            {constants.question.map(a => <option
                                value={a.value} key={a.value}>{a.label}</option>)}</select>
                        <p className="error-message">{securityQuestionId2}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Answer</label>
                        <input className="input" type="text" name="securityAnswer2" onChange={this.handleUserInput}/>
                        <p className="error-message">{securityAnswer2}</p>
                    </div>


                    <div className="col-sm-6 form-group">
                        <label>*Memorable word</label>
                        <input className="input" type="text" name="memorableWord" onChange={this.handleUserInput}/>
                        <p className="error-message">{memorableWord}</p>
                    </div>
                </div>
                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={this._back}>Back</button>
                    <button className="login-form-btn" disabled={!this.state.formValid}
                            onClick={() => this.submit()}>Submit
                    </button>
                </div>

            </div>
        );
    }
}

const mapStateToProps = state => ({
    data: state.data,
    photo: state.photo
});
const mapDispatchToProps = (dispatch) => ({
    onAdd: (data) => dispatch({ type: 'ADD_DATA', text: data })
});
export default connect(mapStateToProps,mapDispatchToProps)(Security);



