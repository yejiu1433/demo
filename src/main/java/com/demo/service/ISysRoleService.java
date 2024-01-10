package com.demo.service;

import java.util.List;
import com.demo.domain.SysRole;

/**
 * 角色信息Service接口
 * 
 * @author zyj
 * @date 2023-12-27
 */
public interface ISysRoleService 
{
    /**
     * 查询角色信息
     * 
     * @param roleId 角色信息ID
     * @return 角色信息
     */
    public SysRole selectSysRoleById(Long roleId);

    /**
     * 查询角色信息列表
     * 
     * @param sysRole 角色信息
     * @return 角色信息集合
     */
    public List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 新增角色信息
     * 
     * @param sysRole 角色信息
     * @return 结果
     */
    public int insertSysRole(SysRole sysRole);

    /**
     * 修改角色信息
     * 
     * @param sysRole 角色信息
     * @return 结果
     */
    public int updateSysRole(SysRole sysRole);

    /**
     * 批量删除角色信息
     * 
     * @param roleIds 需要删除的角色信息ID
     * @return 结果
     */
    public int deleteSysRoleByIds(Long[] roleIds);

    /**
     * 删除角色信息信息
     * 
     * @param roleId 角色信息ID
     * @return 结果
     */
    public int deleteSysRoleById(Long roleId);
}
