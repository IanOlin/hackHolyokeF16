import '../styles/navbar.scss'

import React from 'react';

export default class NavBar extends React.Component {
	render() {
		return (
			<div className="navbar">
				<SearchField/>
				<ImportButton/>
			</div>
		);
	}
}

class SearchField extends React.Component {
	render() {
		return (
			<div className="search-field">
				<input type="text" name="search" placeholder="Search..."></input>
			</div>
		);
	}
}

class ImportButton extends React.Component {
	render() {
		return (
			<div className="import-button">
				Import a sound
			</div>
		);
	}
}
