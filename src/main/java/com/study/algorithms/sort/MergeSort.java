package com.study.algorithms.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * @program: fourth
 * @className: ShellSort
 * @description: 希尔排序
 * @author: kukuxiahuni
 * @create: 2019-04-09 09:20
 * @version: v1.0
 **/
public class MergeSort<T extends Comparable<T>> extends BaseSort {

    @Override
    public void sort(Comparable[] array) {

        if (Objects.isNull(array) || array.length == 0) {
            return;
        }

        mergeSort(array, 0, array.length - 1);


    }

    public final void mergeSort(Comparable[] array, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = lo + ((hi - lo) >>> 1);

        mergeSort(array, lo, mid);
        mergeSort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    /**
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: kukuxiahuni
     * @date: 2019/4/17 3:02 PM
     * @modify_auther: kukuxiahuni
     * @modify_time: 2019/4/17 3:02 PM
     **/
    private final void merge(Comparable[] a, int lo, int mid, int hi) {

        int len = hi - lo + 1;
        int i = lo;
        int j = mid + 1;

//        for (int k = lo; k <= hi; ++k) {
//
//            if (i > mid) {
//                a[k] = tmp[j++];
//            } else if (j > hi) {
//                a[k] = tmp[i++];
//            } else if (less(a[i], a[j])) {
//                a[k] = tmp[i++];
//            } else {
//                a[k] = tmp[j++];
//            }
//
//        }

        Comparable[] tmp = new Comparable[len];
        int index = 0;
        while (i <= mid && j <= hi) {
            if (less(a[i], a[j])) {
                tmp[index++] = a[i++];
            } else {
                tmp[index++] = a[j++];
            }
        }

        while (i <= mid) {
            tmp[index++] = a[i++];
        }

        while (j <= hi) {
            tmp[index++] = a[j++];
        }
        //拷回去
        index = 0;
        for (i = lo; i <= hi; i++) {
            a[i] = tmp[index++];
        }

    }

    public static void main(String[] args) {
        MergeSort<Integer> selectSort = new MergeSort<>();

        Integer[] arrays = {-1, -2, 4, -5};
        selectSort.sort(arrays);

        selectSort.show(arrays);
    }

}
