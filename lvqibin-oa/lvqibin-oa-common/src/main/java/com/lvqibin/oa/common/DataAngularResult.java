package com.lvqibin.oa.common;

import java.util.List;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class DataAngularResult<T> {
	private long total;
	private List<T> list = null;
	
	public DataAngularResult(long total, List<T> list) {
		this.total = total;
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		JsonObject jn = new JsonObject();
		jn.addProperty("total", total);
		JsonArray jsonArray =  new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJsonTree(list, new TypeToken<List<T>>() {}.getType()).getAsJsonArray();
		jn.add("list", jsonArray);
		return jn.toString();
	}
	
	
}
