package com.gdpu.springbootcrud.mapper;

import com.gdpu.springbootcrud.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {
    Department mySelectById(Long did);
}
