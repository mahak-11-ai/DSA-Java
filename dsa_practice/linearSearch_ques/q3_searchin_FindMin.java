package dsa_practice.linearSearch_ques;

public class q3_searchin_FindMin {
    public static void main(String[] args) {
        int [] arr={1112,34,6,7,3};
        System.out.println(min(arr));
    }
    static int min(int [] arr){
        int ans=arr[0];
        for(int i=1;i<arr.length;i++){
            if(ans>arr[i]){
                ans=arr[i];
            }
        }
        return ans;
    }
}
