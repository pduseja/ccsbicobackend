import React, {Component} from 'react';
import constants from "../Utils/Constants";

export default class UserOptions extends Component {
    render() {
        let links = constants.menuItems.links.map((link, i) => <li ref={i + 1} key={i}>
            <p onClick={() => this.toggle(link.name)}><a href={link.link}>{link.text}</a>
            </p>

        </li>);

        return (
            <div className={this.props.rightMenuStatus} id='menu'>
                <ul>
                    {links}
                </ul>
            </div>
        )
    }
}