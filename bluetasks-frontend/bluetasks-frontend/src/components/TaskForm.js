import React, { Component } from "react";

class TaskForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      task: {
        id: 0,
        description: "",
        whenToDo: "",
      },
    };

    this.onSubmitHandler = this.onSubmitHandler.bind(this);
    this.onInputChangeHandler = this.onInputChangeHandler.bind(this);
  }

  onSubmitHandler(event) {
    event.preventDefault();
    alert("entrou aqui");
  }

  onInputChangeHandler(event) {
    console.log(event);
  }

  render() {
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
