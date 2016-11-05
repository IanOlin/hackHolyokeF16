import React from 'react';

export default class SoundBytesContainer extends React.Component {
	render() {
		return (
			<div className="soundbytes-container">
				{this.props.soundbytes.map((soundbyte) =>
					<SoundByteBox key={soundbyte.id}{...result}></SoundByteBox>
				)}
			</div>
		);
	}
}