package com.tyss.jspiders.service;

import com.tyss.jspiders.dto.EmployeeDTO;
import com.tyss.jspiders.dto.StudentRegisterDTO;
import com.tyss.jspiders.dto.TrainerRegisterDTO;
import com.tyss.jspiders.entity.*;
import com.tyss.jspiders.exception.RoleNotFoundException;
import com.tyss.jspiders.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JspidersServiceImpl implements JspidersService{

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final AppUserRepository appUserRepository;
    private final TrainerRepository trainerRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public String registerEmployee(EmployeeDTO dto) {
        Employee employee = Employee.builder()
                .employeeId(dto.getEmployeeId())
                .name(dto.getName())
                .build();
        employeeRepository.save(employee);

        Role role = roleRepository.findByName("ROLE_EMPLOYEE")
                .orElseThrow(() -> new RoleNotFoundException("Role does not exist"));

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);

        AppUser appUser = AppUser.builder()
                .username(dto.getEmployeeId())
                .password(dto.getPassword())
                .roles(roles)
                .build();
        appUserRepository.save(appUser);
        return dto.getEmployeeId();
    }

    @Override
    public String registerTrainer(TrainerRegisterDTO dto) {
        Trainer trainer = Trainer.builder()
                .trainerId(dto.getTrainerId())
                .name(dto.getName())
                .build();
        trainerRepository.save(trainer);

        Role role = roleRepository.findByName("ROLE_TRAINER")
                .orElseThrow(() -> new RoleNotFoundException("Role does not exist"));

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);

        AppUser appUser = AppUser.builder()
                .username(dto.getTrainerId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(roles)
                .build();
        appUserRepository.save(appUser);
        return dto.getTrainerId();
    }

    @Override
    public String registerStudent(StudentRegisterDTO dto) {
        Student student = Student.builder()
                .studentId(dto.getStudentId())
                .name(dto.getName())
                .build();
        studentRepository.save(student);

        Role role = roleRepository.findByName("ROLE_STUDENT")
                .orElseThrow(() -> new RoleNotFoundException("Role does not exist"));

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);

        AppUser appUser = AppUser.builder()
                .username(dto.getStudentId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(roles)
                .build();
        appUserRepository.save(appUser);
        return dto.getStudentId();
    }


}
