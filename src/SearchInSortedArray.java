import java.util.ArrayList;

public class SearchInSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(5);
        A.add(1);
//        A.add(109);
//        A.add(158);
//        A.add(164);
//        A.add(182);
//        A.add(187);
//        A.add(202);
//        A.add(205);
//        A.add(205);
//        A.add(2);
//        A.add(3);
//        A.add(32);
//        A.add(57);
//        A.add(69);
//        A.add(74);
//        A.add(81);
//        A.add(99);
//        A.add(100);
        System.out.println(search(A, 3));
    }

    static int search(ArrayList<Integer> A, int target) {
        int partition = findPivot(A, 0, A.size()-1);
        if(partition == -1) {
            return binarySearch(A, 0, A.size()-1, target);
        }

        if(A.get(partition) == target) {
            return partition;
        }
        if(A.get(0)<=partition) {
            return binarySearch(A, 0, partition-1, target);
        }
        return binarySearch(A, partition+1, A.size()-1, target);
    }

    static int findPivot(ArrayList<Integer> A, long low, long high){
        if(high < low) {
            return -1;
        }
        if(high==low) {
            return (int)low;
        }

        int mid = (int)(low+high)/2;
        if(mid<high&&A.get(mid)>A.get(mid+1)) {
            return mid;
        }
        if(mid>low&&A.get(mid)<A.get(mid-1)) {
            return mid-1;
        }
        if(A.get(mid) <= A.get((int)low)) {
            return findPivot(A, low, mid-1);
        }
        return findPivot(A, mid+1, high);
    }

    static int binarySearch(ArrayList<Integer> A, long low, long high, long key) {
        if(high<low) {
            return -1;
        }
        if(high==low) {
            return (int)low;
        }
        int mid = (int) (low + (high-low)/2);
        if(key==A.get(mid)) {
            return mid;
        }
        if(key>A.get(mid)) {
            return binarySearch(A, mid+1, high, key);
        }
        return binarySearch(A, low, mid-1, key);
    }
}
