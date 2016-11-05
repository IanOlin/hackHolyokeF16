package olin.eightbyte.jdbi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import olin.eightbyte.api.SoundByte;

public class SoundByteMapper implements ResultSetMapper<SoundByte> {

	@Override
	public SoundByte map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new SoundByte(
				r.getLong("id"),
				r.getString("ext"),
				r.getString("uri"));
	}

}
