package majiang.algorithm.center.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import majiang.algorithm.center.base.MaJiangConfigConstants;
import majiang.algorithm.center.bean.HuPaiBean;
import majiang.algorithm.center.bean.OperationPaiBean;
import majiang.algorithm.center.bean.SingleRoundRealtimeDataBean;
import majiang.algorithm.center.bean.UserPaiBean;
import majiang.algorithm.center.service.MaJiangAlgorithmService;

public class Main {
	
	public static void main(String[] args) throws IOException {
		MaJiangAlgorithmService service = new MaJiangAlgorithmService();
//		List<String> pai = service.initAllPai();
//		
//		SingleRoundRealtimeDataBean dataBean = service.initHandPai(pai);
		
		//打印内存对象
		
		//每打一次牌都要刷新胡牌状态
		//小七对
//		UserPaiBean userPaiBean = new UserPaiBean();
//		List<String> handPai = new ArrayList<String>();
//		handPai.add("01");
//		handPai.add("02");
//		handPai.add("02");
//		handPai.add("03");
//		handPai.add("03");
//		handPai.add("04");
//		handPai.add("04");
//		handPai.add("05");
//		handPai.add("05");
//		handPai.add("06");
//		handPai.add("06");
//		handPai.add("13");
//		handPai.add("13");
//		userPaiBean.setHandPai(handPai);
//		
//		service.judgeUserCurrentStatus(userPaiBean);
		
		
		//两张余牌碰碰胡
//		UserPaiBean userPaiBean = new UserPaiBean();
//		List<String> handPai = new ArrayList<String>();
//		handPai.add("03");
//		userPaiBean.setHandPai(handPai);
//		
////		List<OperationedPaiBean> operationedPaiBeans = userPaiBean.getOperationedPaiBeans();
////		OperationedPaiBean operationedPaiBean = new OperationedPaiBean();
////		operationedPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_0);
////		operationedPaiBeans.add(operationedPaiBean);
////		userPaiBean.setOperationedPaiBeans(operationedPaiBeans);
////		userPaiBean.setOperationedPaiTypes("0");
//		service.judgeUserCurrentStatus(userPaiBean);
		
		
		
		//多张余牌碰碰胡
//		UserPaiBean userPaiBean = new UserPaiBean();
//		List<String> handPai = new ArrayList<String>();
//		handPai.add("01");
//		handPai.add("01");
//		handPai.add("02");
//		handPai.add("02");
//		handPai.add("03");
//		handPai.add("03");
//		handPai.add("04");
//		handPai.add("04");
//		userPaiBean.setHandPai(handPai);
//		
//		List<OperationedPaiBean> operationedPaiBeans = userPaiBean.getOperationedPaiBeans();
//		OperationedPaiBean operationedPaiBean = new OperationedPaiBean();
//		operationedPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_0);
//		operationedPaiBeans.add(operationedPaiBean);
//		userPaiBean.setOperationedPaiBeans(operationedPaiBeans);
//		userPaiBean.setOperationedPaiTypes("1");
//		service.judgeUserCurrentStatus(userPaiBean);
		
		//屁胡
//		UserPaiBean userPaiBean = new UserPaiBean();
//		List<String> handPai = new ArrayList<String>();
//		handPai.add("01");
//		handPai.add("02");
//		handPai.add("03");
//		handPai.add("05");
//		handPai.add("05");
//		handPai.add("12");
//		handPai.add("12");
//		handPai.add("12");
//		handPai.add("15");
//		handPai.add("15");
//		userPaiBean.setHandPai(handPai);
//		
//		service.judgeUserCurrentStatus(userPaiBean);
		
		//天听
//		while (true) {
//			List<String> pai = service.initAllPai();
//			SingleRoundRealtimeDataBean dataBean = service.initHandPai(pai);
//			if (dataBean.getUserPaiBeans()[0].getHuPaiBeans().size()>0) {
//				System.out.println("天听："+dataBean.getUserPaiBeans()[0].getHuPaiBeans().get(0).getPai());
//				System.out.println("天听："+dataBean.getUserPaiBeans()[0].getHuPaiBeans().get(0).getHuPaiType());
//				System.out.println("手牌为："+dataBean.getUserPaiBeans()[0].getHandPai());
//				break;
//			}
//		}
		
		
		
			List<String> pai = service.initAllPai();
			
			SingleRoundRealtimeDataBean dataBean = service.initHandPai(pai);
			
			//先让庄家摸一张牌
			String currPai = pai.get(0);
			dataBean.getUserPaiBeans()[0].getHandPai().add(currPai);
			//判断庄家是否能胡牌
			for (HuPaiBean huPaiBean : dataBean.getUserPaiBeans()[0].getHuPaiBeans()) {
				if (huPaiBean.getPai().equals(currPai)) {//如果有则天胡
					System.out.println("爸爸天胡了");
				}
			}
			System.out.println("当前手牌为：");
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < dataBean.getUserPaiBeans()[j].getHandPai().size(); i++) {
					System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(dataBean.getUserPaiBeans()[j].getHandPai().get(i))+" ");
				}
				System.out.println();
			}
			System.out.println();
			//等待输入
			for (int i = 1; i < 28; i++) {
				System.out.print((i-1)+" "+MaJiangConfigConstants.BASE_PAI_NAME.get(MaJiangConfigConstants.BASE_PAI_DISTINCT[i-1])+" ");
				if (i%9==0) {
					System.out.println();
				}
			}
			System.out.println("请打牌：");
			byte[] releasePaiB = new byte[2];
			System.in.read(releasePaiB);
			String releasePai = MaJiangConfigConstants.BASE_PAI_DISTINCT[Integer.parseInt((char)releasePaiB[0]+""+(char)releasePaiB[1])];
			System.out.println("要打掉的牌为："+MaJiangConfigConstants.BASE_PAI_NAME.get(releasePai));
			
			int currOpUserIndex = 0;
//			while (true) {
				//剩余三家判定是否能吃碰杠
				for (int i = 0; i < 4; i++) {
					if (currOpUserIndex==i) {//打牌的人直接跳过
						continue;
					}
					if (currOpUserIndex+1==i) {//下家可以吃碰杠
						service.judgeUserOperations(dataBean.getUserPaiBeans()[i], releasePai, 0);
						continue;
					}
					service.judgeUserOperations(dataBean.getUserPaiBeans()[i], releasePai, 1);
					//判定是否能胡牌
					service.judgeCanHuPai(dataBean.getUserPaiBeans()[i], releasePai);
				}
				//打印出所有人的信息
				int i  = currOpUserIndex+1;
				do {
					if (i==4) {
						i = 0;
					}
					if (currOpUserIndex==i) {//如果循环到刚刚打牌的用户则停止遍历
						break;
					}
					System.out.println("-----------------第"+(i+1)+"个用户信息------------------");
					System.out.println("手牌"+dataBean.getUserPaiBeans()[i].getHandPai());
					System.out.println();
					System.out.println("打掉的牌"+dataBean.getUserPaiBeans()[i].getReleasePai());
					System.out.println();
					System.out.print("已操作的牌:\t");
					for (int j = 0; j < dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().size(); j++) {
						System.out.print(MaJiangConfigConstants.operate_pai_type_name.get(dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().get(j).getOperateType())
								+" ");
						for (int j2 = 0; j2 < dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().get(j).getOperatePai().size(); j2++) {
							System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().get(j).getOperatePai().get(j2)));
						}
					}
					System.out.println();
					System.out.println();
					System.out.println("能操作的牌：");
					for (int j = 0; j < dataBean.getUserPaiBeans()[i].getOperationPaiBeans().size(); j++) {
						System.out.print(MaJiangConfigConstants.operate_pai_type_name.get(dataBean.getUserPaiBeans()[i].getOperationPaiBeans().get(j).getOperateType())
								+" ");
						for (int j2 = 0; j2 < dataBean.getUserPaiBeans()[i].getOperationPaiBeans().get(j).getOperatePai().size(); j2++) {
							System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(dataBean.getUserPaiBeans()[i].getOperationPaiBeans().get(j).getOperatePai().get(j2)));
						}
					}
					System.out.println();
					i++;
					//
					System.in.read(releasePaiB);
					releasePai = MaJiangConfigConstants.BASE_PAI_DISTINCT[Integer.parseInt((char)releasePaiB[0]+""+(char)releasePaiB[1])];
				} while (true);
				
//			}
		
	}

}
