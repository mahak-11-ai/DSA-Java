package dsa_crt;

public class TwoDarr {
    static void matrix(int arr[][], int row){
        for( int i=0; i<row; i++){
            for(int j=0; j<3; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static void main(String [] args){
        int arr[][]={
            {1,2,3},
            {2,3,4},
        };
        matrix(arr, 2);
      
    }
    
}
