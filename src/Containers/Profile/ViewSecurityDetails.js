import React from 'react';
import {connect} from "react-redux";
import {Link} from "react-router-dom";

export class ViewSecurityDetails extends React.Component{

    render(){
        let {securityQuestionId1, securityQuestionId2, memorableWord} = this.props.details.UsersDetails
        return(<div className="profile-details">
        <Link to={{pathname:"/Security", flow: "Profile"}}>
           <i style={{fontSize: 25, float: 'right'}} class="fas fa-edit"></i>
        </Link>
            <div className="form-group">
                <label>Security question 1</label>
                <span>{securityQuestionId1}</span>
           </div>
         <div className="form-group">
              <label>Security answer</label>
              <span></span>
         </div>
           <div className="form-group">
                <label>Security question 2</label>
                <span>{securityQuestionId2}</span>
           </div>
             <div className="form-group">
                  <label>Security answer</label>
                  <span></span>
             </div>
           <div className="form-group">
                <label>MemorableWord</label>
                <span>{memorableWord}</span>
           </div>

        </div>)
    }
}
const mapStateToProps = state => ({
    details: state.details
});
export default connect(mapStateToProps)(ViewSecurityDetails);