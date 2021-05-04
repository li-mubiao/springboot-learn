package com.lmb.hello.sort;

import java.util.Arrays;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-25 10:02
 */
public class SortTest {

    /**
     * 冒泡排序
     * *算法描述:
     * <p>
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * <p>
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * <p>
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * <p>
     * 重复步骤1~3，直到排序完成。
     * var arr = [6, 5, 4, 3, 2, 1];
     */

    public static void sort1(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     * <p>
     * 初始状态：无序区为R[1..n]，有序区为空；
     * <p>
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * <p>
     * n-1趟结束，数组有序化了。
     *
     * @param arr
     */
    public static void sort2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                index = arr[j] < arr[index] ? j : index;
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

    }

    /**
     * 插入排序
     * *算法描述:
     * <p>
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序；
     * <p>
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * <p>
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * <p>
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * <p>
     * 将新元素插入到该位置后；
     * <p>
     * 重复步骤2~5。
     *
     * @param
     */
    public static void sort3(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int tmp = arr[i];
            int j = i;

            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = tmp;
            }
        }

    }

    /**
     * 快速排序
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * <p>
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * <p>
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * @param arr
     */
    public static void sort4(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            sort4(arr, left, partitionIndex - 1);
            sort4(arr, partitionIndex + 1, right);
        }


    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot =left;
        int index = pivot+1;
        for (int i = index; i <= right; i++) {
            if(arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }

        }
        swap(arr,pivot,index-1);
        return index-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {30, 1, 3, 4, 25, 6, 7, 8, 12};
        sort4(arr,0,arr.length-1);
//        sort2(arr);
//        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

}