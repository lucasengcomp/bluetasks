import React from "react";
import Navbar from "./components/NavBar";
import { BrowserRouter } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
    
    <div className="App">
      <Navbar></Navbar>
    </div>
    </BrowserRouter>
    
  );
}

export default App;
