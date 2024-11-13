package uni.hcmus.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uni.hcmus.employeemanagement.dto.EmployeeDto;
import uni.hcmus.employeemanagement.service.interfaceService.IEmployeeService;
import uni.hcmus.employeemanagement.service.interfaceService.IPointService;

import java.security.Principal;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IPointService pointService;

    @Autowired
    private IEmployeeService employeeService;


    //Lay thong tin cua nhan vien dang dang nhap
    //Tra ve thong tin cua nhan vien dang dang nhap là
    //int: id, string:name, int point, string type, string managerId
    //URL: http://localhost:8080/api/employees/me/profile
    @GetMapping("/me/profile")
    public ResponseEntity<EmployeeDto> getMyProfile(Principal principal) {
        // Lấy email của người dùng từ Principal (Spring Security sẽ tự động cung cấp thông tin này)
        String email = principal.getName();

        // Lấy thông tin nhân viên từ service bằng email
        EmployeeDto employeeDto = employeeService.getEmployeeByEmail(email);

        // Trả về thông tin nhân viên dưới dạng ResponseEntity
        return ResponseEntity.ok(employeeDto);
    }


}