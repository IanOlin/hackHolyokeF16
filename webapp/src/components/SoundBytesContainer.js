import React from 'react';

import SoundByteBox from './SoundByteBox';

export default class SoundBytesContainer extends React.Component {
	render() {
		return (
			<div className="soundbytes-container">
				{this.props.soundbytes.map((soundbyte) =>
					<SoundByteBox key={soundbyte.id}{...soundbyte}></SoundByteBox>
				)}
			</div>
		);
	}
}