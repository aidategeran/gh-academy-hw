class Solution {
    public boolean checkValidString(String s) {
        // left_stack    : []
        // asterisk_stack: [2, 3]
        // 01234
        // ((**)
        Stack<Integer> left_indices = new Stack<>();
        Stack<Integer> asterisk_indices = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left_indices.push(i);
            } else if (c == '*') {
                asterisk_indices.push(i);
            } else {
                if (!left_indices.isEmpty()) {
                    left_indices.pop();
                } else if (!asterisk_indices.isEmpty()) {
                    asterisk_indices.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left_indices.isEmpty()) {
            if (!asterisk_indices.isEmpty() &&
                left_indices.peek() < asterisk_indices.peek()) {
                left_indices.pop();
                asterisk_indices.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
 
---
 
class Solution {
    public boolean checkValidString(String s) {
        int low = 0; // lowest number of floating balloons possible so far 
        int high = 0; // highest number of floating ballons possible so far
        for (char c : s.toCharArray()) {
            if (c == '(') { // float a new balloon
                low++;
                high++;
            } else if (c == ')') { // burst a balloon
                low--;
                high--;
            } else { // c == '*'   -> we can either float a new balloon or burst
                low--;
                high++;
            }
            if (low < 0) {
                low = 0;
            }
            if (high < 0) { // no matter how much we tried to float new balloons, we failed
                return false;
            }
        }
        return low == 0; // if it's > 0, then it means no matter how many balloons we tried to burst, we failed
    }
}
