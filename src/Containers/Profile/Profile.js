import React from 'react';
import ViewPersonalDetails from './ViewPersonalDetails'
import ViewAddressDetails from './ViewAddressDetails'
import ViewSecurityDetails from './ViewSecurityDetails'
import '../../Styles/Profile.css'
export default class Profile extends React.Component{
    render(){
        return(
            <div className="common-wrapper">
               <div className="admin-menu nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                 <a className="nav-link active" id="v-pills-personal-tab" data-toggle="pill" href="#v-pills-personal" role="tab" aria-controls="v-pills-personal" aria-selected="true">Personal</a>
                 <a className="nav-link" id="v-pills-address-tab" data-toggle="pill" href="#v-pills-address" role="tab" aria-controls="v-pills-address" aria-selected="false">Address</a>
                 <a className="nav-link" id="v-pills-security-tab" data-toggle="pill" href="#v-pills-security" role="tab" aria-controls="v-pills-security" aria-selected="false">Security</a>
               </div>
               <div className="admin-menu-content tab-content" id="v-pills-tabContent">
                 <div className="tab-pane fade show active" id="v-pills-personal" role="tabpanel" aria-labelledby="v-pills-personal-tab">
                    <ViewPersonalDetails />
                 </div>
                 <div className="tab-pane fade" id="v-pills-address" role="tabpanel" aria-labelledby="v-pills-address-tab">
                    <ViewAddressDetails />
                 </div>
                 <div className="tab-pane fade" id="v-pills-security" role="tabpanel" aria-labelledby="v-pills-security-tab">
                    <ViewSecurityDetails />
                 </div>
               </div>
            </div>
        )
    }

}