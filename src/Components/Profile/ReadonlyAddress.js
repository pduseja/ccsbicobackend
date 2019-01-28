import React from 'react';
import {connect} from "react-redux";

export class ReadonlyAddress extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            addressData : []
        }
    }
    componentDidMount(){
        let address = this.props.details.AddressDetailsList.filter(address => address.type === this.props.type);
        this.setState({
            addressData: address
        })
    }

    render(){
        return(<div>
         {this.state.addressData && this.state.addressData.length ?
                    <div>
                    <div className="form-group">
                         <label>House name</label>
                         <span>{this.state.addressData[0].houseName}</span>
                    </div>
                    <div className="form-group">
                         <label>Address</label>
                         <span>{this.state.addressData[0].addressLine1}</span>
                         <span>{this.state.addressData[0].addressLine2}</span>
                         <span>{this.state.addressData[0].addressLine3}</span>
                    </div>
                   <div className="form-group">
                        <label>City</label>
                        <span>{this.state.addressData[0].cityTown}</span>
                   </div>
                   <div className="form-group">
                      <label>State</label>
                      <span>{this.state.addressData[0].stateProvince}</span>
                   </div>
                   <div className="form-group">
                        <label>Town</label>
                        <span>{this.state.addressData[0].country}</span>
                   </div>
                   <div className="form-group">
                        <label>Pincode</label>
                        <span>{this.state.addressData[0].pinPostCode}</span>
                   </div>
                  <div className="form-group">
                       <label>Mobile</label>
                       <span>{this.state.addressData[0].mobile}</span>
                  </div>
                  <div className="form-group">
                     <label>Landline</label>
                     <span>{this.state.addressData[0].landline}</span>
                  </div>
                  <div className="form-group">
                       <label>Email</label>
                       <span>{this.state.addressData[0].email}</span>
                  </div></div> : <div>Address entry is not available</div>
                  }

        </div>)
    }
}
const mapStateToProps = state => ({
    details: state.details
});
export default connect(mapStateToProps)(ReadonlyAddress);