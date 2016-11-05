package olin.eightbyte.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import olin.eightbyte.api.SoundByte;
import olin.eightbyte.jdbi.mapper.SoundByteMapper;

@RegisterMapper(SoundByteMapper .class)

public interface SoundByteDAO {
	@SqlQuery("SELECT * FROM soundbyte")
	List<SoundByte> getAll();
	
	@SqlQuery("SELECT * FROM soundbyte WHERE ext = :soundByteExt")
	SoundByte getSoundByte(@Bind("soundByteExt") String soundByteExt);
	
	@SqlUpdate("UPDATE soundbyte SET "
			+ "(id, uri, ext) "
			+ "VALUES "
			+ "(:id, :uri, :ext)")
	void addSoundByte(@BindBean SoundByte soundByte);
	
}
