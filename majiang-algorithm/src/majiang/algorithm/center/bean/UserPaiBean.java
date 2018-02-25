package majiang.algorithm.center.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * �û��ƶ���
 * @author yspc18
 *
 */
public class UserPaiBean {
	
	/**
	 * �û�����
	 */
	private List<String> handPai = new ArrayList<String>();
	
	/**
	 * �û����ȥ����
	 */
	private List<String> releasePai = new ArrayList<String>();
	
//	/**
//	 * �û��ܺ�����
//	 */
//	private List<String> huPai = new ArrayList<String>();
	
	/**
	 * �ܺ�����
	 */
	private List<HuPaiBean> huPaiBeans = new ArrayList<HuPaiBean>();
	
	
	/**
	 * �������û������ʱ�û��ܲ�������
	 */
	private List<OperationPaiBean> operationPaiBeans = new ArrayList<OperationPaiBean>();
	
	/**
	 * �û����������ƣ����������ԣ���
	 */
	private List<OperationPaiBean> operationedPaiBeans = new ArrayList<OperationPaiBean>();
	
	/**
	 * ������������
	 */
	
	private String operationedPaiTypes="";

	public List<String> getHandPai() {
		return handPai;
	}

	public void setHandPai(List<String> handPai) {
		this.handPai = handPai;
	}

	public List<String> getReleasePai() {
		return releasePai;
	}

	public void setReleasePai(List<String> releasePai) {
		this.releasePai = releasePai;
	}
	
	

//	public List<String> getHuPai() {
//		return huPai;
//	}
//
//	public void setHuPai(List<String> huPai) {
//		this.huPai = huPai;
//	}

	public List<OperationPaiBean> getOperationedPaiBeans() {
		return operationedPaiBeans;
	}

	public void setOperationedPaiBeans(List<OperationPaiBean> operationedPaiBeans) {
		this.operationedPaiBeans = operationedPaiBeans;
	}

	public List<OperationPaiBean> getOperationPaiBeans() {
		return operationPaiBeans;
	}

	public void setOperationPaiBeans(List<OperationPaiBean> operationPaiBeans) {
		this.operationPaiBeans = operationPaiBeans;
	}

	public List<HuPaiBean> getHuPaiBeans() {
		return huPaiBeans;
	}

	public void setHuPaiBeans(List<HuPaiBean> huPaiBeans) {
		this.huPaiBeans = huPaiBeans;
	}

	public String getOperationedPaiTypes() {
		return operationedPaiTypes;
	}

	public void setOperationedPaiTypes(String operationedPaiTypes) {
		this.operationedPaiTypes = operationedPaiTypes;
	}

}
