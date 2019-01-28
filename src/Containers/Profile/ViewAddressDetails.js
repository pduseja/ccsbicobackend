import React from 'react';
import {Link} from "react-router-dom";
import ReadonlyAddress from "../../Components/Profile/ReadonlyAddress"
export default class ViewPersonalDetails extends React.Component{

    render(){
        return(<div className="profile-details">
              <Link to={{pathname:"/Address", flow: "Profile"}}>
              <i style={{fontSize: 25, float: 'right'}} className="fas fa-edit"></i>
              </Link>
              <ul className="nav nav-pills mb-3 nav-justified" id="pills-tab" role="tablist">
                                  <li className="nav-item">
                                      <a className="nav-link active" id="pills-permanent" data-toggle="pill" href="#Permanent"
                                         role="tab" aria-controls="permanent" aria-selected="true">*Permanent</a>
                                  </li>
                                  <li className="nav-item">
                                      <a className="nav-link" id="pills-temporary" data-toggle="pill" href="#Temporary" role="tab"
                                         aria-controls="temporary" aria-selected="false">Temporary</a>
                                  </li>
                                  <li className="nav-item">
                                      <a className="nav-link" id="pills-work" data-toggle="pill" href="#Work" role="tab"
                                         aria-controls="work" aria-selected="false">Work</a>
                                  </li>
                                  <li className="nav-item">
                                      <a className="nav-link" id="pills-billing" data-toggle="pill" href="#Billing" role="tab"
                                         aria-controls="billing" aria-selected="false">Billing</a>
                                  </li>
                              </ul>
                              <div className="tab-content" id="pills-tabContent">
                                  <div className="tab-pane fade show active" id="Permanent" role="tabpanel"
                                       aria-labelledby="pills-permanent">
                                      <ReadonlyAddress type="PermA"/>
                                  </div>
                                  <div className="tab-pane fade" id="Temporary" role="tabpanel" aria-labelledby="pills-temporary">
                                      <ReadonlyAddress type="TempA"/>
                                  </div>
                                  <div className="tab-pane fade" id="Work" role="tabpanel" aria-labelledby="pills-work">
                                      <ReadonlyAddress type="WorkA"/>
                                  </div>
                                  <div className="tab-pane fade" id="Billing" role="tabpanel" aria-labelledby="pills-billing">
                                      <ReadonlyAddress type="BillA"/>
                                  </div>
                              </div>
        </div>)
    }
}
