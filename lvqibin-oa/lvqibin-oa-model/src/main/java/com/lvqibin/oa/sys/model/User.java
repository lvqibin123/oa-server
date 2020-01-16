package com.lvqibin.oa.sys.model;

import java.util.Date;

public class User {
	/* token: '123456789',
     name: data.userName,
     email: `${data.userName}@qq.com`,
     id: 10000,
     time: +new Date(),*/
	private String token;
	private String name;
	private String email;
	private String id;
	private String avatar;
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	private Date time;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "User [token=" + token + ", name=" + name + ", email=" + email + ", id=" + id + ", avatar=" + avatar
				+ ", time=" + time + "]";
	}
	
}
