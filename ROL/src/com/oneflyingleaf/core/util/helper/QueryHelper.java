package com.oneflyingleaf.core.util.helper;

public interface QueryHelper {
	public static final String ORDER_BY_DESC = "DESC";
	public static final String ORDER_BY_ASC = "ASC";
	/**
	 * ��Ӳ�ѯ����
	 * @param condition ��ѯ���� ��Ҫ��� = ��like�Ȳ�ѯ����
	 * @param value ֵ ,û��ֵʱ����Ϊnull
	 */
	void addCondition(String condition,Object value);

	/**
	 * ��Ӳ�ѯ����,����value��ֵ������֤��check Ϊtrueʱ��valueΪnull����Ϊ"",����Ӳ�ѯ����
	 * @param condition
	 * @param value 
	 * @param check false ����֤��true ��֤
	 */
	void addCondition(String condition, Object value,boolean check);
	/**
	 * �������
	 * @param filed
	 * @param seq
	 */
	void addOrderBy(String filed,String seq);
	
	/**
	 * �õ���ѯ���
	 * @return
	 */
	String getHQL();
	
	/**
	 * �õ���ѯ��������Ӧ��ֵ
	 * @return
	 */
	Object[] getValue();
	
}
