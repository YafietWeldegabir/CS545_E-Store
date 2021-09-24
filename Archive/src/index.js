import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import store from './store/store';
import { Provider } from 'react-redux';
import { createMuiTheme, MuiThemeProvider } from '@material-ui/core';

const theme = createMuiTheme({
  palette:{
    primary:{
      main: '#000000'
    },
    secondary:{
      main: '#FFFFFF'
    }
  }
})

ReactDOM.render(
  <React.StrictMode>
    <MuiThemeProvider theme= {theme}>
    <Provider store={store}>
      <App />
    </Provider>
    </MuiThemeProvider>
  </React.StrictMode>,
  document.getElementById('root')
);
