import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, browserHistory } from 'react-router'

import App from './components/App'
import { File } from './components/File';

ReactDOM.render((
	<Router history={browserHistory}>
		<Route path="/" component={App}/>
		<Route path="/file/:fileId" component={File}/>
	</Router>), document.getElementById('audio_player_container'));
