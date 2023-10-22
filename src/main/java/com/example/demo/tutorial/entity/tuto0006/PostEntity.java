package com.example.demo.tutorial.entity.tuto0006;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity
@Table(name="posts")
public class PostEntity {

	@Id
	@Column
	@NotNull
	public String id;
	
	@Column
	@NotNull
	public int userId;
	
	@Column
	public String title;
	
	@Column
	public String body;
	
	public PostEntity() {
		this("00000",0,"","");
	}
	
	public PostEntity(String id, int userId, String title, String body) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(" id:").append(id);
		sb.append(",userId:").append(userId);
		sb.append(",title:").append(title);
		sb.append(",body:").append(body);
		sb.append("}");
		
		return sb.toString();
	}
}
