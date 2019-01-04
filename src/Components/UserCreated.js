import React from 'react';
import {Link} from "react-router-dom";
import {connect} from "react-redux";
import {withRouter} from "react-router-dom";

export class UserCreated extends React.Component{
    render(){
        this.props.onSubmit && this.props.onSubmit();
        return(<div style={{'padding':'170px 15px 0 15px'}}>
                <div style={{'padding':'0 0 10px 0','color':'#6f6e6e','fontWeight': '600','fontSize':'18px'}}>{this.props.location.data}</div>
                <Link to="/">Go to home</Link>
            </div>
    )}
};

const mapDispatchToProps = (dispatch) => ({
    onSubmit: () => dispatch({ type: 'CLEAR_DATA', text: {}})
});
export default withRouter(connect(null,mapDispatchToProps)(UserCreated));