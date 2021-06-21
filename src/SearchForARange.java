import java.util.ArrayList;
import java.util.List;

public class SearchForARange {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(7);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(10);
        A.add(10);
        int B = 3;
        ArrayList<Integer> res = searchRange(A, B);
        for(Integer a: res) {
            System.out.println(a);
        }
    }

    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> res;
        if(A.size() == 1) {
            res = new ArrayList<>();
            res.add(0);
            res.add(0);
            return res;
        }
        res = new ArrayList<>();
        res.add(first(A, 0, A.size(), B, A.size()));
        res.add(last(A, 0, A.size(), B, A.size()));
        return res;
    }

    static int first(List<Integer> A, int l , int h, int x, int n) {
        if(h>=l) {
            int mid = l+(h-l)/2;
            if((mid == 0 || x>A.get(mid-1)) && A.get(mid)==x)
                return mid;
            else if(x > A.get(mid+1))
                return first(A, (mid+1), h, x, n);
            else
                return first(A, l, (mid-1), x, n);
        }
        return -1;
    }

    static int last(List<Integer> A, int l , int h, int x, int n) {
        if(h>=l) {
            int mid = l + (h-l)/2;
            if((mid==n-1 || x < A.get(mid+1)) && A.get(mid) == x)
                return mid;
            else if(x < A.get(mid)) {
                return last(A, l, (mid-1), x, n);
            }
            else
                return last(A, (mid+1), h, x, n);
        }
        return -1;
    }
}
