package com.sgy.bookstore.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring容器上下文工具类，用于获取当前的Spring容器
 * 该类被Spring容器管理，自动调用setApplicationContext方法获取Spring容器对象
 */
public class GetExampleUtil implements ApplicationContextAware {

    public static ApplicationContext application;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }

    /**
     * 根据类型获得bean
     * @param clazz 获取类型
     * @param <T>
     * @return 指定类型bean对象
     */
    public static <T> T getBean(Class<T> clazz){
        return application.getBean(clazz);
    }

    /**
     * 根据名称获取bean
     * @param name 名称
     * @return bean对象
     */
    public static Object getBean(String name){
        return application.getBean(name);
    }
}
