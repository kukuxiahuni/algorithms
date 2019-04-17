package com.study.algorithms.sort;

import java.util.Objects;

/**
 * @program: fourth
 * @className: ShellSort
 * @description: 希尔排序
 * @author: kukuxiahuni
 * @create: 2019-04-09 09:20
 * @version: v1.0
 **/
public class ShellSort<T extends Comparable<T>> extends BaseSort {

    @Override
    public void sort(Comparable[] array) {

        if (Objects.isNull(array) || array.length == 0) {
            return;
        }

        int n = array.length;
        int gap = 1;
        //计算gap的值
        while (gap < n / 3) {
            gap = gap * 3 + 1;
        }

        while (gap >= 1) {

            for (int i = gap; i < n; ++i) {

                for (int j = i; j >= gap; j = j - gap) {
                    if (less(array[j], array[j - gap])) {
                        swap(array, j, j - gap);
                    }
                }

            }

            gap = gap / 3;

        }
    }

    public static void main(String[] args) {
        ShellSort<Integer> selectSort = new ShellSort<>();

        Integer[] arrays = {-1,-2,4, -5};
        selectSort.sort(arrays);

        selectSort.show(arrays);
    }

}
