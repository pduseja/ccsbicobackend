import React, {Component} from 'react';
import MenuLinks from "./MenuLinks";
import {Link} from "react-router-dom";
import '../Styles/Header.css'

export default class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isOpen: false
        };
    }

    componentDidMount() {
        document.addEventListener('click', this._handleDocumentClick, false);
    }

    componentWillUnmount() {
        document.removeEventListener('click', this._handleDocumentClick, false);
    }

    _handleDocumentClick = (e) => {
        if (!this.refs.root.contains(e.target) && this.state.isOpen === true) {
            this.setState({
                isOpen: false
            });
        }
        ;
    };

    _menuToggle = (e) => {
        e.stopPropagation();
        this.setState({
            isOpen: !this.state.isOpen
        });
    };

    render() {
        let menuStatus = this.state.isOpen ? 'isopen' : '';

        return (
            <div ref="root">
                <nav className="navbar">
                    <div className="navbar-top">
                        <Link className="logo" to="/">
                            <img src="http://ccsbi.info/usersresource/images/logo.png" alt="logo"/>
                        </Link>
                        <div className="d-none d-sm-none d-md-block d-lg-block d-xl-block">
                            <Link to="/login" className="custom-btn">Login</Link>
                        </div>
                        <div onClick={ this._menuToggle } id="hambmenu"
                             className={"d-block d-sm-block d-md-none d-lg-none d-xl-none " + menuStatus }>
                            <i className="fas fa-bars"/>
                        </div>
                        {/*<div className="important-links">*/}
                        {/*<ul>*/}
                        {/*<li><a href="#">Important information</a></li>*/}
                        {/*<li><a href="#">Privacy policy</a></li>*/}
                        {/*<li><a  href="#">Terms of use</a></li>*/}
                        {/*<li><a href="#">Cookies</a></li>*/}
                        {/*<li><a href="#"><i className="fab fa-facebook-f"/></a></li>*/}
                        {/*<li><a href="#"><i className="fab fa-twitter"/></a></li>*/}
                        {/*<li><a href="#"><i className="fab fa-linkedin-in"/></a></li>*/}
                        {/*<li><a href="#"><i className="fab fa-youtube"/></a></li>*/}
                        {/*</ul>*/}
                        {/*</div>*/}
                    </div>
                    <div className="navbar-bottom  d-none d-sm-none d-md-block d-lg-block d-xl-block">
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
                        </ul>

                    </div>
                </nav>
                <MenuLinks menuStatus={ menuStatus }/>
            </div>
        )
    }
}