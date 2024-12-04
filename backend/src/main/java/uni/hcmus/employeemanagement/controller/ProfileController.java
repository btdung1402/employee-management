package uni.hcmus.employeemanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uni.hcmus.employeemanagement.dto.Response.EmployeePublicDto_v1;
import uni.hcmus.employeemanagement.exception_handler.exceptions.DataNotFoundException;
import uni.hcmus.employeemanagement.service.interfaceService.IEmployeeService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    IEmployeeService employeeService;


    //lay ra danh sach tat ca cac nhan vien trong team cua nguoi dang dang nhap
    @GetMapping("all")
    public ResponseEntity<List<EmployeePublicDto_v1>> getAllProfile(Principal principal) {
        String email = principal.getName();
        List<EmployeePublicDto_v1> employees = employeeService.getTeamMate(email).orElse(null);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeePublicDto_v1> getSummaryProfile(Principal principal, @PathVariable Long id) {
        String email = principal.getName();

        // Kiểm tra profile cá nhân
        Optional<EmployeePublicDto_v1> emp = employeeService.getMyselft(email, id);
        if (emp.isPresent()) {
            return ResponseEntity.ok(emp.get());
        }

        List<EmployeePublicDto_v1> employees = employeeService.getTeamMate(email)
                .orElseThrow(() -> new DataNotFoundException("No employees found."));

        EmployeePublicDto_v1 employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("Employee not found with id = " + id));

        return ResponseEntity.ok(employee);
    }

}
