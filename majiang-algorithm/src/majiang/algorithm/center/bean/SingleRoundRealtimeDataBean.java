package majiang.algorithm.center.bean;

/**
 * 单局游戏实时数据缓存对象
 * @author yspc18
 *
 */
public class SingleRoundRealtimeDataBean {
	/**
	 * 单局编号
	 */
	private String _id;
	
	/**
	 * 当前等待操作的用户
	 */
	private Integer currentUserInd;
	
	/**
	 * 用户信息
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
