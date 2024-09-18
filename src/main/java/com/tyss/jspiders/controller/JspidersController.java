package com.tyss.jspiders.controller;

import com.tyss.jspiders.dto.EmployeeDTO;
import com.tyss.jspiders.dto.LoginDTO;
import com.tyss.jspiders.dto.StudentRegisterDTO;
import com.tyss.jspiders.dto.TrainerRegisterDTO;
import com.tyss.jspiders.jwt.JwtUtils;
import com.tyss.jspiders.repository.EmployeeRepository;
import com.tyss.jspiders.response.SuccessResponse;
import com.tyss.jspiders.service.JspidersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
@RestController
public class JspidersController {

    public final JspidersService jspidersService;
    public final JwtUtils jwtUtils;
    public final AuthenticationManager authenticationManager;

    @PostMapping(path = "register/employee")
    public ResponseEntity<SuccessResponse> registerEmployee(@RequestBody EmployeeDTO dto) {
        String id = jspidersService.registerEmployee(dto);

        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Employee Saved Successfully")
                .data(id)
                .status(HttpStatus.CREATED)
                .timeStamp(LocalDateTime.now())
                .build()));
    }

    @PostMapping(path = "register/trainer")
    public ResponseEntity<SuccessResponse> registerTrainer(@RequestBody TrainerRegisterDTO dto) {
        String id = jspidersService.registerTrainer(dto);

        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Trainer Saved Successfully")
                .data(id)
                .status(HttpStatus.CREATED)
                .timeStamp(LocalDateTime.now())
                .build()));
    }

    //yet to write student

    @PostMapping(path = "register/student")
    public ResponseEntity<SuccessResponse> registerStudent(@RequestBody StudentRegisterDTO dto) {
        String id = jspidersService.registerStudent(dto);

        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Trainer Saved Successfully")
                .data(id)
                .status(HttpStatus.CREATED)
                .timeStamp(LocalDateTime.now())
                .build()));
    }


    @PostMapping(path = "login")
    public ResponseEntity<SuccessResponse> login(@RequestBody LoginDTO dto) {

        //some logic to check username and password
        //authenticationManager.authenticate()
        System.out.println("Reached in login start");
        authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.getUsername(), dto.getPassword()
                        )
                );

        String token = jwtUtils.generateToken(dto.getUsername());
        System.out.println("Reached in login end");
        return ResponseEntity.of(Optional.ofNullable(SuccessResponse.builder()
                .message("Login Successfully")
                .data(false)
                .status(HttpStatus.OK)
                .token(token)
                .timeStamp(LocalDateTime.now())
                .build()));
    }
}
