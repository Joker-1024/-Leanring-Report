package cn.Sort;

import java.util.Arrays;

/**
 *冒泡排序:
 * 时间复杂度O(n^2),空间复杂度O(1);
 */
public class Code_BubbleSort {
    public static void BubbbleSort(int arr[]){
        if(arr==null||arr.length<2){
            return;
        }
        for (int end = arr.length-1;end>0;end--){
            for(int i= 0;i<end;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对数器制作部分
     */
    public static void RightMathod(int arr[]){
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int size,int value){
        int arr[] = new int[(int)((size+1)*Math.random())];
        for (int i= 0;i<arr.length;i++){
            arr[i] = (int)((value+1)*Math.random())-(int)(value*Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int arr[]){
        if (arr == null) {
            return null;
        }
        int res[] = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            res[i]=arr[i];
        }
        return res;
    }

    public static boolean isEqual(int arr1[],int arr2[]){
        if ((arr1==null&&arr2!=null)||(arr1!=null&&arr2==null)){
            return false;
        }
        if (arr1==null&&arr2==null){//要记清楚&&并且两边同时成立才可以执行；||或者，两边任意成立都执行
            return true;            //两边都为空的话返回true
        }
        if (arr1.length!=arr2.length){
            return false;
        }
        for (int i =0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArr(int arr[]){
        if(arr==null){
            return;
        }
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+"、");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int testTime = 10000;
        int size = 100;
        int value = 100;
        boolean success = true;
        for (int i= 0;i<testTime;i++){
                int [] arr1 = generateRandomArray(size,value);
                int [] arr2 = copyArray(arr1);
                int [] arr3 = copyArray(arr1);
            BubbbleSort(arr1);
            RightMathod(arr2);
            if(!isEqual(arr1,arr2)){
                success = false;
                printArr(arr3);
                break;           //这里为什么要用break？？
            }
        }
        System.out.println(success ? "Nice":"Fuking fucked");


//        int arr[] = generateRandomArray(size,value);
//        printArr(arr);
//        BubbbleSort(arr);
//        printArr(arr);

    }
}
