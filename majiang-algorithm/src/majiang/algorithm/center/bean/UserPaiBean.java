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
	
	/**
	 * 用户操作过的牌，比如碰，吃，杠
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
