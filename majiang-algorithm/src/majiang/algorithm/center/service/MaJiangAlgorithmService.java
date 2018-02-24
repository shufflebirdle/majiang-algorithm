package majiang.algorithm.center.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import majiang.algorithm.center.base.MaJiangConfigConstants;
import majiang.algorithm.center.bean.UserPaiBean;


/**
 * 麻将核心服务
 * @author yspc18
 *
 */
public class MaJiangAlgorithmService {
	
	/**
	 * 牌序初始化
	 * @return
	 */
	public List<String> initAllPai(){
		List<String> pai = Arrays.asList(MaJiangConfigConstants.BASE_PAI.clone());
		Collections.shuffle(pai);
		return pai;
	}
	
	/**
	 * 初始化手牌
	 * @return
	 */
	public UserPaiBean[] initHandPai(List<String> pai){
		System.out.println("初始牌序为："+pai);
		UserPaiBean[] beans = new UserPaiBean[]{ new UserPaiBean(), new UserPaiBean(), new UserPaiBean(), new UserPaiBean()};
		for (int i = 0; i < 4; i++) {//发四轮
			int size = i==3? 1 : 4;//如果是第四轮则只发一张
			for (int j = 0; j < beans.length; j++) {
				beans[j].getHandPai().addAll(pai.subList(0, size));
				pai = pai.subList(size,pai.size());
				System.out.println("用户"+(j+1)+"牌序为："+beans[j].getHandPai());
			}
			System.out.println("第"+(i+1)+"轮摸牌后剩余牌序为："+pai);
		}
		//庄家再多摸一张
		beans[0].getHandPai().add(pai.get(0));
		pai = pai.subList(1, pai.size());
		System.out.println("摸牌后的牌数为："+pai.size());
		System.out.println("摸牌后剩余牌序为："+pai);
		for (int i = 0; i < beans.length; i++) {
			Collections.sort(beans[i].getHandPai());
			System.out.print("用户"+(i+1)+"排序后的牌为：");
			for (int j = 0; j < beans[i].getHandPai().size(); j++) {
				System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(beans[i].getHandPai().get(j))+" ");
			}
			System.out.println();
		}
		return beans;
	}

}
