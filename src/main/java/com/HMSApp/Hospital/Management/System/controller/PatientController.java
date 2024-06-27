package com.HMSApp.Hospital.Management.System.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.HMSApp.Hospital.Management.System.entity.patient;
import com.HMSApp.Hospital.Management.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping("/patients")
    public patient createPatient(@RequestBody patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/patients")
    public List<patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException {
        patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with id " + id));
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
        patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with id " + id));

        patientRepository.delete(patient);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<patient> updatePatient(@PathVariable long id, @RequestBody patient patientDetails) throws AttributeNotFoundException {
        patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with id " + id));

        patient.setAge(patientDetails.getAge());
        patient.setName(patientDetails.getName());
        patient.setBlood(patientDetails.getBlood());
        patient.setDose(patientDetails.getDose());
        patient.setFees(patientDetails.getFees());
        patient.setPrescription(patientDetails.getPrescription());
        patient.setUrgency(patientDetails.getUrgency());
        patient.setMedicalHistory(patientDetails.getMedicalHistory());
        patient.setSlots(patientDetails.getSlots());
        patient.setVisits(patientDetails.getVisits());

        patient savedPatient = patientRepository.save(patient);

        return ResponseEntity.ok(savedPatient);
    }
}
