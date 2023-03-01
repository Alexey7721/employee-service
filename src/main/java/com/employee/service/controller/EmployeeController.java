package com.employee.service.controller;

import com.employee.service.entity.Employee;
import com.employee.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("employee", new Employee());
        return "employees-list";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if(result.hasErrors()) return "employees-list";
        employeeService.save(employee);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee-update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if(result.hasErrors()) return "employees-list";
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeeService.getById(id));
        return "show-employee";
    }
}
