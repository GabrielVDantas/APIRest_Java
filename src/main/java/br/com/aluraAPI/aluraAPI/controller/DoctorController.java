package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.entity.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/register")
    @Transactional
    public void registerDoctor(@RequestBody @Valid RegisterDoctorDTO registerDoctorDTO) {
        Doctor doctor = registerDoctorDTO.convertDoctorDTO(registerDoctorDTO);
        doctorRepository.save(doctor);
    }

    @GetMapping("/get_registered_doctors")
    public Page<ListDoctorsDTO> getRegisteredDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return doctorRepository.findAllByActiveTrue(pageable).map(ListDoctorsDTO::new);
    }

    @PutMapping("/update_doctor_info")
    @Transactional
    public void updateDoctorInformation(@RequestBody @Valid UpdateDoctorInfoDTO updateDoctorInfoDTO) {
        Doctor doctor = doctorRepository.getReferenceById(updateDoctorInfoDTO.id());
        doctor.updateDoctorInformation(updateDoctorInfoDTO);
    }

    @DeleteMapping("/delete_doctor/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.setActiveAsFalse(id);
    }
}
