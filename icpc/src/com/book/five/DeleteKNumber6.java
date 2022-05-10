package com.book.five;

public class DeleteKNumber6 {
    /**
     * 删除整数的k个数字，获得删除后的最小值
     *
     * @param num 原整数
     * @param k   删除数量
     * @return
     */
    public static String removeDigits(String num, int k) {
        //新整数的最终长度=原整数长度-k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有数据
        char[] stack = new char[newLength];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的数字时，栈顶元素出栈，相当于删除数字
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //遍历到的元素进栈
            stack[top++] = c;
        }
        //找到栈中第1个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset<newLength&&stack[offset]=='0'){
            offset++;
        }
        return offset==newLength?"0":new String(stack,offset,newLength-offset);
    }

    public static void main(String[] args) {
        System.out.println(removeDigits("1234546",1));
        System.out.println(removeDigits("320006",2));
        System.out.println(removeDigits("6541111",3));
    }
}
