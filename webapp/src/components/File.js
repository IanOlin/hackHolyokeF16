import React from 'react';
import AudioPlayer from  'react-responsive-audio-player';
import { Router, Route, Link } from 'react-router'

class App extends React.Component {
	render() {
		return (
			<div>
			<AudioPlayer playlist={playlist} autoplay={true} />
			</div>
			);
	}
}

class File extends React.Component {
	constructor() {
		super();
		this.state = {
			uri: "",
			ext: ""
		}
	}

	componentDidMount() {
		fetch('/api/soundbytes/' + this.props.params.fileId).then((response) => {
			response.json().then((json) => {
				this.setState(json);
			});
		});

	}

	render() {
		let soundbite = '/api'+this.state.uri+'.ogg'
		let text = 'This will be useful'

		var playlist =
		[{ url: soundbite, displayText: text }];
		return (
			<div>
			<AudioPlayer playlist={playlist} autoplay={true} />
			{this.state.uri}
			</div>
			);
	}
}

export { App, File };