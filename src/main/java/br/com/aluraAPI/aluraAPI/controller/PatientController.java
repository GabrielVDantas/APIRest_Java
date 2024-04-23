package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.entity.patient.Patient;
import br.com.aluraAPI.aluraAPI.entity.patient.PatientRepository;
import br.com.aluraAPI.aluraAPI.entity.patient.RegisterPatientDTO;
import br.com.aluraAPI.aluraAPI.entity.patient.UpdatePatientInfoDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/register")
    @Transactional
    public void registerPatient(@RequestBody @Valid RegisterPatientDTO registerPatientDTO) {
        Patient patient = registerPatientDTO.convertPatientDTO(registerPatientDTO);
        patientRepository.save(patient);
    }

    @GetMapping("get_registered_patients")
    public void getRegisteredPatients() {

    }

    @PutMapping("update_patient_information")
    @Transactional
    public void updatePatientInformation(@RequestBody @Valid UpdatePatientInfoDTO updatePatientInfoDTO) {
        Patient patient = patientRepository.getReferenceById(updatePatientInfoDTO.id());
        patient.updatePatientInformation(updatePatientInfoDTO);
    }
}
