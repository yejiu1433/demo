package com.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.common.annotation.Log;
import com.demo.common.enums.BusinessType;
import com.demo.domain.SysDept;
import com.demo.service.ISysDeptService;
import com.demo.domain.AjaxResult;
import com.demo.common.util.ExcelUtil;
import com.demo.domain.page.TableDataInfo;

/**
 * 部门Controller
 * 
 * @author zyj
 * @date 2023-12-28
 */
@RestController
@RequestMapping("/demo/dept")
public class SysDeptController extends BaseController
{
    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 查询部门列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysDept sysDept)
    {
        startPage();
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        return getDataTable(list);
    }

    /**
     * 导出部门列表
     */
    @Log(title = "部门", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysDept sysDept)
    {
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        ExcelUtil<SysDept> util = new ExcelUtil<SysDept>(SysDept.class);
        return util.exportExcel(list, "dept");
    }

    /**
     * 获取部门详细信息
     */
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(sysDeptService.selectSysDeptById(deptId));
    }

    /**
     * 新增部门
     */
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.insertSysDept(sysDept));
    }

    /**
     * 修改部门
     */
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.updateSysDept(sysDept));
    }

    /**
     * 删除部门
     */
    @Log(title = "部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(sysDeptService.deleteSysDeptByIds(deptIds));
    }
}
