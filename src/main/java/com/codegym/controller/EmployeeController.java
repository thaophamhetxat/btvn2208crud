package com.codegym.controller;

import moduls.Employee;
import moduls.PhongBan;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IEmployeeService;
import service.IPhongBanService;

import java.util.ArrayList;

@Controller
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPhongBanService iPhongBanService;

    @GetMapping("show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iEmployeeService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("listPhongBan",iPhongBanService.ShowAllPhongBan());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Employee employee) {
        iEmployeeService.save(employee);
        return new ModelAndView("redirect:/show");
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit","listPhongBan",iPhongBanService.ShowAllPhongBan());
        modelAndView.addObject("list", iEmployeeService.findById(id));
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iEmployeeService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iEmployeeService.delete(iEmployeeService.findById(id));
        return new ModelAndView("redirect:/show");
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Employee employee) {
        iEmployeeService.edit(employee);
        return new ModelAndView("redirect:/show");
    }


    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("list", iEmployeeService.findById(id));
        return modelAndView;
    }
}
