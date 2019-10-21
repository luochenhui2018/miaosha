package com.example.lchms.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//组件，让配置文件扫描进来
@Component
//springboot读取配置文件
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;         //秒
    private String password;
    private int poolMaxTotal;
    private int poolMaxdle;
    private int poolMaxWait;     //秒
}
