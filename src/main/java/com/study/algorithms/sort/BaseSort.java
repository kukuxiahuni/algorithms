package com.study.algorithms.sort;

/**
 * @program: fourth
 * @className: BaseSort
 * @description: TODO
 * @author: kukuxiahuni
 * @create: 2019-04-09 09:23
 * @version: v1.0
 **/
public abstract class BaseSort<T extends Comparable<T>> {

    public abstract void sort(T[] array);

    /**
     * @param v
     * @param w
     * @return: v < w: true; v >= w : false
     * @see #sort(Comparable[])
     * 判断大小
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    protected void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 展示
     *
     * @param a
     */
    protected void show(T[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    /**
     * 判定是否排序
     *
     * @param a
     * @return
     */
    protected boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;

    }


}
