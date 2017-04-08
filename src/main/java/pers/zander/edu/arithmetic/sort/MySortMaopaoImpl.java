package pers.zander.edu.arithmetic.sort;
/**
 * 冒泡排序
 * @author zhaozhao
 * @time 2016-5-10 下午3:28:59
 */
public class MySortMaopaoImpl implements MySort{

	@Override
	public void insertSort(String name, int[] array) {
		int s = 0 ;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j<array.length-i-1; j++) {
				if(array[j]>array[j+1]){
					int temp = array[j]; 
					array[j] = array[j+1]; 
					array[j+1] = temp;
					s++;
				}
			}
		}
		System.out.println(s);
	}

}
