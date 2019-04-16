package com.study.algorithms.sort;

import java.util.Objects;

/**
 * @program: fourth
 * @className: SelectSort
 * @description: 简单插入排序
 * 1. 核心在于进行数据交换
 * 2. swap(j-1, j)
 * @author: kukuxiahuni
 * @create: 2019-04-09 09:20
 * @version: v1.0
 **/
public class InsertSort<T extends Comparable<T>> extends BaseSort {

    @Override
    public void sort(Comparable[] array) {

        if (Objects.isNull(array) || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (less(array[j], array[j - 1])) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertSort<Integer> selectSort = new InsertSort<>();

        Integer[] arrays = {1, 4, 2, 8, 7, 0};
        selectSort.sort(arrays);

        selectSort.show(arrays);
    }

}
