import React from 'react';
import '../../Styles/Admin.css'
import SystemParams from '../../Components/Admin/SystemParams'
import FAQS from '../../Components/Admin/FAQS'
import PendingAndRegisteredUsers from './PendingAndRegisteredUsers'
export default class AdminDashboard extends React.Component{
    render(){
        return(
            <div className="common-wrapper">
               <div className="admin-menu nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                 <a className="nav-link active" id="v-pills-users-tab" data-toggle="pill" href="#v-pills-users" role="tab" aria-controls="v-pills-users" aria-selected="true">Manage registered user</a>
                 <a className="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-system-params" role="tab" aria-controls="v-pills-system-params" aria-selected="false">System params</a>
                 <a className="nav-link" id="v-pills-addedit-faq-tab" data-toggle="pill" href="#v-pills-addedit-faq" role="tab" aria-controls="v-pills-addedit-faq" aria-selected="false">Add/Edit Faqs</a>
                 <a className="nav-link" id="v-pills-mail-settings-tab" data-toggle="pill" href="#v-pills-mail-settings" role="tab" aria-controls="v-pills-mail-settings" aria-selected="false">Email settings</a>
               </div>
               <div className="admin-menu-content tab-content" id="v-pills-tabContent">
                 <div className="tab-pane fade show active" id="v-pills-users" role="tabpanel" aria-labelledby="v-pills-teams-tab">
                    <PendingAndRegisteredUsers />
                 </div>
                 <div className="tab-pane fade" id="v-pills-system-params" role="tabpanel" aria-labelledby="v-pills-system-params-tab"> <SystemParams /></div>
                 <div className="tab-pane fade" id="v-pills-addedit-faq" role="tabpanel" aria-labelledby="v-pills-addedit-faq-tab"><FAQS /></div>
                 <div className="tab-pane fade" id="v-pills-mail-settings" role="tabpanel" aria-labelledby="v-pills-mail-settings-tab">Email settings</div>
               </div>
            </div>
        )
    }

}