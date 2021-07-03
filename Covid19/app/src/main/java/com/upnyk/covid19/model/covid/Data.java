package com.upnyk.covid19.model.covid;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private List<ContentItem> content;

	public Metadata getMetadata(){
		return metadata;
	}

	public List<ContentItem> getContent(){
		return content;
	}
}