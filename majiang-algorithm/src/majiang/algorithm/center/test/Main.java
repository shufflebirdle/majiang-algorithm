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
		
		//��ӡ�ڴ����
		
		//ÿ��һ���ƶ�Ҫˢ�º���״̬
		//С�߶�
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
		
		
		//��������������
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
		
		
		
		//��������������
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
		
		//ƨ��
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
		
		//����
//		while (true) {
//			List<String> pai = service.initAllPai();
//			SingleRoundRealtimeDataBean dataBean = service.initHandPai(pai);
//			if (dataBean.getUserPaiBeans()[0].getHuPaiBeans().size()>0) {
//				System.out.println("������"+dataBean.getUserPaiBeans()[0].getHuPaiBeans().get(0).getPai());
//				System.out.println("������"+dataBean.getUserPaiBeans()[0].getHuPaiBeans().get(0).getHuPaiType());
//				System.out.println("����Ϊ��"+dataBean.getUserPaiBeans()[0].getHandPai());
//				break;
//			}
//		}
		
		
		
			List<String> pai = service.initAllPai();
			
			SingleRoundRealtimeDataBean dataBean = service.initHandPai(pai);
			
			//����ׯ����һ����
			String currPai = pai.get(0);
			dataBean.getUserPaiBeans()[0].getHandPai().add(currPai);
			//�ж�ׯ���Ƿ��ܺ���
			for (HuPaiBean huPaiBean : dataBean.getUserPaiBeans()[0].getHuPaiBeans()) {
				if (huPaiBean.getPai().equals(currPai)) {//����������
					System.out.println("�ְ������");
				}
			}
			System.out.println("��ǰ����Ϊ��");
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < dataBean.getUserPaiBeans()[j].getHandPai().size(); i++) {
					System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(dataBean.getUserPaiBeans()[j].getHandPai().get(i))+" ");
				}
				System.out.println();
			}
			System.out.println();
			//�ȴ�����
			for (int i = 1; i < 28; i++) {
				System.out.print((i-1)+" "+MaJiangConfigConstants.BASE_PAI_NAME.get(MaJiangConfigConstants.BASE_PAI_DISTINCT[i-1])+" ");
				if (i%9==0) {
					System.out.println();
				}
			}
			System.out.println("����ƣ�");
			byte[] releasePaiB = new byte[2];
			System.in.read(releasePaiB);
			String releasePai = MaJiangConfigConstants.BASE_PAI_DISTINCT[Integer.parseInt((char)releasePaiB[0]+""+(char)releasePaiB[1])];
			System.out.println("Ҫ�������Ϊ��"+MaJiangConfigConstants.BASE_PAI_NAME.get(releasePai));
			
			int currOpUserIndex = 0;
//			while (true) {
				//ʣ�������ж��Ƿ��ܳ�����
				for (int i = 0; i < 4; i++) {
					if (currOpUserIndex==i) {//���Ƶ���ֱ������
						continue;
					}
					if (currOpUserIndex+1==i) {//�¼ҿ��Գ�����
						service.judgeUserOperations(dataBean.getUserPaiBeans()[i], releasePai, 0);
						continue;
					}
					service.judgeUserOperations(dataBean.getUserPaiBeans()[i], releasePai, 1);
					//�ж��Ƿ��ܺ���
					service.judgeCanHuPai(dataBean.getUserPaiBeans()[i], releasePai);
				}
				//��ӡ�������˵���Ϣ
				int i  = currOpUserIndex+1;
				do {
					if (i==4) {
						i = 0;
					}
					if (currOpUserIndex==i) {//���ѭ�����ոմ��Ƶ��û���ֹͣ����
						break;
					}
					System.out.println("-----------------��"+(i+1)+"���û���Ϣ------------------");
					System.out.println("����"+dataBean.getUserPaiBeans()[i].getHandPai());
					System.out.println();
					System.out.println("�������"+dataBean.getUserPaiBeans()[i].getReleasePai());
					System.out.println();
					System.out.print("�Ѳ�������:\t");
					for (int j = 0; j < dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().size(); j++) {
						System.out.print(MaJiangConfigConstants.operate_pai_type_name.get(dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().get(j).getOperateType())
								+" ");
						for (int j2 = 0; j2 < dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().get(j).getOperatePai().size(); j2++) {
							System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(dataBean.getUserPaiBeans()[i].getOperationedPaiBeans().get(j).getOperatePai().get(j2)));
						}
					}
					System.out.println();
					System.out.println();
					System.out.println("�ܲ������ƣ�");
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
