import React from 'react';
import WebApi from "../../Utils/WebApi";
import {withRouter} from "react-router-dom";
import '../../Styles/MessageForm.css'
export class MessageReply extends React.Component{
    constructor(props){
        super(props)
        this.state={
            formData:{
                iMessageId: '',
                userName: '',
                subject: '',
                message: '',
                email: '',
                mobile: '',
                methodOfContact: '',
                fileattached: 'N',
                responseStatus: 'Y',
                messageReply: '',
                readStatus: 'Y',
                crBy: '',
                modBy: ''
            },
            formErrors: {
                messageReply: ''
            },
            messageReplyValid: false,
            formValid: false
        }
    }
    componentDidMount(){
        let data = this.props.location.data;
        this.setState({...this.state,
            formData: {...this.state.formData,
            iMessageId: data.iMessageId,
            userName: data.userName,
            subject: data.subject,
            message: data.message,
            email: data.email,
            mobile: data.mobile,
            methodOfContact: '',
            crBy: data.crBy,
            modBy: data.modBy
            }
        })


    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({...this.state,formData:{...this.state.formData, [name]: value}},
            () => {
                this.validateField(name, value)
            });
    };

    validateForm() {
        this.setState({
             formValid: this.state.messageReplyValid
        });

    };

    submit = () =>{
        WebApi.sendReply(this.state.formData,this.state.filePreviewUrl, (err, response)=>{

            if(err){ throw err}
            this.props.history.push({pathname:"/UserMessage",data: response})
        })
    }



        validateField(fieldName, value) {
            let fieldValidationErrors = this.state.formErrors;
            let { messageReplyValid } = this.state;
            switch (fieldName) {
                case 'messageReply':
                    messageReplyValid = value.length !== 0;
                    fieldValidationErrors.messageReply = messageReplyValid ? '' : 'Please add a description';
                    break;

                default:
                    break;
            }
            this.setState({
                ...this.state,
                formErrors: fieldValidationErrors,
                messageReplyValid: messageReplyValid,
            }, this.validateForm);


        };

        handleImageChange = (e) => {

                e.preventDefault();

                let reader = new FileReader();
                let file = e.target.files[0];
                    reader.onloadend = () => {

                    this.setState({...this.state,formData:{...this.state.formData, fileattached: 'Y'},
                        file: file,
                        filePreviewUrl: reader.result
                    });
                };
                reader.readAsDataURL(file)
            };

        back = () => {
            this.props.history.push("/CommunicationDashboard");
        };


    render(){
        let {messageReply} = this.state.formErrors;
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
        					Secure Message Reply
        				</span>


                        <div className="wrap-input">
                            <div className="col-sm-6">
                                <label>*Reply</label>
                                <textarea className="input" name="messageReply" value={this.state.formData.messageReply}
                                 onChange={this.handleUserInput} />
                            <p className="error-message">{messageReply}</p>
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


export default withRouter(MessageReply);