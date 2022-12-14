import React, { Component } from "react";
import NavBarItem from "./NavBarItem";
import { APP_NAME } from "../constants";


class Navbar extends Component {
  constructor(props) {
    super(props);

    this.state = {
      items: [
        { name: "Listar tarefas", href: "/", active: true },
        { name: "Nova Tarefa", href: "/form", active: false },
      ],
    };
    this.onClickHandler = this.onClickHandler.bind(this);
  }

  onClickHandler(itemClicked) {
    const items = [...this.state.items];
    items.forEach((item) => {
      if (item.name === itemClicked.name) {
        item.active = true;
      } else {
        item.active = false;
      }
    });
    this.setState({ items });
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
              <NavBarItem key={i.name} item={i} onClick={this.onClickHandler} />
            ))}
          </div>
        </div>
      </nav>
    );
  }
}

export default Navbar;
