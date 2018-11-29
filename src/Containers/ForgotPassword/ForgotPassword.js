import React, {Component} from 'react';
import {states} from './States.js';
import {StateMachine} from './StateMachine.js';
import {Details} from "./Details";
import {Retrieve} from "./Retrieve";

class ForgotPassword extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentState: states.DETAILS
        };
        this.stateMachine = new StateMachine();
    }

    _next = (desiredState) => {
        let currentState = this.state.currentState;
        console.log(currentState, desiredState)
        let nextState = this.stateMachine.transitionTo(currentState, desiredState);
        this.setState({
            currentState: nextState
        });
    };

    _back = (desiredState) => {
        let currentState = this.state.currentState;
        this.setState({
            currentState: this.stateMachine.transitionFrom(currentState, desiredState)
        });
    };

    _currentStep = () => {
        switch (this.state.currentState) {
            case states.PERSONAL_DETAILS:
                return (<Details next={this._next}/>);
            case states.RETRIEVE:
                return (<Retrieve next={this._next} back={this._back}/>);
            default:
                return (<Details next={this._next}/>);
        }
    };

    render() {
        return (
            <div>
                <div className="form-container">

                    <div className="wrapper">
                        {this._currentStep()}
                    </div>
                </div>
            </div>
        );
    }
}

export default ForgotPassword;
