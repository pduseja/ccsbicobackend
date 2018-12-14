import React, {Component} from 'react';
import {states} from './States.js';
import constants from '../../Utils/Constants';
import {addPhoto} from "../../Actions/Actions";
import connect from "react-redux/es/connect/connect";

let countries = require('country-list')();

export class PersonalDetails extends Component {
    constructor(props) {
        super(props);

        this.state = {
            file: '',
            imagePreviewUrl: '',
            formData: {
                userName: '',
                title: 'Mr.',
                firstName: '',
                middleName: '',
                lastName: '',
                photoId: 1,
                gender: 'Male',
                townOfBirth: '',
                countryOfBirth: '',
                dateofbirth: '',
                nationality: '',
                fatherId: '',
                motherId: '',
                UsersPhoto: {
                    photo: "",
                    photoContent: "",
                    fileType: "",
                    active: "",
                }
            },
            formErrors: {
                firstName: '',
                lastName: '',
                townOfBirth: '',
                dateofbirth: '',
                nationality: '',
                countryOfBirth: ''
            },
            fnameValid: false,
            snameValid: false,
            dobValid: false,
            tobValid: false,
            nationalityValid: false,
            cobValid: false,
            formValid: false

        }
    }

    componentDidMount() {
        this.setState({
            formData: {...this.state.formData, ...this.props.data}
        })
    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({formData: {...this.state.formData, [name]: value}},
            () => {
                this.validateField(name, value)
            });
    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {fnameValid, snameValid, tobValid, dobValid, nationalityValid, cobValid} = this.state;

        switch (fieldName) {
            case 'firstName':
                fnameValid = value.length !== 0;
                fieldValidationErrors.firstName = fnameValid ? '' : 'Your name is required';
                break;

            case 'lastName':
                snameValid = value.length !== 0;
                fieldValidationErrors.lastName = snameValid ? '' : 'Your last name is required';
                break;

            case 'dateofbirth':
                dobValid = value.length !== 0;
                fieldValidationErrors.dateofbirth = dobValid ? '' : 'Your date of birth is required';
                break;

            case 'townOfBirth':
                tobValid = value.length !== 0;
                fieldValidationErrors.townOfBirth = tobValid ? '' : 'Your town of birth is required';
                break;

            case 'nationality':
                nationalityValid = value !== "Select your nationality";
                fieldValidationErrors.nationality = nationalityValid ? '' : 'Your nationality is required';
                break;

            case 'countryOfBirth':
                cobValid = value !== "Select your country of birth";
                fieldValidationErrors.countryOfBirth = cobValid ? '' : 'Your country of birth is required';
                break;

            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            fnameValid: fnameValid,
            snameValid: snameValid,
            dobValid: dobValid,
            tobValid: tobValid,
            nationalityValid: nationalityValid,
            cobValid: cobValid
        }, this.validateForm);


    };

    handleImageChange = (e) => {
        e.preventDefault();

        let reader = new FileReader();
        let file = e.target.files[0];
        console.log(file,"file")
        let fileToStore =  window.URL.createObjectURL(file);
        reader.onloadend = () => {
            this.setState({
                file: file,
                imagePreviewUrl: reader.result,
                formData:{...this.state.formData,UsersPhoto:{...this.state.formData.UsersPhoto,
                        photo: fileToStore,
                        fileType: file.type,
                        active: "Y"
                    }
                }
            }, () => this.props.dispatch(addPhoto( fileToStore )));
        };

        reader.readAsDataURL(file)
    };


    validateForm() {
        this.setState({
            formValid: this.state.fnameValid && this.state.snameValid &&
                this.state.tobValid && this.state.dobValid && this.state.nationalityValid &&
                this.state.cobValid
        });

    };

    render() {
        let {firstName, lastName, townOfBirth, nationality, countryOfBirth} = this.state.formErrors;

        let {imagePreviewUrl} = this.state;
        let data = this.state.formData;
        let $imagePreview = null;
        if (imagePreviewUrl) {
            $imagePreview = (<img className="file-upload-img" alt="user" src={imagePreviewUrl}/>);
        }
        return (

            <div className="registration-form">
                <span className="title">
						Personal details
					</span>
                <div className="wrap-input">
                    <div className="col-sm-2 form-group">
                        <label>*Title</label>
                        <select className="input" name="title" onChange={this.handleUserInput}>{constants.title.map(a =>
                            <option
                                key={a.value} value={a.value}>{a.label}</option>)}</select>
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
                    <div className="col-sm-6 form-group">
                        <label>Middle Name</label>
                        <input className="input" type="text" name="middleName" placeholder="Middle name"
                               onChange={this.handleUserInput} value={this.state.formData.middleName}/>
                    </div>

                </div>
                <div className="wrap-input">
                    <div className="col-sm-3 form-group">
                        <label>Upload your picture</label>

                        {$imagePreview}
                    </div>
                    <div id="upload_button">
                        <label>
                            <input type="file" id="upload-photo" onChange={this.handleImageChange}/>
                            <i className="fa fa-upload"/>
                        </label>

                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-3">
                        <label htmlFor="male"><input type="radio"
                                                     name="gender"
                                                     value="Male"
                                                     id="male"
                                                     onChange={this.handleUserInput}
                                                     defaultChecked
                        />Male</label>
                    </div>
                    <div className="col-sm-3">
                        <label htmlFor="female"><input type="radio"
                                                       name="gender"
                                                       id="female"
                                                       onChange={this.handleUserInput}
                                                       value="Female"/>Female</label></div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-4 form-group">
                        <label>*Date of birth</label>
                        <input type="date" className="input" name="dateofbirth" onChange={this.handleUserInput}/></div>
                    <div className="col-sm-4 form-group">
                        <label>*Place of birth</label>
                        <input className="input" name="townOfBirth" placeholder="Birth place"
                               onChange={this.handleUserInput} value={this.state.formData.townOfBirth}/>
                        <p className="error-message">{townOfBirth}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-5 form-group">
                        <label>*Nationality</label>
                        <select className="input" name="nationality" onChange={this.handleUserInput}>
                            <option>Select your nationality</option>
                            {countries.getNames().map(a => <option
                                key={a} value={a}>{a}</option>)}</select>
                        <p className="error-message">{nationality}</p>
                    </div>
                    <div className="col-sm-5 form-group">
                        <label>*Country of birth</label>
                        <select className="input" name="countryOfBirth" onChange={this.handleUserInput}>
                            <option>Select your country of birth</option>
                            {countries.getNames().map(a => <option
                                key={a} value={a}>{a}</option>)}</select>
                        <p className="error-message">{countryOfBirth}</p>
                    </div>
                </div>

                <div className="wrap-input">
                    <div className="col-sm-4 form-group">
                        <label>Father Id</label>
                        <input className="input" type="text" name="fatherId" placeholder="Father id"
                               onChange={this.handleUserInput} value={this.state.fatherId}/>
                    </div>
                    <div className="col-sm-4 form-group">
                        <label>Mother Id</label>
                        <input className="input" type="text" name="mid" placeholder="Mother id"
                               onChange={this.handleUserInput} value={this.state.motherId}/>
                    </div>

                </div>


                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.props.next(states.ADDRESS, data)}
                            disabled={!this.state.formValid}>Next
                    </button>
                </div>

            </div>
        )
    }
}

const mapStateToProps = state => ({
    data: state.data
});

export default connect(mapStateToProps)(PersonalDetails);