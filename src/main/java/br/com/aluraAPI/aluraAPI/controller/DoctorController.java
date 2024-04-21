package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.doctor.Doctor;
import br.com.aluraAPI.aluraAPI.doctor.DoctorRepository;
import br.com.aluraAPI.aluraAPI.doctor.RegisterDoctorDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
