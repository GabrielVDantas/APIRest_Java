package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.domain.doctor.*;
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
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity registerDoctor(@RequestBody @Valid RegisterDoctorDTO registerDoctorDTO, UriComponentsBuilder uriBuilder) {
        Doctor doctor = registerDoctorDTO.convertDoctorDTO(registerDoctorDTO);
        doctorRepository.save(doctor);

        URI uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailedDoctorDataDTO(doctor));
    }

    @GetMapping("/get_registered_doctors")
    public ResponseEntity<Page<ListDoctorsDTO>> getRegisteredDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<ListDoctorsDTO> list = doctorRepository.findAllByActiveTrue(pageable).map(ListDoctorsDTO::new);

        return ResponseEntity.ok(list);
    }

    @PutMapping("/update_doctor_info")
    @Transactional
    public ResponseEntity updateDoctorInformation(@RequestBody @Valid UpdateDoctorInfoDTO updateDoctorInfoDTO) {
        Doctor doctor = doctorRepository.getReferenceById(updateDoctorInfoDTO.id());
        doctor.updateDoctorInformation(updateDoctorInfoDTO);

        return ResponseEntity.ok(new DetailedDoctorDataDTO(doctor));
    }

    @DeleteMapping("/delete_doctor/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.setActiveAsFalse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detail_doctor/{id}")
    public ResponseEntity detailingDoctor(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetailedDoctorDataDTO(doctor));
    }
}
