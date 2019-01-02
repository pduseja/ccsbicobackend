import React from 'react';
import ReactDOM from 'react-dom';
import 'babel-polyfill';
import 'react-app-polyfill/ie11';
import App from './Containers/App';
import './Styles/index.css';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
