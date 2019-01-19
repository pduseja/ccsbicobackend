import React, {Component} from 'react';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';

export default class RTE extends Component {
  constructor(props) {
    super(props)
    this.state = { text: '' }
  }
  componentWillReceiveProps(nextProps){
    if(nextProps.shouldErase === true && nextProps.shouldErase === this.props.shouldErase)
        this.setState({text: ''})
    if(nextProps.value && nextProps.value !== this.props.value)
        this.setState({text: nextProps.value})
  }

  handleChange = (value) => {
    this.setState({ text: value })
    this.props.onChange(value, this.props.type)
  }

  render() {
    return (
      <ReactQuill value={this.state.text}
                  onChange={this.handleChange} />
    )
  }
}