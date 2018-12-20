import React from 'react'
import Image from '../Images/under_construction.jpg'
const style={
    'container':{
        'display': 'flex',
        'justify-content': 'center'
    },
    'image':{
        'width':'auto',
        'height': 200,
        'margin-top': 250
    }
};
export default class UnderConstruction extends React.Component{
    render(){
        return(
            <div style={style.container}>
                <img style={style.image} src={Image} alt="under construction"/>
            </div>
        )
    }
}