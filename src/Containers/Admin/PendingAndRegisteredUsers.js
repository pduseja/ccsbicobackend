import React from 'react';
import PendingUsers from '../../Components/Admin/PendingUsers'
import RegisteredUsers from '../../Components/Admin/RegisteredUsers'

export default class PendingAndRegisteredUsers extends React.Component{
    render(){
        return(<div>
            <PendingUsers />
            <RegisteredUsers />
        </div>)
    }
}