import React, { Component } from "react";
import NavBarItem from "./NavBarItem";
import { APP_NAME } from "../constants";

class Navbar extends Component {
  constructor(props) {
    super(props);

    this.state = {
      items: [
        { name: "Listar tarefas", href: "/" },
        { name: "Nova Tarefa", href: "/form" },
      ],
    };
  }

  onClickHandler(item) {
    alert(item.name);
  }

  render() {
    return (
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand" href="#">
          {APP_NAME}
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarText">
          <div className="navbar-nav mr-auto">
            {this.state.items.map((i) => (
              <NavBarItem item={i} onClick={this.onClickHandler} />
            ))}
          </div>
        </div>
      </nav>
    );
  }
}

export default Navbar;
