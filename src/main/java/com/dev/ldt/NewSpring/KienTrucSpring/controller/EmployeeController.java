package com.dev.ldt.NewSpring.KienTrucSpring.controller;

import com.dev.ldt.NewSpring.KienTrucSpring.entity.Employee;
import com.dev.ldt.NewSpring.KienTrucSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping
//    public String employeeList(Model model){
//        List<Employee> employees = employeeService.getListEmployee();
//        model.addAttribute("employeeList", employees);
//        System.out.println(model.getAttribute("employeeList"));
//        System.out.println(model.asMap());
//        return "Hello";
//    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getListEmployee();

    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeByID(id);

    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
    
}
