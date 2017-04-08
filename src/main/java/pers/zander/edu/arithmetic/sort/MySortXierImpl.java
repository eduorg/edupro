package pers.zander.edu.arithmetic.sort;
/**
 * 希尔法实现排序
 * @author zhaozhao
 * @time 2016-5-10 上午9:56:01
 */
public class MySortXierImpl implements MySort{

	@Override
	public void insertSort(String name, int[] array) {
		int l = array.length;
		int s = 0;
		int m = l/2;
		while (true) {
			m = m-1;
			for (int i = 0; i < array.length-m; i++) {
				s++;
				if(array[i]>array[i+m]){
					int temp = array[i];
					array[i]=array[i+m];
					array[i+m]=temp;
				}
			}
			if(m==1){
				break;
			}
		}
		System.out.println(s);
	}
	
	
	
	
	
	
	
	
//	@Override
//	public void insertSort(String name,int[] array) {
//		int d = array.length;
//		int s = 0;
//		while (true) {
//			d = d / 2;
//			for (int x = 0; x < d; x++) {
//				for (int i = x + d; i < array.length; i = i + d) {
//					int temp = array[i];
//					int j;
//					s++;
//					for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
//						array[j + d] = array[j];
//					}
//					array[j + d] = temp;
//				}
//			}
//			if (d == 1) {
//				break;
//			}
//		}
//		System.out.println(s);
//	}

}
