package com.HMSApp.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "number")
    private String number;

    // No need for explicit getter and setter methods when using @Data from Lombok
    // Lombok's @Data includes all fields, constructors, getters, setters, and toString method

    // If you want to add additional logic to getters and setters, you can still define them manually

}
