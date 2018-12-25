import React from 'react';

export default class Footer extends React.Component{
    render(){
        return(<>
            <section className="footer-bar d-flex d-sm-flex d-md-none d-lg-none d-xl-none">
                <ul className="important-links">
                    <li><a href="/">Important information</a></li>
                    <li><a href="/">Privacy policy</a></li>
                    <li><a href="/">Terms of use</a></li>
                    <li><a href="/">Cookies</a></li>
                </ul>
            </section>

            <footer className="footer">
            <div className="container">
            <div className="row">
            <div className="col-lg-12 col-sm-12 col-md-12">
            <small>© 2018 ccsbi.com | All Rights Reserved.</small>
    </div>
    </div>
    </div>
    </footer></>
        )
    }
}