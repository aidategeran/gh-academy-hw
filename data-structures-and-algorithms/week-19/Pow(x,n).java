class Solution {
    public double myPow(double x, int n) {
        long exponent = (long)n;

        // negative n, x^n=(1/x)^(-n)
        // e.g. x^(-7)=(1/x)^(-7)

        if (exponent<0){
            exponent = -exponent;
            x = 1 / x;
        }
        return myPow_(x,exponent);


    }
    //T: O(Log n)
    //S: O (Log n)

    private double myPow_(double x, long exponent){
        if (exponent ==0) return 1;

        // even n, x^n = (x^2)^n/2 = x^(2*(n/2))
        // e.g. x^6 = (x^2)6/2=x^(2*3)

        //odd n, x^n = (x^2)^n/2*x = x^(2*(n/2))*x = x^(n-1)*x,
        //                                           because 2*(n/2) = n-1 for n/2 is floored,
        //                                           i.e. for odd n=7, n/2 will be 3 not 3.5
        // e.g. x^7 = (x^2)^3*x = x^(2*3)*x = x^6*x
        return (exponent %2 == 0) ? myPow_(x*x, exponent/2)
                                  : myPow_(x*x, exponent/2)*x;
    }                             



}
