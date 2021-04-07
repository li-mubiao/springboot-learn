package com.dubbo.consumer;

import com.dubbo.provider.NacosDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-27 17:16
 */
@Service
public class NacosDubboConsumer {

    @DubboReference(version = "1.0.0", check = false)
    private NacosDubboService nacosDubboService;

    public void say(String name){
        nacosDubboService.say(name);
    }

}