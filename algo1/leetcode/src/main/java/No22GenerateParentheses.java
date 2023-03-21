import java.util.ArrayList;
import java.util.List;

public class No22GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<String>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        /*
            递归枚举每一种情况

                (     )
                /\   /\
               (  ) (  )
               /\
              (
         */
        public void generateAll(char[] current, int pos, List<String> result) {
            // 每个结果的长度必然是 n*2 == current.length
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                // 按括号定义先左括号
                current[pos] = '(';
                // 递归全部可能的结果
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        // 是否符合括号的定义
        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }
    }
}
