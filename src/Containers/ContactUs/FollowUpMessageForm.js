import React from 'react';
import constants from '../../Utils/Constants';
import WebApi from "../../Utils/WebApi";
import {withRouter} from "react-router-dom";
import '../../Styles/MessageForm.css'
export class SecureMessageForm extends React.Component{
    constructor(props){
        super(props)
        this.state={
            formData:{
                iMessageId: '',
                userName: '',
                IMessageFollowUpList:[{
                subject: '',
                message: '',
                email: '',
                mobile: '',
                methodOfContact: '',
                fileattached: 'N',
                wasSignedIn: 'Y',
                responseStatus:'N',
                messageStatus:'N',
                readStatus:'N',
                crBy:''}]
            },
            formErrors: {
                subject: '',
                message: '',
                email: '',
                mobile: '',
                methodOfContact: ''
            },
            subjectValid: false,
            messageValid: false,
            mobileValid: true,
            emailValid: true,
            methodOfContactValid: false,
            formValid: false
        }
    }
    componentDidMount(){
        let data = this.props.location.data;
        this.setState({...this.state,
            formData: {...this.state.formData,
            iMessageId: data.iMessageId,
            userName: data.userName

            }
        })


    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        let a = this.state.formData.IMessageFollowUpList[0];
        a[name] = value;
        this.setState({...this.state,IMessageFollowUpList:a},
            () => {
                this.validateField(name, value)
                console.log(this.state)
            });
    };

    validateForm() {
        this.setState({
             formValid: this.state.subjectValid && this.state.messageValid &&
             this.state.emailValid && this.state.mobileValid && this.state.methodOfContactValid
        });

    };

    submit = () =>{
        WebApi.addFollowUpMessage(this.state.formData,this.state.filePreviewUrl, (err, response)=>{

            if(err){ throw err}
            this.props.history.push({pathname:"/UserCreated",data: response})
        })
    }



        validateField(fieldName, value) {
            let fieldValidationErrors = this.state.formErrors;
            let {subjectValid, messageValid, emailValid, mobileValid, methodOfContactValid } = this.state;
            switch (fieldName) {
                case 'subject':
                    subjectValid = value !== "Select a subject";
                    fieldValidationErrors.subject = subjectValid ? '' : 'Please select a subject';
                    break;

                case 'message':
                    messageValid = value.length !== 0;
                    fieldValidationErrors.message = messageValid ? '' : 'Please add a description';
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
                subjectValid: subjectValid,
                messageValid: messageValid,
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
        let {subject, message, mobile, email} = this.state.formErrors;
        let {filePreviewUrl} = this.state;
        let $filePreview = null;
        if (filePreviewUrl) {
            $filePreview = (<div className="file-container"><i className="fa fa-file" aria-hidden="true"></i>
<p>{this.state.file.name}</p></div>);
        }
        return(<div className="form-container">
        <div className="wrapper">
                    <div className="registration-form">
                        <span className="title">
        					Secure Message
        				</span>


                        <div className="wrap-input">
                            <div className="col-sm-6 form-group">
                             <label>*Method of contact</label>
                                <div>
                                <label htmlFor="email">
                                <input type="radio"
                                     name="methodOfContact"
                                     value="email"
                                     id="email"
                                     checked={this.state.formData.IMessageFollowUpList[0].methodOfContact === "email"}
                                     onChange={this.handleUserInput}

                                />Email</label>
                            <label htmlFor="mobile">
                            <input type="radio"
                                   name="methodOfContact"
                                   id="mobile"
                                   checked={this.state.formData.IMessageFollowUpList[0].methodOfContact === "mobile"}
                                   onChange={this.handleUserInput}
                                   value="mobile"/>Mobile</label>
                                   </div>
                                </div>
                        </div>
                        {this.state.formData.IMessageFollowUpList[0].methodOfContact === "email" &&
                        <div className="wrap-input">
                            <div className="col-sm-5 form-group">
                                <label>*Email id</label>
                                <input className="input" type="text" name="email" placeholder="Email id"
                                       onChange={this.handleUserInput} value={this.state.formData.IMessageFollowUpList[0].email}/>
                                <p className="error-message">{email}</p>
                            </div>
                         </div>

                        }
                        {this.state.formData.IMessageFollowUpList[0].methodOfContact === "mobile" &&
                        <div className="wrap-input">
                            <div className="col-sm-5 form-group">
                                <label>*Mobile</label>
                                <input className="input" type="text" name="mobile" placeholder="Mobile"
                                       onChange={this.handleUserInput} value={this.state.formData.IMessageFollowUpList[0].mobile}/>
                                <p className="error-message">{mobile}</p>
                            </div>
                         </div>

                        }

                        <div className="wrap-input">
                            <div className="col-sm-6">
                                <label>*Subject</label>
                                  <select className="input" name="subject" value={this.state.formData.IMessageFollowUpList[0].subject}
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
                                <textarea className="input" name="message" value={this.state.formData.IMessageFollowUpList[0].message}
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


export default withRouter(SecureMessageForm);