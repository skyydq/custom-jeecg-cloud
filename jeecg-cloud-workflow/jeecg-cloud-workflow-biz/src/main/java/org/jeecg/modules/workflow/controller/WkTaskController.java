package org.jeecg.modules.workflow.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.workflow.entity.WkTask;
import org.jeecg.modules.workflow.service.IWkTaskService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 工作流任务表
 * @Author: jeecg-boot
 * @Date:   2020-12-25
 * @Version: V1.0
 */
@Api(tags="工作流任务表")
@RestController
@RequestMapping("/workflow/wkTask")
@Slf4j
public class WkTaskController extends JeecgController<WkTask, IWkTaskService> {
	@Autowired
	private IWkTaskService wkTaskService;
	
	/**
	 * 分页列表查询
	 *
	 * @param wkTask
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "工作流任务表-分页列表查询")
	@ApiOperation(value="工作流任务表-分页列表查询", notes="工作流任务表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(WkTask wkTask,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<WkTask> queryWrapper = QueryGenerator.initQueryWrapper(wkTask, req.getParameterMap());
		Page<WkTask> page = new Page<WkTask>(pageNo, pageSize);
		IPage<WkTask> pageList = wkTaskService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param wkTask
	 * @return
	 */
	@AutoLog(value = "工作流任务表-添加")
	@ApiOperation(value="工作流任务表-添加", notes="工作流任务表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody WkTask wkTask) {
		wkTaskService.save(wkTask);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param wkTask
	 * @return
	 */
	@AutoLog(value = "工作流任务表-编辑")
	@ApiOperation(value="工作流任务表-编辑", notes="工作流任务表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody WkTask wkTask) {
		wkTaskService.updateById(wkTask);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "工作流任务表-通过id删除")
	@ApiOperation(value="工作流任务表-通过id删除", notes="工作流任务表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		wkTaskService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "工作流任务表-批量删除")
	@ApiOperation(value="工作流任务表-批量删除", notes="工作流任务表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.wkTaskService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "工作流任务表-通过id查询")
	@ApiOperation(value="工作流任务表-通过id查询", notes="工作流任务表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		WkTask wkTask = wkTaskService.getById(id);
		if(wkTask==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(wkTask);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param wkTask
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, WkTask wkTask) {
        return super.exportXls(request, wkTask, WkTask.class, "工作流任务表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, WkTask.class);
    }

}
