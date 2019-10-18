package com.zhangxiaobin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.List;

/**
 * @author zhangxiaobin
 * @title: RedisHelper
 * @description: TODO
 * @date 2019/10/1719:39
 */
@Service
@Slf4j
public class RedisHelper {


    @Autowired
    private JedisPool jedisPool;

    public void scan2del(String pattern,Integer count) {
        Jedis jedis = jedisPool.getResource();
//        List<String> list = new ArrayList<>();
        ScanParams params = new ScanParams();
        params.match(pattern);
        params.count(count);
        String cursor = "0";
        while (true) {
            ScanResult scanResult = jedis.scan(cursor,params);
            List<String> elements = scanResult.getResult();
            if (elements != null && elements.size() > 0) {
//                list.addAll(elements);
                for (String key : elements) {
                    log.info("key = {}",key);
                    jedis.del(key);
                }

            }
            cursor = scanResult.getStringCursor();
            log.info("ing ... cursor = {} ， elements = {} ",cursor , elements.size());
            if ("0".equals(cursor)) {
                log.info("finish 0 ...... ");
                break;
            }
        }
        log.info("finish ...... ");
    }

}
