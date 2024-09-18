package com.tyss.jspiders.service;

import com.tyss.jspiders.dto.EmployeeDTO;
import com.tyss.jspiders.dto.LoginDTO;
import com.tyss.jspiders.dto.StudentRegisterDTO;
import com.tyss.jspiders.dto.TrainerRegisterDTO;

public interface JspidersService {


    String registerEmployee(EmployeeDTO dto);


    String registerTrainer(TrainerRegisterDTO dto);


    String registerStudent(StudentRegisterDTO dto);
}
