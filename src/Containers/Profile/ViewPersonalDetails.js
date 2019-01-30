import React, {Component} from 'react';
import {addPhoto} from "../../Actions/Actions";
import connect from "react-redux/es/connect/connect";
import WebApi from "../../Utils/WebApi";
import {withRouter} from "react-router-dom";

export class ViewPersonalDetails extends Component {
    constructor(props) {
        super(props);

        this.state = {
            file: '',
            imagePreviewUrl: props.details.UsersPhoto ? "data:image/jpeg;base64,"+this.props.details.UsersPhoto.photoContent : '',
            formData: {
                userName: props.details.userName,
                photoId: props.details.photoId,
                UsersPhoto: {
                    photo: props.details.UsersPhoto.photo,
                    photoContent: "",
                    fileType: "",
                    active: "",
                }
            }

        }
    }

    handleImageChange = (e) => {
        e.preventDefault();

        let reader = new FileReader();
        let file = e.target.files[0];
        let fileToStore = window.URL.createObjectURL(file);
        reader.onloadend = () => {
            this.setState({
                file: file,
                imagePreviewUrl: reader.result,
                formData: {
                    ...this.state.formData, UsersPhoto: {
                        ...this.state.formData.UsersPhoto,
                        photo: fileToStore,
                        fileType: file.type,
                        active: "Y"
                    }
                }
            }, () => this.props.dispatch(addPhoto(fileToStore)));
        };

        reader.readAsDataURL(file)
    };

    submit = (data) => {
        WebApi.editPhoto(this.state.formData,this.state.formData.UsersPhoto.photo, (err, response)=>{
            this.props.history.push({pathname:"/Profile"})
        })

    };

    render() {
        let {imagePreviewUrl} = this.state;
        let {firstName, lastName, gender, dateofbirth, townOfBirth, nationality } = this.props.details;
        const date = new Date(parseInt(dateofbirth)).toDateString();
        let data = this.state.formData;
        let $imagePreview = null;
        if (imagePreviewUrl) {
            $imagePreview = (<img className="file-upload-img" alt="user" src={imagePreviewUrl}/>);
        }
        console.log(imagePreviewUrl)
        return (
<div className="profile-details">
           <div className="form-group">
                <label>Name</label>
                <span>{firstName}</span>
           </div>
           <div className="form-group">
                <label>Last name</label>
                <span>{lastName}</span>
           </div>
           <div className="form-group">
                <label>Gender</label>
                <span>{gender}</span>
           </div>
          <div className="form-group">
               <label>Date of Birth</label>
               <span>{date}</span>
          </div>
          <div className="form-group">
             <label>Nationality</label>
             <span>{nationality}</span>
          </div>
          <div className="form-group">
               <label>Town of birth</label>
               <span>{townOfBirth}</span>
          </div>

            <div className="wrap-input">
                    <div className="col-sm-3 form-group">
                        <label>Upload your picture
                            <div id="upload_button">
                                <label>
                                    <input type="file" id="upload-photo" onChange={this.handleImageChange}/>
                                    <i className="fa fa-upload"/>
                                </label>

                            </div>
                        </label>

                        {$imagePreview}
                    </div>

                </div>
<div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.submit(data)}>Submit
                    </button>
                </div>
        </div>
        )
    }
}

const mapStateToProps = state => ({
    details: state.details,
    photo: state.photo
});

export default withRouter(connect(mapStateToProps)(ViewPersonalDetails));