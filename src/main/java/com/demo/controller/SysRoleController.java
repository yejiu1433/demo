package com.demo.controller;

import java.util.List;

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
import com.demo.common.enums.BusinessType;
import com.demo.common.util.ExcelUtil;
import com.demo.domain.AjaxResult;
import com.demo.domain.SysRole;
import com.demo.domain.page.TableDataInfo;
import com.demo.service.ISysRoleService;

/**
 * 角色信息Controller
 * 
 * @author zyj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/demo/role")
public class SysRoleController extends BaseController
{
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 查询角色信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysRole sysRole)
    {
        startPage();
        List<SysRole> list = sysRoleService.selectSysRoleList(sysRole);
        return getDataTable(list);
    }

    /**
     * 导出角色信息列表
     */
    @Log(title = "角色信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysRole sysRole)
    {
        List<SysRole> list = sysRoleService.selectSysRoleList(sysRole);
        ExcelUtil<SysRole> util = new ExcelUtil<SysRole>(SysRole.class);
        return util.exportExcel(list, "role");
    }

    /**
     * 获取角色信息详细信息
     */
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable("roleId") Long roleId)
    {
        return AjaxResult.success(sysRoleService.selectSysRoleById(roleId));
    }

    /**
     * 新增角色信息
     */
    @Log(title = "角色信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRole sysRole)
    {
        return toAjax(sysRoleService.insertSysRole(sysRole));
    }

    /**
     * 修改角色信息
     */
    @Log(title = "角色信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRole sysRole)
    {
        return toAjax(sysRoleService.updateSysRole(sysRole));
    }

    /**
     * 删除角色信息
     */
    @Log(title = "角色信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds)
    {
        return toAjax(sysRoleService.deleteSysRoleByIds(roleIds));
    }
}
