import React from 'react';
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
                message: ''
            },
            messageValid: false,
            formValid: false
        }
    }
    componentDidMount(){
        let data = this.props.location.data;
        let a = this.state.formData.IMessageFollowUpList[0];
        a.email = data.email;
        a.mobile = data.mobile;
        a.methodOfContactValid = data.methodOfContact;
        a.subject = data.subject;
        a.crBy = data.crBy
        this.setState({...this.state,IMessageFollowUpList:a,
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
            });
    };

    validateForm() {
        this.setState({
             formValid: this.state.messageValid
        });

    };

    submit = () =>{
        WebApi.addFollowUpMessage(this.state.formData,this.state.filePreviewUrl, (err, response)=>{

            if(err){ throw err}
            this.props.history.push({pathname:"/UserMessage",data: response})
        })
    }



        validateField(fieldName, value) {
            let fieldValidationErrors = this.state.formErrors;
            let { messageValid } = this.state;
            switch (fieldName) {
                case 'message':
                    messageValid = value.length !== 0;
                    fieldValidationErrors.message = messageValid ? '' : 'Please add a description';
                    break;

                default:
                    break;
            }
            this.setState({
                ...this.state,
                formErrors: fieldValidationErrors,
                messageValid: messageValid,
            }, this.validateForm);


        };

        handleImageChange = (e) => {

                e.preventDefault();

                let reader = new FileReader();
                let file = e.target.files[0];
                let a = this.state.formData.IMessageFollowUpList[0];
                a.fileattached = "Y";
                    reader.onloadend = () => {

                    this.setState({...this.state,IMessageFollowUpList:a,
                        file: file,
                        filePreviewUrl: reader.result
                    });
                };
                reader.readAsDataURL(file)
            };

        back = () => {
            this.props.history.push("/secureMessages");
        };


    render(){
        let {message} = this.state.formErrors;
        let {filePreviewUrl} = this.state;
        let $filePreview = null;
        if (filePreviewUrl) {
            $filePreview = (<div className="file-container"><i className="fa fa-file" aria-hidden="true"></i>
<p>{this.state.file.name}</p></div>);
        }
        return(<div className="form-container">
        <div className="wrapper">
                    <div className="registration-form-step2">
                        <span className="title">
        					Secure Message
        				</span>


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
                        <button className="login-form-btn" onClick={()=> this.back()}>Back</button>
                            <button className="login-form-btn" onClick={() => this.submit()}
                                    disabled={!this.state.formValid}>Submit
                            </button>
                        </div>
        			</div>

        </div>
        </div>)

    }
}


export default withRouter(SecureMessageForm);