package majiang.algorithm.center.bean;

/**
 * ������Ϸʵʱ���ݻ������
 * @author yspc18
 *
 */
public class SingleRoundRealtimeDataBean {
	/**
	 * ���ֱ��
	 */
	private String _id;
	
	/**
	 * ��ǰ�ȴ��������û�
	 */
	private Integer currentUserInd;
	
	/**
	 * �û���Ϣ
	 */
	
	private UserPaiBean[] userPaiBeans;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Integer getCurrentUserInd() {
		return currentUserInd;
	}

	public void setCurrentUserInd(Integer currentUserInd) {
		this.currentUserInd = currentUserInd;
	}

	public UserPaiBean[] getUserPaiBeans() {
		return userPaiBeans;
	}

	public void setUserPaiBeans(UserPaiBean[] userPaiBeans) {
		this.userPaiBeans = userPaiBeans;
	}

}
