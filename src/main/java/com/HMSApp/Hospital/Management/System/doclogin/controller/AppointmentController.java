package com.HMSApp.Hospital.Management.System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSApp.Hospital.Management.System.doclogin.repository.AppointmentsRepository;
import com.HMSApp.Hospital.Management.System.doclogin.entity.Appointment;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
    
    @Autowired
    private final AppointmentsRepository appointmentsRepository;

    public AppointmentController(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    @PostMapping("/appointments")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentsRepository.save(appointment);
    }
    
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentsRepository.findAll();
    }
    
    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
        Appointment appointment = appointmentsRepository.findById(id)
            .orElseThrow(() -> new AttributeNotFoundException("Appointment not found with id " + id));
        
        appointmentsRepository.delete(appointment);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    
    }

