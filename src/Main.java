public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 6, 7};
        int l = 0;
        int r = arr.length-1;
        int x = 5;
        System.out.println(binarySearch(arr, l, r, x));
    }

    static int binarySearch(int[] arr, int l, int r, int x) {
        if(r>=l){
            int mid = l + (r-l)/2;

            if(arr[mid]==x) {
                return mid;
            }

            if(arr[mid] > x) {
                return binarySearch(arr, l, mid-1, x);
            }
            return binarySearch(arr, mid+1, r, x);
        }
        return -1;
    }
}
