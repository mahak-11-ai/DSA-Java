/*Approach
Initialize a variable x = 0.
Traverse the operations array.
If the operation contains ++, increment x.
Otherwise, decrement x.
Return x.*/


class Solution {
    public int finalValueAfterOperations(String[] operations) {

        int x = 0;

        for (String op : operations) {
            if (op.contains("++")) {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}
