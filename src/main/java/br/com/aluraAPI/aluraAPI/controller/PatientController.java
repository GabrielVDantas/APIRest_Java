package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.entity.patient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity registerPatient(@RequestBody @Valid RegisterPatientDTO registerPatientDTO, UriComponentsBuilder uriBuilder) {
        Patient patient = registerPatientDTO.convertPatientDTO(registerPatientDTO);
        patientRepository.save(patient);

        // Construindo a URI manualmente
        URI uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailedPatientDTO(patient));
    }

    @GetMapping("get_registered_patients")
    public ResponseEntity<Page<ListPatientDTO>> getRegisteredPatients(@PageableDefault Pageable pageable) {
        Page<ListPatientDTO> list = patientRepository.findAllByActiveTrue(pageable).map(ListPatientDTO::new);

        return ResponseEntity.ok(list);
    }

    @PutMapping("update_patient_information")
    @Transactional
    public ResponseEntity updatePatientInformation(@RequestBody @Valid UpdatePatientInfoDTO updatePatientInfoDTO) {
        Patient patient = patientRepository.getReferenceById(updatePatientInfoDTO.id());
        patient.updatePatientInformation(updatePatientInfoDTO);

        return ResponseEntity.ok(new DetailedPatientDTO(patient));
    }

    @DeleteMapping("delete_patient/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        Patient patient = patientRepository.getReferenceById(id);
        patient.setActiveAsFalse(patient.getId());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("detail_patient/{id}")
    public ResponseEntity detailingPatient(@PathVariable Long id) {
        Patient patient = patientRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetailedPatientDTO(patient));
    }
}
