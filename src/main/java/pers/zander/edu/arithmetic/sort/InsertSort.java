package pers.zander.edu.arithmetic.sort;

/**
 * 排序算法
 * 
 * @author zhaozhao
 * @time 2016-5-4 上午10:47:10
 */
public class InsertSort {

	static int[] datas = new int[100000];
	static int[] datas2 = new int[100000];
	static int[] datas3 = new int[100000];
	static int[] datas4 = new int[100000];

	public static void getdata() {
		for (int i = 0; i < 100000; i++) {
			int a = (int) (Math.random() * 100000);
			datas[i] = a;
			datas2[i] = a;
			datas3[i] = a;
			datas4[i] = a;
		}
	}

	/**
	 * 直接插入排序
	 * 
	 * @author zhaozhao
	 * @time 2016-5-4 上午10:48:16
	 */
	public static void zhijie() {
		for (int i = 1; i < datas.length; i++) {
			int a = datas[i];
			for (int j = 0; j < i; j++) {
				int b = datas[j];
				if (a < b) {
					int c = datas[i];
					datas[i] = datas[j];
					datas[j] = c;
				}
			}
		}
	}

	/**
	 * 二分法插入排序
	 * 
	 * @author zhaozhao
	 * @time 2016-5-4 上午10:48:26
	 */
	public static void erfen() {
		for (int i = 0; i < datas2.length; i++) {
			int temp = datas2[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				if (temp < datas2[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;

				}
			}
			for (int j = i - 1; j >= left; j--) {
				datas2[j + 1] = datas2[j];
			}
			if (left != i) {
				datas2[left] = temp;
			}
		}
	}

	/**
	 * 希尔插入排序
	 * 
	 * @author zhaozhao
	 * @time 2016-5-4 上午10:48:36
	 */
	public static void xier() {
		int d = datas3.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < datas3.length; i = i + d) {
					int temp = datas3[i];
					int j;
					for (j = i - d; j >= 0 && datas3[j] > temp; j = j - d) {
						datas3[j + d] = datas3[j];
					}
					datas3[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
	}

	//归并排序
	public static void	mergingSort(){
		sort(datas4,0,datas4.length-1);
	}
	public static void sort(int[] data, int left, int right) {
	    // TODO Auto-generated method stub
	    if(left<right){
	        //找出中间索引
	        int center=(left+right)/2;
	        //对左边数组进行递归
	        sort(data,left,center);
	        //对右边数组进行递归
	        sort(data,center+1,right);
	        //合并
	        merge(data,left,center,right);
	        
	    }
	}
	public static void merge(int[] data, int left, int center, int right) {
	    // TODO Auto-generated method stub
	    int [] tmpArr=new int[data.length];
	    int mid=center+1;
	    //third记录中间数组的索引
	    int third=left;
	    int tmp=left;
	    while(left<=center&&mid<=right){

	   //从两个数组中取出最小的放入中间数组
	        if(data[left]<=data[mid]){
	            tmpArr[third++]=data[left++];
	        }else{
	            tmpArr[third++]=data[mid++];
	        }
	    }
	    //剩余部分依次放入中间数组
	    while(mid<=right){
	        tmpArr[third++]=data[mid++];
	    }
	    while(left<=center){
	        tmpArr[third++]=data[left++];
	    }
	    //将中间数组中的内容复制回原数组
	    while(tmp<=right){
	        data[tmp]=tmpArr[tmp++];
	    }
	}

	
//	public static void main(String[] args) {
//		System.out.println("********start********");
//		getdata();
//		Long ls = System.currentTimeMillis();
//		zhijie();
//		Long le = System.currentTimeMillis();
//		System.out.println("直接排序   " + (le - ls) + "ms");
//		for (int i = 0; i < 100; i++) {
//			System.out.print(datas[i] + ",");
//		}
//		System.out.println("");
//		Long ls1 = System.currentTimeMillis();
//		erfen();
//		Long le1 = System.currentTimeMillis();
//		
//		System.out.println("二分法排序   " + (le1 - ls1) + "ms");
//		for (int i = 0; i < 100; i++) {
//			System.out.print(datas2[i] + ",");
//		}
//		System.out.println("");
//		Long ls2 = System.currentTimeMillis();
//		xier();
//		Long le2 = System.currentTimeMillis();
//		System.out.println("希尔排序   " + (le2 - ls2) + "ms");
//		for (int i = 0; i < 100; i++) {
//			System.out.print(datas3[i] + ",");
//		}
//		System.out.println("");
//		Long ls3 = System.currentTimeMillis();
//		mergingSort();
//		Long le3 = System.currentTimeMillis();
//		System.out.println("归并排序   " + (le3 - ls3) + "ms");
//		for (int i = 0; i < 100; i++) {
//			System.out.print(datas4[i] + ",");
//		}
//		System.out.println("");
//		System.out.println("********end********");
//		// erfen();
//		// xier();
//	}

}
