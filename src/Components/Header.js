import React, {Component} from 'react';
import MenuLinks from "./MenuLinks";
import {Link} from "react-router-dom";
import '../Styles/Header.css'
import Helpers from "../Utils/Helpers";
import UserOptions from "./UserOptions";

export default class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isOpen: false,
            isRightOpen: false,
            user: '',
            currentPage: ''
        };
    }

    componentDidMount() {
        this.getUserDetails();
        document.addEventListener('click', this._handleDocumentClick, false);

    }

    componentWillUnmount() {
        document.removeEventListener('click', this._handleDocumentClick, false);
    }

    _handleDocumentClick = (e) => {
        if (!this.refs.root.contains(e.target) && this.state.isOpen === true) {
            this.setState({
                isOpen: false,
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

    getUserDetails = () => {
        this.setState({'currentPage': this.props.history.location.pathname === '/login'});
        let authData = Helpers.authenticateUser();
        if (authData) {
            this.setState({
                user: authData
            })
        }
        else{
            this.setState({
                user: ''
            })
        }
    };

    login = () => {
      this.props.history.push('/login');
      this.setState({'isOpen': false, 'isRightOpen': false})
    };

    logout = () => {
        localStorage.removeItem('user');
        this.props.history.push('/');
        this.setState({'isOpen': false, 'isRightOpen': false})
    };

    componentWillReceiveProps(nextProps, nextContext) {
        this.getUserDetails();
    }

    render() {
        let {user,currentPage} = this.state;
        let menuStatus = this.state.isOpen ? 'isopen' : '';
        let rightMenuStatus = this.state.isRightOpen ? 'is-right-open' : '';

        return (
            <div ref="root">
                <nav className="navbar">
                    <ul className="important-links">
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><a href="/">Important
                            information</a></li>
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><a href="/">Privacy policy</a>
                        </li>
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><a href="/">Terms of use</a>
                        </li>
                        <li className="d-none d-sm-none d-md-block d-lg-block d-xl-block"><a href="/">Cookies</a></li>
                        <li><a href="/">Languages</a></li>
                        <li><a href="/"><i className="fab fa-facebook-f"/></a></li>
                        <li><a href="/"><i className="fab fa-twitter"/></a></li>
                        <li><a href="/"><i className="fab fa-linkedin-in"/></a></li>
                        <li><a href="/"><i className="fab fa-youtube"/></a></li>
                    </ul>

                    <div className="navbar-top">
                        <div className="logo-container">{!currentPage && <div onClick={this._menuToggle} id="hambmenu"
                                                                              className={"d-inline-block d-sm-inline-block d-md-none d-lg-none" +
                                                                              " d-xl-none " + menuStatus}>
                            <i className="fas fa-bars"/>
                        </div>}
                            <Link className="logo" to="/">
                                <img src="http://ccsbi.info/usersresource/images/logo.png" alt="logo"/>
                            </Link></div>
                        {!currentPage && (user !== '' &&
                            <div className="user-info">
                                <span>{user.firstName} {user.lastName}</span><i id="ellipsis" onClick={this._menuRightToggle} className="fa fa-ellipsis-v"/>
                            </div>
                            )}
                    </div>


                    {!currentPage && <div className="navbar-bottom  d-none d-sm-none d-md-block d-lg-block d-xl-block">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <Link to="/" className="nav-link">Home</Link>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">About us</Link>
                                <ul>
                                    <li><Link to="/">About us</Link></li>
                                    <li><Link to="/">What we do</Link></li>
                                    <li><Link to="/">Team</Link></li>
                                    <li><Link to="/">Pricing</Link></li>
                                    <li><Link to="/">FAQ's</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">Services</Link>
                                <ul>
                                    <li><Link to="/">Educational Support Services</Link></li>
                                    <li><Link to="/">Care Support Services</Link></li>
                                    <li><Link to="/">Business Support Services</Link></li>
                                    <li><Link to="/">Operations Management</Link></li>
                                    <li><Link to="/">Information Tech Services</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">Our partners</Link>
                                <ul>
                                    <li><Link to="/">Citizens</Link></li>
                                    <li><Link to="/">Small businesses</Link></li>
                                    <li><Link to="/">CCSBI Families</Link></li>
                                    <li><Link to="/">Franchises</Link></li>
                                    <li><Link to="/">Other stakeholders</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item"><Link to="/" className="nav-link">Search S&P</Link>
                                <ul>
                                    <li><Link to="/">Service & Prod Search</Link></li>
                                    <li><Link to="/">Our approach</Link></li>
                                    <li><Link to="/">Help: How it Works</Link></li>
                                    <li><Link to="/">Write your need</Link></li>
                                    <li><Link to="/">Additional information</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item">
                                <Link to="/" className="nav-link">Opinion polls</Link>
                            </li>
                            <li className="nav-item">
                                <Link to="/" className="nav-link">Contact us</Link>
                            </li>
                            {!currentPage && <li className="nav-item d-none d-sm-none d-md-block d-lg-block d-xl-block">
                                {user === '' ? <Link to="/login" className="custom-btn">Login</Link> :
                                    <Link to="/" className="custom-btn"
                                          onClick={() => this.logout()}>Logout</Link>}</li>}
                        </ul>

                    </div>}
                </nav>
                <MenuLinks menuStatus={menuStatus} login={this.login} logout={this.logout}/>
                <UserOptions rightMenuStatus={rightMenuStatus}/>
            </div>
        )
    }
}