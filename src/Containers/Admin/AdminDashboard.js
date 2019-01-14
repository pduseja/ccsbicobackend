import React from 'react';
import '../../Styles/Admin.css'
import SystemParams from '../../Components/Admin/SystemParams'
export default class AdminDashboard extends React.Component{
    render(){
        return(
            <div className="common-wrapper">
               <div class="admin-menu nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                 <a class="nav-link active" id="v-pills-users-tab" data-toggle="pill" href="#v-pills-users" role="tab" aria-controls="v-pills-users" aria-selected="true">Manage registered user</a>
                 <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-system-params" role="tab" aria-controls="v-pills-system-params" aria-selected="false">System params</a>
                 <a class="nav-link" id="v-pills-addedit-faq-tab" data-toggle="pill" href="#v-pills-addedit-faq" role="tab" aria-controls="v-pills-addedit-faq" aria-selected="false">Add/Edit Faqs</a>
                 <a class="nav-link" id="v-pills-mail-settings-tab" data-toggle="pill" href="#v-pills-mail-settings" role="tab" aria-controls="v-pills-mail-settings" aria-selected="false">Email settings</a>
               </div>
               <div class="admin-menu-content tab-content" id="v-pills-tabContent">
                 <div class="tab-pane fade show active" id="v-pills-users" role="tabpanel" aria-labelledby="v-pills-teams-tab">
                    Registered user
                 </div>
                 <div class="tab-pane fade" id="v-pills-system-params" role="tabpanel" aria-labelledby="v-pills-system-params-tab"> <SystemParams /></div>
                 <div class="tab-pane fade" id="v-pills-addedit-faq" role="tabpanel" aria-labelledby="v-pills-addedit-faq-tab">Add edit faq</div>
                 <div class="tab-pane fade" id="v-pills-mail-settings" role="tabpanel" aria-labelledby="v-pills-mail-settings-tab">Email settings</div>
               </div>
            </div>
        )
    }

}