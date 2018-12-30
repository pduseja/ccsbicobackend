import React, {Component} from 'react';
import {states} from './States.js';
import AddressForm from "../../Components/Registration/AddressForm";
import connect from "react-redux/es/connect/connect";

export class Address extends Component {
    constructor(props) {
        super(props);
        this.state = {
            value: null,
            errors: [],
            key: 1,
            formValid: {
                "1": false,
                "2": true,
                "3": true,
                "4": true
            },
            formData: {
                AddressDetailsList: []
            }
        };
    }

    componentDidMount() {
        let data = this.props.data.AddressDetailsList;
        if(data) {
            this.setState({formValid:{...this.state.formValid,"1":true}
            })
        }
    }

    next = () => {
        this.props.next(states.SECURITY, this.state.formData);
    };

    back = () => {
        this.props.back(states.PERSONAL_DETAILS)
    };

    isFormValid = (data, key, object) => {
        if(object){
        let formStatus = this.state.formValid;
        let address = this.state.formData.AddressDetailsList;
        let found = false;
        this.setState({formValid: {...formStatus, [key]: data}}
        );
        if (address.length === 0) {
            address.push(object)
        }
        address.forEach(function (item, index) {
            if (item.type === object.type) {
                address[index] = object;
                found = true;
            }
        });

        if (!found) address.push(object)
        }
        else{
             let formStatus = this.state.formValid;
             this.setState({formValid: {...formStatus, [key]: data}}
             );
        }

    };

    enableNext = () => {
        let formStatus = this.state.formValid;
        return !(formStatus["1"] && formStatus["2"] && formStatus["3"] && formStatus["4"])
    };

    render() {
        return (
            <div className="registration-form-step2">

                <ul className="nav nav-pills mb-3 nav-justified" id="pills-tab" role="tablist">
                    <li className="nav-item">
                        <a className="nav-link active" id="pills-permanent" data-toggle="pill" href="#Permanent"
                           role="tab" aria-controls="permanent" aria-selected="true">*Permanent</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" id="pills-temporary" data-toggle="pill" href="#Temporary" role="tab"
                           aria-controls="temporary" aria-selected="false">Temporary</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" id="pills-work" data-toggle="pill" href="#Work" role="tab"
                           aria-controls="work" aria-selected="false">Work</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" id="pills-billing" data-toggle="pill" href="#Billing" role="tab"
                           aria-controls="billing" aria-selected="false">Billing</a>
                    </li>
                </ul>
                <div className="tab-content" id="pills-tabContent">
                    <div className="tab-pane fade show active" id="Permanent" role="tabpanel"
                         aria-labelledby="pills-permanent">
                        <AddressForm formNumber={1} isFormValid={this.isFormValid} type="PermA"/>
                    </div>
                    <div className="tab-pane fade" id="Temporary" role="tabpanel" aria-labelledby="pills-temporary">
                        <AddressForm formNumber={2} isFormValid={this.isFormValid} type="TempA"/>
                    </div>
                    <div className="tab-pane fade" id="Work" role="tabpanel" aria-labelledby="pills-work">
                        <AddressForm formNumber={3} isFormValid={this.isFormValid} type="WorkA"/>
                    </div>
                    <div className="tab-pane fade" id="Billing" role="tabpanel" aria-labelledby="pills-billing">
                        <AddressForm formNumber={4} isFormValid={this.isFormValid} type="BillA"/>
                    </div>
                </div>

                <div className="container-login-form-btn">
                    <button className="login-form-btn" onClick={this.back}>Back
                    </button>
                    <button className="login-form-btn" onClick={() => this.next()} disabled={this.enableNext()}>Next
                    </button>
                </div>
            </div>

        );
    }
}
const mapStateToProps = state => ({
    data: state.data
});

export default connect(mapStateToProps)(Address)