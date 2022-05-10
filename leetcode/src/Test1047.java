public class Test1047 {
   static class Solution {
        public String removeDuplicates(String s) {
            char[] ch = s.toCharArray();
            int fast = 0;
            int slow = 0;
            while(fast < s.length()){
                // 直接用fast指针覆盖slow指针的值
                ch[slow] = ch[fast];
                // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
                if(slow > 0 && ch[slow] == ch[slow - 1]){
                    slow--;
                }else{
                    slow++;
                }
                fast++;
                System.out.println(ch);
            }
            return new String(ch,0,slow);
        }
    }

    public static void main(String[] args) {
        String str = "abbaca";
        new Solution().removeDuplicates(str);
    }
}
