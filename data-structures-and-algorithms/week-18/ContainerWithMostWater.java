class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;

        int answer = 0;
        while(i<j){
            // we fixed pillas i and j - now, we want to know how much water
            // we can fill in between them 

            // width between pillars i and j.
            // let's call it 'w' for 'width'

            int w = j-i;

            // This is, at most,how much water can be filled vertically
            // at this any point between i and j, so that it doesn't
            // spill over to the left of pillar i or to the right of pillar j.
            // Let's call it 'h' for 'height'

            // We will call the lower pillar the 'limiting factor'.

            int h = Math.min(height[i], height[j]);

            //The total volume of water that can be filled between pillars i and j
            //Let's call it 'v' for 'volume'.

            int v = w * h;

            // Update the answer.
            answer = Math.max(answer,v);

            if (height[i]<height[j]){
                // If pillar i is the 'limiting factor',
                // then let's move i to (i+1) in hopes that
                // it will improve our answer.
                i++; 
            }else {
                //Otherwise let's move j to (j-1) in hopes that 
                //it will improve our answer.
                j--;
            }

        
        }

        return answer;
    
        
    }
}
