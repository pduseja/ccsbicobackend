import React, {Component} from 'react';
import {states} from './States.js';
import {StateMachine} from './StateMachine.js';
import {UserID} from "./UserID";
import {MemorableWord} from "./MemorableWord";
import {SecurityQuestion} from "./SecurityQuestion";
import SetPassword from "./SetPassword";
import connect from "react-redux/es/connect/connect";

class ForgotPassword extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentState: states.USERID
        };
        this.stateMachine = new StateMachine();
    }
    componentDidMount(){
        document.title = "Forgot password"
    }
    _next = (desiredState, data, userId) => {
        let currentState = this.state.currentState;
        let nextState = this.stateMachine.transitionTo(currentState, desiredState);
        this.setState({
            currentState: nextState,
            data: data,
            userId: userId
        });
    };

    _currentStep = () => {
        switch (this.state.currentState) {
            case states.USERID:
                return (<UserID next={this._next} />);
            case states.SECURITYQUESTION:
                return (<SecurityQuestion next={this._next} data={this.state.data} userId={this.state.userId}/>);
            case states.MEMORABLEWORD:
                return (<MemorableWord next={this._next} data={this.state.data} userId={this.state.userId}/>);
            case states.SETPASSWORD:
                return (<SetPassword data={this.state.data}  userId={this.state.userId}/>)
            default:
                return (<UserID next={this._next}/>);
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

export default connect()(ForgotPassword);
