package cn.Sort;
import java.util.Arrays;
/**
 * 归并排序，时间复杂是O(NlogN),空间复杂度是O(N)
 */
public class MergeSort {
    public static void mergeSort(int arr[]){
        if (arr == null || arr.length <2){
            return;
        }
        SortProcess(arr,0,arr.length-1);
    }

    /**
     * 这里调用了递归
     */
    public static void SortProcess(int arr[],int L,int R){
        if (L==R){
            return;
        }
        int mid = L+ ((R-L) >> 1);
        SortProcess(arr,L,mid);
        SortProcess(arr,mid+1,R);
        merge(arr,L,R,mid);
    }

    /**
     * 这里没有调用递归，只是把数组中的元素放好位置再拷回
     */
    public static void merge(int arr[],int L,int R, int mid){
        int help[] = new int[R-L+1];   //数组长度（先定义一个辅助数组）
        int i = 0;
        //定义两个指向两个位置的指针
        int p1 = L;
        int p2 = mid +1;
        //想象左右两个已经排好序的数组
        while (p1<=mid && p2<=R){
            help[i++] = arr[p1] < arr[p2]? arr[p1++]: arr[p2++];
        }
        //p1如果没越界，就把pi所在数组填到help数组中，下面两种情况只会发生一种
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for (i = 0;i<help.length;i++){
            //这里是数组排好序以后拷回
            arr[L+i] = help[i];     //这里是因为help数组是0~R(如0~7)的，而原数组是不确定的，有可能是10~17，是是一一对应
        }
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
        int size = 60;
        int value = 60;
        boolean success = true;
        for (int i = 0; i<testTime;i++){
            int arr1[] = generateRandomArray(size,value);
            int arr2[] = copyArray(arr1);
            int arr3[] = copyArray(arr1);
            mergeSort(arr1);
            RightMathod(arr2);
            if (!isEqual(arr1,arr2)){
                success = false;
                printArr(arr3);
                break;
            }
        }
        System.out.println(success? "Bingo！": "Fuck！");
    }
}
//今天学习到: 1、mid = L+((R-L)>>1)  这种写法的好处是结果不会溢出
          // 2、计算时间复杂度的master公式
        //   3、swap交换两个值的第二种写法 -> 亦或    方便敲代码
//                arr[i] = arr[i] ^ arr[j];
//                arr[j] = arr[i] ^ arr[j];
//                arr[i] = arr[i] ^ arr[j];