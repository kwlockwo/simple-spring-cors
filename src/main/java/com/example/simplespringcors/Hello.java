package com.example.simplespringcors;

public class Hello {
    private final long id;
	private final String content;

	public Hello() {
		this.id = -1;
		this.content = "";
	}

	public Hello(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
