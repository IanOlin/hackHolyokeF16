import React from 'react';

export default class SoundByteBox extends React.Component {
	render() {
		return (
			<div>
				{this.props.id}
				{this.props.ext}
			</div>
		)
	}
}