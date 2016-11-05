import React from 'react';
import AudioPlayer from  'react-responsive-audio-player';

export default class App extends React.Component {
	render() {
		return (
			<div>
			<AudioPlayer playlist={playlist} autoplay={true} />
			Hello Olin!
			</div>
		);
	}
}
