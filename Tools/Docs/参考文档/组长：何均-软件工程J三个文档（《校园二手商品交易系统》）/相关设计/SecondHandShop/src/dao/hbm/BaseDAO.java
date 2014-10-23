package dao.hbm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

//import com.ebookstore.common.HibernateSessionFactory;
import domain.model.BaseDTO;
import exception.SecondHandShopException;

public class BaseDAO extends AbstractDAO {
	// hibernate会话对象
	//private static Session session = HibernateSessionFactory.getCurrentSession();
    private static Session session=HibernateUtils.getSession(); 
	private static BaseDAO baseDAO=null;
    public BaseDAO() {
		super();
	}
    /*
     * ���baseDao 
     */
    public static BaseDAO getBaseDAO(){
    	if(baseDAO==null){
    		baseDAO=new BaseDAO();
    	}
    	return baseDAO;
    }

	/**
	 * ���
	 * 
	 * @param object
	 * @return
	 * @throws SecondHandShopException
	 */
	public BaseDTO addObject(final BaseDTO object) throws SecondHandShopException {
		if (object == null)
			throw new SecondHandShopException("�޷���Ӷ���The Object is null");
		session.save(object);
		session.close();
		return object;
	}

	/**
	 * ����ʵ����ɾ����
	 * 
	 * @param object
	 *            要删除的对象
	 * @throws SecondHandShopException
	 */
	public void deleteObject(final BaseDTO object) throws SecondHandShopException {
		if (object == null)
			throw new SecondHandShopException("The Object is null");
		session.delete(object);
		session.close();
	}

	/**
	 * 
	 * ����Id����ɾ����
	 * @param id
	 *            删除类型的id
	 * @param clazz
	 *            删除的类�?
	 * @throws SecondHandShopException
	 */
	public void deleteObject(int id, Class clazz) throws SecondHandShopException {
		Object object = session.load(clazz, new Integer(id));
		if (object == null)
			throw new SecondHandShopException("�޷�ɾ�����The Object is null");
		session.delete(object);
		session.close();
	}

	/**
	 * ���¶���
	 * 
	 * @param object
	 * @return
	 * @throws SecondHandShopException
	 */
	public BaseDTO updateObject(BaseDTO object) throws SecondHandShopException {
		if (object == null)
			throw new SecondHandShopException("�޷����¶���The Object is null");
		session.update(object);
		session.close();
		return object;
	}

	/**
	 * �������£�
	 * 
	 * @param object
	 * @return
	 * @throws SecondHandShopException
	 */
	public BaseDTO saveOrUpdate(BaseDTO object) throws SecondHandShopException {
		if (object == null)
			throw new SecondHandShopException("�޷����¶���The Object is null");
		session.saveOrUpdate(object);
		session.flush();
		return object;
	}

	/**
	 * ִ��sql�ʾ�
	 * 
	 * @param sql
	 */
	public void executeSql(String sql) {
		executeSql(sql, null);
	}

	/**
	 * ����ͬ����ִ��sql��䣬���Ϊprocedure,��ִ�д洢���̡�
	 * 
	 * @param sql
	 * @param sqltype
	 */
	@SuppressWarnings("deprecation")
	public void executeSql(String sql, String sqltype) {
		try {
			Connection con = session.connection();
			sqltype = (sqltype == null) ? "sqlstmt" : sqltype;
			if (sqltype.equals("procedure")) {
				CallableStatement cstmt = con.prepareCall(sql);
				cstmt.executeUpdate();
			} else {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.executeUpdate();
			}
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ͨ��id(String)�����Ͳ��Ҷ���
	 * 
	 * @param id
	 * @param dtoclass
	 * @return
	 */
	public Object findById(String id, Class dtoclass) {
		Object obj = session.get(dtoclass, id);
		session.flush();
		return obj;
	}

	/**
	 *ͨ��id��int�������Ͳ��Ҷ���
	 * 
	 * @param id
	 * @param dtoclass
	 * @return
	 */
	public Object findById(int id, Class dtoclass) {
		Object obj = session.get(dtoclass, new Integer(id));
		session.flush();
		return obj;
	}

	/**
	 * ͨ��HQL��ѯ
	 * 
	 * @param hql
	 * @return
	 */
	public List findByHql(String hql) {
		Query q = session.createQuery(hql);
		return q.list();
	}

	/**
	 * ͨ��HQL��ѯ�����ҿ��Կ�ʼ�ļ�¼�����ļ�¼����
	 * 
	 * @param hql
	 * @param firstValue
	 * @param maxValue
	 * @return
	 */
	public List findByHql(String hql, int firstValue, int maxValue) {
		Query q = session.createQuery(hql);
		q.setMaxResults(maxValue);
		q.setFirstResult(firstValue);
		return q.list();
	}
}
