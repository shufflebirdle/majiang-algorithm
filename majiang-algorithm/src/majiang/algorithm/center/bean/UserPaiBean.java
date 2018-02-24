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
	
	/**
	 * �û����������ƣ����������ԣ���
	 */
	private List<OperationPaiBean> operationPaiBeans = new ArrayList<OperationPaiBean>();

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

	public List<OperationPaiBean> getOperationPaiBeans() {
		return operationPaiBeans;
	}

	public void setOperationPaiBeans(List<OperationPaiBean> operationPaiBeans) {
		this.operationPaiBeans = operationPaiBeans;
	}

}
