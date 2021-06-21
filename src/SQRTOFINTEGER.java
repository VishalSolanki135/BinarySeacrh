public class SQRTOFINTEGER {
    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(mySqrt(x));
    }
    static int mySqrt(int x) {
        if(x==0 || x==1) {
            return x;
        }
        long start = 1, end = Math.min(x/2, 46340), ans = 0;
        while(start<=end) {
            int mid = (int)(start + (end-start)/2);

            if(mid*mid == x) {
                return mid;
            }
            if(mid*mid < x) {
                start = mid+1;
                ans = mid;
            } else {
                end = mid -1;
            }
        }
        return (int)ans;
    }
}
