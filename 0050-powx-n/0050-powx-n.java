class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        double pow = n;

        if(n < 0) {
            pow = pow * -1;
        }

        while(pow > 0) {
            if(pow % 2 != 0) {
                pow = pow - 1;
                ans = ans * x;
            } else {
                pow = pow / 2;
                x = x * x;
            }
        }

        if(n < 0) {
            return 1 / ans * 1.0;
        }

        return ans * 1.0;
    }
}