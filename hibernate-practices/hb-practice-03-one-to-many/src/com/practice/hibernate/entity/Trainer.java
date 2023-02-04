package com.practice.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="trainer_detail_id")
	private TrainerDetail trainerDetail;
	

	@OneToMany(mappedBy="trainer",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Technology> technologies;
	
	
	public Trainer() {
		
	}

	public Trainer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TrainerDetail getTrainerDetail() {
		return trainerDetail;
	}

	public void setTrainerDetail(TrainerDetail trainerDetail) {
		this.trainerDetail = trainerDetail;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", trainerDetail=" + trainerDetail + "]";
	}
	
	// add convenience methods for bi-directional relationship
	
		public void add(Technology technology) {
			
			if (technologies == null) {
				technologies = new ArrayList<>();
			}
			
			technologies.add(technology);
			
			technology.setInstructor(this);
		}
	
}






