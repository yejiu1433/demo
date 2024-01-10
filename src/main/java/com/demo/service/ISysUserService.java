package com.demo.service;

import java.util.List;

import com.demo.domain.SysUser;

/**
 * 用户信息Service接口
 * 
 * @author zyj
 * @date 2023-11-30
 */
public interface ISysUserService 
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public SysUser selectSysUserById(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param sysUser 用户信息
     * @return 用户信息集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 新增用户信息
     * 
     * @param sysUser 用户信息
     * @return 结果
     */
    public int insertSysUser(SysUser sysUser);

    /**
     * 修改用户信息
     * 
     * @param sysUser 用户信息
     * @return 结果
     */
    public int updateSysUser(SysUser sysUser);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的用户信息ID
     * @return 结果
     */
    public int deleteSysUserByIds(Long[] userIds);

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deleteSysUserById(Long userId);
}
