import React, {Component} from 'react';
import '../Styles/App.css';
import {BrowserRouter, Route} from "react-router-dom";
import Home from "./Home";
import Login from "./Login/Login";
import Registration from "./Registration/Registration";
import PersonalDetails from "./Registration/PersonalDetails";
import Security from "../Components/Profile/Security";
import Address from "./Registration/Address";
import '../Styles/Override.css'
import Header from "../Components/Header";
import ForgotPassword from "./ForgotPassword/ForgotPassword";
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import Reducers from "../Reducers/Reducers";
import UserCreated from "../Components/UserCreated";
import UserMessage from "../Components/UserMessage";
import Profile from "../Containers/Profile/Profile";
import UnderConstruction from "../Components/UnderConstruction";
import Footer from "../Components/Footer";
import EditRole from "../Components/Admin/EditRole";
import AdminDashboard from "../Containers/Admin/AdminDashboard";
import ContactUs from "../Containers/ContactUs/ContactUs";
import SecureMessageForm from "../Containers/ContactUs/SecureMessageForm";
import FollowUpMessageForm from "../Containers/ContactUs/FollowUpMessageForm";
import SecureMessages from "../Components/SecureMessages";
import CommunicationDashboard from "../Components/Communication/CommunicationDashboard";
import MessageReply from "../Components/Communication/MessageReply";
import MessageFollowUpReply from "../Components/Communication/MessageFollowUpReply";
import LiveChat from "../Containers/Chat/LiveChat"
import LiveChatDashboard from "../Containers/LiveChat/LiveChatDashboard"
import ChatWindow from "../Containers/LiveChat/ChatWindow"
import AuthenticateChatUser from "../Containers/Chat/AuthenticateChatUser"
import ChatBoard from "../Containers/Chat/ChatBoard/ChatBoard"

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
                    <Route exact path="/PersonalDetails" component={PersonalDetails}/>
                    <Route exact path="/Address" component={Address}/>
                    <Route exact path="/Security" component={Security}/>
                    <Route exact path="/forgotPassword" component={ForgotPassword}/>
                    <Route exact path="/UserCreated" component={UserCreated} />
                    <Route exact path="/UserMessage" component={UserMessage} />
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
                    <Route exact path="/ContactUs" component={ContactUs}/>
                    <Route exact path="/SecureMessageForm" component={SecureMessageForm}/>
                    <Route exact path="/Profile" component={Profile}/>
                    <Route exact path="/MyDashboard" component={UnderConstruction}/>
                    <Route exact path="/AdminDashboard" component={AdminDashboard}/>
                    <Route exact path="/EditRole" component={EditRole}/>
                    <Route exact path="/SecureMessages" component={SecureMessages} />
                    <Route exact path="/FollowUpMessageForm" component={FollowUpMessageForm} />
                    <Route exact path="/CommunicationDashboard" component={CommunicationDashboard} />
                    <Route exact path="/MessageReply" component={MessageReply} />
                    <Route exact path="/MessageFollowUpReply" component={MessageFollowUpReply} />
                    <Route exact path="/LiveChat" component={LiveChat} />
                    <Route exact path="/AuthenticateChatUser" component={AuthenticateChatUser} />
                    <Route exact path="/ChatBoard" component={ChatBoard} />
                    <Route exact path="/LiveChatDashboard" component={LiveChatDashboard} />
                    <Route exact path="/ChatWindow" component={ChatWindow} />

                    <Route path="/" component={Footer} />
                </div>
            </BrowserRouter>
            </Provider>
        );
    }
}

export default App;
