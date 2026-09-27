package com.rushinga.fire.controller;

import com.rushinga.fire.model.FireIncident;
import com.rushinga.fire.repository.FireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/fires")
public class FireController {

    @Autowired
    private FireRepository fireRepository;

    @GetMapping
    public List<FireIncident> getAllFires() {
        return fireRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createFireIncident(@RequestBody FireIncident incident, @RequestHeader(value = "X-User-Role", defaultValue = "RECORDER") String role, @RequestHeader(value = "X-User-Ward", defaultValue = "Ward-1") String userWard) {
        
        // Enforce Backend Ward-Level Scoping Security Rule
        if (!incident.getWard().equalsIgnoreCase(userWard) && !role.equals("PROVINCIAL_SUPERVISOR")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Access Denied: You are not authorized to record or view incidents outside your assigned ward[cite: 1].");
        }

        incident.setStatus("PENDING"); // Enforce initial workflow state[cite: 1]
        incident.setOccurrenceDateTime(LocalDateTime.now());
        FireIncident savedIncident = fireRepository.save(incident);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIncident);
    }
}