package com.practice.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainer_detail")
public class TrainerDetail {

	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="experience")
	private String experience;
	
	public TrainerDetail() {
		
	}

	public TrainerDetail(String youtubeChannel, String experience) {
		this.youtubeChannel = youtubeChannel;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getexperience() {
		return experience;
	}

	public void setexperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "TrainerDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", experience=" + experience + "]";
	}
		
}







