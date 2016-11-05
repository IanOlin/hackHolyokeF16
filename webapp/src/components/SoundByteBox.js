import '../styles/box.scss';

import React from 'react';

export default class SoundByteBox extends React.Component {
	render() {
		return (
			<div className="soundbyte-box">
				<a href={'/' + this.props.ext}>{this.props.ext}</a>
			</div>
		)
	}
}