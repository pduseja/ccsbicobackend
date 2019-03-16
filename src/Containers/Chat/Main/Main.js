import React, { Component } from 'react'
import ReactLoading from 'react-loading'
import { withRouter } from 'react-router-dom'
import { myFirebase, myFirestore } from '../../../Utils/MyFirebase'
import images from '../Themes/Images'
import WelcomeBoard from '../WelcomeBoard/WelcomeBoard'
import './Main.css'
import ChatBoard from './../ChatBoard/ChatBoard'
import { AppString } from './../Const'
import WebApi from "../../../Utils/WebApi";
import Stomp from 'stomp-websocket';
import SockJs from 'sockjs-client'

let stompClient = null;
class Main extends Component {
  constructor(props) {
    super(props)
    this.state = {
      isLoading: true,
      isOpenDialogConfirmLogout: false,
      currentPeerUser: null
    }
    this.currentUserId = "RC100005"
    this.currentUserAvatar = localStorage.getItem(AppString.PHOTO_URL)
    this.currentUserNickname = localStorage.getItem(AppString.NICKNAME)
    this.listUser = []
  }

  componentDidMount() {
    let userData = JSON.parse(this.props.userData)
      var socket = new SockJs('/chatQueue');
      stompClient = Stomp.over(socket);
      stompClient.connect({}, function(frame) {
          console.log('Connected: ' + frame);
          stompClient.send('/topic/api', {} ,JSON.stringify({'userName': userData.userName, 'department': userData.department}))
          stompClient.subscribe('/topic/api', function(greeting){
              console.log("message")
          });
      });

//      socket.onmessage = (m) =>{
//        console.log(m, "message")
//      }

    WebApi.getQueueDetails(userData.userName, userData.department)
    .then(response => response.json()).then(response => {

        this.setState({
            currentQueueNumber: response,
            userData: userData
        })
    })
    this.checkLogin()
  }

  checkLogin = () => {
    if (!localStorage.getItem(AppString.ID)) {
      this.setState({ isLoading: false }, () => {
        this.props.history.push('/')
      })
    } else {
      this.getListUser()
    }
  }

  getListUser = async () => {
    const result = await myFirestore.collection(AppString.NODE_USERS).get()
    if (result.docs.length > 0) {
      this.listUser = [...result.docs]
      this.setState({ isLoading: false })
    }
  }

  onLogoutClick = () => {
    this.setState({
      isOpenDialogConfirmLogout: true
    })
  }

    sendMessage = () => {
    debugger
    let userData = JSON.parse(this.props.userData)
      this.clientRef.sendMessage('/topic/api', {}, JSON.stringify({'userName': userData.userName, 'department': userData.department}));
    }

  doLogout = () => {
    this.setState({ isLoading: true })
    myFirebase
      .auth()
      .signOut()
      .then(() => {
        this.setState({ isLoading: false }, () => {
          localStorage.clear()
          this.props.showToast(1, 'Logout success')
          this.props.history.push('/CCSBI/AuthenticateChatUser')
        })
      })
      .catch(function(err) {
        this.setState({ isLoading: false })
        this.props.showToast(0, err.message)
      })
  }

  hideDialogConfirmLogout = () => {
    this.setState({
      isOpenDialogConfirmLogout: false
    })
  }

  renderListUser = () => {
    if (this.listUser.length > 0) {
      let viewListUser = []
      this.listUser.forEach((item, index) => {
        if (item.data().id !== this.currentUserId) {
          viewListUser.push(
            <button
              className={
                this.state.currentPeerUser &&
                this.state.currentPeerUser.id === item.data().id
                  ? 'viewWrapItemFocused'
                  : 'viewWrapItem'
              }
              key={item.data().id}
              onClick={() => {
                this.setState({ currentPeerUser: item.data() })
              }}
            >
              <div className="viewWrapContentItem">
                <span className="textItem">{
                  item.data().nickname
                }</span>

              </div>
            </button>
          )
        }
      })
      return viewListUser
    } else {
      return null
    }
  }

  render() {

    return (
      <div className="common-wrapper">
                        <div className="full-wrapper">
      <div className="root">
        {/* Header */}
        <div className="header">
          <img
            className="icLogout"
            alt="An icon logout"
            src={images.ic_logout}
            onClick={this.onLogoutClick}
          />
        </div>

        {/* Body */}
        <div className="body">
          <div className="viewBoard">
            {this.state.currentPeerUser ? (
              <ChatBoard
                currentPeerUser={this.state.currentPeerUser}
                showToast={this.props.showToast}
              />
            ) : (
              <WelcomeBoard
                currentUserNickname={this.currentUserNickname}
                currentUserAvatar={this.currentUserAvatar}
                currentQueueNumber={this.state.currentQueueNumber}
                userData={this.state.userData}
              />
            )}
          </div>
        </div>

        {/* Dialog confirm */}
        {this.state.isOpenDialogConfirmLogout ? (
          <div className="viewCoverScreen">
            {this.renderDialogConfirmLogout()}
          </div>
        ) : null}

        {/* Loading */}
        {this.state.isLoading ? (
          <div className="viewLoading">
            <ReactLoading
              type={'spin'}
              color={'#203152'}
              height={'3%'}
              width={'3%'}
            />
          </div>
        ) : null}
      </div></div></div>
    )
  }

  renderDialogConfirmLogout = () => {
    return (
      <div>
        <div className="titleDialogConfirmLogout">Are you sure to logout?</div>
        <div className="viewWrapButtonDialogConfirmLogout">
          <button className="btnYes" onClick={this.doLogout}>
            YES
          </button>
          <button className="btnNo" onClick={this.hideDialogConfirmLogout}>
            CANCEL
          </button>
        </div>
      </div>
    )
  }
}

export default withRouter(Main)
