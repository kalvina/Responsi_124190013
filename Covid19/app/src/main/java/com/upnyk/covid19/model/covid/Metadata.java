package com.upnyk.covid19.model.covid;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("last_update")
	private Object lastUpdate;

	public Object getLastUpdate(){
		return lastUpdate;
	}
}