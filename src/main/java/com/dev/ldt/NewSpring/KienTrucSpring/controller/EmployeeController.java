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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Web interface endpoints
    @GetMapping
    public String employeeList(Model model) {
        List<Employee> employees = employeeService.getListEmployee();
        model.addAttribute("employeeList", employees);
        return "employees/list";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeByID(id);
        model.addAttribute("employee", employee);
        return "employees/edit";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // REST API endpoints
    @GetMapping("/api")
    @ResponseBody
    public List<Employee> getAllEmployee() {
        return employeeService.getListEmployee();
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeByID(id);
    }

    @PostMapping("/api")
    @ResponseBody
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/api/{id}")
    @ResponseBody
    public Employee updateEmployeeApi(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public void deleteEmployeeApi(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
