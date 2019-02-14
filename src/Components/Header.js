import React, {Component} from 'react';
import MenuLinks from "./MenuLinks";
import Logo from '../Images/logo.png'
import {Link} from "react-router-dom";
import '../Styles/Header.css'
import UserOptions from "./UserOptions";
import WebApi from "../Utils/WebApi";
import {connect} from "react-redux";
import {addUserName,addUserDetails} from "../Actions/Actions";
import Cookies from 'universal-cookie';

export class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isOpen: false,
            isRightOpen: false,
            user: '',
            systemParams: {}
        };
    }

    componentDidMount() {
        this.getUserDetails();
        document.addEventListener('click', this._handleDocumentClick, false);
        WebApi.getSystemParams().then(response => response.json()).then(response => {
            this.setState({
                systemParams: response
            })
        })
    }

    componentWillUpdate(nextProps, nextState, nextContext) {
        if(nextProps.location.pathname === '/login' ||
            nextProps.location.pathname === '/forgotPassword' ||
            nextProps.location.pathname === '/registration')
            this.props.dispatch(addUserName(''))
    }

    componentWillUnmount() {
        document.removeEventListener('click', this._handleDocumentClick, false);
    }

    _handleDocumentClick = (e) => {
        if (!this.refs.root.contains(e.target) && this.state.isOpen === true) {
            this.setState({
                isOpen: false,
            });
        }
        if (!this.refs.root.contains(e.target) && this.state.isRightOpen === true) {
            this.setState({
                isRightOpen: false
            });
        }
    };

    _menuRightToggle = (e) => {
        e.stopPropagation();
        this.setState({
            isRightOpen: !this.state.isRightOpen
        });
    };

    _menuToggle = (e) => {
        e.stopPropagation();
        this.setState({
            isOpen: !this.state.isOpen
        });
    };

    login = () => {
        this.props.history.push('/login');
        this.setState({'isOpen': false, 'isRightOpen': false})
    };

    getUserDetails = () => {
        const cookies = new Cookies();
        const cookie = cookies.get('cookie');
        const token = cookies.get('token');
        if(cookie && token){
        WebApi.getLoggedInUser(cookie, token)
            .then(response => response.json())
            .then(response => {
                this.props.dispatch(addUserName(response.firstName))
                this.props.dispatch(addUserDetails(response))
                if (response.UsersLoginRecord.rememberMe === true) {
                const cookies = new Cookies();
                     cookies.set('token', response.UsersLoginRecord.token, { path: '/', expires: this.getDate() });
                     cookies.set('cookie', response.UsersLoginRecord.cookie, { path: '/', expires: this.getDate() });

                }
                else{
                const cookies = new Cookies();
                     cookies.remove('token');
                     cookies.remove('cookie');

                }
            }).catch(err =>{
            this.props.dispatch(addUserName(''))
        });
        }
        else{
            this.props.dispatch(addUserName(''))
        }
    };

    getDate = () =>{
        let d = new Date()
        d.setDate(d.getDate() + 1)
        return d;
    };

    logout = () => {
        const cookies = new Cookies();
        cookies.remove('token', { path: '/' });
        cookies.remove('cookie', { path: '/' });
        this.props.history.push('/');
        this.props.dispatch(addUserName(''))
        this.props.dispatch(addUserDetails(''))
        this.setState({'isOpen': false, 'isRightOpen': false})
    };

    getPath = (param) => {
        return Object.values(this.state.systemParams).filter((p) =>
            p.keyVal1 === param
        );
    };

    hideMenu = () =>{
        this.setState({
            isRightOpen: false,
            isOpen: false
        });
    }

    render() {
        let {currentPage} = this.state;
        let {user} = this.props;
        let facebookLink, twitterLink, linkedInLink, youtubeLink;
        let menuStatus = this.state.isOpen ? 'isopen' : '';
        let rightMenuStatus = this.state.isRightOpen ? 'is-right-open' : '';
        if (this.state.systemParams.length) {
            facebookLink = this.getPath("Facebook")[0].param1;
            twitterLink = this.getPath("Twiter")[0].param1;
            linkedInLink = this.getPath("Linkedin")[0].param1;
            youtubeLink = this.getPath("Youtube")[0].param1;
        }
        return (
            <div ref="root">
                <nav className="navbar">
                    <ul className="important-links">
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><Link to="/ImportantLinks">Important
                            information</Link></li>
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><Link to="/PrivacyPolicy">Privacy
                            policy</Link>
                        </li>
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><Link to="/TermsOfUse">Terms
                            of use</Link>
                        </li>
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><Link
                            to="/Cookies">Cookies</Link></li>
                        <li><Link to="/Language">Languages</Link></li>
                        <li><a href={facebookLink} rel="noopener noreferrer" target="_blank"><i className="fab fa-facebook-f"/></a></li>
                        <li><a href={twitterLink} rel="noopener noreferrer" target="_blank"><i className="fab fa-twitter"/></a></li>
                        <li><a href={linkedInLink} rel="noopener noreferrer" target="_blank"><i className="fab fa-linkedin-in"/></a></li>
                        <li><a href={youtubeLink} rel="noopener noreferrer" target="_blank"><i className="fab fa-youtube"/></a></li>
                    </ul>

                    <div className="navbar-top">
                        <div className="logo-container"><div onClick={this._menuToggle} id="hambmenu"
                                                                              className={"d-inline-block d-sm-inline-block d-md-block d-lg-none" +
                                                                              " d-xl-none " + menuStatus}>
                            <i className="fas fa-bars"/>
                        </div>
                            <Link className="logo" to="/">
                            <img src={Logo} alt="logo"/>
                            </Link></div>
                        {user !== '' &&
                        <div className="user-info" onClick={this._menuRightToggle}>
                            Hello <span>{user}</span><i id="ellipsis"

                                                  className="fa fa-ellipsis-v"/>
                        </div>
                        }
                    </div>


                    <div className="navbar-bottom  d-none d-sm-none d-md-none d-lg-block d-xl-block">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <Link to="/" className="nav-link">Home</Link>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">About us</Link>
                                <ul>
                                    <li onClick={this.hideMenu}><Link to="/AboutUs">About us</Link></li>
                                    <li onClick={this.hideMenu}><Link to="/WhatWeDo">What we do</Link></li>
                                    <li onClick={this.hideMenu}><Link to="/Team">Team</Link></li>
                                    <li onClick={this.hideMenu}><Link to="/Pricing">Pricing</Link></li>
                                    <li onClick={this.hideMenu}><Link to="/FAQ">FAQ's</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">Services</Link>
                                <ul>
                                    <li><Link to="/EducationSupport">Educational Support Services</Link></li>
                                    <li><Link to="/CareSupport">Care Support Services</Link></li>
                                    <li><Link to="/BusinessSupport">Business Support Services</Link></li>
                                    <li><Link to="/OperationManagement">Operations Management</Link></li>
                                    <li><Link to="/InformationTech">Information Tech Services</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">Our partners</Link>
                                <ul>
                                    <li><Link to="/Citizen">Citizens</Link></li>
                                    <li><Link to="/SmallBusiness">Small businesses</Link></li>
                                    <li><Link to="/CCSBIFamilies">CCSBI Families</Link></li>
                                    <li><Link to="/Franchises">Franchises</Link></li>
                                    <li><Link to="/Stakeholders">Other stakeholders</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">Service & Product Search</Link>
                                <ul>
                                    <li><Link to="/ServicesProdSearch">Service & Product Search</Link></li>
                                    <li><Link to="/OurApproach">Our approach</Link></li>
                                    <li><Link to="/Help">Help: How it Works</Link></li>
                                    <li><Link to="/WriteToUs">Write your need</Link></li>
                                    <li><Link to="/AdditionalInfo">Additional information</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item"><Link to="/CharityOptions" className="nav-link">Charity
                                Options</Link></li>
                            <li className="nav-item">
                                <Link to="/OpinionPolls" className="nav-link">Opinion polls</Link>
                            </li>
                            <li className="nav-item">
                                <Link to="/ContactUs" className="nav-link">Contact us</Link>
                            </li>
                            {!currentPage && <li className="nav-item d-none d-sm-none d-md-block d-lg-block d-xl-block">
                                {user === '' ? <Link to="/login" className="custom-btn">Login</Link> :
                                    <Link to="/" className="custom-btn"
                                          onClick={() => this.logout()}>Logout</Link>}</li>}
                        </ul>

                    </div>
                </nav>

                <MenuLinks menuStatus={menuStatus} hideMenu={this.hideMenu} login={this.login} logout={this.logout}/>
                <UserOptions rightMenuStatus={rightMenuStatus} hideMenu={this.hideMenu}/>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    user: state.user
});

export default connect(mapStateToProps)(Header);