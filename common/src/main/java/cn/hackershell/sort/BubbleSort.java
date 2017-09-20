package cn.hackershell.tire.sort;

/**
 * Created by shangwen on 2017/9/11.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,6,-1,0,6,8,9};
        array = new BubbleSort().sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1 ; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
