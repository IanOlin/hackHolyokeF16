package olin.eightbyte.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import olin.eightbyte.api.SoundByte;
import olin.eightbyte.db.SoundByteDAO;

@Path("/soundbytes")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class SoundByteResource {
	SoundByteDAO dao;
	

	public SoundByteResource(SoundByteDAO dao) {
		this.dao = dao;
	}
	
	@GET
	public List<SoundByte> getAllSoundBytes() {
		return dao.getAll();
	}
	
	@GET
	@Path("/{ext}")
	public SoundByte getSoundByte(@PathParam("ext") String ext) {
		return dao.getSoundByte(ext);
	}
	
	@POST
	@Path("/submit")
	public void add(@Valid SoundByte soundByte) {
		dao.addSoundByte(soundByte);
	}
}
