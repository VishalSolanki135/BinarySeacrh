import java.util.ArrayList;

public class PaintersPartition {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
//        a.add(1000000);
        System.out.println((paintersPartition(a, 1, 2))%10000003);
    }

    //n is length of array and m is number of painters
    static int paintersPartition(ArrayList<Integer> boards, int time , int m) {
        return (int)((partition(boards, boards.size(), m) * (long)time) % 10000003);
    }

    static long partition(ArrayList<Integer> boards, int n, int m) {
        long totalLength = 0, k = 0;
        for (int i = 0; i < n; i++) {
            k = Math.max(k, boards.get(i));
            totalLength+=boards.get(i);
        }

        long low = k, high = totalLength;
        while(low<high) {
            long mid = (low+high)/2;
            int painters = isFeasible(boards, n, mid);
            if(painters<=m) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    static int isFeasible(ArrayList<Integer> boards, int n, long limit) {
        int sum = 0, numP = 1;
        for (int i = 0; i < n; i++) {
            sum+=boards.get(i);
            if(sum>limit) {
                sum = boards.get(i);
                numP++;
            }
        }
        return numP;
    }
}
