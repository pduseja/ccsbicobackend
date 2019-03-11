import React, { Component } from 'react'
import 'react-toastify/dist/ReactToastify.css'
import './WelcomeBoard.css'
import WebApi from "../../../Utils/WebApi";
import {withRouter} from "react-router-dom";
import ChatBoard from "../ChatBoard/ChatBoard"
class WelcomeBoard extends Component {
  constructor(props){
    super(props)
    this.state = {
          isLoading: false,
          isShowSticker: false,
          inputValue: '',
          counter: 0,
          showWindowPortal: false
        }
  }

    componentDidMount() {
      window.addEventListener('beforeunload', () => {
        this.closeWindowPortal();
      });

    }

  toggleWindowPortal = () => {

      this.setState(state => ({
        ...state,
        showWindowPortal: !state.showWindowPortal,
      }));
    }

    closeWindowPortal = () => {
        WebApi.endChat(this.props.userData.userName, this.props.userData.department)
          .then(response => response.json()).then(response => {
            this.setState({ showWindowPortal: false })
      })
    }

  render() {
    return (
      <div className="viewWelcomeBoard">
        <span className="textTitleWelcome">{`Welcome, ${
          this.props.currentUserNickname
        }`}</span>
                <button onClick={this.toggleWindowPortal}>
                  {this.state.showWindowPortal ? 'Close' : 'Start'} Chat
                </button>

                 {this.state.showWindowPortal && (
                            <ChatBoard currentPeerUser={this.props.userData.userName}
                                                       showToast={this.props.showToast}/>


                          )}

        <p className="textDesciptionWelcome">
          {`Your Current queue number is ${this.props.currentQueueNumber}`}</p>
        <p> All our customer executives are currently busy, please wait for someone to revert,
           or you can also drop us a message and will get back to you as soon as possible.
        </p>

      </div>

    )
  }
}

export default withRouter(WelcomeBoard)