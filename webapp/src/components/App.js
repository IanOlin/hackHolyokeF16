import React from 'react';
import AudioPlayer from  'react-responsive-audio-player';
// import ReactDOM from 'react-dom';

var playlist =
[{ url: 'test/audiotest.ogg',
displayText: 'Track 1 by Some Artist' },
{ url: 'test/audiotest.ogg',
displayText: 'Some Other Artist - Track 2' }];

// ReactDOM.render(
// 	<AudioPlayer playlist={playlist} hideBackSkip={true} />,
// 	document.getElementById('audio_player_container')
// 	);

export default class App extends React.Component {
	render() {
		return (
			<div>
			<AudioPlayer playlist={playlist} hideBackSkip={true} />
			Hello Olin!
			</div>
			);
	}
}
