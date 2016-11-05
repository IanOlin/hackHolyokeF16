import React from 'react';
import AudioPlayer from  'react-responsive-audio-player';

var playlist =
[{ url: 'audiotest.ogg', displayText: 'Track 1 - a track to remember' },
{ url: 'audiotest.ogg', displayText: 'Oggs Oggs Oggs' }];

var reactElement = React.createElement(AudioPlayer, {
	playlist: playlist,
	autoplay: true,
	autoplayDelayInSeconds: 2.1,
	style: { position: 'fixed', bottom: 0 }
})

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
