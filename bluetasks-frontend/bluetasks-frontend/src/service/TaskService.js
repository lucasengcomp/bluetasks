class TaskService {
  constructor() {
    this.tasks = [
      { id: 1, description: "Tarefa 1", whenToDo: "2020-01-10", done: true },
      { id: 2, description: "Tarefa 2", whenToDo: "2020-05-14", done: false },
      { id: 3, description: "Tarefa 3", whenToDo: "2020-09-16", done: false },
      { id: 4, description: "Tarefa 4", whenToDo: "2020-08-10", done: false },
      { id: 5, description: "Tarefa 5", whenToDo: "2020-01-01", done: false },
    ];
  }

  list() {
    return this.tasks;
  }

  delete(id) {
    this.tasks = this.tasks.filter((task) => task.id !== id);
  }

  save(task) {
    if (task.id !== 0) {
      this.tasks = this.tasks.map((t) => (task.id !== t.id ? t : task));
    } else {
      const taskId = Math.max(...this.tasks.map((t) => t.id));
      task.id = taskId;
      this.tasks.push(task);
    }
  }

  load(id) {
    return this.tasks.filter((t) => t.id === id)[0];
  }
}

export default new TaskService();
