package com.cochrane.review;

public class Topic {
	
	private String topicName;
	private String topicUrl;
	
	public Topic(String name, String url)
	{
		this.topicName  = name;
		this.topicUrl = url;
	}
	public String getTopicName() {
		return topicName;
	}
	public String getTopicUrl() {
		return topicUrl;
	}
	
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public void setTopicUrl(String topicUrl) {
		this.topicUrl = topicUrl;
	}
	
	@Override
	public String toString()
	{
		return "Name: "+this.topicName+"\nUrl: "+this.topicUrl;
	}

}
