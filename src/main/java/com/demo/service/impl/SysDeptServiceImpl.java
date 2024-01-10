package com.demo.service.impl;

import java.util.List;
import com.demo.common.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.mapper.SysDeptMapper;
import com.demo.domain.SysDept;
import com.demo.service.ISysDeptService;

/**
 * 部门Service业务层处理
 * 
 * @author zyj
 * @date 2023-12-28
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService 
{
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询部门
     * 
     * @param deptId 部门ID
     * @return 部门
     */
    @Override
    public SysDept selectSysDeptById(Long deptId)
    {
        return sysDeptMapper.selectSysDeptById(deptId);
    }

    /**
     * 查询部门列表
     * 
     * @param sysDept 部门
     * @return 部门
     */
    @Override
    public List<SysDept> selectSysDeptList(SysDept sysDept)
    {
        return sysDeptMapper.selectSysDeptList(sysDept);
    }

    /**
     * 新增部门
     * 
     * @param sysDept 部门
     * @return 结果
     */
    @Override
    public int insertSysDept(SysDept sysDept)
    {
        sysDept.setCreateTime(DateUtils.getNowDate());
        return sysDeptMapper.insertSysDept(sysDept);
    }

    /**
     * 修改部门
     * 
     * @param sysDept 部门
     * @return 结果
     */
    @Override
    public int updateSysDept(SysDept sysDept)
    {
        sysDept.setUpdateTime(DateUtils.getNowDate());
        return sysDeptMapper.updateSysDept(sysDept);
    }

    /**
     * 批量删除部门
     * 
     * @param deptIds 需要删除的部门ID
     * @return 结果
     */
    @Override
    public int deleteSysDeptByIds(Long[] deptIds)
    {
        return sysDeptMapper.deleteSysDeptByIds(deptIds);
    }

    /**
     * 删除部门信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    @Override
    public int deleteSysDeptById(Long deptId)
    {
        return sysDeptMapper.deleteSysDeptById(deptId);
    }
}
