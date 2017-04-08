package pers.zander.edu.arithmetic.sort;

/**
 * 排序工厂实现类
 * @author zhaozhao
 * @time 2016-5-10 上午9:56:43
 */
public class SortFactoryImpl extends SortFactory{

	@Override
	public void insertSort(String name,int[] array) {
		if("zhijie".equals(name)){
			 new MySortZhijieImpl().insertSort("",array);
		}else if("erfen".equals(name)){
			 new MySortErfenImpl().insertSort("",array);
		}else if("xier".equals(name)){
			 new MySortXierImpl().insertSort("",array);
		}else if("maopao".equals(name)){
			 new MySortMaopaoImpl().insertSort("",array);
		}
	}
	@Override
	public MySort createSort(String name) {
		if("zhijie".equals(name)){
			return new MySortZhijieImpl();
		}else if("erfen".equals(name)){
			return new MySortErfenImpl();
		}else if("xier".equals(name)){
			return new MySortXierImpl();
		}else{
			return null;
		}
	}
	
	@Override
	public MySortZhijieImpl createZhijie() {
		// TODO Auto-generated method stub
		return new MySortZhijieImpl();
	}

	@Override
	public MySortXierImpl createXier() {
		// TODO Auto-generated method stub
		return new MySortXierImpl();
	}

	@Override
	public MySortErfenImpl createErfen() {
		// TODO Auto-generated method stub
		return new MySortErfenImpl();
	}

	

	

	

}
