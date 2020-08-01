import React, { Component } from "react";
import { Link } from "react-router-dom";

class NavBarItem extends Component {
  render() {
    return (
      <div>
        <Link to={this.props.href} onClick={e => alert("clicou aquiii")}>
          {this.props.name}
        </Link>
      </div>
    );
  }
}

export default NavBarItem;
