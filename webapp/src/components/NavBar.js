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
				<input type="text" name="search" placeholder="Search for a sound..."></input>
			</div>
		);
	}
}

class ImportButton extends React.Component {
	constructor() {
		super();
		this.handleClick = this.handleClick.bind(this);
	}

	handleClick() {

	}

	render() {
		return (
			
			<div className="import-button" onClick={this.handleClick}>
				Import a sound
			</div>
		);
	}
}
