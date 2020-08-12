import React, { Component } from "react";
import TaskService from "../service/TaskService";
import { Redirect } from "react-router-dom";

class TaskForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      task: {
        id: 0,
        description: "",
        whenToDo: "",
      },
      redirect: false,
    };

    this.onSubmitHandler = this.onSubmitHandler.bind(this);
    this.onInputChangeHandler = this.onInputChangeHandler.bind(this);
  }

  onSubmitHandler(event) {
    event.preventDefault();
    TaskService.save(this.state.task);
    this.setState({ redirect: true });
  }

  onInputChangeHandler(event) {
    const field = event.target.name;
    const value = event.target.value;

    this.setState((prevState) => ({
      task: { ...prevState.task, [field]: value },
    }));
  }

  render() {
    if (this.state.redirect) {
      return <Redirect to="/" />;
    }

    return (
      <div>
        <h1>Cadastro da tarefa</h1>
        <form onSubmit={this.onSubmitHandler}>
          <div className="form-group">
            <label htmlFor="description">Descrição</label>
            <input
              type="text"
              className="form-control"
              name="description"
              placeholder="Digite a descrição"
              onChange={this.onInputChangeHandler}
            />
          </div>
          <div className="form-group">
            <label htmlFor="whenToDo">Data</label>
            <input
              type="date"
              className="form-control"
              name="whenToDo"
              placeholder="Informe a data"
              onChange={this.onInputChangeHandler}
            />
          </div>
          <button type="submit" className="btn-primary">
            Cadastrar
          </button>
          &nbsp;&nbsp;
          <button type="button" className="btn-danger">
            Cancelar
          </button>
        </form>
      </div>
    );
  }
}

export default TaskForm;
