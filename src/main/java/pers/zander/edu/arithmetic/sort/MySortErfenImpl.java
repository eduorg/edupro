package pers.zander.edu.arithmetic.sort;
/**
 * 二分法实现排序
 * @author zhaozhao
 * @time 2016-5-10 上午9:55:45
 */
public class MySortErfenImpl implements MySort{

	@Override
	public void insertSort(String name, int[] array) {
		for (int i = 0; i < array.length; i++) {
			int a = array[i];
			int l = 0;
			int r = i-1;
			int m = 0;
			while(l<=r){
				m = (l+r)/2;
				if(a<array[m]){
					r = m-1;
				}else{
					l = m+1;
				}
			}
			for (int j = i - 1; j >= l; j--)  {
				array[j+1]=array[j];
			}
			if(l!=i){
				array[l]=a;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public void insertSort(String name,int[] array) {
//		for (int i = 0; i < array.length; i++) {
//			int temp = array[i];
//			int left = 0;
//			int right = i - 1;
//			int mid = 0;
//			while (left <= right) {
//				mid = (left + right) / 2;
//				if (temp < array[mid]) {
//					right = mid - 1;
//				} else {
//					left = mid + 1;
//
//				}
//			}
//			for (int j = i - 1; j >= left; j--) {
//				array[j + 1] = array[j];
//			}
//			if (left != i) {
//				array[left] = temp;
//			}
//		}
//		
//	}


}
