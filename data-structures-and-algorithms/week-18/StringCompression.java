class Solution {
    public int compress(char[] chars) {
        int n=chars.length;

        int streakStart = 0;
        int indexAnswer = 0;

        while (streakStart<n){
            //Current streak starts with chars[streakStart]
            char streakChar = chars[streakStart]

            //Count how many consecutive streak-chars there are in this streak
            //streakStart and streaEnd are the two pointers. This is a common technique.
            int streakEnd = streakStart;
            int count = 1;
            while (streakEnd+1<n && chars[streakEnd+1] == streakChar){
                streakEnd ++;
                count ++;
            }

            //if count == 1 -> then we should write in 'chars' just the streakChar
            //else -> we should write in 'chars' the streakChar followed by the innteger 'count' as characters
            chars[indexAnswer] = streakChar;
            indexAnswer++;

            if (count>0){
                char[] countAsChars = Integer.toString(count).toCharArray();
                for (char digit : countAsChars) {
                    chars[indexAnswer] = digit;
                    indexAnswer++;
            }
        }

        streakStart = streakEnd + 1;
    }
    return indexAnswer;
}
