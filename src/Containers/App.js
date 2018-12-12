import React, {Component} from 'react';
import '../Styles/App.css';
import {BrowserRouter, Route} from "react-router-dom";
import Home from "./Home";
import Login from "./Login/Login";
import Registration from "./Registration/Registration";
import '../Styles/Override.css'
import Header from "../Components/Header";
import ForgotPassword from "./ForgotPassword/ForgotPassword";
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import Reducers from "../Reducers/Reducers";

const store = createStore(Reducers)
class App extends Component {
    render() {
        return (
            <Provider store={store}>
            <BrowserRouter>
                <div>
                    <Route path="/" component={Header}/>
                    <Route exact path="/login" component={Login}/>
                    <Route exact path="/registration" component={Registration}/>
                    <Route exact path="/forgotPassword" component={ForgotPassword}/>
                    <Route exact path="/" component={Home}/>
                </div>
            </BrowserRouter>
            </Provider>
        );
    }
}

export default App;
