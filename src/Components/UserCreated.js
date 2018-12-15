import React from 'react';
import {Link} from "react-router-dom";

export default class UserCreated extends React.Component{
    render(){
        return(<div style={{'padding':'170px 15px 0 15px'}}>
                <div style={{'padding':'0 0 10px 0','color':'#6f6e6e','font-weight': '600','font-size':'18px'}}>{this.props.location.data}</div>
                <Link to="/">Go to home</Link>
            </div>
    )}
};

