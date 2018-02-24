package majiang.algorithm.center.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 麻将常用配置变量
 * @author yspc18
 *
 */
public class MaJiangConfigConstants {
	
	/**
	 * 基础麻将牌
	 */
	public static final String[] BASE_PAI = 
		{"01","02","03","04","05","06","07","08","09",
		 "01","02","03","04","05","06","07","08","09",
		 "01","02","03","04","05","06","07","08","09",
		 "01","02","03","04","05","06","07","08","09",
		 "11","12","13","14","15","16","17","18","19",
		 "11","12","13","14","15","16","17","18","19",
		 "11","12","13","14","15","16","17","18","19",
		 "11","12","13","14","15","16","17","18","19",
		 "21","22","23","24","25","26","27","28","29",
		 "21","22","23","24","25","26","27","28","29",
		 "21","22","23","24","25","26","27","28","29",
		 "21","22","23","24","25","26","27","28","29"};
	/**
	 * 牌名
	 */
	public static final Map<String, String> BASE_PAI_NAME = new HashMap<>();
	
	static{
		BASE_PAI_NAME.put("01", "一筒");
		BASE_PAI_NAME.put("02", "二筒");
		BASE_PAI_NAME.put("03", "三筒");
		BASE_PAI_NAME.put("04", "四筒");
		BASE_PAI_NAME.put("05", "五筒");
		BASE_PAI_NAME.put("06", "六筒");
		BASE_PAI_NAME.put("07", "七筒");
		BASE_PAI_NAME.put("08", "八筒");
		BASE_PAI_NAME.put("09", "九筒");
		BASE_PAI_NAME.put("11", "一条");
		BASE_PAI_NAME.put("12", "二条");
		BASE_PAI_NAME.put("13", "三条");
		BASE_PAI_NAME.put("14", "四条");
		BASE_PAI_NAME.put("15", "五条");
		BASE_PAI_NAME.put("16", "六条");
		BASE_PAI_NAME.put("17", "七条");
		BASE_PAI_NAME.put("18", "八条");
		BASE_PAI_NAME.put("19", "九条");
		BASE_PAI_NAME.put("21", "一万");
		BASE_PAI_NAME.put("22", "二万");
		BASE_PAI_NAME.put("23", "三万");
		BASE_PAI_NAME.put("24", "四万");
		BASE_PAI_NAME.put("25", "五万");
		BASE_PAI_NAME.put("26", "六万");
		BASE_PAI_NAME.put("27", "七万");
		BASE_PAI_NAME.put("28", "八万");
		BASE_PAI_NAME.put("29", "九万");
	}
	/**
	 * 操作牌类型：吃
	 */
	public static final int operate_pai_type_0 = 0;
	/**
	 * 操作牌类型：碰
	 */
	public static final int operate_pai_type_1 = 1;
	/**
	 * 操作牌类型：明杠
	 */
	public static final int operate_pai_type_2 = 2;
	/**
	 * 操作牌类型：暗杠
	 */
	public static final int operate_pai_type_3 = 3;

}
