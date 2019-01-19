import React from 'react'
import WebApi from "../../Utils/WebApi";
import {withRouter} from "react-router-dom";

export class EditRole extends React.Component{

    state = {
        profileId: this.props.location.data,
        active: "Y"
    }
    componentDidMount(){
        WebApi.getProfiles().then(response => response.json()).then(response => {
            this.setState({
                profiles: response
            })
        })
    }
    onChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        this.setState({[name]: value});
    };

    handleUpdate = () =>{
        let {userId,userName,title,firstName,lastName,photoId,gender,townOfBirth,countryOfBirth,dateofbirth,

        nationality} = this.props.location.data;
        const data = {
            "userId": userId,
            "userName": userName,
            "title": title,
            "firstName": firstName,
            "lastName": lastName,
            "photoId": photoId,
            "gender": gender,
            "townOfBirth": townOfBirth,
            "countryOfBirth": countryOfBirth,
            "dateofbirth": dateofbirth,
            "nationality": nationality,
            "profileId": parseInt(this.state.profileId),
            "active": this.state.active
        }
        WebApi.updateUser(data).then(response => response.json()).then(response => {
             this.props.history.push({pathname:"/AdminDashboard"})
        })
    }
    render(){
        let {userName,firstName} = this.props.location.data;
        return(<div className="common-wrapper">
                     <div className="col-sm-12 form">
                         <div className="col-sm-6 form-group">
                             <label>User name</label>
                             <input className="input" disabled value={userName}/>
                         </div>
                       <div className="col-sm-6 form-group">
                           <label>Name</label>
                           <input className="input" disabled value={firstName}/>
                       </div>
                        <div className="col-sm-6 form-group">
                            <label>Assign profile</label>
                            <select name="profileId" onChange={this.onChange} value={this.state.profileId}>
                                {this.state.profiles &&
                                this.state.profiles.map(p => <option value={p.id} key={p.id}>{p.template}</option>)}
                            </select>
                        </div>
                       <div className="col-sm-6 form-group">
                           <label>Activate</label>
                           <select name="active" onChange={this.onChange}>
                                <option value="Y">Yes</option>
                                <option value="N">No</option>
                           </select>
                       </div>
                       <div className="col-sm-6 form-group">
                            <button onClick={this.handleUpdate}>Update</button>
                       </div>

                    </div>
           </div>
        )
    }
}

export default withRouter(EditRole)