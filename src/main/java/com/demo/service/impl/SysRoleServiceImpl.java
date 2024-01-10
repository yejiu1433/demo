package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.util.DateUtils;
import com.demo.domain.SysRole;
import com.demo.mapper.SysRoleMapper;
import com.demo.service.ISysRoleService;

/**
 * 角色信息Service业务层处理
 * 
 * @author zyj
 * @date 2023-12-27
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService 
{
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询角色信息
     * 
     * @param roleId 角色信息ID
     * @return 角色信息
     */
    @Override
    public SysRole selectSysRoleById(Long roleId)
    {
        return sysRoleMapper.selectSysRoleById(roleId);
    }

    /**
     * 查询角色信息列表
     * 
     * @param sysRole 角色信息
     * @return 角色信息
     */
    @Override
    public List<SysRole> selectSysRoleList(SysRole sysRole)
    {
        return sysRoleMapper.selectSysRoleList(sysRole);
    }

    /**
     * 新增角色信息
     * 
     * @param sysRole 角色信息
     * @return 结果
     */
    @Override
    public int insertSysRole(SysRole sysRole)
    {
        sysRole.setCreateTime(DateUtils.getNowDate());
        return sysRoleMapper.insertSysRole(sysRole);
    }

    /**
     * 修改角色信息
     * 
     * @param sysRole 角色信息
     * @return 结果
     */
    @Override
    public int updateSysRole(SysRole sysRole)
    {
        sysRole.setUpdateTime(DateUtils.getNowDate());
        return sysRoleMapper.updateSysRole(sysRole);
    }

    /**
     * 批量删除角色信息
     * 
     * @param roleIds 需要删除的角色信息ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleByIds(Long[] roleIds)
    {
        return sysRoleMapper.deleteSysRoleByIds(roleIds);
    }

    /**
     * 删除角色信息信息
     * 
     * @param roleId 角色信息ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleById(Long roleId)
    {
        return sysRoleMapper.deleteSysRoleById(roleId);
    }
}
