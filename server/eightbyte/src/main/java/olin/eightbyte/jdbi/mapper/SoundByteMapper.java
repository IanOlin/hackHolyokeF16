package olin.eightbyte.jdbi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import olin.eightbyte.api.SoundByte;

public class SoundByteMapper implements ResultSetMapper<SoundByte> {

	@Override
	public SoundByte map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		final byte[] literallyJustARandomByteArr = {17, 42, 5};
		return new SoundByte(new Long(42),
							"xxxxxxxxxxxxxxxx",
							literallyJustARandomByteArr);
	}

}
