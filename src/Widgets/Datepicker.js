import React from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

export default class Datepicker extends React.Component {

    handleChange = (date) => {
        this.props.onChange('dateofbirth', date)
    };

    render() {
        return (
            <DatePicker dropdownMode="select"
                selected={this.props.date}
                onChange={this.handleChange}
            />
        );
    }
}