import React, {Component} from 'react';
import {connect} from "react-redux";
import WebApi from "../../Utils/WebApi";
import {withRouter} from "react-router-dom";

export class Security extends Component {
    constructor(props) {
        super(props);
        this.state = {
            securityQuestions: [],
            securityQuestionId1: '',
            securityQuestionId2: '',
            confirmPassword: '',
            formData: {
            userName:'',
            UsersDetails:{
                securityQuestionId1: '',
                securityQuestionId2: '',
                securityAnswer1: '',
                securityAnswer2: '',
                memorableWord: ''
            }},
            formErrors: {
                securityQuestionId1: '',
                securityQuestionId2: '',
                securityAnswer1: '',
                securityAnswer2: '',
                memorableWord: ''
            },
            securityQuestionId1Valid: false,
            securityQuestionId2Valid: false,
            securityAnswer1Valid: false,
            securityAnswer2Valid: false,
            memorableWordValid: false,
            formValid: false
        };
    }

     componentDidMount() {
        let mandatoryFields = ["securityQuestionId1Valid", "securityQuestionId2Valid",
                 "securityAnswer1Valid",
                 "securityAnswer2Valid",
                 "memorableWordValid","formValid"];

             mandatoryFields.forEach(fields => {
                 this.setState({[fields]: true})
             });
        WebApi.getSecurityQuestions().then(response => response.json()).then(response => {
            this.setState({...this.state,
                securityQuestions: response,
                securityQuestionIdStr1: this.props.details.UsersDetails.securityQuestionIdStr1,
                securityQuestionIdStr2: this.props.details.UsersDetails.securityQuestionIdStr2,
                formData : {
                    userName:this.props.details.userName,
                    UsersDetails: {
                    securityQuestionId1: this.props.details.UsersDetails.securityQuestionId1,
                    securityQuestionId2: this.props.details.UsersDetails.securityQuestionId2,
                    securityAnswer1: this.props.details.UsersDetails.securityAnswer1,
                    securityAnswer2: this.props.details.UsersDetails.securityAnswer2,
                    memorableWord: this.props.details.UsersDetails.memorableWord
                }}
            })
        })
    }

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {securityQuestionId1Valid, securityQuestionId2Valid, securityAnswer1Valid, securityAnswer2Valid, memorableWordValid} = this.state;
        switch (fieldName) {
            case 'securityQuestionId1':
                securityQuestionId1Valid = value !== 'Select 1st security question';
                fieldValidationErrors.securityQuestionId1 = securityQuestionId1Valid ? '' : 'Please choose a security question';
                break;

            case 'securityQuestionId2':
                securityQuestionId2Valid = value !== 'Select 2nd security question';
                fieldValidationErrors.securityQuestionId2 = securityQuestionId2Valid ? '' : 'Please choose a security question';
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
                memorableWordValid = value.length >= 10;
                fieldValidationErrors.memorableWord = memorableWordValid ? '' : 'Memorable word is must for registration and should atleast be 10 characters long';
                break;

            default:
                break;
        }
        this.setState({...this.state,
            formErrors: fieldValidationErrors,
            securityQuestionId1Valid: securityQuestionId1Valid,
            securityQuestionId2Valid: securityQuestionId2Valid,
            securityAnswer1Valid: securityAnswer1Valid,
            securityAnswer2Valid: securityAnswer2Valid,
            memorableWordValid: memorableWordValid
        }, this.validateForm);
    };

    validateForm() {
        this.setState({...this.state,
            formValid:
                this.state.securityQuestionId1Valid &&
                this.state.securityAnswer1Valid &&
                this.state.securityQuestionId2Valid &&
                this.state.securityAnswer2Valid &&
                this.state.memorableWordValid
        });

    };

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({...this.state,formData:{...this.state.formData,UsersDetails:{...this.state.formData.UsersDetails,[name]: value}}},
            () => {
                this.validateField(name, value)
            });
    };

    handleChangeSecurityQuestion = (e,id) =>{
        const name = e.target.name;
        const value = e.target.value;
        this.setState({[name]:value})
        const questionId = this.state.securityQuestions[id].filter(q => q.hintQuestion === value)[0].securityQuestionId
        this.setState({...this.state,["securityQuestionIdStr"+(id+1)]: value, formData:{...this.state.formData,
        UsersDetails:{...this.state.formData.UsersDetails,[name]: questionId  }}},
        ()=>{
               this.validateField(name, value)
        });
    };

    submit = () => {
        WebApi.editSecurity(this.state.formData).then(response => response.json()).then(response => {
            this.props.history.push("/Profile");
        })
    };

    back = () => {
        this.props.history.push("/Profile");
    };

    render() {
        let {securityQuestionId1, securityQuestionId2, securityAnswer1, securityAnswer2, memorableWord} = this.state.formErrors;
        let {securityQuestions} = this.state;

        return (
         <div className="form-container">
            <div className="wrapper">
            <div className="registration-form-step2">
                <div className="col-sm-12 form security">

                    <div className="col-sm-6 form-group">
                        <label>*Security Question</label>
                        <select className="input" name="securityQuestionId1"
                                onChange={(e) => this.handleChangeSecurityQuestion(e,0)} value={this.state.securityQuestionIdStr1}>
                            {securityQuestions[0] && securityQuestions[0].map(a => <option
                                value={a.hintQuestion} key={a.securityQuestionId}>{a.hintQuestion}</option>)}</select>
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
                                onChange={(e) => this.handleChangeSecurityQuestion(e,1)} value={this.state.securityQuestionIdStr2}>
                            {securityQuestions[1] && securityQuestions[1].map(a => <option
                                value={a.hintQuestion} key={a.securityQuestionId}>{a.hintQuestion}</option>)}</select>
                        <p className="error-message">{securityQuestionId2}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Security Answer</label>
                        <input className="input" type="text" name="securityAnswer2" value={this.state.formData.UsersDetails.securityAnswer2} onChange={this.handleUserInput}/>
                        <p className="error-message">{securityAnswer2}</p>
                    </div>


                    <div className="col-sm-6 form-group">
                        <label>*Memorable word</label>
                        <input className="input" type="text" name="memorableWord" value={this.state.formData.UsersDetails.memorableWord} onChange={this.handleUserInput}/>
                        <p className="error-message">{memorableWord}</p>
                    </div>
                </div>
                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={()=> this.back()}>Back</button>
                    <button className="login-form-btn" disabled={!this.state.formValid}
                            onClick={() => this.submit()}>Submit
                    </button>
                </div>
            </div>

            </div>
            </div>
        );
    }
}

const mapStateToProps = state => ({
    details: state.details
});

export default withRouter(connect(mapStateToProps)(Security));



