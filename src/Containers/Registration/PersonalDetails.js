import React, {Component} from 'react';
import {states} from './States.js';
import constants from '../../Utils/Constants';
import {addPhoto} from "../../Actions/Actions";
import connect from "react-redux/es/connect/connect";
import DatePicker from 'react-date-picker';
import {CountryDropdown, RegionDropdown} from 'react-country-region-selector';
import WebApi from "../../Utils/WebApi";

export class PersonalDetails extends Component {
    constructor(props) {
        super(props);

        this.state = {
            file: '',
            imagePreviewUrl: '',
            cities: '',
            formData: {
                userName: '',
                title: 'Select your title',
                firstName: '',
                middleName: '',
                lastName: '',
                gender: '',
                townOfBirth: '',
                cityOfBirth: '',
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
                countryOfBirth: '',
                cityOfBirth: ''
            },
            titleValid: false,
            fnameValid: false,
            snameValid: false,
            mnameValid: true,
            genderValid: false,
            dobValid: false,
            tobValid: false,
            nationalityValid: false,
            cobValid: false,
            cityOfBirthValid: false,
            formValid: false

        }
    }

    componentDidMount() {
        document.getElementsByClassName('react-date-picker__inputGroup__input react-date-picker__inputGroup__day')[0].placeholder = "DD"
        document.getElementsByClassName('react-date-picker__inputGroup__input react-date-picker__inputGroup__month')[0].placeholder = "MM"
        document.getElementsByClassName('react-date-picker__inputGroup__input react-date-picker__inputGroup__year')[0].placeholder = "YYYY"
        let mandatoryFields = ["titleValid", "fnameValid",
            "lastName",
            "snameValid",
            "dobValid",
            "tobValid",
            "genderValid",
            "nationalityValid",
            "cobValid",
            "cityOfBirthValid",
            "formValid"];
        let data = this.props.location ? this.props.location.data : this.props.data;
        let reload = Object.keys(data).length !== 0 && data.constructor === Object;
        if(reload){
        mandatoryFields.forEach(fields => {
            this.setState({[fields]: true})
        });
        this.setState({
            formData: {...this.state.formData, ...data}
        },()=>{
            WebApi.getCities(this.state.formData.countryOfBirth,this.state.formData.townOfBirth).then(response => response.json()).then(response => {
               this.setState({...this.state, cities: response})
            })
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

    handleChangeCountry = (name, value) => {
        this.setState({formData: {...this.state.formData, [name]: value}},
            () => {
                this.validateField(name, value)
            });
    };

    handleChangeState = (name, value) => {
        this.setState({formData: {...this.state.formData, [name]: value}},
            () => {
                this.validateField(name, value)
                WebApi.getCities(this.state.formData.countryOfBirth,this.state.formData.townOfBirth).then(response => response.json()).then(response => {
                    this.setState({...this.state, cities: response})
                })
            });
    };

    handleDateChange = (value) => {
        let name = "dateofbirth"
        this.setState({formData: {...this.state.formData, [name]: value}},
            () =>
        {
                this.validateField(name, value)
            });

    };

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let {titleValid, fnameValid, snameValid, mnameValid, genderValid, tobValid, dobValid, nationalityValid, cobValid, cityOfBirthValid} = this.state;
        let clearCity = this.state;
        let clearCityData = this.state.formData;
        switch (fieldName) {
            case 'title':
                titleValid = value !== "Select your title";
                fieldValidationErrors.title = titleValid ? '' : 'Your title is required';
                break;

            case 'firstName':
                fnameValid = value.length !== 0 && /^([a-zA-Z']*)$/.test(value);
                fieldValidationErrors.firstName = fnameValid ? '' : 'Your name is invalid';
                break;

            case 'middleName':
                mnameValid = /^([a-zA-Z']*)$/.test(value);
                fieldValidationErrors.middleName = mnameValid ? '' : 'Your middle name is invalid';
                break;

            case 'lastName':
                snameValid = value.length !== 0 && /^([a-zA-Z']*)$/.test(value);
                fieldValidationErrors.lastName = snameValid ? '' : 'Your last name is invalid';
                break;

            case 'dateofbirth':
                dobValid = value.length !== 0;
                fieldValidationErrors.dateofbirth = dobValid ? '' : 'Your date of birth is required';
                break;

            case 'nationality':
                nationalityValid = value !== "";
                fieldValidationErrors.nationality = nationalityValid ? '' : 'Your nationality is required';
                break;

            case 'countryOfBirth':
                cobValid = value !== "";
                tobValid = false;
                cityOfBirthValid = false;
                fieldValidationErrors.countryOfBirth = cobValid ? '' : 'Your country of birth is required';
                fieldValidationErrors.townOfBirth = 'Your region of birth is required';
                fieldValidationErrors.cityOfBirth = 'Your city of birth is required';
                clearCity.cities = '';
                clearCityData.cityOfBirth = ''

                break;

            case 'townOfBirth':
                tobValid = value !== "";
                cityOfBirthValid = false;
                fieldValidationErrors.townOfBirth = tobValid ? '' : 'Your region of birth is required';
                fieldValidationErrors.cityOfBirth = 'Your city of birth is required';
                clearCity.cities = '';
                clearCityData.cityOfBirth = ''

                break;

            case 'cityOfBirth':
                cityOfBirthValid = value !== "Select your city of birth";
                fieldValidationErrors.cityOfBirth = cityOfBirthValid ? '' : 'Your city of birth is required';
                break;

            case 'gender':
                genderValid = true
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
            mnameValid: mnameValid,
            genderValid: genderValid,
            dobValid: dobValid,
            tobValid: tobValid,
            nationalityValid: nationalityValid,
            cobValid: cobValid,
            cityOfBirthValid: cityOfBirthValid
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
                        photo: '',
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
            formValid: this.state.titleValid && this.state.fnameValid && this.state.snameValid && this.state.mnameValid &&
                this.state.genderValid && this.state.tobValid && this.state.dobValid && this.state.nationalityValid &&
                this.state.cobValid && this.state.cityOfBirthValid
        });

    };

    render() {
        let {title, firstName, lastName, middleName, townOfBirth, nationality, countryOfBirth, cityOfBirth} = this.state.formErrors;
        let {imagePreviewUrl} = this.state;
        let data = this.state.formData;
        let $imagePreview = null;
        if (imagePreviewUrl) {
            $imagePreview = (<img className="file-upload-img" alt="user" src={imagePreviewUrl}/>);
        }
        return (
            <div className="form-container">

                    <div className="wrapper">
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
                         <p className="error-message">{middleName}</p>
                    </div>

                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                     <label>*Gender</label>
                        <div>
                        <label htmlFor="male"><input type="radio"
                                                     name="gender"
                                                     value="Male"
                                                     id="male"
                                                     checked={this.state.formData.gender === "Male"}
                                                     onChange={this.handleUserInput}

                        />Male</label>
                        <label htmlFor="female"><input type="radio"
                                                       name="gender"
                                                       id="female"
                                                       checked={this.state.formData.gender === "Female"}
                                                       onChange={this.handleUserInput}
                                                       value="Female"/>Female</label>
                                                       </div>
                        </div>
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
                        <DatePicker value={this.state.formData.dateofbirth} locale="en-GB" onChange={this.handleDateChange}/>
                        {/*<input type="date" className="input" name="dateofbirth" onChange={this.handleUserInput}/>*/}
                    </div>
                    <div className="col-sm-5 form-group">
                        <label>*Nationality</label>
                        <CountryDropdown className="input"
                                         value={this.state.formData.nationality}
                                         name="nationality"
                                         onChange={(val) => this.handleChangeCountry("nationality", val)}/>
                        <p className="error-message">{nationality}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*Country of birth</label>
                        <CountryDropdown className="input"
                                         value={this.state.formData.countryOfBirth}
                                         name="countryOfBirth"
                                         onChange={(val) => this.handleChangeCountry("countryOfBirth", val)}/><p
                        className="error-message">{countryOfBirth}</p>

                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Region of birth</label>
                        <RegionDropdown className="input"
                                        country={this.state.formData.countryOfBirth}
                                        value={this.state.formData.townOfBirth}
                                        name="townOfBirth"
                                        onChange={(val) => this.handleChangeState("townOfBirth", val)}/>
                        <p className="error-message">{townOfBirth}</p>
                    </div>
                </div>


                <div className="wrap-input">
                    <div className="col-sm-4 form-group">
                        <label>*City of birth</label>
                        <select className="input" name="cityOfBirth" value={this.state.formData.cityOfBirth}
                                onChange={this.handleUserInput}>
                            <option>Select your city of birth</option>
                            {this.state.cities && this.state.cities.map((a,index) =>
                                <option
                                    key={index} value={a}>{a}</option>)}</select>
                        <p className="error-message">{cityOfBirth}</p>
                    </div>
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
            </div>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    data: state.data
});

export default connect(mapStateToProps)(PersonalDetails);