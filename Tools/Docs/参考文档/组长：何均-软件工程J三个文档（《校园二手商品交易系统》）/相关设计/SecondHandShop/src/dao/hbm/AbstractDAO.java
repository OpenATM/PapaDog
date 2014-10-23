package dao.hbm;

public class AbstractDAO implements IDAO {

	protected Class _entityType;// 类实体信�?

	// 指定类名，装载类
	public void setEntityType(String typeName) {
		try {
			Class clazz = getClass().getClassLoader().loadClass(typeName);
			_entityType = clazz;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
