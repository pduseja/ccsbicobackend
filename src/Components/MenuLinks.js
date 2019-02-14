import React,{ Component } from 'react';
import constants from '../Utils/Constants';
import Helpers from "../Utils/Helpers";
import {connect} from "react-redux";
import {Link} from "react-router-dom";

export class MenuLinks extends Component {
    constructor(props) {
        super(props);
        this.state = {
            active: {
                aboutus: false,
                services: false,
                ourpartners: false,
                search: false,
                user: ''
            }
        }
    }

    componentDidMount() {
        this.getUserDetails();
    }
    componentWillReceiveProps(nextProps, nextContext) {
        this.getUserDetails();
    }
    getUserDetails = () =>{
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


    toggle = (name) => {
        const currentState = this.state.active[name];
        this.setState( {active: { [name] : !currentState }});
    };


    render() {
        let { user } = this.props;
        let links = constants.menuItems.links.map((link, i) => <li ref={i + 1} key={i} onClick={!link.submenu && this.props.hideMenu}>
                <p onClick={() => this.toggle(link.name)} >
                    {link.link ? <Link to={link.link}>{link.text}</Link> : <span>{link.text}</span>}
                    {link.submenu &&
                    <i className={"icon " + (this.state.active[link.name] ? 'fas fa-chevron-up' : 'fas fa-chevron-down')} />}</p>
                {link.submenu && this.state.active[link.name] && <ul className="sub-menu">
                        {link.submenu.map(item => <li key={item.text} onClick={this.props.hideMenu}><Link to={item.link}>{item.text}</Link></li>)}</ul>}

        </li>);

        return (
            <div className={this.props.menuStatus} id='menu'>
                <ul>
                    { links }
                    {user === '' ? <li><span onClick={this.props.login}>Login</span></li> :
                        <li><span onClick={this.props.logout}>Logout</span></li>}
                </ul>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    user: state.user
});

export default connect(mapStateToProps)(MenuLinks);