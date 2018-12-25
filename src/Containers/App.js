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
import UserCreated from "../Components/UserCreated";
import UnderConstruction from "../Components/UnderConstruction";
import Footer from "../Components/Footer";

const store = createStore(Reducers);
class App extends Component {
    render() {
        return (
            <Provider store={store}>
            <BrowserRouter basename={'/CCSBI'}>
                <div>
                    <Route path="/" component={Header}/>
                    <Route exact path="/" component={Home}/>
                    <Route exact path="/login" component={Login}/>
                    <Route exact path="/registration" component={Registration}/>
                    <Route exact path="/forgotPassword" component={ForgotPassword}/>
                    <Route exact path="/UserCreated" component={UserCreated} />
                    <Route exact path="/ImportantLinks" component={UnderConstruction} />
                    <Route exact path="/PrivacyPolicy" component={UnderConstruction} />
                    <Route exact path="/TermsOfUse" component={UnderConstruction} />
                    <Route exact path="/Cookies" component={UnderConstruction} />
                    <Route exact path="/Language" component={UnderConstruction} />
                    <Route exact path="/AboutUs" component={UnderConstruction}/>
                    <Route exact path="/WhatWeDo" component={UnderConstruction}/>
                    <Route exact path="/Team" component={UnderConstruction}/>
                    <Route exact path="/Pricing" component={UnderConstruction}/>
                    <Route exact path="/FAQ" component={UnderConstruction}/>
                    <Route exact path="/AboutUs" component={UnderConstruction}/>
                    <Route exact path="/EducationSupport" component={UnderConstruction}/>
                    <Route exact path="/CareSupport" component={UnderConstruction}/>
                    <Route exact path="/BusinessSupport" component={UnderConstruction}/>
                    <Route exact path="/OperationManagement" component={UnderConstruction}/>
                    <Route exact path="/InformationTech" component={UnderConstruction}/>
                    <Route exact path="/Citizen" component={UnderConstruction}/>
                    <Route exact path="/SmallBusiness" component={UnderConstruction}/>
                    <Route exact path="/CCSBIFamilies" component={UnderConstruction}/>
                    <Route exact path="/Franchises" component={UnderConstruction}/>
                    <Route exact path="/Stakeholders" component={UnderConstruction}/>
                    <Route exact path="/ServicesProdSearch" component={UnderConstruction}/>
                    <Route exact path="/OurApproach" component={UnderConstruction}/>
                    <Route exact path="/Help" component={UnderConstruction}/>
                    <Route exact path="/WriteToUs" component={UnderConstruction}/>
                    <Route exact path="/AdditionalInfo" component={UnderConstruction}/>
                    <Route exact path="/CharityOptions" component={UnderConstruction}/>
                    <Route exact path="/OpinionPolls" component={UnderConstruction}/>
                    <Route exact path="/ContactUs" component={UnderConstruction}/>
                    <Route path="/" component={Footer} />
                </div>
            </BrowserRouter>
            </Provider>
        );
    }
}

export default App;
