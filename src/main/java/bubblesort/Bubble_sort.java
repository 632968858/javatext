package bubblesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Bubble_sort {
	public static void merge(int [] a){     //归并排序
		int left =0;
		int right=a.length;
		int temp[]=new int[a.length];
		internalMergeSort(a,temp,left,right-1);  /////////俩个数组归并
	}
	public static void internalMergeSort(int [] a,int[] b,int left,int right){     //归并排序
		if(left<right){
			int mid=(left+right)/2;
			internalMergeSort(a,b,left,mid);
			internalMergeSort(a,b,mid+1,right);//////////////////////
			MergeSort(a,b,left,mid,right);
			
			
		}
	}
	public static void MergeSort(int [] a,int[] b,int left,int mid,int right){//将a的左边和右边有序序列归并
		int i=left;
		int j=mid+1;///////////////////////////
		int k=0;
		while(i<=mid&&j<=right){
			if(a[i]<=a[j]){
					b[k++]=a[i++];
				}else{
					b[k++]=a[j++];
				}
		}
		while(i<=mid){b[k++]=a[i++];}
		while(j<=right){b[k++]=a[j++];}
		for(i=0;i<k;i++){
			a[left+i]=b[i];
		}
		for (int c : a) {
			System.out.print(c);
		}
		System.out.println("");
	}
	public static void heapSort(int []a){
		int temp;
		for(int i=a.length/2-1;i>=0;i--){   //从非叶节点开始建堆///////////////////n/2-1           nlg(n)
			sift(a,i,a.length);   ///此处不用 sift(a,0,a.length)原因是还不是堆，不能直接使用/////////////////////////从非叶节点开始建堆lg(n)
			}
		System.out.println("heap ");
		for(int i:a){
			System.out.print(i);
		}
		System.out.println(" ");
		for(int j=a.length-1;j>0;j--){   ///n-1次选出最终结果
			temp=a[0];
			a[0]=a[j];
			a[j]=temp;
			sift(a,0,j);       ///////堆顶开始到为排序的末尾开始建堆
		}
	}
	public static void sift(int []a,int low,int high){             //最小堆
		int i=low;
		int j=i*2+1;
		int temp =a[i];
		while(j<high){
			if(j<high-1&&a[j]>a[j+1])   /////最小孩子节点   high-1可达，high 不可达
			{
				j++;
			}
			if(a[j]<temp){         ///最小孩子节如果小于父节点则交换，父节点保持最小  ，下沉，上浮
			
				a[i]=a[j];
				i=j;
				j=i*2+1;
			}else{     //否则退出，是建立在已是堆的基处上
				j=high+1;
			}
		}
		a[i]=temp;
	}
	public static void quickSort(int [] a,int begin,int end){  //快排   不稳定
		if(begin<end){/////////////////////////////////
		int i=randget(a,begin,end);
		quickSort(a, begin, i-1);
		quickSort(a, i+1, end);
		}
	}
	public static int randget(int []a,int begin,int end){
		int temp =a[begin];
		while(begin<end){
			while(begin<end&&a[begin]<temp)begin++; /////////////////begin<end 
			while(begin<end&&a[end]>=temp)end--;/////////////////begin<end 
			if(begin<end){
				int temp2=a[begin];
				a[begin]=a[end];
				a[end]=temp2;
			}
		}
		a[begin]=temp;
		return begin;
	}
	public static int[] bubble_sort(int[] a) {            //稳定
		boolean flag = true;
		for (int i = 0; i < a.length && flag; i++) {
			flag = false;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					flag = true;
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}
	public static int[] insertSort1(int [] a){  //无哨兵  插入排序稳定
		int temp;
		int i,j;
		for(i=1;i<a.length;i++){
			temp=a[i];
			for(j=i-1;j>=0&&a[j]>temp;j--){       //j前面的是已排好的递增序
				a[j+1]=a[j];
			}
			a[j+1]=temp;                          ////////////////////////////////
		}
		return a;
	}
	public static int[] insertSort2(int [] a){  //有哨兵
		int i,j;
		for(i=1;i<a.length;i++){
			a[0]=a[i];
			for(j=i-1;a[j]>a[0];j--){
				a[j+1]=a[j];
			}
			a[j+1]=a[0];
		}
		return a;                       
	}
	
	public static void selectSort(int a[]){  //选择排序不稳定涉及交换
		for(int i=0;i<a.length-1;i++){            ///////////i用不着到a.length ,因为最后一个肯定在最后
			int mix=i;
			for(int j=i+1;j<a.length;j++){    ////////////////////////
				if(a[j]<a[mix])
					mix=j;
			}
			if(mix!=i){
				int temp=a[i];
				a[i]=a[mix];            //应该交换
				a[mix]=temp;
			}
			
		}
	}
	public static void main(String[] args) {
		/*int max = 5;
		int[] a = new int[max];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();

		}*/
		int[] am={3,1, 4, 1 ,9 ,5 ,7 ,2};
		System.out.println("开始输入顺序");
		for (int i : am) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("归并排序");
		merge(am);
		for (int i : am) {     
			System.out.print(i);
		}
		System.out.println();
		int[] a={5, 3 ,4 ,2 ,1};
		System.out.println("开始输入顺序");
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("堆排序");
		heapSort(a);
		for (int i : a) {     
			System.out.print(i);
		}
		System.out.println();
		System.out.println("开始输入顺序");
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("冒泡排序");
		for (int i : bubble_sort(a)) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("开始输入顺序");
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("插入排序");
		for (int i : insertSort1(a)) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("开始输入顺序");
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("插入排序2");
		for (int i : insertSort2(a)) {     //a[0]为哨兵，
			System.out.print(i);
		}
		System.out.println();
		
		int []b={5, 3 ,4 ,2 ,1,5,4};
		a=b;
		System.out.println("开始输入顺序");
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("快速排序");
		quickSort(a, 0, a.length-1);
		for (int i : a) {     
			System.out.print(i);
		}
		System.out.println();
		int []c={5, 3 ,4 ,2 ,1,5,4};
		a=c;
		System.out.println("开始输入顺序");
		for (int i : a) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("选择排序");
		quickSort(a, 0, a.length-1);
		for (int i : a) {     
			System.out.print(i);
		}
		System.out.println();
		
	//	sc.close();
	}
}
