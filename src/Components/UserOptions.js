import React, {Component} from 'react';
import {Link} from "react-router-dom";

export default class UserOptions extends Component {
    render() {
        return (
            <div className={"hide "+this.props.rightMenuStatus}>
            <span className="up-arrow"></span>
                <ul>
                    <li>My Profile</li>
                    <li>My Dashboard</li>
                    <li><Link to="/AdminDashboard">Admin dashboard</Link></li>
                </ul>
            </div>
        )
    }
}