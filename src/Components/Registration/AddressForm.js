import React, {Component} from 'react';

export default class AddressForm extends Component {
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
            formErrors: {addressLine1: '', cityTown: '', stateProvince: '', country: '', pinPostCode: '', email: ''},
            addressLine1Valid: false,
            cityTownValid: false,
            stateProvinceValid: false,
            countryValid: false,
            pinPostCodeValid: false,
            emailValid: false,
            currentFormValid: false
        };
    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({formData:{...this.state.formData,[name]: value}},
            () => {
                this.validateField(name, value)
            });
    };

    validateForm = () => {
        let {formNumber} = this.props;
        let data = this.state.formData;
        this.setState({
            currentFormValid:this.state.addressLine1Valid && this.state.cityTownValid && this.state.stateProvinceValid
                && this.state.countryValid && this.state.pinPostCodeValid && this.state.emailValid
        },() => this.props.isFormValid(this.state.currentFormValid, formNumber, data));

    };

    validateField = (fieldName, value) => {
        let fieldValidationErrors = this.state.formErrors;
        let {addressLine1Valid, cityTownValid, stateProvinceValid, countryValid, pinPostCodeValid, emailValid} = this.state;


        switch (fieldName) {
            case 'addressLine1':
                addressLine1Valid = value.length !== 0;
                fieldValidationErrors.addressLine1 = addressLine1Valid ? '' : 'Your address line 1 is required';
                break;
            case 'cityTown':
                cityTownValid = value.length !== 0;
                fieldValidationErrors.cityTown = cityTownValid ? '' : 'Your city/town is required';
                break;
            case 'stateProvince':
                stateProvinceValid = value.length !== 0;
                fieldValidationErrors.stateProvince = stateProvinceValid ? '' : 'Your state/province is required';
                break;
            case 'country':
                countryValid = value.length !== 0;
                fieldValidationErrors.country = countryValid ? '' : 'Your country is required';
                break;
            case 'pinPostCode':
                pinPostCodeValid = value.length !== 0;
                fieldValidationErrors.pinPostCode = pinPostCodeValid ? '' : 'Your pin_postcode is required';
                break;
            case 'email':
                emailValid = value.length !== 0;
                fieldValidationErrors.email = emailValid ? '' : 'Your email id is invalid';
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
            emailValid: emailValid
        }, this.validateForm);


    };

    render() {
        let {addressLine1, cityTown, stateProvince, country, pinPostCode, email} = this.state.formErrors;
        return (
            <div className="registration-form">
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>House No</label>
                        <input className="input" type="text" name="flatNo" onChange={this.handleUserInput}/>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>House Name</label>
                        <input className="input" type="text" name="houseName" onChange={this.handleUserInput}/>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*Address Line</label>
                        <input className="input" type="text" name="addressLine1" onChange={this.handleUserInput}/>
                        <p className="error-message">{addressLine1}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>Address Line 2</label>
                        <input className="input" type="text" name="addressLine2" onChange={this.handleUserInput}/>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*City/Town</label>
                        <input className="input" type="text" name="cityTown" onChange={this.handleUserInput}/>
                        <p className="error-message">{cityTown}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*State/ Province</label>
                        <input className="input" type="text" name="stateProvince" onChange={this.handleUserInput}/>
                        <p className="error-message">{stateProvince}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*Country</label>
                        <input className="input" type="text" name="country" onChange={this.handleUserInput}/>
                        <p className="error-message">{country}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Pin/Postcode</label>
                        <input className="input" type="text" name="pinPostCode" onChange={this.handleUserInput}/>
                        <p className="error-message">{pinPostCode}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>Mobile</label>
                        <input className="input" type="text" name="mobile" onChange={this.handleUserInput}/>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>Landline</label>
                        <input className="input" type="text" name="landline" onChange={this.handleUserInput}/>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*Email</label>
                        <input className="input" type="text" name="email" onChange={this.handleUserInput}/>
                        <p className="error-message">{email}</p>
                    </div>
                </div>
            </div>
        )
    }
}