import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchInSortedArray1 {
    public static void main(String[] args) {
//        int[] arr = {9, 10, 11, 12, 14, 15, 17, 19, 24, 25, 30, 39, 40, 44, 46, 48, 51, 53, 54, 56, 59, 60, 69, 70, 73, 75, 80, 87, 88, 89, 92, 93, 97, 99, 104, 107, 109, 110, 111, 117, 123, 124, 125, 126, 127, 128, 135, 136, 137, 141, 148, 153, 154, 161, 166, 167, 169, 175, 177, 180, 181, 182, 185, 186, 189, 193, 198, 202, 1, 2, 6, 7};

        List<Integer> A =  new ArrayList<>();
        A.add(5);
        A.add(1);
        A.add(3);
//        A.add(133);
//        A.add(178);
        System.out.println(search(A, 3));
    }
    static int search(List<Integer> A, int target) {
        int low = 0, high = A.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;

            if (A.get(mid)==target) {
                return mid;
            }

            if(A.get(mid)>=A.get(low)) {
                if(target>=A.get(low) && target<A.get(mid)) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(target>A.get(mid) && target<=A.get(high)) {
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
