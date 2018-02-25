package majiang.algorithm.center.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import majiang.algorithm.center.base.MaJiangConfigConstants;
import majiang.algorithm.center.bean.HuPaiBean;
import majiang.algorithm.center.bean.OperationPaiBean;
import majiang.algorithm.center.bean.SingleRoundRealtimeDataBean;
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
	public SingleRoundRealtimeDataBean initHandPai(List<String> pai){
		
		SingleRoundRealtimeDataBean dataBean = new SingleRoundRealtimeDataBean();
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
//		//庄家再多摸一张
//		beans[0].getHandPai().add(pai.get(0));
//		pai = pai.subList(1, pai.size());
		System.out.println("摸牌后的牌数为："+pai.size());
		System.out.println("摸牌后剩余牌序为："+pai);
		for (int i = 0; i < beans.length; i++) {
			Collections.sort(beans[i].getHandPai());
			System.out.print("用户"+(i+1)+"排序后的牌为：");
			for (int j = 0; j < beans[i].getHandPai().size(); j++) {
				System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(beans[i].getHandPai().get(j))+" ");
			}
			System.out.println();
			//判定是否听牌
			judgeUserCurrentStatus(beans[i]);
		}
		
		dataBean.setUserPaiBeans(beans);
		return dataBean;
	}
	/**
	 * 摸牌
	 * @param pai
	 * @param userPaiBean
	 * @return
	 */
	public UserPaiBean getNewHandPai(List<String> pai,UserPaiBean userPaiBean){
		String newHandPai = pai.get(0);
		userPaiBean.getHandPai().add(newHandPai);
		pai = pai.subList(1, pai.size());
		System.out.println("摸牌后的牌数为："+pai.size());
		System.out.println("摸牌后剩余牌序为："+pai);
		return userPaiBean;
	}
	
	/**
	 * 判定用户当前能做的操作
	 * @return
	 */
	public UserPaiBean judgeUserCurrentStatus(UserPaiBean userPaiBean){
		
		List<String> handPai = userPaiBean.getHandPai();
		
		List<HuPaiBean> huPaiBeans = new ArrayList<HuPaiBean>();
		
		//循环所有的牌凑一张  看是否达到胡牌效果
		//一个对子 其它都是三个的   然后是否能
		for (int i = 0; i < 27; i++) {
			//复制一手手牌
			List<String> tempPai = new ArrayList<String>(handPai);
			
			tempPai.add(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
			//排序
			Collections.sort(tempPai);
			//后面看多线程是否要快一点
			System.out.println(tempPai);
			//判断七对
			if (tempPai.size()==14) {//如果牌是14张
				boolean flag = true;
				int j;
				for (j = 0; j < 14; j+=2) {
					if (!tempPai.get(j).equals(tempPai.get(j+1))) {
						System.out.println("不相等");
						flag = false;
						break;
					}else {
						System.out.println("相等");
					}
				}
				if (j>12&&flag) {
					HuPaiBean huPaiBean = new HuPaiBean();
					huPaiBean.setHuPaiType(0);
					huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
					//huPaiBean.setSize(size) //TODO  后面根据自己手牌和桌面牌判定剩余牌
					huPaiBeans.add(huPaiBean);
					//小七对直接结束轮循
					System.out.println("我胡牌了"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
					break;
				}
			}
			
			{//碰碰胡 3*n+2
				//桌面上的操作的牌不是碰就是杠
//				List<OperationedPaiBean> operationPaiBeans = userPaiBean.getOperationedPaiBeans();
//				boolean flag = true;
//				for (OperationedPaiBean operationedPaiBean : operationPaiBeans) {
//					if (operationedPaiBean.getOperateType()==MaJiangConfigConstants.operate_pai_type_0) {
//						flag = false;
//						System.out.println("桌面有吃牌"+operationedPaiBean.getOperatePai());
//						break;
//					}
//				}
				if (userPaiBean.getOperationedPaiTypes().indexOf(MaJiangConfigConstants.operate_pai_type_0+"")==-1) {
					//如果只有两张牌则直接判断这两张牌是否一致
					if (tempPai.size()==2&&tempPai.get(0).equals(tempPai.get(1))) {
						HuPaiBean huPaiBean = new HuPaiBean();
						huPaiBean.setHuPaiType(0);
						huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
						//huPaiBean.setSize(size) //TODO  后面根据自己手牌和桌面牌判定剩余牌
						huPaiBeans.add(huPaiBean);
						//小七对直接结束轮循
						System.out.println("我胡牌了"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"碰碰胡");
						break;
					}
					int _double = 0;
					int _triple = 0;
					String currPai;
					String prevPai = tempPai.get(0);
					for (int j = 1; j < tempPai.size(); j++) {
						currPai = tempPai.get(j);
						boolean isLastOne = j==(tempPai.size()-1);
						//如果当前这张牌跟上一张牌相等并且跟下一张牌也相等，那么三张相同的则凑一起  
						if (currPai.equals(prevPai)) {
							if (isLastOne) {
								HuPaiBean huPaiBean = new HuPaiBean();
								huPaiBean.setHuPaiType(1);
								huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
								//huPaiBean.setSize(size) //TODO  后面根据自己手牌和桌面牌判定剩余牌
								huPaiBeans.add(huPaiBean);
								System.out.println("我胡牌了"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"碰碰胡");
								break;
							}else if (currPai.equals(tempPai.get(j+1))) {//如果跟下一张一致就说明是三个的
								_triple++;
								if ((j+1)!=(tempPai.size()-1)) {
									j+=2;
									prevPai = tempPai.get(j);
								}
							}else {
								_double++;
								j+=1;
								prevPai = tempPai.get(j);
							}
						}else {
							System.out.println("我这个牌没听碰碰胡"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
							break;
						}
						if (_double>1) {//如果两张的大于1说明没胡牌
							System.out.println("我这个牌没听碰碰胡"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
							break;
						}
						if (isLastOne) {
							HuPaiBean huPaiBean = new HuPaiBean();
							huPaiBean.setHuPaiType(1);
							huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
							//huPaiBean.setSize(size) //TODO  后面根据自己手牌和桌面牌判定剩余牌
							huPaiBeans.add(huPaiBean);
							System.out.println("我胡牌了"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"碰碰胡");
							System.out.println("三个的个数为："+_triple);
							
						}
					}
					
//					System.out.println("三张个数"+_triple);
				}
//				else {
//					System.out.println("桌面有吃牌");
//				}
			}
			
			{//屁胡
				//先找将然后从牌中移除
				Map<String, List<String>> leftPais = new HashMap<String, List<String>>();
				for (int j = 0; j < tempPai.size(); j++) {
					//如果当前这张牌跟下一张牌一样的话那么可以用来做对
					if (j!=(tempPai.size()-1)&&tempPai.get(j).equals(tempPai.get(j+1))&&MaJiangConfigConstants.JIANG_PAI.contains(tempPai.get(j))){
						List<String> leftPai = new ArrayList<String>(tempPai);
						leftPai.remove(j+1);
						leftPai.remove(j);
						leftPais.put(tempPai.get(j), leftPai);
						j+=1;
					}
				}
				System.out.println("可以用来做将的"+leftPais.keySet());
				
				for (String jiangPai : leftPais.keySet()) {
					System.out.println(jiangPai);
					//先将三个整的移除
					List<String> leftPai = leftPais.get(jiangPai);
					for (int j = 0; j < leftPai.size(); ) {//里面肯定是三的倍数
						if (MaJiangConfigConstants.BASE_PAI_DISTINCT[13].equals(jiangPai)&&i==4) {
							System.out.println("看当前牌："+i);
						}
						if (j+2<=(leftPai.size()-1)&&leftPai.get(j).equals(leftPai.get(j+1))&&leftPai.get(j).equals(leftPai.get(j+2))) {
							leftPai.remove(j);
							leftPai.remove(j);
							leftPai.remove(j);
						}else {
							j++;
						}
						System.out.println("剩余的牌："+leftPai);
					}
					//找顺子
					for (int j = 0; j < leftPai.size(); ) {
						//得到当前牌的位置
						int first = leftPai.get(j).charAt(0)=='0' ? 0 : (leftPai.get(j).charAt(0)=='1' ? 1 : 2);
						int second = Integer.valueOf(leftPai.get(j).charAt(1)+"");
						int ind = first*9+second-1;
						//如果第一二三张牌是顺子则移除
						System.out.println(ind);
						if (j+2<=(leftPai.size()-1)&&//剩余的牌要可以大于等于两张做顺子
								(second<=6)&&//当前牌最多为7
								leftPai.get(j+1).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+1])
								&&leftPai.get(j+2).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+2])) {
							leftPai.remove(j);
							leftPai.remove(j);
							leftPai.remove(j);
							System.out.println("剩余的牌："+leftPai);
							System.out.println("j:"+j);
						}else if (j+5<=(leftPai.size()-1)&&//剩余的牌要可以大于等于五张做顺子
								(second<=6)&&//当前牌最多为7
								leftPai.get(j+2).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+1])
								&&leftPai.get(j+4).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+2])) {
							leftPai.remove(j+4);
							leftPai.remove(j+2);
							leftPai.remove(j);
						}else {
							System.out.println("不是胡子");
							break;
						}
					}
					System.out.println(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
					if (leftPai.size()==0) {//如果牌被清空了那么就说明这张牌可以胡
						HuPaiBean huPaiBean = new HuPaiBean();
						huPaiBean.setHuPaiType(1);
						huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
						//huPaiBean.setSize(size) //TODO  后面根据自己手牌和桌面牌判定剩余牌
						huPaiBeans.add(huPaiBean);
						System.out.println("----------------------------------------------我胡牌了"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"屁胡");
					}
				}
			}
		}
		userPaiBean.setHuPaiBeans(huPaiBeans);
		return userPaiBean;
	}
	/**
	 * 判定用户可以对打出来的牌的操作
	 * @param userPaiBean
	 * @param releasePai 打出的牌
	 * @param ind  0 下家 1 非下家
	 */
	public void judgeUserOperations(UserPaiBean userPaiBean,String releasePai,int ind){
		if (ind==0) {//下家判定是否能吃
			//先拿出同类型牌
			String startInd = releasePai.substring(0, 1);
			String endInd = releasePai.substring(1, 2);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < userPaiBean.getHandPai().size(); i++) {
				if (userPaiBean.getHandPai().get(i).startsWith(startInd)) {
					if (sb.lastIndexOf(userPaiBean.getHandPai().get(i).substring(1, 2))==-1) {
						sb.append(userPaiBean.getHandPai().get(i).substring(1, 2));
					}
				}else if(sb.length()>0) {
					break;
				}
			}
			//选四张牌
			String prevPrevInd = String.valueOf(Integer.valueOf(endInd)-2);
			String prevInd = String.valueOf(Integer.valueOf(endInd)-1);
			String nextInd = String.valueOf(Integer.valueOf(endInd)+1);
			String nextNextInd = String.valueOf(Integer.valueOf(endInd)+2);
			String distinctSameTypePai = sb.toString();
			//这张牌在最后一张
			if (distinctSameTypePai.indexOf(prevPrevInd)!=-1
					&&distinctSameTypePai.indexOf(prevInd)!=-1) {
				OperationPaiBean operationPaiBean = new OperationPaiBean();
				operationPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_0);
				operationPaiBean.getOperatePai().add(startInd+prevPrevInd);
				operationPaiBean.getOperatePai().add(startInd+prevInd);
				operationPaiBean.getOperatePai().add(startInd+endInd);
				userPaiBean.getOperationPaiBeans().add(operationPaiBean);
			}
			//牌在中间
			if (distinctSameTypePai.indexOf(prevInd)!=-1
					&&distinctSameTypePai.indexOf(nextInd)!=-1) {
				OperationPaiBean operationPaiBean = new OperationPaiBean();
				operationPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_0);
				operationPaiBean.getOperatePai().add(startInd+prevInd);
				operationPaiBean.getOperatePai().add(startInd+endInd);
				operationPaiBean.getOperatePai().add(startInd+nextInd);
				userPaiBean.getOperationPaiBeans().add(operationPaiBean);
			}
			//牌在前面
			if (distinctSameTypePai.indexOf(nextInd)!=-1
					&&distinctSameTypePai.indexOf(nextNextInd)!=-1) {
				OperationPaiBean operationPaiBean = new OperationPaiBean();
				operationPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_0);
				operationPaiBean.getOperatePai().add(startInd+endInd);
				operationPaiBean.getOperatePai().add(startInd+nextInd);
				operationPaiBean.getOperatePai().add(startInd+nextNextInd);
				
				userPaiBean.getOperationPaiBeans().add(operationPaiBean);
			}
		}
		//判定是否能碰
		//找两张一样的
		int firstSamePaiIndex = userPaiBean.getHandPai().indexOf(releasePai);
		if (firstSamePaiIndex!=-1) {
			if (userPaiBean.getHandPai().size()>=(firstSamePaiIndex+2)
					&&userPaiBean.getHandPai().get(firstSamePaiIndex+1).equals(releasePai)) {
				OperationPaiBean operationPaiBean = new OperationPaiBean();
				operationPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_1);
				List<String> operatePai = new ArrayList<String>();
				operatePai.add(releasePai);
				operatePai.add(releasePai);
				operatePai.add(releasePai);
				userPaiBean.getOperationPaiBeans().add(operationPaiBean);
				if (userPaiBean.getHandPai().size()>=(firstSamePaiIndex+3)
						&&userPaiBean.getHandPai().get(firstSamePaiIndex+2).equals(releasePai)) {
					OperationPaiBean operationPaiBeanGang = new OperationPaiBean();
					operationPaiBeanGang.setOperateType(MaJiangConfigConstants.operate_pai_type_1);
					List<String> operatePaiGang = new ArrayList<String>();
					operatePaiGang.add(releasePai);
					operatePaiGang.add(releasePai);
					operatePaiGang.add(releasePai);
					operatePaiGang.add(releasePai);
					userPaiBean.getOperationPaiBeans().add(operationPaiBeanGang);
				}
			}
		}
	}
	/**
	 * 判定用户是否可以胡别人打出的牌了
	 * @param huPaiBeans
	 * @param releasePai
	 */
	public void judgeCanHuPai(UserPaiBean userPaiBean,String releasePai){
		List<HuPaiBean> huPaiBeans = userPaiBean.getHuPaiBeans();
		for (int j = 0; j < huPaiBeans.size(); j++) {
			if (huPaiBeans.get(j).getPai().equals(releasePai)) {
				OperationPaiBean operationPaiBean = new OperationPaiBean();
				operationPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_4);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		MaJiangAlgorithmService service = new MaJiangAlgorithmService();
		UserPaiBean userPaiBean = new UserPaiBean();
		userPaiBean.getHandPai().add("01");
		userPaiBean.getHandPai().add("02");
		userPaiBean.getHandPai().add("02");
		userPaiBean.getHandPai().add("03");
		userPaiBean.getHandPai().add("04");
		userPaiBean.getHandPai().add("06");
		userPaiBean.getHandPai().add("06");
		service.judgeUserOperations(userPaiBean, "02", 0);
	}
	
}
