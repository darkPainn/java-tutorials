package com.sedat.serializationDeserialization;

import java.io.Serializable;

public class MySerializableObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String title;
	private int count;
	public MySerializableObject(String title, int count) {
		this.title = title;
		this.count = count;
	}
	public long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MySerializableObject [serialVersionUID=" + serialVersionUID + ", title=" + title + ", count=" + count
				+ "]";
	}
	

}
