package com.jingang.springinterfacetest.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import java.io.IOException;
/**
 * @program: jg-api-autotest
 * @description: yaml配置文件加载工厂
 * @author: LiuGang
 * @create: 2020-06-02 13:43
 **/

    public class YamlPropertyLoaderFactory extends DefaultPropertySourceFactory {
        @Override
        public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {

            if (null == resource) {
                super.createPropertySource(name, resource);
            }
            return new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource()).get(0);
        }
    }

