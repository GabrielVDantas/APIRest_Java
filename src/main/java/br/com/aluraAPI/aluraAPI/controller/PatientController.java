package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.entity.patient.Patient;
import br.com.aluraAPI.aluraAPI.entity.patient.PatientRepository;
import br.com.aluraAPI.aluraAPI.entity.patient.RegisterPatientDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    public void registerPatient(@RequestBody @Valid RegisterPatientDTO registerPatientDTO) {
        Patient patient = registerPatientDTO.convertPatientDTO(registerPatientDTO);
        patientRepository.save(patient);
    }
}
