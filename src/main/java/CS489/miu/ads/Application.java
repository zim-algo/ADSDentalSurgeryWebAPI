package CS489.miu.ads;

import CS489.miu.ads.model.*;
import CS489.miu.ads.repository.RoleRepository;
import CS489.miu.ads.repository.UserRepository;
import CS489.miu.ads.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private PatientService patientService;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public Application(PatientService patientService, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.patientService = patientService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @PostConstruct
    public void initAdminUser() {
        var adminUser = userRepository.findByUsername("admin");
        if(adminUser.isEmpty()) {
            List<Role> listAdminRoles = new ArrayList<>();
            var adminRole = roleRepository.findByName("ROLE_ADMIN");
            if(adminRole.isEmpty()) {
                var newAdminRole =  new Role(null, "ROLE_ADMIN");
                listAdminRoles.add(newAdminRole);
            } else {
                listAdminRoles.add(adminRole.get());
            }
            User newAdminUser = new User(null, "Admin", "Admin", "Admin", "admin",
                    passwordEncoder.encode("test1234"), "admin@ads.com",
                    true,true, true, true);
            newAdminUser.setRoles(listAdminRoles);
            userRepository.save(newAdminUser);
        }
    }

    @Override
    public void run(String... args) throws Exception {

            var address1 = new Address(null, "Fairfield", "Iowa", "52557",null);
            var address2 = new Address(null, "123 Main St", "California", "12345",null);
            var address3 = new Address(null, "456 Elm St", "Nevada", "67890",null);


            // Populate the attributes of patient
            var patient1 = new Patient(null, "Paul", "Gomes", "P10", "1234567890", "john.doe@example.com", LocalDate.of(1990, 5, 15), address1, null);
            var patient2 = new Patient(null, "Jane", "Smith", "P15", "0987654321", "jane.smith@example.com", LocalDate.of(1985, 9, 20), address2, null);
            var patient3 = new Patient(null, "Alice", "Johnson", "P20", "9876543210", "alice.johnson@example.com", LocalDate.of(1975, 3, 10), address3, null);
            patientService.registerAll(Arrays.asList(patient1,patient2,patient3));
            //patientService.registerOne(patient2);
            //patientService.registerOne(patient3);

    }
}
