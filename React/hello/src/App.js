import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import NameCards from './components/NameCard'
import Welecome from "./Welcome"
import Welcome from './Welcome';
const tags=['aaa','cccc','wwwww']
class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>         
        </header>
        <Welcome/>
        <NameCards name="sss" number={123234} isHuman="asd" tags={tags}/>
      </div>
    );
  }
}

export default App;
