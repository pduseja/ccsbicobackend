import React from 'react';
import {connect} from "react-redux";

export class ViewPersonalDetails extends React.Component{

    render(){
        let {firstName, lastName, gender, dateofbirth, townOfBirth, nationality } = this.props.details;
        const date = new Date(parseInt(dateofbirth)).toDateString();
        return(<div className="profile-details">
           <div className="form-group">
                <label>Name</label>
                <span>{firstName}</span>
           </div>
           <div className="form-group">
                <label>Last name</label>
                <span>{lastName}</span>
           </div>
           <div className="form-group">
                <label>Gender</label>
                <span>{gender}</span>
           </div>
          <div className="form-group">
               <label>Date of Birth</label>
               <span>{date}</span>
          </div>
          <div className="form-group">
             <label>Nationality</label>
             <span>{nationality}</span>
          </div>
          <div className="form-group">
               <label>Town of birth</label>
               <span>{townOfBirth}</span>
          </div>
          <div>
            <label>Profile picture</label>
            <img alt="file-upload" className="file-upload-img" src={`data:image/jpeg;base64,${this.props.details.UsersPhoto.photoContent}`} />
            <i style={{fontSize: 15, cursor:'pointer'}} className="fas fa-edit"></i>
          </div>
        </div>)
    }
}
const mapStateToProps = state => ({
    details: state.details
});
export default connect(mapStateToProps)(ViewPersonalDetails);