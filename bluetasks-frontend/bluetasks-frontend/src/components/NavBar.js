import React, { Component } from "react";
import NavBarItem from "./NavBarItem";

class Navbar extends Component {
  render() {
    return (
      <div>
        <NavBarItem name="Item 1" />
        <NavBarItem name="Item 2" />
        <NavBarItem name="Item 3" />
      </div>
    );
  }
}

export default Navbar;
