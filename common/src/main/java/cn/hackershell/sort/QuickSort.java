package cn.hackershell.tire.sort;

/**
 * Created by shangwen on 2017/9/11.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,6,-1,0,6,8,9};
        new QuickSort().sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return ;
        }
        int index = partition(arr, l, r);
        sort(arr, l, index - 1);
        sort(arr, index + 1, r);
    }

    private int partition(int[] array, int l, int r) {
        int key = array[l];
        while (l < r) {
            while (l < r && array[r] >= key) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] <= key) {
                l++;
            }
            array[r] = array[l];
        }
        array[r] = key;
        return r;
    }
}
