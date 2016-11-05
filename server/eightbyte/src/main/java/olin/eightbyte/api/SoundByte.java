package olin.eightbyte.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoundByte {

	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String ext;
	
	@NotNull
	@JsonProperty
	private byte[] data;
	
	
	
	public SoundByte(Long newId, String uri, byte[] sound) {
		id = newId;
		ext = uri;
		data = sound;
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
	
	
	public void setExt(String uri) {
		ext = uri;
	}
	
	
	public byte[] getData() {
		return data;
	}
	
	
	public void setData(byte[] sound) {
		data = sound;
	}

}
