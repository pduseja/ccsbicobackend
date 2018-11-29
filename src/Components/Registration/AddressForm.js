import React, {Component} from 'react';

export default class AddressForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            contact_type: '',
            address_line: '',
            city_town: '',
            state_province: '',
            country: '',
            pin_postcode: '',
            email: '',
            formErrors: {address_line: '', city_town: '', state_province: '', country: '', pin_postcode: '', email: ''},
            address_lineValid: false,
            city_townValid: false,
            state_provinceValid: false,
            countryValid: false,
            pin_postcodeValid: false,
            emailValid: false,
            formValid: false

        };

    }

    handleUserInput = (e) => {
        const name = e.target.name;
        const value = e.target.type === 'radio' ? e.target.value : e.target.value;
        this.setState({[name]: value},
            () => {
                this.validateField(name, value)
            });
    };

    validateForm = () => {
        this.setState({
            formValid: this.state.address_lineValid && this.state.city_townValid && this.state.state_provinceValid
            && this.state.countryValid && this.state.pin_postcode && this.state.emailValid
        });

    };

    validateField = (fieldName, value) => {
        let fieldValidationErrors = this.state.formErrors;
        let {address_lineValid,city_townValid,state_provinceValid, countryValid, pin_postcodeValid,emailValid} = this.state;


        switch (fieldName) {
            case 'address_line':
                address_lineValid = value.length !== 0;
                fieldValidationErrors.address_line = address_lineValid ? '' : 'Your address line 1 is required';
            break;
            case 'city_town':
                city_townValid = value.length !== 0;
                fieldValidationErrors.city_town = city_townValid ? '' : 'Your city/town is required';
            break;
            case 'state_province':
                state_provinceValid = value.length !== 0;
                fieldValidationErrors.state_province = state_provinceValid ? '' : 'Your state/province is required';
            break;
            case 'country':
                countryValid = value.length !== 0;
                fieldValidationErrors.country = countryValid ? '' : 'Your country is required';
            break;
            case 'pin_postcode':
                pin_postcodeValid = value.length !== 0;
                fieldValidationErrors.pin_postcode = pin_postcodeValid ? '' : 'Your pin_postcode is required';
            break;
            case 'email':
                emailValid = value.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
                fieldValidationErrors.email = emailValid ? '' : 'Your email id is invalid';
            break;

            default:
            break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            address_lineValid: address_lineValid,
            city_townValid: city_townValid,
            state_provinceValid: state_provinceValid,
            countryValid: countryValid,
            pin_postcodeValid: pin_postcodeValid,
            emailValid: emailValid
        }, this.validateForm);


    };

    render() {
        let {address_line,city_town,state_province,country,pin_postcode,email} = this.state.formErrors;
        return (
            <div className="registration-form">
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>Contact Type</label>
                        <input className="input" type="text" name="contact_type" onChange={this.handleUserInput}/>
                    </div >
                    <div className="col-sm-6 form-group">
                        <label>House Name</label>
                        <input className="input" type="text" name="house_name" onChange={this.handleUserInput}/>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>House No</label>
                        <input className="input" type="text" name="house_no" onChange={this.handleUserInput}/>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Address Line</label>
                        <input className="input" type="text" name="address_line" onChange={this.handleUserInput}/>
                        <p className="error-message">{address_line}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>Address Line 2</label>
                        <input className="input" type="text" name="address_line_2" onChange={this.handleUserInput}/>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*City/Town</label>
                        <input className="input" type="text" name="city_town" onChange={this.handleUserInput}/>
                        <p className="error-message">{city_town}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*State/ Province</label>
                        <input className="input" type="text" name="state_province" onChange={this.handleUserInput}/>
                        <p className="error-message">{state_province}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Country</label>
                        <input className="input" type="text" name="country" onChange={this.handleUserInput}/>
                        <p className="error-message">{country}</p>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>*Pin/Postcode</label>
                        <input className="input" type="text" name="pin_postcode" onChange={this.handleUserInput}/>
                        <p className="error-message">{pin_postcode}</p>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>Landline</label>
                        <input className="input" type="text" name="landline" onChange={this.handleUserInput}/>
                    </div>
                </div>
                <div className="wrap-input">
                    <div className="col-sm-6 form-group">
                        <label>Mobile</label>
                        <input className="input" type="text" name="mobile" onChange={this.handleUserInput}/>
                    </div>
                    <div className="col-sm-6 form-group">
                        <label>*Email</label>
                        <input className="input" type="text" name="email" onChange={this.handleUserInput}/>
                        <p className="error-message">{email}</p>
                    </div>
                </div>
                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={this.props.back}>Back
                    </button>
                    <button className="login-form-btn" onClick={this.props.next} disabled={!this.state.formValid}>Next
                    </button>
                </div>
            </div>
        )
    }
}