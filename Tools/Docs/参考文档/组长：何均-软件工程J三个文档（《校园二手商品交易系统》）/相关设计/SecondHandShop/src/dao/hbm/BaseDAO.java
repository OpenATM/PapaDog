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
	// hibernate浼氳瘽瀵硅薄
	//private static Session session = HibernateSessionFactory.getCurrentSession();
    private static Session session=HibernateUtils.getSession(); 
	private static BaseDAO baseDAO=null;
    public BaseDAO() {
		super();
	}
    /*
     * 获得baseDao 
     */
    public static BaseDAO getBaseDAO(){
    	if(baseDAO==null){
    		baseDAO=new BaseDAO();
    	}
    	return baseDAO;
    }

	/**
	 * 添加
	 * 
	 * @param object
	 * @return
	 * @throws SecondHandShopException
	 */
	public BaseDTO addObject(final BaseDTO object) throws SecondHandShopException {
		if (object == null)
			throw new SecondHandShopException("锟睫凤拷锟斤拷佣锟斤拷锟絋he Object is null");
		session.save(object);
		session.close();
		return object;
	}

	/**
	 * 根据实体作删除；
	 * 
	 * @param object
	 *            瑕佸垹闄ょ殑瀵硅薄
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
	 * 根据Id号作删除；
	 * @param id
	 *            鍒犻櫎绫诲瀷鐨刬d
	 * @param clazz
	 *            鍒犻櫎鐨勭被鍨?
	 * @throws SecondHandShopException
	 */
	public void deleteObject(int id, Class clazz) throws SecondHandShopException {
		Object object = session.load(clazz, new Integer(id));
		if (object == null)
			throw new SecondHandShopException("锟睫凤拷删锟斤拷锟斤拷锟絋he Object is null");
		session.delete(object);
		session.close();
	}

	/**
	 * 更新对象
	 * 
	 * @param object
	 * @return
	 * @throws SecondHandShopException
	 */
	public BaseDTO updateObject(BaseDTO object) throws SecondHandShopException {
		if (object == null)
			throw new SecondHandShopException("锟睫凤拷锟斤拷锟铰讹拷锟斤拷The Object is null");
		session.update(object);
		session.close();
		return object;
	}

	/**
	 * 保存或更新；
	 * 
	 * @param object
	 * @return
	 * @throws SecondHandShopException
	 */
	public BaseDTO saveOrUpdate(BaseDTO object) throws SecondHandShopException {
		if (object == null)
			throw new SecondHandShopException("锟睫凤拷锟斤拷锟铰讹拷锟斤拷The Object is null");
		session.saveOrUpdate(object);
		session.flush();
		return object;
	}

	/**
	 * 执行sql词句
	 * 
	 * @param sql
	 */
	public void executeSql(String sql) {
		executeSql(sql, null);
	}

	/**
	 * 按不同类型执行sql语句，如果为procedure,则执行存储过程。
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
	 * 通过id(String)和类型查找对象；
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
	 *通过id（int）和类型查找对象；
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
	 * 通过HQL查询
	 * 
	 * @param hql
	 * @return
	 */
	public List findByHql(String hql) {
		Query q = session.createQuery(hql);
		return q.list();
	}

	/**
	 * 通过HQL查询，并且可以开始的记录和最大的记录数。
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
