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
 * �齫���ķ���
 * @author yspc18
 *
 */
public class MaJiangAlgorithmService {
	
	/**
	 * �����ʼ��
	 * @return
	 */
	public List<String> initAllPai(){
		List<String> pai = Arrays.asList(MaJiangConfigConstants.BASE_PAI.clone());
		Collections.shuffle(pai);
		return pai;
	}
	
	/**
	 * ��ʼ������
	 * @return
	 */
	public SingleRoundRealtimeDataBean initHandPai(List<String> pai){
		
		SingleRoundRealtimeDataBean dataBean = new SingleRoundRealtimeDataBean();
		System.out.println("��ʼ����Ϊ��"+pai);
		UserPaiBean[] beans = new UserPaiBean[]{ new UserPaiBean(), new UserPaiBean(), new UserPaiBean(), new UserPaiBean()};
		for (int i = 0; i < 4; i++) {//������
			int size = i==3? 1 : 4;//����ǵ�������ֻ��һ��
			for (int j = 0; j < beans.length; j++) {
				beans[j].getHandPai().addAll(pai.subList(0, size));
				pai = pai.subList(size,pai.size());
				System.out.println("�û�"+(j+1)+"����Ϊ��"+beans[j].getHandPai());
			}
			System.out.println("��"+(i+1)+"�����ƺ�ʣ������Ϊ��"+pai);
		}
//		//ׯ���ٶ���һ��
//		beans[0].getHandPai().add(pai.get(0));
//		pai = pai.subList(1, pai.size());
		System.out.println("���ƺ������Ϊ��"+pai.size());
		System.out.println("���ƺ�ʣ������Ϊ��"+pai);
		for (int i = 0; i < beans.length; i++) {
			Collections.sort(beans[i].getHandPai());
			System.out.print("�û�"+(i+1)+"��������Ϊ��");
			for (int j = 0; j < beans[i].getHandPai().size(); j++) {
				System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(beans[i].getHandPai().get(j))+" ");
			}
			System.out.println();
			//�ж��Ƿ�����
			judgeUserCurrentStatus(beans[i]);
		}
		
		dataBean.setUserPaiBeans(beans);
		return dataBean;
	}
	/**
	 * ����
	 * @param pai
	 * @param userPaiBean
	 * @return
	 */
	public UserPaiBean getNewHandPai(List<String> pai,UserPaiBean userPaiBean){
		String newHandPai = pai.get(0);
		userPaiBean.getHandPai().add(newHandPai);
		pai = pai.subList(1, pai.size());
		System.out.println("���ƺ������Ϊ��"+pai.size());
		System.out.println("���ƺ�ʣ������Ϊ��"+pai);
		return userPaiBean;
	}
	
	/**
	 * �ж��û���ǰ�����Ĳ���
	 * @return
	 */
	public UserPaiBean judgeUserCurrentStatus(UserPaiBean userPaiBean){
		
		List<String> handPai = userPaiBean.getHandPai();
		
		List<HuPaiBean> huPaiBeans = new ArrayList<HuPaiBean>();
		
		//ѭ�����е��ƴ�һ��  ���Ƿ�ﵽ����Ч��
		//һ������ ��������������   Ȼ���Ƿ���
		for (int i = 0; i < 27; i++) {
			//����һ������
			List<String> tempPai = new ArrayList<String>(handPai);
			
			tempPai.add(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
			//����
			Collections.sort(tempPai);
			//���濴���߳��Ƿ�Ҫ��һ��
			System.out.println(tempPai);
			//�ж��߶�
			if (tempPai.size()==14) {//�������14��
				boolean flag = true;
				int j;
				for (j = 0; j < 14; j+=2) {
					if (!tempPai.get(j).equals(tempPai.get(j+1))) {
						System.out.println("�����");
						flag = false;
						break;
					}else {
						System.out.println("���");
					}
				}
				if (j>12&&flag) {
					HuPaiBean huPaiBean = new HuPaiBean();
					huPaiBean.setHuPaiType(0);
					huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
					//huPaiBean.setSize(size) //TODO  ��������Լ����ƺ��������ж�ʣ����
					huPaiBeans.add(huPaiBean);
					//С�߶�ֱ�ӽ�����ѭ
					System.out.println("�Һ�����"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
					break;
				}
			}
			
			{//������ 3*n+2
				//�����ϵĲ������Ʋ��������Ǹ�
//				List<OperationedPaiBean> operationPaiBeans = userPaiBean.getOperationedPaiBeans();
//				boolean flag = true;
//				for (OperationedPaiBean operationedPaiBean : operationPaiBeans) {
//					if (operationedPaiBean.getOperateType()==MaJiangConfigConstants.operate_pai_type_0) {
//						flag = false;
//						System.out.println("�����г���"+operationedPaiBean.getOperatePai());
//						break;
//					}
//				}
				if (userPaiBean.getOperationedPaiTypes().indexOf(MaJiangConfigConstants.operate_pai_type_0+"")==-1) {
					//���ֻ����������ֱ���ж����������Ƿ�һ��
					if (tempPai.size()==2&&tempPai.get(0).equals(tempPai.get(1))) {
						HuPaiBean huPaiBean = new HuPaiBean();
						huPaiBean.setHuPaiType(0);
						huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
						//huPaiBean.setSize(size) //TODO  ��������Լ����ƺ��������ж�ʣ����
						huPaiBeans.add(huPaiBean);
						//С�߶�ֱ�ӽ�����ѭ
						System.out.println("�Һ�����"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"������");
						break;
					}
					int _double = 0;
					int _triple = 0;
					String currPai;
					String prevPai = tempPai.get(0);
					for (int j = 1; j < tempPai.size(); j++) {
						currPai = tempPai.get(j);
						boolean isLastOne = j==(tempPai.size()-1);
						//�����ǰ�����Ƹ���һ������Ȳ��Ҹ���һ����Ҳ��ȣ���ô������ͬ�����һ��  
						if (currPai.equals(prevPai)) {
							if (isLastOne) {
								HuPaiBean huPaiBean = new HuPaiBean();
								huPaiBean.setHuPaiType(1);
								huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
								//huPaiBean.setSize(size) //TODO  ��������Լ����ƺ��������ж�ʣ����
								huPaiBeans.add(huPaiBean);
								System.out.println("�Һ�����"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"������");
								break;
							}else if (currPai.equals(tempPai.get(j+1))) {//�������һ��һ�¾�˵����������
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
							System.out.println("�������û��������"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
							break;
						}
						if (_double>1) {//������ŵĴ���1˵��û����
							System.out.println("�������û��������"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
							break;
						}
						if (isLastOne) {
							HuPaiBean huPaiBean = new HuPaiBean();
							huPaiBean.setHuPaiType(1);
							huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
							//huPaiBean.setSize(size) //TODO  ��������Լ����ƺ��������ж�ʣ����
							huPaiBeans.add(huPaiBean);
							System.out.println("�Һ�����"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"������");
							System.out.println("�����ĸ���Ϊ��"+_triple);
							
						}
					}
					
//					System.out.println("���Ÿ���"+_triple);
				}
//				else {
//					System.out.println("�����г���");
//				}
			}
			
			{//ƨ��
				//���ҽ�Ȼ��������Ƴ�
				Map<String, List<String>> leftPais = new HashMap<String, List<String>>();
				for (int j = 0; j < tempPai.size(); j++) {
					//�����ǰ�����Ƹ���һ����һ���Ļ���ô������������
					if (j!=(tempPai.size()-1)&&tempPai.get(j).equals(tempPai.get(j+1))&&MaJiangConfigConstants.JIANG_PAI.contains(tempPai.get(j))){
						List<String> leftPai = new ArrayList<String>(tempPai);
						leftPai.remove(j+1);
						leftPai.remove(j);
						leftPais.put(tempPai.get(j), leftPai);
						j+=1;
					}
				}
				System.out.println("��������������"+leftPais.keySet());
				
				for (String jiangPai : leftPais.keySet()) {
					System.out.println(jiangPai);
					//�Ƚ����������Ƴ�
					List<String> leftPai = leftPais.get(jiangPai);
					for (int j = 0; j < leftPai.size(); ) {//����϶������ı���
						if (MaJiangConfigConstants.BASE_PAI_DISTINCT[13].equals(jiangPai)&&i==4) {
							System.out.println("����ǰ�ƣ�"+i);
						}
						if (j+2<=(leftPai.size()-1)&&leftPai.get(j).equals(leftPai.get(j+1))&&leftPai.get(j).equals(leftPai.get(j+2))) {
							leftPai.remove(j);
							leftPai.remove(j);
							leftPai.remove(j);
						}else {
							j++;
						}
						System.out.println("ʣ����ƣ�"+leftPai);
					}
					//��˳��
					for (int j = 0; j < leftPai.size(); ) {
						//�õ���ǰ�Ƶ�λ��
						int first = leftPai.get(j).charAt(0)=='0' ? 0 : (leftPai.get(j).charAt(0)=='1' ? 1 : 2);
						int second = Integer.valueOf(leftPai.get(j).charAt(1)+"");
						int ind = first*9+second-1;
						//�����һ����������˳�����Ƴ�
						System.out.println(ind);
						if (j+2<=(leftPai.size()-1)&&//ʣ�����Ҫ���Դ��ڵ���������˳��
								(second<=6)&&//��ǰ�����Ϊ7
								leftPai.get(j+1).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+1])
								&&leftPai.get(j+2).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+2])) {
							leftPai.remove(j);
							leftPai.remove(j);
							leftPai.remove(j);
							System.out.println("ʣ����ƣ�"+leftPai);
							System.out.println("j:"+j);
						}else if (j+5<=(leftPai.size()-1)&&//ʣ�����Ҫ���Դ��ڵ���������˳��
								(second<=6)&&//��ǰ�����Ϊ7
								leftPai.get(j+2).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+1])
								&&leftPai.get(j+4).equals(MaJiangConfigConstants.BASE_PAI_DISTINCT[ind+2])) {
							leftPai.remove(j+4);
							leftPai.remove(j+2);
							leftPai.remove(j);
						}else {
							System.out.println("���Ǻ���");
							break;
						}
					}
					System.out.println(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
					if (leftPai.size()==0) {//����Ʊ��������ô��˵�������ƿ��Ժ�
						HuPaiBean huPaiBean = new HuPaiBean();
						huPaiBean.setHuPaiType(1);
						huPaiBean.setPai(MaJiangConfigConstants.BASE_PAI_DISTINCT[i]);
						//huPaiBean.setSize(size) //TODO  ��������Լ����ƺ��������ж�ʣ����
						huPaiBeans.add(huPaiBean);
						System.out.println("----------------------------------------------�Һ�����"+MaJiangConfigConstants.BASE_PAI_DISTINCT[i]+"ƨ��");
					}
				}
			}
		}
		userPaiBean.setHuPaiBeans(huPaiBeans);
		return userPaiBean;
	}
	/**
	 * �ж��û����ԶԴ�������ƵĲ���
	 * @param userPaiBean
	 * @param releasePai �������
	 * @param ind  0 �¼� 1 ���¼�
	 */
	public void judgeUserOperations(UserPaiBean userPaiBean,String releasePai,int ind){
		if (ind==0) {//�¼��ж��Ƿ��ܳ�
			//���ó�ͬ������
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
			//ѡ������
			String prevPrevInd = String.valueOf(Integer.valueOf(endInd)-2);
			String prevInd = String.valueOf(Integer.valueOf(endInd)-1);
			String nextInd = String.valueOf(Integer.valueOf(endInd)+1);
			String nextNextInd = String.valueOf(Integer.valueOf(endInd)+2);
			String distinctSameTypePai = sb.toString();
			//�����������һ��
			if (distinctSameTypePai.indexOf(prevPrevInd)!=-1
					&&distinctSameTypePai.indexOf(prevInd)!=-1) {
				OperationPaiBean operationPaiBean = new OperationPaiBean();
				operationPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_0);
				operationPaiBean.getOperatePai().add(startInd+prevPrevInd);
				operationPaiBean.getOperatePai().add(startInd+prevInd);
				operationPaiBean.getOperatePai().add(startInd+endInd);
				userPaiBean.getOperationPaiBeans().add(operationPaiBean);
			}
			//�����м�
			if (distinctSameTypePai.indexOf(prevInd)!=-1
					&&distinctSameTypePai.indexOf(nextInd)!=-1) {
				OperationPaiBean operationPaiBean = new OperationPaiBean();
				operationPaiBean.setOperateType(MaJiangConfigConstants.operate_pai_type_0);
				operationPaiBean.getOperatePai().add(startInd+prevInd);
				operationPaiBean.getOperatePai().add(startInd+endInd);
				operationPaiBean.getOperatePai().add(startInd+nextInd);
				userPaiBean.getOperationPaiBeans().add(operationPaiBean);
			}
			//����ǰ��
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
		//�ж��Ƿ�����
		//������һ����
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
	 * �ж��û��Ƿ���Ժ����˴��������
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
