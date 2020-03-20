package com.gdpu.springbootcrud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.springbootcrud.entity.Department;
import com.gdpu.springbootcrud.entity.Employee;
import com.gdpu.springbootcrud.entity.Msg;
import com.gdpu.springbootcrud.service.IDepartmentService;
import com.gdpu.springbootcrud.service.IEmployeeService;
import com.gdpu.springbootcrud.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descriptin TODO
 * @Author AlanLiang
 * Date 2020/3/19 9:39
 * Version 1.0
 **/
@Controller
public class IndexController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;

    //每页显示数量
    private static final long SIZE = 5;
    //连续显示页码
    private static final long NAVIGATE_PAGE = 5;

    /**
     * 分页展示员工信息
     *
     * @param current 当前页码
     * @return 首页视图
     */
    @GetMapping("/main/{cur}")
    public String list(@PathVariable("cur") Long current,
                       Model model) {
        Page<Employee> page = new Page<>(current, SIZE);
        Page<Employee> pageInfo = employeeService.pageWithDept(page);
        //获取当前连续显示页码
        ArrayList<Long> navigatePageNums = PageUtil.getNavigatePageNums(pageInfo.getCurrent(), pageInfo.getPages(), NAVIGATE_PAGE);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("navigatePageNums", navigatePageNums);

        List<Department> depts = departmentService.list();
        model.addAttribute("depts", depts);
        return "main";
    }

    /**
     * 根据关键词查询员工
     *
     * @param current 当前页码
     * @param keyword 关键词
     * @param model   数据模型
     * @return
     */
    @GetMapping("/main/search/{cur}")
    public String searchList(@PathVariable("cur") Long current,
                             @RequestParam(value = "keyword") String keyword,
                             Model model) {
        Page<Employee> page = new Page<>(current, SIZE);
        Page<Employee> pageInfo = employeeService.getByKeyword(keyword, page);
        //获取当前连续显示页码
        ArrayList<Long> navigatePageNums = PageUtil.getNavigatePageNums(pageInfo.getCurrent(), pageInfo.getPages(), NAVIGATE_PAGE);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("navigatePageNums", navigatePageNums);
        model.addAttribute("isSearch", true);
        model.addAttribute("keyword", keyword);

        List<Department> depts = departmentService.list();
        model.addAttribute("depts", depts);
        return "main";
    }
}
