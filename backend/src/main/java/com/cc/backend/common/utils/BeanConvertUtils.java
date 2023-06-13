package com.cc.backend.common.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class BeanConvertUtils {

    /**
     * 将原始List中的元素转换成目标类型，并返回目标类型的List
     *
     * @param sourceList  原始List
     * @param targetClass 目标类型的Class
     * @param <T>         目标类型
     * @return 目标类型的List
     */
    public static <T> List<T> convertList(List<?> sourceList, Class<T> targetClass) {
        List<T> targetList = new ArrayList<>();
        for (Object source : sourceList) {
            T target;
            try {
                target = targetClass.newInstance();
                BeanUtils.copyProperties(target, source);
                targetList.add(target);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return targetList;
    }

    /**
     * 将原始类型的Bean转换成目标类型的Bean，并返回目标类型的Bean
     *
     * @param source      原始类型的Bean
     * @param targetClass 目标类型的Class
     * @param <T>         目标类型
     * @return 目标类型的Bean
     */
    public static <T> T convertBean(Object source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
            BeanUtils.copyProperties(source,target );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }

    public static Object convertBean(Object source, Object target) {
        try {
            BeanUtils.copyProperties(source,target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }
}