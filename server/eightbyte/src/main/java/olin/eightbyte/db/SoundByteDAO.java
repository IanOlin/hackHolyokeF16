package olin.eightbyte.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import olin.eightbyte.api.SoundByte;
import olin.eightbyte.jdbi.mapper.SoundByteMapper;

@RegisterMapper(SoundByteMapper .class)

public interface SoundByteDAO {
	@SqlQuery("SELECT * FROM soundbyte")
	List<SoundByte> getAll();
	
	@SqlQuery("SELECT * FROM soundbyte WHERE id = :soundByteId")
	SoundByte getSoundByte(@Bind("soundByteId") int soundByteId);
}
