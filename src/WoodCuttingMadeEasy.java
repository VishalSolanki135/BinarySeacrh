import java.util.ArrayList;
import java.util.Arrays;

public class WoodCuttingMadeEasy {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(20);
        A.add(15);
        A.add(10);
        A.add(17);

        int B = 7;
        System.out.println(solve(A, B));
    }
    public static int solve(ArrayList<Integer> A, int B) {
        int start = 0;
        int end = 0;
        for(Integer i : A) {
            if(i > end) {
                end = i;
            }
        }
        int res = -1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(canCut(A, B, mid)) {
                res = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return res;
    }

    static boolean canCut(ArrayList<Integer> A, int B, int currentHeight) {
        long total = 0;
        for(int a: A) {
            total += a > currentHeight ? a-currentHeight : 0;
        }
        return total >=B;
    }
}
