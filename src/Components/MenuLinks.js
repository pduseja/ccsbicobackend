import React,{ Component } from 'react';
import constants from '../Utils/Constants';
export default class MenuLinks extends Component {
    constructor(props) {
        super(props);
        this.state = {
            active: {
                aboutus: false,
                services: false,
                ourpartners: false,
                search: false
            }
        }
    }

    toggle = (name) => {
        const currentState = this.state.active[name];
        this.setState( {active: { [name] : !currentState }});
    };

    render() {
        let links = constants.menuItems.links.map((link, i) => <li ref={i + 1} key={i}>
                <p onClick={() => this.toggle(link.name)} ><a href={link.link}>{link.text}</a>
                    {link.submenu &&
                    <i className={"icon " + (this.state.active[link.name] ? 'fas fa-chevron-up' : 'fas fa-chevron-down')} />}</p>
                {link.submenu && this.state.active[link.name] && <ul className="sub-menu">
                        {link.submenu.map(item => <li key={item.text}><a href="/">{item.text}</a></li>)}
                    </ul>}

        </li>);

        return (
            <div className={this.props.menuStatus} id='menu'>
                <ul>
                    { links }
                </ul>
            </div>
        )
    }
}