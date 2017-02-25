package com.joke.bean;

public class Joke {
	String s_text;
	int i_favCount;
	int i_commentCount;
	int i_shareCount;
	int i_buryCount;
	String s_name;
	String s_icon;
	String s_shareUrl;
	
	public Joke() {
		super();
	}

	public Joke(String s_text, int i_favCount, int i_commentCount,
			int i_shareCount, int i_buryCount, String s_name, String s_icon, String s_shareUrl) {
		super();
		this.s_text = s_text;
		this.i_favCount = i_favCount;
		this.i_commentCount = i_commentCount;
		this.i_shareCount = i_shareCount;
		this.i_buryCount = i_buryCount;
		this.s_name = s_name;
		this.s_icon = s_icon;
		this.s_shareUrl = s_shareUrl;
	}
	
	public String getS_text() {
		return s_text;
	}
	public void setS_text(String s_text) {
		this.s_text = s_text;
	}
	public int getI_favCount() {
		return i_favCount;
	}
	public void setI_favCount(int i_favCount) {
		this.i_favCount = i_favCount;
	}
	public int getI_commentCount() {
		return i_commentCount;
	}
	public void setI_commentCount(int i_commentCount) {
		this.i_commentCount = i_commentCount;
	}
	public int getI_shareCount() {
		return i_shareCount;
	}
	public void setI_shareCount(int i_shareCount) {
		this.i_shareCount = i_shareCount;
	}
	public int getI_buryCount() {
		return i_buryCount;
	}
	public void setI_buryCount(int i_buryCount) {
		this.i_buryCount = i_buryCount;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_icon() {
		return s_icon;
	}
	public void setS_icon(String s_icon) {
		this.s_icon = s_icon;
	}
	public String getS_shareUrl() {
		return s_shareUrl;
	}
	public void setS_shareUrl(String s_shareUrl) {
		this.s_shareUrl = s_shareUrl;
	}
	
	
}
