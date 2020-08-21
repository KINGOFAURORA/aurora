package com.aurora.test;

public class InsertSort {

    public static void sort(int[] arrays){
        int temp = arrays[0];
        int index = 0;
        for(int i=1;i<arrays.length;i++){
            temp = arrays[i];
            index = i;
            for(int j=i-1;j>=0;j--){
                if(temp < arrays[j]){
                    arrays[index] = arrays[j];
                    arrays[j] = temp;
                    index--;
                } else {
                    break;
                }
            }
        }
    }

    public static void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i = 0;
        int j = low,k = mid+1;  //左边序列和右边序列起始索引
        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t=0;t<i;t++){
            arr[low+t] = tmp[t];
        }
    }

    public static void mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid,tmp); //对左边序列进行归并排序
            mergeSort(arr,mid+1,high,tmp);  //对右边序列进行归并排序
            merge(arr,low,mid,high,tmp);    //合并两个有序序列
        }
    }


    public static void main(String[] args) {
        int[] arrarys = {5,2,8,9,4,1,7};
        int[] tmp = new int[arrarys.length];
        mergeSort(arrarys,0,arrarys.length-1,tmp);
//        sort(arrarys);
        for(int a : arrarys){
            System.out.println(a);
        }
    }
}
