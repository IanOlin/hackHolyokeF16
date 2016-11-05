import React from 'react';

import NavBar from 'NavBar';
import SoundBytesContainer from 'SoundBytesContainer';

export default class App extends React.Component {
	constructor() {
		this.state = { soundbytes: [] }
	}

	componentDidMount() {
		fetch('/api/soundbytes').then((response) => {
			response.json().then((json) => {
				this.setState({soundbytes: json})
			});
		});
	}

	render() {
		return (
			<div>
				<NavBar/>
				<SoundBytesContainer soundbytes={this.state.soundbytes}></SoundBytesContainer>
			</div>
		);
	}
}
