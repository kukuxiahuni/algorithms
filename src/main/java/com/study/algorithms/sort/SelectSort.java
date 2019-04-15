package com.study.algorithms.sort;

import java.nio.channels.SelectionKey;
import java.util.Objects;

/**
 * @program: fourth
 * @className: SelectSort
 * @description: 简单选择排序
 * @author: kukuxiahuni
 * @create: 2019-04-09 09:20
 * @version: v1.0
 **/
public class SelectSort<T extends Comparable<T>> extends BaseSort {

    @Override
    public void sort(Comparable[] array) {

        if (Objects.isNull(array) || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length; ++i) {
            int min = i;

            for (int j = i + 1; j < array.length; ++j) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }

            swap(array, i, min);

        }
    }

    public static void main(String[] args) {
        SelectSort<Integer> selectSort = new SelectSort<>();

        Integer[] arrays = {1, 4, 2, 8, 7};
        selectSort.sort(arrays);

        selectSort.show(arrays);
    }

}
