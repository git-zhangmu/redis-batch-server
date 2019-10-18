package com.zhangxiaobin.controller;

import com.zhangxiaobin.service.RedisHelper;
import com.zhangxiaobin.util.AsyncTaskManager;
import com.zhangxiaobin.vo.BusinessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxiaobin
 * @title: Test
 * @description: TODO
 * @date 2019/10/1720:15
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class Test {

    @Autowired
    private AsyncTaskManager taskManager;

    @Autowired
    private RedisHelper redisHelper;


    /**
     *  批量删除key
     * @param pattern 匹配的条件 比如 *2018*
     * @param count 每次scan的数量
     * @return
     */
    @GetMapping("/delKey")
    public BusinessResult delKey(@RequestParam("pattern")String pattern ,
                                 @RequestParam(name = "count",defaultValue = "100000")Integer count ){

        taskManager.getExecutor().submit(new Runnable() {
            @Override
            public void run() {
                redisHelper.scan2del(pattern,count);

            }
        });

        return BusinessResult.createSuccessInstance(null);
    }


}
