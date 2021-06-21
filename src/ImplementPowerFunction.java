public class ImplementPowerFunction {
    public static void main(String[] args) {
        int x = 4;
        int n = 10;
        int d = 3;
        System.out.println(power(x, n ,d));
    }
    static int power(int x, int n, int d) {
        long ans;
        if(x==0) return 0;
        if(n==0) return 1;
        if(x<0) return power(d+x, n, d);

        long temp = power(x, n/2, d);
        if(n%2==0)
            ans = ((temp%d)*(temp%d))%d;
        else
            ans = ((((x%d) * (temp%d))%d * (temp%d))%d);
        return (int)ans%d;
    }
}
