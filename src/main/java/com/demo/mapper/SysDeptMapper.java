package com.demo.mapper;

import java.util.List;
import com.demo.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门Mapper接口
 * 
 * @author zyj
 * @date 2023-12-28
 */
 @Mapper
public interface SysDeptMapper 
{
    /**
     * 查询部门
     * 
     * @param deptId 部门ID
     * @return 部门
     */
    public SysDept selectSysDeptById(Long deptId);

    /**
     * 查询部门列表
     * 
     * @param sysDept 部门
     * @return 部门集合
     */
    public List<SysDept> selectSysDeptList(SysDept sysDept);

    /**
     * 新增部门
     * 
     * @param sysDept 部门
     * @return 结果
     */
    public int insertSysDept(SysDept sysDept);

    /**
     * 修改部门
     * 
     * @param sysDept 部门
     * @return 结果
     */
    public int updateSysDept(SysDept sysDept);

    /**
     * 删除部门
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteSysDeptById(Long deptId);

    /**
     * 批量删除部门
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDeptByIds(Long[] deptIds);
}
