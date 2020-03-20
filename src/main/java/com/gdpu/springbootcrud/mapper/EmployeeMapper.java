package com.gdpu.springbootcrud.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.springbootcrud.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

   Page<Employee> selectPageWithDept(Page<Employee> page, @Param("ew") Wrapper<Employee> queryWrapper);
}
