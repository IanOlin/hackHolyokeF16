import React from 'react';
import AudioPlayer from  'react-responsive-audio-player';

let soundbite = 'test/audiotest.ogg'
let text = 'This will be useful'

var playlist =
[{ url: soundbite, displayText: text }];


export default class App extends React.Component {
	render() {
		return (
			<div>
			<AudioPlayer playlist={playlist} autoplay={true} />
			</div>
			);
	}
}
