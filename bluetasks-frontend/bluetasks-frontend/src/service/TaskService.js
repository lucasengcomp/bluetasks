class TaskService {
  constructor() {
    this.tasks = [
      { id: 1, description: "Tarefa 1", whenToDo: "01/09/2020", done: false },
      { id: 2, description: "Tarefa 2", whenToDo: "01/10/2020", done: false },
      { id: 3, description: "Tarefa 3", whenToDo: "01/11/2020", done: false },
      { id: 4, description: "Tarefa 4", whenToDo: "01/12/2020", done: false },
      { id: 5, description: "Tarefa 5", whenToDo: "01/10/2020", done: false },
    ];
  }

  list() {
    return this.tasks;
  }
}

export default new TaskService();
