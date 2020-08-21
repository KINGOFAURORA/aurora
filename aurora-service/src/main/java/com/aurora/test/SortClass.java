package com.aurora.test;

public class SortClass {
    public static void sort(int[] arrarys){
        for(int i=0;i<arrarys.length;i++){
            for(int j=0;j<arrarys.length;j++){
                if(arrarys[i] < arrarys[j]){
                    arrarys[i] = arrarys[i] ^ arrarys[j];
                    arrarys[j] = arrarys[i] ^ arrarys[j];
                    arrarys[i] = arrarys[i] ^ arrarys[j];
                }
            }
        }
    }

    public static void sort1(int[] arrarys, int left, int right){
        int tar = arrarys[right];
        int head = left,tail=right;
        int mid = 0;
        if(left >= right){
            return;
        }
        while(head < tail){
            while(tar > arrarys[head] && head < tail){
                head++;
            }
            if(head < tail){
                int tmp = arrarys[head];
                arrarys[head] = tar;
                arrarys[tail] = tmp;
            }
            while(tar < arrarys[tail] && head < tail){
                tail--;
            }
            if(head < tail){
                int tmp = arrarys[tail];
                arrarys[tail] = tar;
                arrarys[head] = tmp;
            }
        }
        mid = tail-1;
        sort1(arrarys,left,mid);
        sort1(arrarys,mid+1,right);
    }

    public static void main(String[] args) {
        int[] arrarys = {5,2,8,9,4,1,7};
//        sort(arrarys);
        sort1(arrarys, 0, arrarys.length-1);
        for(int a : arrarys){
            System.out.println(a);
        }
    }
}
