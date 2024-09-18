package com.tyss.jspiders.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "api/student")
@RestController
public class StudentController {

    @GetMapping(path = "dummy")
    public String dummy() {
        return "dummy msg for student";
    }
}
