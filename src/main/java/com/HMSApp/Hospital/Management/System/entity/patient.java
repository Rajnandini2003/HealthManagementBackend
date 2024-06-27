package com.HMSApp.Hospital.Management.System.entity;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;


@Entity
@Table(name = "patients")
public class patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "blood_group")
    private String blood;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "dose")
    private String dose;

    @Column(name = "fees")
    private String fees;

    @Column(name = "urgency")
    private String urgency;

    @Column(name = "medical_history")
    private String medicalHistory;

    @Column(name = "slots")
    private String slots;

    @Column(name = "visits")
    private Integer visits;

    // Default constructor
    public patient() {
        super();
    }

    // Parameterized constructor
    public patient(long id, String name, String age, String blood, String prescription, String dose, String fees, String urgency, String medicalHistory, String slots, int visits) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.blood = blood;
        this.prescription = prescription;
        this.dose = dose;
        this.fees = fees;
        this.urgency = urgency;
        this.medicalHistory = medicalHistory;
        this.slots = slots;
        this.visits = visits;
    }

    // Getters and Setters
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

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVisits() {
        return visits;
    }


    public void setVisits(Integer visits) {
        this.visits = Optional.ofNullable(visits).orElse(0);
    }
}
