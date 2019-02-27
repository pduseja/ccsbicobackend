import React, { Component } from 'react'
import 'react-toastify/dist/ReactToastify.css'
import './WelcomeBoard.css'
import images from '../Themes/Images'

export default class WelcomeBoard extends Component {
  constructor(props){
    super(props)
    this.state = {
          isLoading: false,
          isShowSticker: false,
          inputValue: ''
        }
  }
  render() {
    return (
      <div className="viewWelcomeBoard">
        <span className="textTitleWelcome">{`Welcome, ${
          this.props.currentUserNickname
        }`}</span>

        <span className="textDesciptionWelcome">
          All our customer executives are currently busy, please wait for someone to revert,
           or you can also drop us a message and will get back to you as soon as possible.
        </span>
        <div className="viewBottom">
                  <img
                    className="icOpenGallery"
                    src={images.ic_photo}
                    alt="icon open gallery"

                  />
                  <input
                    ref={el => {
                      this.refInput = el
                    }}
                    accept="image/*"
                    className="viewInputGallery"
                    type="file"
                  />

                  <img
                    className="icOpenSticker"
                    src={images.ic_sticker}
                    alt="icon open sticker"
                  />

                  <input
                    className="viewInput"
                    placeholder="Type your message..."
                    disabled
                    value={this.state.inputValue}
                  />

                  <img
                    className="icSend"
                    src={images.ic_send}
                    alt="icon send"

                  />
                </div>
      </div>

    )
  }
}
