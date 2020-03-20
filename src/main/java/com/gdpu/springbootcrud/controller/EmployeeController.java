package com.gdpu.springbootcrud.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.springbootcrud.entity.Employee;
import com.gdpu.springbootcrud.entity.Msg;
import com.gdpu.springbootcrud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * 保存员工
     *
     * @param employee 员工
     * @return
     */
    @ResponseBody
    @PostMapping
    public Msg save(Employee employee) {
        boolean result = employeeService.save(employee);
        if (result) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 根据ID查询员工
     *
     * @param id 员工ID
     * @return
     */
    @ResponseBody
    @GetMapping("/{id}")
    public Msg getById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getById(id);
        if (employee != null) {
            return Msg.success().add("emp", employee);
        } else {
            return Msg.fail();
        }
    }

    /**
     * 更新员工信息
     *
     * @param employee 新员工信息
     * @return
     */
    @ResponseBody
    @PutMapping
    public Msg update(Employee employee) {
        boolean result = employeeService.updateById(employee);
        if (result) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 根据ID删除员工
     *
     * @param id 员工ID
     * @return
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public Msg removeById(@PathVariable("id") Long id) {
        boolean result = employeeService.removeById(id);
        if (result) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 批量删除员工
     *
     * @param idList 员工id集合
     * @return
     */
    @ResponseBody
    @DeleteMapping("/list")
    public Msg removeList(@RequestBody List<Long> idList) {
        boolean result = employeeService.removeByIds(idList);
        if (result) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

   /* @GetMapping
    public String getByKeyword(@RequestParam("keyword") String keyword,
                               Model model) {
        Page<Employee> page = new Page<>(1, 5);
        Page<Employee> searchPageInfo = employeeService.getByKeyword(keyword, page);
        model.addAttribute("searchPageInfo", searchPageInfo);
        return "/main/1";
    }*/
}
