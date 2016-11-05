import React from 'react';
import AudioPlayer from  'react-responsive-audio-player';
import { Router, Route, Link } from 'react-router'

class File extends React.Component {
	constructor() {
		super();
		this.state = {
			playlist: [],
			uri: "",
			ext: ""
		}
	}

	componentDidMount() {
		fetch('/api/soundbytes/' + this.props.params.fileId).then((response) => {
			response.json().then((json) => {
				this.setState({
					url: json.uri + '.ogg',
					displayText: json.ext
				});
			});
		});

	}

	render() {
		return (
			<div>
			<AudioPlayer playlist={[this.state]} autoplay={true}
			autoplayDelayInSeconds={.5}/>
			</div>
			);
	}
}

export { File };