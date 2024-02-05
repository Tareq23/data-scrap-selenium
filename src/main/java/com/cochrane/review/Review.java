package com.cochrane.review;

import java.util.Date;

public class Review {
	private String url;
	private String topic;
	private String title;
	private String author;
	private Date date;

	public Review(String url, String topic, String title, String author, Date date) {
		super();
		this.url = url;
		this.topic = topic;
		this.title = title;
		this.author = author;
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public String getTopic() {
		return topic;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
