import React from 'react';
import constants from '../../Utils/Constants';
import connect from "react-redux/es/connect/connect";
import WebApi from "../../Utils/WebApi";
import {withRouter} from "react-router-dom";
import '../../Styles/MessageForm.css'
export class SecureMessageForm extends React.Component{
    constructor(props){
        super(props)
        this.state={
            formData:{
                title: '',
                firstName: '',
                lastName: '',
                department: '',
                subject: '',
                message: '',
                userName: '',
                email: '',
                mobile: '',
                isExistingCustomer: '',
                methodOfContact: '',
                serviceRef: '',
                followUpTicketId: 1,
                fileattached: 'N',
                wasSignedIn: 'N',
                responseStatus:'N',
                messageStatus:'N',
                readStatus:'N',
                crBy:''
            },
            formErrors: {
                title: '',
                firstName: '',
                lastName: '',
                department: '',
                subject: '',
                message: '',
                userName: '',
                email: '',
                mobile: '',
                isExistingCustomer: '',
                methodOfContact: ''
            },
            titleValid: false,
            fnameValid: false,
            snameValid: false,
            departmentValid: false,
            subjectValid: false,
            messageValid: false,
            userNameValid: true,
            isExistingCustomerValid: false,
            mobileValid: true,
            emailValid: true,
            methodOfContactValid: false,
            formValid: false
        }
    }
    componentDidMount(){
        let data = this.props.details ? this.props.details : "";
        let userSignedIn = Object.keys(data).length !== 0 && data.constructor === Object;
        if(userSignedIn){
        this.setState({...this.state,
            titleValid: true,
            fnameValid: true,
            snameValid: true,
            isExistingCustomerValid:true,
            userNameValid:true,
            formData: {...this.state.formData,
            wasSignedIn: "Y",
            crBy: data.userName,
            userName: data.userName,
            isExistingCustomer: "Y",
            title: data.title,
            firstName: data.firstName,
            lastName: data.lastName
            }
        })
        }

    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({formData: {...this.state.formData, [name]: value}},
            () => {
                this.validateField(name, value)
            });
    };

    validateForm() {
        this.setState({
            formValid: this.state.titleValid && this.state.fnameValid && this.state.snameValid && this.state.departmentValid &&
             this.state.subjectValid && this.state.messageValid && this.state.userNameValid && this.state.isExistingCustomerValid &&
             this.state.emailValid && this.state.mobileValid && this.state.methodOfContactValid
        });

    };

    submit = () =>{
        WebApi.addNewServiceRequest(this.state.formData,this.state.filePreviewUrl, (err, response)=>{

            if(err){ throw err}
            this.props.history.push({pathname:"/UserCreated",data: response})
        })
    }



        validateField(fieldName, value) {
            let fieldValidationErrors = this.state.formErrors;
            let {titleValid, fnameValid, snameValid, departmentValid, subjectValid, messageValid, userNameValid, isExistingCustomerValid,
            emailValid, mobileValid, methodOfContactValid } = this.state;
            switch (fieldName) {
                case 'title':
                    titleValid = value !== "Select your title";
                    fieldValidationErrors.title = titleValid ? '' : 'Your title is required';
                    break;

                case 'firstName':
                    fnameValid = value.length !== 0 && /^([a-zA-Z']*)$/.test(value);
                    fieldValidationErrors.firstName = fnameValid ? '' : 'Your name is invalid';
                    break;

                case 'lastName':
                    snameValid = value.length !== 0 && /^([a-zA-Z']*)$/.test(value);
                    fieldValidationErrors.lastName = snameValid ? '' : 'Your last name is invalid';
                    break;

                case 'department':
                    departmentValid = value !== "Select the department";
                    fieldValidationErrors.department = departmentValid ? '' : 'Please select a department';
                    break;

                case 'subject':
                    subjectValid = value !== "Select a subject";
                    fieldValidationErrors.subject = subjectValid ? '' : 'Please select a subject';
                    break;

                case 'message':
                    messageValid = value.length !== 0;
                    fieldValidationErrors.message = messageValid ? '' : 'Please add a description';
                    break;

                case 'isExistingCustomer':
                    if(value === "Yes"){
                        userNameValid = false
                    }
                    else{
                        userNameValid = true
                    }
                    isExistingCustomerValid = true

                    break;

                case 'userName':
                    userNameValid = value.length !== 0
                    fieldValidationErrors.userName = userNameValid ? '' : 'Your userName is required';
                break;

                case 'methodOfContact':
                    if(value === "email"){
                        emailValid = false
                        mobileValid = true
                    }
                    else{
                        mobileValid = false
                        emailValid = true
                    }
                    methodOfContactValid = true

                    break;

                case 'email':
                    emailValid = value.length !== 0
                    fieldValidationErrors.email = emailValid ? '' : 'Your Email id is required';
                break;

                case 'mobile':
                    mobileValid = value.length !== 0
                    fieldValidationErrors.mobile = mobileValid ? '' : 'Your Mobile number is required';
                break;

                default:
                    break;
            }
            this.setState({
                ...this.state,
                formErrors: fieldValidationErrors,
                titleValid: titleValid,
                fnameValid: fnameValid,
                snameValid: snameValid,
                departmentValid: departmentValid,
                subjectValid: subjectValid,
                messageValid: messageValid,
                userNameValid: userNameValid,
                isExistingCustomerValid: isExistingCustomerValid,
                emailValid: emailValid,
                mobileValid: mobileValid,
                methodOfContactValid: methodOfContactValid
            }, this.validateForm);


        };

        handleImageChange = (e) => {

                e.preventDefault();

                let reader = new FileReader();
                let file = e.target.files[0];
                    reader.onloadend = () => {

                    this.setState({
                        file: file,
                        filePreviewUrl: reader.result
                    });
                };
                reader.readAsDataURL(file)
            };

    render(){
        let {title, firstName, lastName, userName, department, subject, message, mobile, email} = this.state.formErrors;
        let {filePreviewUrl} = this.state;
        let $filePreview = null;
        if (filePreviewUrl) {
            $filePreview = (<div className="file-container"><i class="fa fa-file" aria-hidden="true"></i>
<p>{this.state.file.name}</p></div>);
        }
        return(<div className="form-container">
        <div className="wrapper">
                    <div className="registration-form">
                        <span className="title">
        					Secure Message
        				</span>
        				<div className="wrap-input">
                            <div className="col-sm-2 form-group">
                                <label>*Title</label>
                                <select className="input" name="title" value={this.state.formData.title}
                                        onChange={this.handleUserInput}>
                                    <option>Select your title</option>
                                    {constants.title.map(a =>
                                        <option
                                            key={a.value} value={a.value}>{a.label}</option>)}</select>
                                <p className="error-message">{title}</p>
                            </div>
                            <div className="col-sm-5 form-group">
                                <label>*Name</label>
                                <input className="input" type="text" name="firstName" placeholder="First name"
                                       onChange={this.handleUserInput} value={this.state.formData.firstName}/>
                                <p className="error-message">{firstName}</p>
                            </div>

                            <div className="col-sm-5 form-group">
                                <label>*Last Name</label>
                                <input className="input" type="text" name="lastName" placeholder="Last name"
                                       onChange={this.handleUserInput} value={this.state.formData.lastName}/>
                                <p className="error-message">{lastName}</p>
                            </div>
                        </div>
                        <div className="wrap-input">
                            <div className="col-sm-6">
                                <label>*Department</label>
                                  <select className="input" name="department" value={this.state.formData.department}
                                      onChange={this.handleUserInput}>
                                  <option>Select the department</option>
                                  {constants.departments.map(a =>
                                      <option
                                          key={a.value} value={a.value}>{a.label}</option>)}
                                    </select>
                                  <p className="error-message">{department}</p>
                            </div>
                        </div>

                        <div className="wrap-input">
                            <div className="col-sm-6 form-group">
                             <label>*Are you an existing customer?</label>
                                <div>
                                <label htmlFor="yes">
                                <input type="radio"
                                     name="isExistingCustomer"
                                     value="Y"
                                     id="yes"
                                     checked={this.state.formData.isExistingCustomer === "Y"}
                                     onChange={this.handleUserInput}

                                />Yes</label>
                            <label htmlFor="No">
                            <input type="radio"
                                   name="isExistingCustomer"
                                   id="no"
                                   checked={this.state.formData.isExistingCustomer === "N"}
                                   onChange={this.handleUserInput}
                                   value="N"/>No</label>
                                   </div>
                                </div>
                        </div>
                        {this.state.formData.isExistingCustomer === "Y" &&
                        <div className="wrap-input">
                            <div className="col-sm-5 form-group">
                                <label>*UserName</label>
                                <input className="input" type="text" name="userName" placeholder="Username"
                                       onChange={this.handleUserInput} value={this.state.formData.userName}/>
                                <p className="error-message">{userName}</p>
                            </div>
                         </div>

                        }

                        <div className="wrap-input">
                            <div className="col-sm-6 form-group">
                             <label>*Method of contact</label>
                                <div>
                                <label htmlFor="email">
                                <input type="radio"
                                     name="methodOfContact"
                                     value="email"
                                     id="email"
                                     checked={this.state.formData.methodOfContact === "email"}
                                     onChange={this.handleUserInput}

                                />Email</label>
                            <label htmlFor="mobile">
                            <input type="radio"
                                   name="methodOfContact"
                                   id="mobile"
                                   checked={this.state.formData.methodOfContact === "mobile"}
                                   onChange={this.handleUserInput}
                                   value="mobile"/>Mobile</label>
                                   </div>
                                </div>
                        </div>
                        {this.state.formData.methodOfContact === "email" &&
                        <div className="wrap-input">
                            <div className="col-sm-5 form-group">
                                <label>*Email id</label>
                                <input className="input" type="text" name="email" placeholder="Email id"
                                       onChange={this.handleUserInput} value={this.state.formData.email}/>
                                <p className="error-message">{email}</p>
                            </div>
                         </div>

                        }
                        {this.state.formData.methodOfContact === "mobile" &&
                        <div className="wrap-input">
                            <div className="col-sm-5 form-group">
                                <label>*Mobile</label>
                                <input className="input" type="text" name="mobile" placeholder="Mobile"
                                       onChange={this.handleUserInput} value={this.state.formData.mobile}/>
                                <p className="error-message">{mobile}</p>
                            </div>
                         </div>

                        }

                        <div className="wrap-input">
                            <div className="col-sm-6">
                                <label>*Subject</label>
                                  <select className="input" name="subject" value={this.state.formData.subject}
                                      onChange={this.handleUserInput}>
                                  <option>Select a subject</option>
                                  {constants.subject.map(a =>
                                      <option
                                          key={a.value} value={a.value}>{a.label}</option>)}
                                    </select>
                                  <p className="error-message">{subject}</p>
                            </div>
                        </div>
                        <div className="wrap-input">
                            <div className="col-sm-6">
                                <label>*Details Message</label>
                                <textarea className="input" name="message" value={this.state.formData.message}
                                 onChange={this.handleUserInput} />
                            <p className="error-message">{message}</p>
                            </div>
                        </div>
                        <div className="col-sm-3 form-group">
                                                <label>Upload file
                                                    <div id="upload_button">
                                                        <label>
                                                            <input type="file" id="upload-photo" onChange={this.handleImageChange}/>
                                                            <i className="fa fa-upload"/>
                                                        </label>

                                                    </div>
                                                </label>

                                                {$filePreview}
                                            </div>
                        <div className="container-login-form-btn">
                            <button className="login-form-btn" onClick={() => this.submit()}
                                    disabled={!this.state.formValid}>Next
                            </button>
                        </div>
        			</div>

        </div>
        </div>)

    }
}

const mapStateToProps = state => ({
    details: state.details
});

export default withRouter(connect(mapStateToProps)(SecureMessageForm));