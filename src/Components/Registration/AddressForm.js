import React, {Component} from 'react';
import {connect} from "react-redux";
import {CountryDropdown, RegionDropdown} from "react-country-region-selector";
import WebApi from "../../Utils/WebApi";

export class AddressForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            formData: {
                flatNo: '',
                houseName: '',
                addressLine1: '',
                addressLine2: '',
                addressLine3: '',
                cityTown: '',
                stateProvince: '',
                country: '',
                pinPostCode: '',
                type: this.props.type,
                active: 'Y',
                mobile: '',
                landline: '',
                email: ''
            },
            isRequired: false,
            formErrors: {addressLine1: '', cityTown: '', stateProvince: '', country: '', pinPostCode: '', email: ''},
            addressLine1Valid: false,
            cityTownValid: false,
            stateProvinceValid: false,
            countryValid: false,
            pinPostCodeValid: false,
            emailValid: true,
            mobileValid: true,
            currentFormValid: false
        };
    }

    componentDidMount() {
        let data = this.props.data.AddressDetailsList;
        if(data) {
            let addressType = this.props.data.AddressDetailsList.filter(address => address.type === this.state.formData.type);
            var address = Object.assign({},addressType[0])
            if(addressType){
                    let mandatoryFields = [
                        "isRequired",
                        "addressLine1Valid",
                        "cityTownValid",
                        "stateProvinceValid",
                        "countryValid",
                        "pinPostCodeValid",
                        "emailValid",
                        "mobileValid",
                        "currentFormValid"];

                    mandatoryFields.forEach(fields => {
                        this.setState({[fields]: true})
                    });
            this.setState({
                formData: {...this.state.formData, ...address}
            },()=>{
                    WebApi.getCities(this.state.formData.country,this.state.formData.stateProvince).then(response => response.json()).then(response => {
                         this.setState({...this.state, cities: response})
                    })
            });
        }
    }
}
    handleCheckBox = () =>{
        this.setState({...this.state,isRequired:!this.state.isRequired},() => {
            this.validateField('isRequired', this.state.isRequired)
        });
    };

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({formData:{...this.state.formData,[name]: value}},
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
                WebApi.getCities(this.state.formData.country,this.state.formData.stateProvince).then(response => response.json()).then(response => {
                    this.setState({...this.state, cities: response})
                })
            });
    };


    validateForm = () => {
          let {formNumber} = this.props;
            if(this.state.isRequired || this.state.formData.type === "PermA"){
                let data = this.state.formData;
            if(this.state.formData.type === "PermA"){
            this.setState({
                currentFormValid:this.state.addressLine1Valid && this.state.cityTownValid && this.state.stateProvinceValid
                    && this.state.countryValid && this.state.pinPostCodeValid && this.state.emailValid &&
                    this.state.mobileValid && (this.state.formData.email.length !== 0 || this.state.formData.mobile.length !== 0)
            },() => this.props.isFormValid(this.state.currentFormValid, formNumber, data));
            }
            if(this.state.formData.type === "TempA" || this.state.formData.type === "BillA"){
            this.setState({
                        currentFormValid:this.state.addressLine1Valid && this.state.cityTownValid && this.state.stateProvinceValid
                            && this.state.countryValid && this.state.pinPostCodeValid &&
                            this.state.mobileValid
                    },() => this.props.isFormValid(this.state.currentFormValid, formNumber, data));
            }
            if(this.state.formData.type === "WorkA"){
            this.setState({
                        currentFormValid:this.state.addressLine1Valid && this.state.cityTownValid && this.state.stateProvinceValid
                            && this.state.countryValid && this.state.pinPostCodeValid &&
                            this.state.mobileValid && this.state.emailValid
                    },() => this.props.isFormValid(this.state.currentFormValid, formNumber, data));
            }
            }
            else{
                this.props.isFormValid(true, formNumber)
            }
    };

    validateField = (fieldName, value) => {
        let fieldValidationErrors = this.state.formErrors;
        let {addressLine1Valid, cityTownValid, stateProvinceValid, countryValid, pinPostCodeValid, emailValid, mobileValid} = this.state;


        switch (fieldName) {
            case 'addressLine1':
                addressLine1Valid = value.length !== 0;
                fieldValidationErrors.addressLine1 = addressLine1Valid ? '' : 'Your address line 1 is required';
                break;
            case 'cityTown':
                cityTownValid = value !== "Select your city";
                fieldValidationErrors.cityTown = cityTownValid ? '' : 'Your city/town is required';
                break;
            case 'stateProvince':
                stateProvinceValid = value !== "";
                fieldValidationErrors.stateProvince = stateProvinceValid ? '' : 'Your state/province is required';
                break;
            case 'country':
                countryValid = value !== "";
                fieldValidationErrors.country = countryValid ? '' : 'Your country is required';
                break;
            case 'pinPostCode':
                pinPostCodeValid = value.length !== 0;
                fieldValidationErrors.pinPostCode = pinPostCodeValid ? '' : 'Your pin_postcode is required';
                break;
            case 'email':
                emailValid = value.length === 0 || value.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
                fieldValidationErrors.email = emailValid ? '' : 'Your email id is invalid';
                break;
            case 'mobile':
                mobileValid = !(value.length >= 1 && value.length <= 8)
                fieldValidationErrors.mobile = mobileValid ? '' : 'Your mobile number is invalid';
            break;



            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            addressLine1Valid: addressLine1Valid,
            cityTownValid: cityTownValid,
            stateProvinceValid: stateProvinceValid,
            countryValid: countryValid,
            pinPostCodeValid: pinPostCodeValid,
            emailValid: emailValid,
            mobileValid: mobileValid
        }, this.validateForm);


    };

    render() {
        let {addressLine1, cityTown, stateProvince, country, pinPostCode, email, mobile} = this.state.formErrors;
        return (
            <div className="registration-form">
                {this.state.formData.type!== 'PermA' && <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <input type="checkbox" name="isRequired" value={this.state.isRequired} onChange={this.handleCheckBox}/><label>Wish to submit this address</label>
                    </div>
                </div>}
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>House No</label>
                        <input className="input" type="text" name="flatNo" onChange={this.handleUserInput} value={this.state.formData.flatNo}/>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>House Name</label>
                        <input className="input" type="text" name="houseName" onChange={this.handleUserInput} value={this.state.formData.houseName}/>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*Address Line</label>
                        <input className="input" type="text" name="addressLine1" onChange={this.handleUserInput} value={this.state.formData.addressLine1}/>
                        <p className="error-message">{addressLine1}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>Address Line 2</label>
                        <input className="input" type="text" name="addressLine2" onChange={this.handleUserInput} value={this.state.formData.addressLine2}/>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*Country</label>
                        <CountryDropdown className="input"
                                         value={this.state.formData.country}
                                         name="country"
                                         onChange={(val) => this.handleChangeCountry("country", val)}/>
                        <p className="error-message">{country}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*State/ Province</label>
                        <RegionDropdown className="input"
                                        country={this.state.formData.country}
                                        value={this.state.formData.stateProvince}
                                        name="stateProvince"
                                        onChange={(val) => this.handleChangeState("stateProvince", val)}/>
                        <p className="error-message">{stateProvince}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*City/Town</label>
                        <select className="input" name="cityTown" value={this.state.formData.cityTown}
                                onChange={this.handleUserInput}>
                            <option>Select your city</option>
                            {this.state.cities && this.state.cities.map((a,index) =>
                                <option
                                    key={index} value={a}>{a}</option>)}</select>
                        <p className="error-message">{cityTown}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Pin/Postcode</label>
                        <input className="input" type="text" name="pinPostCode" onChange={this.handleUserInput} value={this.state.formData.pinPostCode}/>
                        <p className="error-message">{pinPostCode}</p>
                    </div>
                </div>
                <div className="wrap-input">
                        {this.state.formData.type=== 'PermA' && <div>Your Mobile or Email id is required</div>}
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>Mobile</label>
                        <input className="input" type="number" name="mobile" onChange={this.handleUserInput} value={this.state.formData.mobile}/>
                        <p className="error-message">{mobile}</p>
                    </div>
                    {(this.state.formData.type === 'PermA' || this.state.formData.type === 'WorkA') &&<div className="col-sm-6 form-group">
                        <label>Email</label>
                        <input className="input" type="email" name="email" onChange={this.handleUserInput} value={this.state.formData.email}/>
                        <p className="error-message">{email}</p>
                    </div>}

                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                                            <label>Landline</label>
                                            <input className="input" type="number" name="landline" onChange={this.handleUserInput} value={this.state.formData.landline}/>
                                        </div>
                </div>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    data: state.data
});

export default connect(mapStateToProps)(AddressForm)