package com.gdpu.springbootcrud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.springbootcrud.entity.Employee;
import com.gdpu.springbootcrud.mapper.EmployeeMapper;
import com.gdpu.springbootcrud.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询员工（携带部门信息）分页信息
     *
     * @param page 分页数据
     * @return 分页信息
     */
    @Override
    public Page<Employee> pageWithDept(Page<Employee> page) {
        return employeeMapper.selectPageWithDept(page, Wrappers.emptyWrapper());
    }

    @Override
    public Page<Employee> getByKeyword(String keyword, Page<Employee> page) {
        if (keyword.matches("[0-9]+")) {
            //根据员工ID查询
            long eid = Integer.parseInt(keyword);
            QueryWrapper<Employee> wrapper = new QueryWrapper<>();
            wrapper.eq("eid", eid);
            Page<Employee> pageInfo = employeeMapper.selectPageWithDept(page, wrapper);
            return pageInfo;
        } else {
            //根据员工姓名查询
            QueryWrapper<Employee> wrapper = new QueryWrapper<>();
            wrapper.like("emp_name", keyword);
            Page<Employee> pageInfo = employeeMapper.selectPageWithDept(page, wrapper);
            return pageInfo;
        }
    }
}
