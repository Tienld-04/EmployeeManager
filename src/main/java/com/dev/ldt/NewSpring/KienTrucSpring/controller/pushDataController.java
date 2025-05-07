package com.dev.ldt.NewSpring.KienTrucSpring.controller;

import com.dev.ldt.NewSpring.KienTrucSpring.entity.Employee;
import com.dev.ldt.NewSpring.KienTrucSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class pushDataController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String employeeList(Model model) {
        List<Employee> employees = employeeService.getListEmployee();
        model.addAttribute("employeeList", employees);
        return "Hello";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeByID(id);
        model.addAttribute("employee", employee);
        return "editEmployee";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
