import React from "react";
import Navbar from "./components/NavBar";
import { BrowserRouter } from "react-router-dom";
import TaskListTable from "./components/TaskListTable";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Navbar />
        <div className="container" style={{ marginTop: 20 }}>
          <TaskListTable />
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
