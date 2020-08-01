import React from "react";
import Navbar from "./components/NavBar";
import { BrowserRouter } from "react-router-dom";
import TaskListTable from "./components/TaskListTable";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Navbar />
        <TaskListTable />
      </div>
    </BrowserRouter>
  );
}

export default App;
