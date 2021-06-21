import java.util.ArrayList;

public class AllopcateBooks {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(17);
        A.add(100);
        A.add(11);

        System.out.println(books(A, 4));
    }

    static int books(ArrayList<Integer> A, int B) {
        long sum = 0;
        if(A.size() < B) {
            return -1;
        }

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
        }

        long low = 0, high = sum, ans = Integer.MAX_VALUE;
        while(low<=high) {
            long mid = (low+high)/2;
            if(isPossible(A, mid, B)) {
                ans = Math.min(ans, mid);
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return (int)ans;
    }

    static boolean isPossible(ArrayList<Integer> A, long limit, int B){
        int students = 1, sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i) > limit){
                return false;
            }
            if(sum+A.get(i) > limit) {
                students++;
                sum = A.get(i);
                if(students>B) {
                    return false;
                }
            } else {
                sum += A.get(i);
            }
        }
        return true;
    }
}
