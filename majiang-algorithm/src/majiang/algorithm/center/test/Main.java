package majiang.algorithm.center.test;

import java.util.List;

import majiang.algorithm.center.bean.UserPaiBean;
import majiang.algorithm.center.service.MaJiangAlgorithmService;

public class Main {
	
	public static void main(String[] args) {
		MaJiangAlgorithmService service = new MaJiangAlgorithmService();
		List<String> pai = service.initAllPai();
		
		UserPaiBean[] beans = service.initHandPai(pai);
		
	}

}
