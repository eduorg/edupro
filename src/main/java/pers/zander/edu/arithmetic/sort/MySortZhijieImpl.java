package pers.zander.edu.arithmetic.sort;
/**
 * 直接法实现排序
 * @author zhaozhao
 * @time 2016-5-10 上午9:56:15
 */
public class MySortZhijieImpl implements MySort{

	@Override
	public void insertSort(String name,int[] array) {
		for (int i = 1; i < array.length; i++) {
			int a = array[i];
			for (int j = 0; j < i; j++) {
				int b = array[j];
				if (a < b) {
					int c = array[i];
					array[i] = array[j];
					array[j] = c;
				}
			}
		}
		
	}


}
