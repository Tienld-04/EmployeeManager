package com.dev.ldt.NewSpring.KienTrucSpring.service;

import com.dev.ldt.NewSpring.KienTrucSpring.entity.Employee;
import com.dev.ldt.NewSpring.KienTrucSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getListEmployee(){
           return employeeRepository.findAll();
    }

    public Employee getEmployeeByID(Long id){
//        Tham số đầu vào: Long id → ID của nhân viên cần tìm.
//        Phương thức findById(id) → Tìm nhân viên trong database theo ID.
//        orElse(null) → Nếu không tìm thấy nhân viên, trả về null.
        return employeeRepository.findById(id).orElse(null);

    }
    public Employee saveEmployee(Employee employee){
//        Tham số đầu vào: Employee employee → đối tượng nhân viên cần lưu.
//        Phương thức save(employee) → Lưu hoặc cập nhật nhân viên vào database.
//        Giá trị trả về: Trả về đối tượng Employee sau khi đã lưu vào database.
//        Nếu employee chưa có ID (ID = null) → Thêm mới (INSERT)
//        Nếu employee đã có ID và tồn tại trong database → Cập nhật (UPDATE)
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long id, Employee employee){
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("No Employee"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        return employeeRepository.save(existingEmployee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }





}
