package com.tyss.jspiders;

import com.tyss.jspiders.entity.Admin;
import com.tyss.jspiders.entity.AppUser;
import com.tyss.jspiders.entity.Role;
import com.tyss.jspiders.repository.AdminRepository;
import com.tyss.jspiders.repository.AppUserRepository;
import com.tyss.jspiders.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@SpringBootApplication
public class JspidersApplication {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;
    private final AdminRepository adminRepository;


    public static void main(String[] args) {
        SpringApplication.run(JspidersApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Optional<Role> role = roleRepository.findByName("ROLE_ADMIN");
            if (!role.isPresent()) {
                Role roleStudent = Role.builder().name("ROLE_STUDENT")
                        .build();

                Role roleAdmin1 = Role.builder().name("ROLE_ADMIN").appUsers(new ArrayList<>()).build();
                roleRepository.save(roleAdmin1);

                Role roleTrainer = Role.builder().name("ROLE_TRAINER").build();
                roleRepository.save(roleTrainer);

                Role roleEmployee = Role.builder().name("ROLE_EMPLOYEE").build();
                roleRepository.save(roleEmployee);


                Admin admin = Admin.builder()
                        .adminId("admin01")
                        .name("admin")
                        .build();
                adminRepository.save(admin);

                AppUser appUser = AppUser.builder()
                        .username(admin.getAdminId())
                        .password(passwordEncoder.encode("Sukesh"))
                        .roles(new ArrayList<>())
                        .build();

                appUser.getRoles().add(roleAdmin1);
                roleAdmin1.getAppUsers().add(appUser);
                appUserRepository.save(appUser);


            }


        };

    }
}
