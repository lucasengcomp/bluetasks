import React from "react";
import Navbar from "./components/NavBar";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import TaskListTable from "./components/TaskListTable";
import TaskForm from "./components/TaskForm";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Navbar />
        <div className="container" style={{ marginTop: 20 }}>
          <Switch>
            <Route path="/form" component={TaskForm} />
            <Route path="/" component={TaskListTable} />
            <TaskListTable />
          </Switch>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
