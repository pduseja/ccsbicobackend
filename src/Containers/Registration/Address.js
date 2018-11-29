import React, {Component} from 'react';
import {states} from './States.js';
import AddressForm from "../../Components/Registration/AddressForm";

export class Address extends Component {
    constructor(props) {
        super(props);
        this.state = {
            value: null,
            errors: [],
            key: 1
        };
    }

    _next = () => {
        this.props.next(states.SECURITY);
    };

    _back = () => {
        this.props.back(states.PERSONAL_DETAILS)
    };

    handleSelect = (key) => {
        this.setState({key});
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
                        <a className="nav-link" id="pills-tempoarary" data-toggle="pill" href="#Temporary" role="tab"
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
                        <AddressForm next={this._next} back={this._back}/></div>
                    <div className="tab-pane fade" id="Temporary" role="tabpanel" aria-labelledby="pills-tempoarary">
                        <AddressForm next={this._next} back={this._back}/></div>
                    <div className="tab-pane fade" id="Work" role="tabpanel" aria-labelledby="pills-work">
                        <AddressForm next={this._next} back={this._back}/></div>
                    <div className="tab-pane fade" id="Billing" role="tabpanel" aria-labelledby="pills-billing">
                        <AddressForm next={this._next} back={this._back}/></div>
                </div>


            </div>
        );
    }
}