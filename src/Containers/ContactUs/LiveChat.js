import React from 'react';
import { database } from './FireBase';

export default class LiveChat extends React.Component{
  constructor() {
    super();

    this.state = {
      messages: [],
    };

  }

    componentWillMount() {
      const messagesRef = database.ref('messages')
        .orderByKey()
        .limitToLast(100);

      messagesRef.on('child_added', snapshot => {
        const message = { text: snapshot.val(), id: snapshot.key };

        this.setState(prevState => ({
          messages: [ message, ...prevState.messages ],
        }));
      });
    }

  onAddMessage = (event) => {
    event.preventDefault();

    database.ref('messages').push(this.input.value);

    this.input.value = '';
  }


    render(){
        return(
            <div className="common-wrapper">
                <div className="full-wrapper">
                    <ul>
                      {this.state.messages.map(message =>
                        <li key={message.id}>{message.text}</li>
                      )}
                    </ul>
                    <input type="text" ref={node => this.input = node}/>
                    <button onClick={this.onAddMessage}>Send</button>
                </div>
            </div>
        )
    }
}