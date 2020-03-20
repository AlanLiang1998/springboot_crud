package com.gdpu.springbootcrud.service.impl;

import com.gdpu.springbootcrud.entity.Department;
import com.gdpu.springbootcrud.mapper.DepartmentMapper;
import com.gdpu.springbootcrud.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
