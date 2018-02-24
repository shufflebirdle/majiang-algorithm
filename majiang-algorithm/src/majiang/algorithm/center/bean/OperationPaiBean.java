package majiang.algorithm.center.bean;

import java.util.ArrayList;
import java.util.List;

public class OperationPaiBean {
	
	/**
	 * ²Ù×÷ÀàĞÍ
	 */
	private Integer operateType;
	
	/**
	 * ÅÆ
	 */
	private List<String> operatePai = new ArrayList<String>();

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public List<String> getOperatePai() {
		return operatePai;
	}

	public void setOperatePai(List<String> operatePai) {
		this.operatePai = operatePai;
	}
	

}
