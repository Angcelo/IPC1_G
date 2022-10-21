//import logo from './logo.svg';
import './App.css';
import { useRoutes } from 'react-router-dom';
import Home from './Vistas/Home/Home';
import About from './Vistas/About/About';

function Routes() {
  return useRoutes([
    {
      path: '/',
      element: <Home />
    },
    {
      path: '/about',
      element: <About />
    }
  ])
}

function App() {
  return (
    <div className="App">
      <Routes />
    </div>
  );
}

export default App;
