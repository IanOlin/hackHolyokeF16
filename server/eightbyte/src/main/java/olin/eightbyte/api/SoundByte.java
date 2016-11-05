package olin.eightbyte.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import olin.eightbyte.resources.SoundByteResource;

public class SoundByte {

	@JsonProperty
	private Long id;	// serializable identifier
	
	@JsonProperty
	private String ext;	// URL extension for indexing
	
	@NotNull
	@JsonProperty
	private String uri;	// filename for referencing actual data
	
	
	
	public SoundByte(Long newId, String newExt) {
		id = newId;
		ext = newExt;
		uri = SoundByteResource.getUniqueURI();
	}
	
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long newID) {
		id = newID;
	}
	
	
	public String getExt() {
		return ext;
	}
	
	
	public void setExt(String newExt) {
		ext = newExt;
	}
	
	
	public String getUri() {
		return uri;
	}
	
	
	public void setData(String newUri) {
		uri = newUri;
	}

}
