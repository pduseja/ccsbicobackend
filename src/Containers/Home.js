import React, {Component} from 'react';
import icon1 from '../Images/icon01.png'
import icon2 from '../Images/icon02.png'
import icon3 from '../Images/icon03.png'
import icon4 from '../Images/icon04.png'
import contact1 from '../Images/contact-icon01.png'
import contact2 from '../Images/contact-icon02.png'
import contact3 from '../Images/contact-icon03.png'
import contact4 from '../Images/contact-icon04.png'
import image1 from '../Images/image1.jpg'
import image2 from '../Images/image2.jpg'

export default class Home extends Component {
    render() {
        return (
            <div className="home">
                <section className="main-features">
                    <div className="container">
                        <div className="row">
                            <div className="col-12">
                                <div className="titles">
                                    <span className="title-bg" />
                                    <h3>Top Services</h3>
                                </div>
                            </div>
                            <div className="col-lg-3 col-md-6">
                                <div className="feature-box">
                                    <figure><img src={icon1} alt="Framework"/></figure>
                                    <h5>Framework</h5>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>

                                    <a href="/" className="more-link">+</a></div>
                            </div>
                            <div className="col-lg-3 col-md-6">
                                <div className="feature-box">
                                    <figure><img src={icon2} alt="Our products"/></figure>
                                    <h5>Our products</h5>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
                                    <a href="/" className="more-link">+</a></div>
                            </div>
                            <div className="col-lg-3 col-md-6">
                                <div className="feature-box">
                                    <figure><img src={icon3} alt="Services"/></figure>
                                    <h5>Services</h5>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
                                    <a href="/" className="more-link">+</a></div>
                            </div>
                            <div className="col-lg-3 col-md-6">
                                <div className="feature-box">
                                    <figure><img src={icon4} alt="CCSBI-BIZ"/></figure>
                                    <h5>CCSBI-BIZ</h5>
                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
                                    <a href="/" className="more-link">+</a></div>
                            </div>
                        </div>

                    </div>
                </section>

                <section className="recent-news">
                    <div className="container">
                        <div className="row">

                            <div className="col-lg-6">
                                <div className="news-box">
                                    <figure><img src={image1} alt="What we do"/></figure>
                                    <div className="news-content">
                                        <h3>What we do</h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
                                        <a href="/">READ MORE</a></div>
                                </div>
                            </div>

                            <div className="col-lg-6">
                                <div className="news-box">
                                    <figure><img src={image2} alt="Our Team"/></figure>
                                    <div className="news-content">
                                        <h3>Our Team</h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
                                        <a href="/">READ MORE</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <section className="footer-bar">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-3 col-md-6">
                                <figure><img src={contact1} alt="E-MAILS"/></figure>
                                <h4>E-MAILS</h4>
                                <address>
                                    info@ccsbi.com
                                </address>
                            </div>
                            <div className="col-lg-3 col-md-6">
                                <figure><img src={contact2} alt="PHONES"/></figure>
                                <h4>PHONES</h4>
                                <address>
                                    +380 (98) 294 80 86
                                </address>
                            </div>
                            <div className="col-lg-3 col-md-6">
                                <figure><img src={contact3} alt="SUPPORT"/></figure>
                                <h4>SUPPORT</h4>
                                <address>
                                    Mon to Fri 09:00h to 18:00h
                                </address>
                            </div>
                            <div className="col-lg-3 col-md-6">
                                <figure><img src={contact4} alt="LOCATION"/></figure>
                                <h4>LOCATION</h4>
                                <address>
                                    UK
                                </address>
                            </div>
                        </div>
                    </div>
                </section>

                <footer className="footer">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-12 col-sm-12 col-md-12">
                                <small>© 2018 ccsbi.com | All Rights Reserved.</small>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        )
    }
}