import React, {Component} from 'react';
import RichTextEditor from 'react-rte';

export default class RTE extends Component {

  state = {
    value: RichTextEditor.createEmptyValue()
  };

  onChange = (value) => {
    this.setState({value});
    this.props.handleChange(value.toString('html'), this.props.type);
  };

  render () {
    return (
    <div className="RTE">
      <h6>{this.props.type}</h6>
      <RichTextEditor
        value={this.state.value}
        onChange={this.onChange}
      />
     </div>
    );
  }
}