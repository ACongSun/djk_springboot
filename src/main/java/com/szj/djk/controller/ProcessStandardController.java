package com.szj.djk.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szj.djk.common.R;
import com.szj.djk.entity.LmdpThirdConcise;
import com.szj.djk.entity.ProcessStandard;
import com.szj.djk.entity.ProcessStandard;
import com.szj.djk.service.ProcessStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProcessStandardController
 * @Authoc 孙少聪
 * @Date 2022/9/29 20:29:18
 */

@RestController
@RequestMapping("/processStandard")
public class ProcessStandardController {

    @Autowired
    private ProcessStandardService processStandardService;

    @GetMapping("list")
    public R<List<ProcessStandard>> list(ProcessStandard processStandard){
        LambdaQueryWrapper<ProcessStandard> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.setEntity(processStandard);
        List<ProcessStandard> list = processStandardService.list(queryWrapper);
        return R.success(list);
    }

    @GetMapping("pageList")
    public R<Page> pageList(int pageNum, int pageSize, ProcessStandard processStandard){
        Page<ProcessStandard> pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<ProcessStandard> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.setEntity(processStandard);
        Page<ProcessStandard> page = processStandardService.page(pageInfo, queryWrapper);
        return R.success(page);
    }

    @GetMapping("{id}")
    public R<ProcessStandard> getStandardbyId(@PathVariable("id") int id){
        ProcessStandard processStandard = processStandardService.getById(id);
        return R.success(processStandard);
    }
}
