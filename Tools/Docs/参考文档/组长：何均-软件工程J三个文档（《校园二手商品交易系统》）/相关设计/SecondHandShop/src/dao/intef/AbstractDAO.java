package dao.intef;

public class AbstractDAO implements IDAO{
    protected Class _entityType;//��ʵ����Ϣ��
    
    public void setEntityType(String typeName){
    	try{
    		Class clazz=getClass().getClassLoader().loadClass(typeName);
    		_entityType=clazz;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
