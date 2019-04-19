package com.study.algorithms.sort;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

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
        mergeH(array, lo, mid, hi);
    }

    private final void mergeH(Comparable[] a, int lo, int mid, int hi) {
        int len = hi - lo + 1;
        int i = lo;
        int j = mid + 1;

        Comparable[] tmp = new Comparable[a.length];
        for (int k = lo; k <= hi; ++k) {
            tmp[k] = a[k];
        }

        for (int index = lo; index <= hi; ++index) {

            //1. 左半区用完了
            if (i > mid) {
                a[index] = tmp[j++];
            } else if (j > hi) {
                a[index] = tmp[i++];
            } else if (less(tmp[i], tmp[j])) {
                a[index] = tmp[i++];
            } else {
                a[index] = tmp[j++];
            }

        }


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
////
        selectSort.show(arrays);

//        selectSort.mergeH(arrays, 0, 2, arrays.length - 2);
    }

}
