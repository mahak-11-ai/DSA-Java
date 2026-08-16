package dsa_practice;
import java.util.Arrays;

public class swapq1 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,78};
        swap(arr,2,5);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[]arr,int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
