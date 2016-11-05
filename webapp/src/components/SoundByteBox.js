import React from 'react';

export default class SoundByteBox extends React.Component {
	render() {
		return (
			<div className="soundbyte-box">
				{this.props.id}
				{this.props.ext}
			</div>
		)
	}
}