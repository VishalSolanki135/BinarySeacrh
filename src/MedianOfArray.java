import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
//        a.add(7);
//        a.add(12);
//        a.add(14);
//        a.add(15);

        List<Integer> b = new ArrayList<>();
        b.add(20);
//        b.add(2);
//        b.add(3);
//        b.add(4);
//        b.add(9);
//        b.add(11);

        System.out.println(findMedianSortedArrays(a, b));
    }

    static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(b.size() < a.size()) return findMedianSortedArrays(b, a);
        int n1 = a.size();
        int n2 = b.size();

        int low = 0;
        int high = n1;

        while(low<=high) {
            int part1 = low + (high - low)/2;
            int part2 = (n1+n2+1)/2 - part1;

            int l1 = part1 == 0 ? Integer.MIN_VALUE : a.get(part1-1);
            int l2 = part2 == 0 ? Integer.MIN_VALUE : b.get(part2-1);

            int r1 = part1 == n1 ? Integer.MAX_VALUE : a.get(part1);
            int r2 = part2 == n2 ? Integer.MAX_VALUE : b.get(part2);

            if(l1<=r2 && l2<=r1) {
                if((n1+n2)%2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                else
                    return ((double)Math.max(l1, l2));
            } else if(l1>r2) {
                high = part1 - 1;
            } else {
                low = part1 + 1;
            }
        }
        return 0.0;
    }
}
