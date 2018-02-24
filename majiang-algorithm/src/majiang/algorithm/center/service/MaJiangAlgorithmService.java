package majiang.algorithm.center.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import majiang.algorithm.center.base.MaJiangConfigConstants;
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
	public UserPaiBean[] initHandPai(List<String> pai){
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
		//ׯ���ٶ���һ��
		beans[0].getHandPai().add(pai.get(0));
		pai = pai.subList(1, pai.size());
		System.out.println("���ƺ������Ϊ��"+pai.size());
		System.out.println("���ƺ�ʣ������Ϊ��"+pai);
		for (int i = 0; i < beans.length; i++) {
			Collections.sort(beans[i].getHandPai());
			System.out.print("�û�"+(i+1)+"��������Ϊ��");
			for (int j = 0; j < beans[i].getHandPai().size(); j++) {
				System.out.print(MaJiangConfigConstants.BASE_PAI_NAME.get(beans[i].getHandPai().get(j))+" ");
			}
			System.out.println();
		}
		return beans;
	}

}
