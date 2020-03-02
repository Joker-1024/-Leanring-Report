package cn.Sort;
import java.util.Arrays;

/**
 * 插入排序，时间复杂度O(n^2),空间复杂度为O(1),与选择，冒泡排序相同
 */
public class Code_InsertSort {
    public static void InsertSort(int [] arr){
        if (arr==null|| arr.length < 2){
            return;
        }
        for (int i = 1; i<arr.length; i++){
            for (int j = i-1; j>=0 && arr[j]>arr[j+1]; j--){ //j--是因为比较完当前的这个数，还要继续跟前面的数比较
                swap2(arr,j,j+1);                         //主意j>=0
            }
        }
    }

    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap2(int arr[],int i,int j){//新看到的一种交换的方法，书写速度比较快，方便
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 对数器练习
     * @param size
     * @param value
     * @return
     */
    public static int[] generateRandomArray(int size, int value){
        int arr[] = new int[(int)((size+1)*Math.random())];
        for (int i= 0;i<arr.length;i++){
            arr[i] = (int)((value+1)*Math.random())-(int)(value*Math.random());
        }
        return arr;
    }

    public static boolean isEqual(int arr1[],int arr2[]){
        if ((arr1==null&&arr2!=null)||(arr1!=null&&arr2==null)){
            return false;
        }
        if (arr1==null&&arr2==null){
            return true;
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

    public static int[] CopyArr(int[] arr){
        if(arr==null){
            return null;
        }
        int [] res= new int[arr.length];
        for (int i=0;i<arr.length;i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void printArr(int arr[]){
        if (arr==null){
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"、");
        }
        System.out.println();
    }

    public static void RightWay(int arr[]){
        Arrays.sort(arr);
    }

    public static void main(String[] args){
        int testTime = 1000;
        int size = 20;
        int value = 20;
        boolean success = true;
        for(int i=0;i<testTime;i++){
            int arr1[] = generateRandomArray(size,value);
            int arr2[] = CopyArr(arr1);
            int arr3[] = CopyArr(arr1);
            InsertSort(arr1);
            RightWay(arr2);
            if (!isEqual(arr1,arr2)){
                success = false;
                printArr(arr3);

                break;     //感觉每次都忘记加break
            }
        }
        System.out.println(success?"Yes!":"Fuck!");
    }
}

//int mid = L + ((R+L) >>1)