import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr_1 = {148,662,358,75,520,3795};
        int[] arr_2 = new int[5];
        /*
        for each
         */
        double[] myList = {1.9, 2.9, 3.4, 3.5};
//        // 打印所有数组元素
//        for (double e: myList) {
//            System.out.println(e);
//        }
        for (int i = 0; i < arr_2.length ; i++) {
            System.out.println(arr_2[i]);
        }
    //打印总和
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("Max is " + max);
     //Array类，例：排序与查找
        Arrays.sort(arr_1);
        for(int element:arr_1)
        {
            System.out.println(element);
        }

     int result_1 = Arrays.binarySearch(arr_1,3795);
        System.out.println("result_1 = " + result_1);

        //比较
        int[] arr_3 = {1,2,3,4};
        int[] arr_4 = {1,2,3,4};
       boolean result_2 =  Arrays.equals(arr_3,arr_4);
        System.out.println("result_2 = " + result_2);
    }
    }

