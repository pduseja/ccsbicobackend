import React, {Component} from 'react';
import {states} from './States.js';
import {StateMachine} from './StateMachine.js';
import Security from "./Security";
import PersonalDetails from "./PersonalDetails";
import Address from "./Address";
import connect from "react-redux/es/connect/connect";
import {addData} from "../../Actions/Actions";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentState: states.PERSONAL_DETAILS
        };
        this.stateMachine = new StateMachine();
    }
    componentDidMount(){
        document.title = "Registration"
    }
    _next = (desiredState, data) => {
        let currentState = this.state.currentState;
        let nextState = this.stateMachine.transitionTo(currentState, desiredState);
        this.props.dispatch(addData(data));
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
                return (<PersonalDetails next={this._next}/>);
            case states.ADDRESS:
                return (<Address
                    back={this._back}
                    next={this._next}/>);
            case states.SECURITY:
                return (<Security
                    saveForm={this._next}
                    back={this._back}/>);
            default:
                return (<PersonalDetails next={this._next}/>);
        }
    };

    render() {
        return (
            <div>
                {this._currentStep()}
            </div>
        );
    }
}


export default connect()(App);
