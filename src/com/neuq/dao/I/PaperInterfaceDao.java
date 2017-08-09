package com.neuq.dao.I;

import java.util.List;

import com.neuq.bean.Paper;



/**
 * �Ծ����ݿ�ӿ���
 *
 */
public interface PaperInterfaceDao {


	/**
	 * ����һ���Ծ�
	 * @param paper
	 * @return
	 */
	public boolean insert(Paper paper);
	
	/**
	 * ɾ��һ���Ծ�
	 * @param paper
	 * @return
	 */
	public boolean delete(Paper paper);
	
	/**
	 * �����޸�һ���Ծ�
	 * @param paper
	 * @return
	 */
//	public boolean update(Paper paper);
	
	/**
	 * ��ѯȫ���Ծ�
	 * @param ��
	 * @return  Paper �Ծ���
	 */
	public List<Paper> select();
	
	/**
	 * ��֪ʶ���ѯ�Ծ�
	 * @param questionpoint
	 * @return  Paper �Ծ���
	 */
	public List<Paper> select(String questionpoint);
	/**
	 * ֮ǰ�Ѿ������Ŀ���
	 * @return
	 */
	public List<Paper> showbeforePaper();
	/**
	 * ��Ҫ���еĿ���
	 * @return
	 */
	public List<Paper> showafterPaper();
	/**
	 * ���ڽ��еĿ���
	 * @return
	 */
	public List<Paper> shownowPaper();
	
	/**
	 * �����Ծ������ҵ�ǰ��Ӧ���Ծ����
	 * @param papername
	 * @return  Paper ����
	 */
	public Paper selectInstance(String papername);
}