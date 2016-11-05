import './styles/master.scss';

import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, Link, browserHistory } from 'react-router'

import { App, File } from './components/File';

ReactDOM.render((
	<Router history={browserHistory}>
		<Route path="/file/:fileId" component={File}>
		</Route>
	</Router>), document.getElementById('audio_player_container'));
