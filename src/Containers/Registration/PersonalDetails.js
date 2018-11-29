import React, {Component} from 'react';
import {states} from './States.js';
import constants from '../../Utils/Constants';

let countries = require('country-list')();
export class PersonalDetails extends Component {
    constructor(props) {
        super(props);

        this.state = {
            file: '',
            imagePreviewUrl: '',
            title: 'mr',
            fname: '',
            sname: '',
            mname: '',
            gender: 'Male',
            dob: '',
            tob: '',
            nationality: '',
            cob: '',
            formErrors: {fname: '', sname: '', tob: '', dob: '', nationality: '', cob: ''},
            fnameValid: false,
            snameValid: false,
            dobValid: false,
            tobValid: false,
            nationalityValid: false,
            cobValid: false,
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
        let {fnameValid, snameValid, tobValid, dobValid, nationalityValid, cobValid} = this.state;

        switch (fieldName) {
            case 'fname':
                fnameValid = value.length !== 0;
                fieldValidationErrors.fname = fnameValid ? '' : 'Your name is required';
                break;

            case 'sname':
                snameValid = value.length !== 0;
                fieldValidationErrors.sname = snameValid ? '' : 'Your last name is required';
                break;

            case 'dob':
                dobValid = value.length !== 0;
                fieldValidationErrors.dob = dobValid ? '' : 'Your date of birth is required';
                break;

            case 'tob':
                tobValid = value.length !== 0;
                fieldValidationErrors.tob = tobValid ? '' : 'Your town of birth is required';
                break;

            case 'nationality':
                nationalityValid = value !== "Select your nationality";
                fieldValidationErrors.nationality = nationalityValid ? '' : 'Your nationality is required';
                break;

            case 'cob':
                cobValid = value !== "Select your country of birth";
                fieldValidationErrors.cob = cobValid ? '' : 'Your country of birth is required';
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

        reader.onloadend = () => {
            this.setState({
                file: file,
                imagePreviewUrl: reader.result
            });
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
        let { fname, sname, tob, nationality, cob } = this.state.formErrors;
        let { imagePreviewUrl } = this.state;
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
                        <input className="input" type="text" name="fname" placeholder="First name"
                               onChange={this.handleUserInput} value={this.state.fname}/>
                        <p className="error-message">{fname}</p>
                    </div>

                    <div className="col-sm-5 form-group">
                        <label>*Last Name</label>
                        <input className="input" type="text" name="sname" placeholder="Last name"
                               onChange={this.handleUserInput} value={this.state.sname}/>
                        <p className="error-message">{sname}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>Middle Name</label>
                        <input className="input" type="text" name="mname" placeholder="Middle name"
                               onChange={this.handleUserInput} value={this.state.mname}/>
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
                        <input type="date" className="input" name="dob" onChange={this.handleUserInput}/></div>
                    <div className="col-sm-4 form-group">
                        <label>*Place of birth</label>
                        <input className="input" name="tob" placeholder="Birth place"
                               onChange={this.handleUserInput} value={this.state.tob}/>
                        <p className="error-message">{tob}</p>
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
                        <select className="input" name="cob" onChange={this.handleUserInput}>
                            <option>Select your country of birth</option>
                            {countries.getNames().map(a => <option
                                key={a} value={a}>{a}</option>)}</select>
                        <p className="error-message">{cob}</p>
                    </div>
                </div>

                <div className="wrap-input">
                    <div className="col-sm-4 form-group">
                        <label>Father Id</label>
                        <input className="input" type="text" name="fid" placeholder="Father id"
                               onChange={this.handleUserInput} value={this.state.fid}/>
                    </div>
                    <div className="col-sm-4 form-group">
                        <label>Mother Id</label>
                        <input className="input" type="text" name="mid" placeholder="Mother id"
                               onChange={this.handleUserInput} value={this.state.mid}/>
                    </div>

                </div>


                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={() => this.props.next(states.ADDRESS)}
                            disabled={!this.state.formValid}>Next
                    </button>
                </div>

            </div>
        )
    }
}