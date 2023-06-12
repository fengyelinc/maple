package com.cc.backend;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@SpringBootTest
class BackendApplicationTests {


    @Test
    void test1() {
        int[] arr = new int[]{443, 21, 32, 656, 8781, 1, 232, 843, 2657, 213, 231, 353543, 5, 36, 3, 3};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            while (base <= array[j] && i < j) {
                j--;
            }
            while (base >= array[i] && i < j) {
                i++;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        array[left] = array[i];
        array[i] = base;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

    }

}
