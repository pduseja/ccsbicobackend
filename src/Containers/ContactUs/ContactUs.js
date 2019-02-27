import React from 'react'
import {Link} from "react-router-dom";

export default class ContactUs extends React.Component{
    render(){
        return(
            <div className="common-wrapper">
                <div className="full-wrapper">
                    <h5 className="title-color">Primary contact methods</h5>
                    <div className="col-sm-6">
                        <Link to="/SecureMessageForm" className="active-link">
                        <i className="fa fa-envelope" style={{marginRight: 8,fontSize: 15,color: 'orange'}}
                         aria-hidden="true"></i>Send secure message</Link>

                    </div>
                    <div className="col-sm-6">
                        <Link to="/AuthenticateChatUser" className="active-link">
                        <i className="fa fa-comments"  style={{marginRight: 8,fontSize: 15,color: 'orange'}}
                         aria-hidden="true"></i>Live chat</Link>
                    </div>
                </div>
            </div>
        )
    }
}