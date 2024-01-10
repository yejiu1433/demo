package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.annotation.Log;
import com.demo.common.constant.Constants;
import com.demo.common.enums.BusinessType;
import com.demo.common.util.ExcelUtil;
import com.demo.domain.AjaxResult;
import com.demo.domain.SysUser;
import com.demo.domain.page.TableDataInfo;
import com.demo.service.ISysUserService;

/**
 * 用户信息Controller
 * 
 * @author zyj
 * @date 2023-11-30
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController
{
    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody String body)
    {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put(Constants.TOKEN, "123");
        return AjaxResult.success(map);
    }
    
    /**
     * 查询用户信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysUser sysUser)
    {
        startPage();
        List<SysUser> list = sysUserService.selectSysUserList(sysUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysUser sysUser)
    {
        List<SysUser> list = sysUserService.selectSysUserList(sysUser);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 获取用户信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('yejiu:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(sysUserService.selectSysUserById(userId));
    }

    /**
     * 新增用户信息
     */
//    @PreAuthorize("@ss.hasPermi('yejiu:user:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUser sysUser)
    {
        return toAjax(sysUserService.insertSysUser(sysUser));
    }

    /**
     * 修改用户信息
     */
//    @PreAuthorize("@ss.hasPermi('yejiu:user:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUser sysUser)
    {
        return toAjax(sysUserService.updateSysUser(sysUser));
    }

    /**
     * 删除用户信息
     */
//    @PreAuthorize("@ss.hasPermi('yejiu:user:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(sysUserService.deleteSysUserByIds(userIds));
    }
}
