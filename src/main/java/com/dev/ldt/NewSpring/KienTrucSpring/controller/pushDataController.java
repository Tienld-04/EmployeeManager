package com.dev.ldt.NewSpring.KienTrucSpring.controller;

import com.dev.ldt.NewSpring.KienTrucSpring.entity.Employee;
import com.dev.ldt.NewSpring.KienTrucSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
