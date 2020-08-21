package org.tj.scheintakehometest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tj.scheintakehometest.service.PatientStringFormatter;

@RestController
public class PatientController {

    private PatientStringFormatter patientStringFormatter;

    public PatientController(PatientStringFormatter patientStringFormatter) {
        this.patientStringFormatter = patientStringFormatter;
    }

    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody String patientsInCSV) {
        String patientsInSquareBrackets = patientStringFormatter.csvToSquareBrackets(patientsInCSV);

        return ResponseEntity.ok().body(patientsInSquareBrackets);
    }
}