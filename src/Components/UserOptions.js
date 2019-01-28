import React, {Component} from 'react';
import {Link} from "react-router-dom";

export default class UserOptions extends Component {
    render() {
        return (
            <div className={"hide "+this.props.rightMenuStatus}>
            <span className="up-arrow"></span>
                <ul className="user-options">
                    <li onClick={this.props.hideMenu}><Link to="/Profile">My Profile</Link></li>
                    <li onClick={this.props.hideMenu}><Link to="/MyDashboard">My Dashboard</Link></li>
                    <li onClick={this.props.hideMenu}><Link to="/AdminDashboard">Admin dashboard</Link></li>
                </ul>
            </div>
        )
    }
}