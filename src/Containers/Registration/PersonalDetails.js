import React, {Component} from 'react';
import {states} from './States.js';
import constants from '../../Utils/Constants';
import {addPhoto} from "../../Actions/Actions";
import connect from "react-redux/es/connect/connect";
import Datepicker from "../../Widgets/Datepicker";

let countries = require('country-list')();

export class PersonalDetails extends Component {
    constructor(props) {
        super(props);

        this.state = {
            file: '',
            imagePreviewUrl: '',
            formData: {
                userName: '',
                title: 'Select your title',
                firstName: '',
                middleName: '',
                lastName: '',
                photoId: 1,
                gender: 'Male',
                townOfBirth: '',
                countryOfBirth: 'Select your country of birth',
                dateofbirth: '',
                nationality: 'Select your nationality',
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
                title: '',
                firstName: '',
                lastName: '',
                townOfBirth: '',
                dateofbirth: '',
                nationality: '',
                countryOfBirth: ''
            },
            titleValid: false,
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
        let mandatoryFields = ["titleValid", "fnameValid",
            "lastName",
            "snameValid",
            "dobValid",
            "tobValid",
            "nationalityValid",
            "cobValid",
        "formValid"];
        let data = this.props.data;
        Object.keys(data).length !== 0 && data.constructor === Object &&
            mandatoryFields.forEach(fields => {
                this.setState({[fields]: true})
            });

        this.setState({
            formData: {...this.state.formData, ...this.props.data}
        });
    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({formData: {...this.state.formData, [name]: value}},
            () => {
                this.validateField(name, value)
            });
    };

    handleDateChange = (name, value) => {
        this.setState({formData: {...this.state.formData, [name]: value}},
            () => {
                this.validateField(name, value)
            });

    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {titleValid, fnameValid, snameValid, tobValid, dobValid, nationalityValid, cobValid} = this.state;

        switch (fieldName) {
            case 'title':
                titleValid = value !== "Select your title";
                fieldValidationErrors.title = titleValid ? '' : 'Your title is required';
                break;

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
        this.setState({...this.state,
            formErrors: fieldValidationErrors,
            titleValid: titleValid,
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


    validateForm() {
        this.setState({
            formValid: this.state.titleValid && this.state.fnameValid && this.state.snameValid &&
                this.state.tobValid && this.state.dobValid && this.state.nationalityValid &&
                this.state.cobValid
        });

    };

    render() {
        let {title, firstName, lastName, townOfBirth, nationality, countryOfBirth} = this.state.formErrors;
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
                    <div className="col-sm-6 form-group">
                        <label>Middle Name</label>
                        <input className="input" type="text" name="middleName" placeholder="Middle name"
                               onChange={this.handleUserInput} value={this.state.formData.middleName}/>
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
                <div className="wrap-input">
                    <div className="col-sm-4 form-group">
                        <label>*Date of birth</label>
                        <Datepicker date={this.state.formData.dateofbirth} onChange={this.handleDateChange}/>
                        {/*<input type="date" className="input" name="dateofbirth" onChange={this.handleUserInput}/>*/}
                    </div>
                    <div className="col-sm-5 form-group">
                        <label>*Nationality</label>
                        <select className="input" ref="nationality" value={this.state.formData.nationality}
                                name="nationality" onChange={this.handleUserInput}>
                            <option>Select your nationality</option>
                            {countries.getNames().map(a => <option
                                key={a} value={a}>{a}</option>)}</select>
                        <p className="error-message">{nationality}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-5 form-group">
                        <label>*Country of birth</label>
                        <select className="input" name="countryOfBirth" value={this.state.formData.countryOfBirth}
                                onChange={this.handleUserInput}>
                            <option>Select your country of birth</option>
                            {countries.getNames().map(a => <option
                                key={a} value={a}>{a}</option>)}</select>
                        <p className="error-message">{countryOfBirth}</p>
                    </div>
                    <div className="col-sm-4 form-group">
                        <label>*Town of birth</label>
                        <input className="input" name="townOfBirth" placeholder="Birth place"
                               onChange={this.handleUserInput} value={this.state.formData.townOfBirth}/>
                        <p className="error-message">{townOfBirth}</p>
                    </div>
                </div>

                <div className="wrap-input">
                    <div className="col-sm-4 form-group">
                        <label>Father Id</label>
                        <input className="input" type="text" name="fatherId" placeholder="Father id"
                               onChange={this.handleUserInput} value={this.state.formData.fatherId}/>
                    </div>
                    <div className="col-sm-4 form-group">
                        <label>Mother Id</label>
                        <input className="input" type="text" name="motherId" placeholder="Mother id"
                               onChange={this.handleUserInput} value={this.state.formData.motherId}/>
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