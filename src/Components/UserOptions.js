import React, {Component} from 'react';
import {Link} from "react-router-dom";
import {connect} from "react-redux";
import constants from '../Utils/Constants'
export class UserOptions extends Component {

    render() {
        let id = this.props.user.details ? this.props.user.details.profileId : ""
        return (
            <div className={"hide "+this.props.rightMenuStatus}>
            <span className="up-arrow"></span>
                <ul className="user-options">
                {id && constants.rightMenu[id].map(tab =>
                    <li onClick={this.props.hideMenu}><Link to={"/"+tab}>{tab}</Link></li>
                    )
                }
                </ul>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    user: state

});

export default connect(mapStateToProps)(UserOptions);