package org.jeecg.modules.workflow.service.impl;

import org.jeecg.modules.workflow.entity.WkTask;
import org.jeecg.modules.workflow.mapper.WkTaskMapper;
import org.jeecg.modules.workflow.service.IWkTaskService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 工作流任务表
 * @Author: jeecg-boot
 * @Date:   2020-12-25
 * @Version: V1.0
 */
@Service
public class WkTaskServiceImpl extends ServiceImpl<WkTaskMapper, WkTask> implements IWkTaskService {

}
