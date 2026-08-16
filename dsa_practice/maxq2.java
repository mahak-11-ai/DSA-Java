package dsa_practice;

public class maxq2 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,78};
        System.out.println(max(arr));
        System.out.println(maxRange(arr,3,4));
    }
    static int max(int[]arr){
        int maxVal=arr[0];
        if(arr.length==0){
            return -1;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxVal){
                maxVal=arr[i];
            }
        }
        return maxVal;
    }
    static int maxRange(int[]arr,int start,int end){
        int maxVal=arr[start];
        if(end<start){
                return-1;                 //edge casses
        }
        if(arr==null){     
            return -1;
        }

        for(int i=start+1;i<=end;i++){
            
            if(arr[i]>maxVal){
                maxVal=arr[i];
            }
        }
        return maxVal;

    }
}
