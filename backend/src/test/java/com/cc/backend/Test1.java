package com.cc.backend;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 通过查阅资料得知，这是因为在启动单元测试时，SpringBootTest不会启动服务器，
 * WebSocket自然也就没有启动，但是在代码里又配置了WebSocket，就会出错
 * 解决方式：在SprintBootTest里加上一段配置，指定一个Web环境，值为随机端口。
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void test1() throws InterruptedException, JSONException {
        ArrayList<Object> list = new ArrayList<>();
        list.add("ID:dhsakjdh");
        list.add(12);

        if (StrUtil.toString(list.get(0)).contains("ID:")) {
            System.out.println("true");
        }

    }

    @Test
    void test2() throws InterruptedException, JSONException {
        List<List<Object>> outerList = new ArrayList<>();

        List<Object> innerList1 = new ArrayList<>();

        List<Object> coordinates1 = new ArrayList<>();
        List<List<Double>> rectangle1 = new ArrayList<>();
        rectangle1.add(Arrays.asList(212.0, 1898.0));
        rectangle1.add(Arrays.asList(470.0, 1898.0));
        rectangle1.add(Arrays.asList(470.0, 1955.0));
        rectangle1.add(Arrays.asList(376.0, 1955.0));
        coordinates1.add(rectangle1);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence1 = Arrays.asList("15:10 ", 0.9999700784683228);
        coordinates1.add(labelAndConfidence1);
        innerList1.add(coordinates1);


        List<Object> coordinates2 = new ArrayList<>();
        List<List<Double>> rectangle2 = new ArrayList<>();
        rectangle2.add(Arrays.asList(212.0, 1898.0));
        rectangle2.add(Arrays.asList(470.0, 1898.0));
        rectangle2.add(Arrays.asList(470.0, 1955.0));
        rectangle2.add(Arrays.asList(376.0, 1955.0));
        coordinates2.add(rectangle2);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence2 = Arrays.asList("46l 四51", 0.9999700784683228);
        coordinates2.add(labelAndConfidence2);
        innerList1.add(coordinates2);


        List<Object> coordinates3 = new ArrayList<>();
        List<List<Double>> rectangle3 = new ArrayList<>();
        rectangle3.add(Arrays.asList(212.0, 1898.0));
        rectangle3.add(Arrays.asList(470.0, 1898.0));
        rectangle3.add(Arrays.asList(470.0, 1955.0));
        rectangle3.add(Arrays.asList(376.0, 1955.0));
        coordinates3.add(rectangle3);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence3 = Arrays.asList("ID:105089382", 0.9999700784683228);
        coordinates3.add(labelAndConfidence3);
        innerList1.add(coordinates3);


        List<Object> coordinates4 = new ArrayList<>();
        List<List<Double>> rectangle4 = new ArrayList<>();
        rectangle4.add(Arrays.asList(212.0, 1898.0));
        rectangle4.add(Arrays.asList(470.0, 1898.0));
        rectangle4.add(Arrays.asList(470.0, 1955.0));
        rectangle4.add(Arrays.asList(376.0, 1955.0));
        coordinates4.add(rectangle4);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence4 = Arrays.asList("复制", 0.9999700784683228);
        coordinates4.add(labelAndConfidence4);
        innerList1.add(coordinates4);


        List<Object> coordinates5 = new ArrayList<>();
        List<List<Double>> rectangle5 = new ArrayList<>();
        rectangle5.add(Arrays.asList(212.0, 1898.0));
        rectangle5.add(Arrays.asList(470.0, 1898.0));
        rectangle5.add(Arrays.asList(470.0, 1955.0));
        rectangle5.add(Arrays.asList(376.0, 1955.0));
        coordinates5.add(rectangle5);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence5 = Arrays.asList("战队名称：", 0.9999700784683228);
        coordinates5.add(labelAndConfidence5);
        innerList1.add(coordinates5);


        List<Object> coordinates6 = new ArrayList<>();
        List<List<Double>> rectangle6 = new ArrayList<>();
        rectangle6.add(Arrays.asList(212.0, 1898.0));
        rectangle6.add(Arrays.asList(470.0, 1898.0));
        rectangle6.add(Arrays.asList(470.0, 1955.0));
        rectangle6.add(Arrays.asList(376.0, 1955.0));
        coordinates6.add(rectangle6);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence6 = Arrays.asList("其他", 0.9999700784683228);
        coordinates6.add(labelAndConfidence6);
        innerList1.add(coordinates6);


        List<Object> coordinates7 = new ArrayList<>();
        List<List<Double>> rectangle7 = new ArrayList<>();
        rectangle7.add(Arrays.asList(212.0, 1898.0));
        rectangle7.add(Arrays.asList(470.0, 1898.0));
        rectangle7.add(Arrays.asList(470.0, 1955.0));
        rectangle7.add(Arrays.asList(376.0, 1955.0));
        coordinates7.add(rectangle7);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence7 = Arrays.asList("个人身份：", 0.9999700784683228);
        coordinates7.add(labelAndConfidence7);
        innerList1.add(coordinates7);


        List<Object> coordinates8 = new ArrayList<>();
        List<List<Double>> rectangle8 = new ArrayList<>();
        rectangle8.add(Arrays.asList(212.0, 1898.0));
        rectangle8.add(Arrays.asList(470.0, 1898.0));
        rectangle8.add(Arrays.asList(470.0, 1955.0));
        rectangle8.add(Arrays.asList(376.0, 1955.0));
        coordinates8.add(rectangle8);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence8 = Arrays.asList("非从业", 0.9999700784683228);
        coordinates8.add(labelAndConfidence8);
        innerList1.add(coordinates8);


        List<Object> coordinates9 = new ArrayList<>();
        List<List<Double>> rectangle9 = new ArrayList<>();
        rectangle9.add(Arrays.asList(212.0, 1898.0));
        rectangle9.add(Arrays.asList(470.0, 1898.0));
        rectangle9.add(Arrays.asList(470.0, 1955.0));
        rectangle9.add(Arrays.asList(376.0, 1955.0));
        coordinates9.add(rectangle9);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence9 = Arrays.asList("非从业", 0.9999700784683228);
        coordinates9.add(labelAndConfidence9);
        innerList1.add(coordinates9);


        List<Object> coordinates10 = new ArrayList<>();
        List<List<Double>> rectangle10 = new ArrayList<>();
        rectangle10.add(Arrays.asList(212.0, 1898.0));
        rectangle10.add(Arrays.asList(470.0, 1898.0));
        rectangle10.add(Arrays.asList(470.0, 1955.0));
        rectangle10.add(Arrays.asList(376.0, 1955.0));
        coordinates10.add(rectangle10);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence10 = Arrays.asList("学历：", 0.9999700784683228);
        coordinates10.add(labelAndConfidence10);
        innerList1.add(coordinates10);


        List<Object> coordinates11 = new ArrayList<>();
        List<List<Double>> rectangle11 = new ArrayList<>();
        rectangle11.add(Arrays.asList(212.0, 1898.0));
        rectangle11.add(Arrays.asList(470.0, 1898.0));
        rectangle11.add(Arrays.asList(470.0, 1955.0));
        rectangle11.add(Arrays.asList(376.0, 1955.0));
        coordinates11.add(rectangle11);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence11 = Arrays.asList("大专及本科", 0.9999700784683228);
        coordinates11.add(labelAndConfidence11);
        innerList1.add(coordinates11);


        List<Object> coordinates12 = new ArrayList<>();
        List<List<Double>> rectangle12 = new ArrayList<>();
        rectangle12.add(Arrays.asList(376.0, 1898.0));
        rectangle12.add(Arrays.asList(470.0, 1898.0));
        rectangle12.add(Arrays.asList(470.0, 1955.0));
        rectangle12.add(Arrays.asList(376.0, 1955.0));
        coordinates12.add(rectangle12);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence12 = Arrays.asList("投资年限：", 0.9999700784683228);
        coordinates12.add(labelAndConfidence12);
        innerList1.add(coordinates12);


        List<Object> coordinates13 = new ArrayList<>();
        List<List<Double>> rectangle13 = new ArrayList<>();
        rectangle13.add(Arrays.asList(376.0, 1898.0));
        rectangle13.add(Arrays.asList(470.0, 1898.0));
        rectangle13.add(Arrays.asList(470.0, 1955.0));
        rectangle13.add(Arrays.asList(376.0, 1955.0));
        coordinates12.add(rectangle13);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence13 = Arrays.asList("5到10年", 0.9999700784683228);
        coordinates13.add(labelAndConfidence13);
        innerList1.add(coordinates13);


        List<Object> coordinates14 = new ArrayList<>();
        List<List<Double>> rectangle14 = new ArrayList<>();
        rectangle14.add(Arrays.asList(376.0, 1898.0));
        rectangle14.add(Arrays.asList(470.0, 1898.0));
        rectangle14.add(Arrays.asList(470.0, 1955.0));
        rectangle14.add(Arrays.asList(376.0, 1955.0));
        coordinates14.add(rectangle14);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence14 = Arrays.asList("就业状态：", 0.9999700784683228);
        coordinates14.add(labelAndConfidence14);
        innerList1.add(coordinates14);

        List<Object> coordinates15 = new ArrayList<>();
        List<List<Double>> rectangle15 = new ArrayList<>();
        rectangle15.add(Arrays.asList(376.0, 1898.0));
        rectangle15.add(Arrays.asList(470.0, 1898.0));
        rectangle15.add(Arrays.asList(470.0, 1955.0));
        rectangle15.add(Arrays.asList(376.0, 1955.0));
        coordinates15.add(rectangle15);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence15 = Arrays.asList("在职", 0.9999700784683228);
        coordinates15.add(labelAndConfidence15);
        innerList1.add(coordinates15);


        List<Object> coordinates16 = new ArrayList<>();
        List<List<Double>> rectangle16 = new ArrayList<>();
        rectangle16.add(Arrays.asList(376.0, 1898.0));
        rectangle16.add(Arrays.asList(470.0, 1898.0));
        rectangle16.add(Arrays.asList(470.0, 1955.0));
        rectangle16.add(Arrays.asList(376.0, 1955.0));
        coordinates16.add(rectangle16);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence16 = Arrays.asList("个人金融资产：", 0.9999700784683228);
        coordinates16.add(labelAndConfidence16);
        innerList1.add(coordinates16);


        List<Object> coordinates17 = new ArrayList<>();
        List<List<Double>> rectangle17 = new ArrayList<>();
        rectangle17.add(Arrays.asList(376.0, 1898.0));
        rectangle17.add(Arrays.asList(470.0, 1898.0));
        rectangle17.add(Arrays.asList(470.0, 1955.0));
        rectangle17.add(Arrays.asList(376.0, 1955.0));
        coordinates17.add(rectangle17);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence17 = Arrays.asList("[0,50]万", 0.9999700784683228);
        coordinates17.add(labelAndConfidence17);
        innerList1.add(coordinates17);


        List<Object> coordinates18 = new ArrayList<>();
        List<List<Double>> rectangle18 = new ArrayList<>();
        rectangle18.add(Arrays.asList(376.0, 1898.0));
        rectangle18.add(Arrays.asList(470.0, 1898.0));
        rectangle18.add(Arrays.asList(470.0, 1955.0));
        rectangle18.add(Arrays.asList(376.0, 1955.0));
        coordinates18.add(rectangle18);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence18 = Arrays.asList("年龄：", 0.9999700784683228);
        coordinates18.add(labelAndConfidence18);
        innerList1.add(coordinates18);


        List<Object> coordinates19 = new ArrayList<>();
        List<List<Double>> rectangle19 = new ArrayList<>();
        rectangle19.add(Arrays.asList(376.0, 1898.0));
        rectangle19.add(Arrays.asList(470.0, 1898.0));
        rectangle19.add(Arrays.asList(470.0, 1955.0));
        rectangle19.add(Arrays.asList(376.0, 1955.0));
        coordinates19.add(rectangle19);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence19 = Arrays.asList("29", 0.9999700784683228);
        coordinates19.add(labelAndConfidence19);
        innerList1.add(coordinates19);


        List<Object> coordinates20 = new ArrayList<>();
        List<List<Double>> rectangle20 = new ArrayList<>();
        rectangle20.add(Arrays.asList(376.0, 1898.0));
        rectangle20.add(Arrays.asList(470.0, 1898.0));
        rectangle20.add(Arrays.asList(470.0, 1955.0));
        rectangle20.add(Arrays.asList(376.0, 1955.0));
        coordinates20.add(rectangle20);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence20 = Arrays.asList("性别：", 0.9999700784683228);
        coordinates20.add(labelAndConfidence20);
        innerList1.add(coordinates20);


        List<Object> coordinates21 = new ArrayList<>();
        List<List<Double>> rectangle21 = new ArrayList<>();
        rectangle21.add(Arrays.asList(376.0, 1898.0));
        rectangle21.add(Arrays.asList(470.0, 1898.0));
        rectangle21.add(Arrays.asList(470.0, 1955.0));
        rectangle21.add(Arrays.asList(376.0, 1955.0));
        coordinates21.add(rectangle21);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence21 = Arrays.asList("男", 0.9999700784683228);
        coordinates21.add(labelAndConfidence21);
        innerList1.add(coordinates21);


        List<Object> coordinates22 = new ArrayList<>();
        List<List<Double>> rectangle22 = new ArrayList<>();
        rectangle22.add(Arrays.asList(376.0, 1898.0));
        rectangle22.add(Arrays.asList(470.0, 1898.0));
        rectangle22.add(Arrays.asList(470.0, 1955.0));
        rectangle22.add(Arrays.asList(376.0, 1955.0));
        coordinates22.add(rectangle22);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence22 = Arrays.asList("当前定位：", 0.9999700784683228);
        coordinates22.add(labelAndConfidence22);
        innerList1.add(coordinates22);


        List<Object> coordinates23 = new ArrayList<>();
        List<List<Double>> rectangle23 = new ArrayList<>();
        rectangle23.add(Arrays.asList(376.0, 1898.0));
        rectangle23.add(Arrays.asList(470.0, 1898.0));
        rectangle23.add(Arrays.asList(470.0, 1955.0));
        rectangle23.add(Arrays.asList(376.0, 1955.0));
        coordinates23.add(rectangle23);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence23 = Arrays.asList("其他", 0.9999700784683228);
        coordinates23.add(labelAndConfidence23);
        innerList1.add(coordinates23);


        outerList.add(innerList1);

        System.out.println(outerList.toString());
    }


    @Test
    void test3() {

        List<List<Object>> outerList = new ArrayList<>();

        List<Object> innerList1 = new ArrayList<>();

        List<Object> coordinates1 = new ArrayList<>();
        List<List<Double>> rectangle1 = new ArrayList<>();
        rectangle1.add(Arrays.asList(212.0, 1898.0));
        rectangle1.add(Arrays.asList(470.0, 1898.0));
        rectangle1.add(Arrays.asList(470.0, 1955.0));
        rectangle1.add(Arrays.asList(376.0, 1955.0));
        coordinates1.add(rectangle1);
        // 字符串和其他数值部分
        List<Object> labelAndConfidence1 = Arrays.asList("15:10 ", 0.9999700784683228);
        coordinates1.add(labelAndConfidence1);
        innerList1.add(coordinates1);

        outerList.add(innerList1);

        System.out.println(outerList.toString());
    }
}
