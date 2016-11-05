package olin.eightbyte.resources;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.mail.MessagingException;

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
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
	        @FormDataParam("file") InputStream uploadedInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileDetail) throws MessagingException, IOException {

	    String uploadedFileLocation = "eightbyte/src/main/resources/sounds/" + fileDetail.getFileName();

	    // save it
	    writeToFile(uploadedInputStream, uploadedFileLocation);
	    String output = "File uploaded to : " + uploadedFileLocation;
    return Response.ok(output).build();
	}
	
//	    @POST
//	    public void uploadFile(){
//	            System.out.println("In upload");
//	    }

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) throws IOException {
	    int read;
	    final int BUFFER_LENGTH = 1024;
	    final byte[] buffer = new byte[BUFFER_LENGTH];
	    OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
	    while ((read = uploadedInputStream.read(buffer)) != -1) {
	        out.write(buffer, 0, read);
	    }
	    out.flush();
	    out.close();
	}
}
