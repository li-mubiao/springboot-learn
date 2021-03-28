package com.dubbo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-27 16:28
 */
@DubboService(version = "1.0.0")
@Service
public class NacosDubboServiceImpl implements NacosDubboService{

    @Override
    public String say(String name) {
        System.out.println(name);
        return name;
    }
}