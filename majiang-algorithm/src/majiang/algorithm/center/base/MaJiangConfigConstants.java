package majiang.algorithm.center.base;

import java.util.HashMap;
import java.util.Map;

/**
 * �齫�������ñ���
 * @author yspc18
 *
 */
public class MaJiangConfigConstants {
	
	/**
	 * �����齫��
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
	 * ����
	 */
	public static final Map<String, String> BASE_PAI_NAME = new HashMap<>();
	
	static{
		BASE_PAI_NAME.put("01", "һͲ");
		BASE_PAI_NAME.put("02", "��Ͳ");
		BASE_PAI_NAME.put("03", "��Ͳ");
		BASE_PAI_NAME.put("04", "��Ͳ");
		BASE_PAI_NAME.put("05", "��Ͳ");
		BASE_PAI_NAME.put("06", "��Ͳ");
		BASE_PAI_NAME.put("07", "��Ͳ");
		BASE_PAI_NAME.put("08", "��Ͳ");
		BASE_PAI_NAME.put("09", "��Ͳ");
		BASE_PAI_NAME.put("11", "һ��");
		BASE_PAI_NAME.put("12", "����");
		BASE_PAI_NAME.put("13", "����");
		BASE_PAI_NAME.put("14", "����");
		BASE_PAI_NAME.put("15", "����");
		BASE_PAI_NAME.put("16", "����");
		BASE_PAI_NAME.put("17", "����");
		BASE_PAI_NAME.put("18", "����");
		BASE_PAI_NAME.put("19", "����");
		BASE_PAI_NAME.put("21", "һ��");
		BASE_PAI_NAME.put("22", "����");
		BASE_PAI_NAME.put("23", "����");
		BASE_PAI_NAME.put("24", "����");
		BASE_PAI_NAME.put("25", "����");
		BASE_PAI_NAME.put("26", "����");
		BASE_PAI_NAME.put("27", "����");
		BASE_PAI_NAME.put("28", "����");
		BASE_PAI_NAME.put("29", "����");
	}
	/**
	 * ���������ͣ���
	 */
	public static final int operate_pai_type_0 = 0;
	/**
	 * ���������ͣ���
	 */
	public static final int operate_pai_type_1 = 1;
	/**
	 * ���������ͣ�����
	 */
	public static final int operate_pai_type_2 = 2;
	/**
	 * ���������ͣ�����
	 */
	public static final int operate_pai_type_3 = 3;

}