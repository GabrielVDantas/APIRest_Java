package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.entity.patient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Page<ListPatientDTO> getRegisteredPatients(@PageableDefault Pageable pageable) {
        return patientRepository.findAllByActiveTrue(pageable).map(ListPatientDTO::new);
    }

    @PutMapping("update_patient_information")
    @Transactional
    public void updatePatientInformation(@RequestBody @Valid UpdatePatientInfoDTO updatePatientInfoDTO) {
        Patient patient = patientRepository.getReferenceById(updatePatientInfoDTO.id());
        patient.updatePatientInformation(updatePatientInfoDTO);
    }

    @DeleteMapping("delete_patient")
    @Transactional
    public void deletePatient(DeletePatientDTO deletePatientDTO) {
        Patient patient = patientRepository.getReferenceById(deletePatientDTO.id());
        patient.setActiveAsFalse(patient.getId());
    }
}
