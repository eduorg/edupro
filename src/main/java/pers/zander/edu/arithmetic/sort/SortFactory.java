package pers.zander.edu.arithmetic.sort;
/**
 * 排序工厂抽象类
 * @author zhaozhao
 * @time 2016-5-10 上午9:56:28
 */
public abstract class SortFactory implements MySort{

	public abstract MySort createZhijie();
	public abstract MySort createXier();
	public abstract MySort createErfen();
	
	public abstract MySort createSort(String name);
}

