class Solution {
    public int mySqrt(int x) {
        if (x==0 || x==1) return x;


        int left = 1;
        int right = x;
        int answer = -1;

        while (left <= right){
            int middle = left - (right+left)/2;
            if ((long)middle*middle > (long)x){
                right = middle-1;
            }else {
                answer = middle; 
                left=middle+1;
            }
        }
        return answer;
    }
        
}
