package majiang.algorithm.center.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户牌对象
 * @author yspc18
 *
 */
public class UserPaiBean {
	
	/**
	 * 用户手牌
	 */
	private List<String> handPai = new ArrayList<String>();
	
	/**
	 * 用户打出去的牌
	 */
	private List<String> releasePai = new ArrayList<String>();
	
//	/**
//	 * 用户能胡的牌
//	 */
//	private List<String> huPai = new ArrayList<String>();
	
	/**
	 * 能胡的牌
	 */
	private List<HuPaiBean> huPaiBeans = new ArrayList<HuPaiBean>();
	
	
	/**
	 * 当其它用户打出牌时用户能操作的牌
	 */
	private List<OperationPaiBean> operationPaiBeans = new ArrayList<OperationPaiBean>();
	
	/**
	 * 用户操作过的牌，比如碰，吃，杠
	 */
	private List<OperationPaiBean> operationedPaiBeans = new ArrayList<OperationPaiBean>();
	
	/**
	 * 操作过的牌型
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
