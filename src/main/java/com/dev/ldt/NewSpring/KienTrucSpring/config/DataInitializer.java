package com.dev.ldt.NewSpring.KienTrucSpring.config;

import com.dev.ldt.NewSpring.KienTrucSpring.entity.Employee;
import com.dev.ldt.NewSpring.KienTrucSpring.entity.Role;
import com.dev.ldt.NewSpring.KienTrucSpring.entity.User;
import com.dev.ldt.NewSpring.KienTrucSpring.repository.EmployeeRepository;
import com.dev.ldt.NewSpring.KienTrucSpring.repository.RoleRepository;
import com.dev.ldt.NewSpring.KienTrucSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Tạo roles mặc định
        createRoles();

        // Tạo admin user mặc định
        createAdminUser();

        // Tạo dữ liệu mẫu cho nhân viên
        createSampleEmployees();
    }

    private void createRoles() {
        // Tạo ROLE_USER nếu chưa tồn tại
        if (!roleRepository.existsByName("ROLE_USER")) {
            Role userRole = new Role("ROLE_USER", "User role");
            roleRepository.save(userRole);
        }

        // Tạo ROLE_ADMIN nếu chưa tồn tại
        if (!roleRepository.existsByName("ROLE_ADMIN")) {
            Role adminRole = new Role("ROLE_ADMIN", "Administrator role");
            roleRepository.save(adminRole);
        }
    }

    private void createAdminUser() {
        // Tạo admin user nếu chưa tồn tại
        if (!userRepository.existsByUsername("admin")) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setEmail("admin@example.com");
            adminUser.setFirstName("Admin");
            adminUser.setLastName("User");
            adminUser.setEnabled(true);

            // Gán cả ROLE_USER và ROLE_ADMIN
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_USER").orElse(null));
            roles.add(roleRepository.findByName("ROLE_ADMIN").orElse(null));
            adminUser.setRoles(roles);

            userRepository.save(adminUser);
            System.out.println("Admin user created: admin/admin123");
        }
    }

    private void createSampleEmployees() {
        // Tạo dữ liệu mẫu cho nhân viên nếu chưa có
        if (employeeRepository.count() == 0) {
            Employee emp1 = new Employee(1L, "Nguyễn Văn An", 25, "0123456789", "Hà Nội");
            Employee emp2 = new Employee(2L, "Trần Thị Bình", 30, "0987654321", "TP. Hồ Chí Minh");
            Employee emp3 = new Employee(3L, "Lê Văn Cường", 28, "0369852147", "Đà Nẵng");

            employeeRepository.save(emp1);
            employeeRepository.save(emp2);
            employeeRepository.save(emp3);

            System.out.println("Sample employees created successfully!");
        }
    }
} 