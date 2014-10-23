package common.interf;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public interface IServletHandle {
	public int writeToClient(HttpServletResponse res,String msgs);      	//把信息写回客户端
	public int writeToClient(HttpServletResponse res,JSONObject jobj);  	//把json对象写回客户端
	public Map changeParamMap(Map paramMap);								//把paramterMap转换成标准map
}
