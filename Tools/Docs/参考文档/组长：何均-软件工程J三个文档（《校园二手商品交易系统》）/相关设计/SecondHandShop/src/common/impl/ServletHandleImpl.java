package common.impl;



import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import common.interf.IServletHandle;


import net.sf.json.JSONObject;


public class ServletHandleImpl implements IServletHandle{
	/*
	 * 把消息写回客户端
	 * @param	res resonse对象
	 * 			msgs 要写回的消息
	 */
	public int writeToClient(HttpServletResponse res,String msgs){
		res.setContentType("text/json; charset=UTF-8");
		try{
	    	PrintWriter out = res.getWriter();
	    	out.print(msgs);
	    }catch(Exception e){}
	    return 1;
	}
	/*
	 * 把JSON对象写回客户端
	 * @param	res resonse对象
	 * 			jobj json对象 
	 */
	public int writeToClient(HttpServletResponse res,JSONObject jobj){
		if(null == jobj || jobj.isEmpty())
			return 0;
		res.setContentType("text/json; charset=UTF-8");
		try{
	    	PrintWriter out = res.getWriter();
	    	out.print("{result:0,msgs:" + jobj.toString() + "}");
	    }catch(Exception e){}
	    return 1;
	}
	/*
	 * 转换parameterMap对象，由于每个值是string[]，转换成string 
	 * @param	paramMap request.getParameterMap对象
	 * @return	转换后的对象			
	 */
	public Map changeParamMap(Map paramMap){
		Map<Object, String> map = new HashMap<Object,String>();
		for(Iterator iter = paramMap.entrySet().iterator();iter.hasNext();){ 
			Map.Entry element = (Map.Entry)iter.next(); 
			Object key = element.getKey(); 
			String[] value=(String[])element.getValue(); 
			int len = value.length;
			String v = "";
			for(int i=0;i<len;i++){ 
				v += value[i];
			}
			map.put(key, v);
		}
		return map;
	}
}
