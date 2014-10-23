package common.impl;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.interf.IJValidator;



public class JValidatorImpl implements IJValidator {
	private Pattern pattern;
	private Matcher matcher;

	/*
	 * 验证空
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateEmpty(String str) {
		if (null == str || "".equals(str))
			return false;
		return true;
	}

	/*
	 * 检查内容攻击注入
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateAttack(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "<(img|iframe|script)[\\w| ]*(src) *=";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return false;
		return true;
	}

	/*
	 * 检查内容过滤
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateLaw(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "(法 *轮 *功|独 *立|激 *情|暴 *力|裸 *体)";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return false;
		return true;
	}

	/*
	 * 检查URL
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateUrl(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "/^(https?|ftp):\\/\\/(((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)(:\\d*)?)(\\/((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)+(\\/(([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)*)*)?)?(\\?((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(\\#((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		return false;
	}

	/*
	 * 检查IP
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateIp(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "^(([01]\\d{2})|(2(([0-4]\\d)|5[0-5]))|\\d{1,2})(\\.(([01]\\d{2})|(2(([0-4]\\d)|5[0-5]))|\\d{1,2})){3}$";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		return false;
	}

	/*
	 * 检查固定电话
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateTel(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "^0\\d{2,3}-[1-9]\\d{6,7}$";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		return false;
	}

	/*
	 * 检查电子邮箱
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMail(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?$";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		return false;
	}

	/*
	 * 检查移动电话
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMobile(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "^1[358]\\d{9}$";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		return false;
	}

	/*
	 * 检查身份证号
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateIDNo(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X)?$";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		return false;
	}

	/*
	 * 检查邮编
	 * 
	 * @param str 检测的字符串
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateZipcode(String str) {
		if (str == null || str.length() == 0)
			return true;
		String scontent = "^\\d{6}$";
		pattern = Pattern.compile(scontent);
		matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		return false;
	}

	/*
	 * 检查长度范围
	 * 
	 * @param str 检测的字符串 len1 最短长度 len2 最大长度
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateBetweenLength(String str, int len1, int len2) {
		if (null == str)
			return true;
		int len = str.length();
		if (len >= len1 && len <= len2)
			return true;
		return false;
	}

	/*
	 * 检查最大长度
	 * 
	 * @param str 检测的字符串 len1 最大长度
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMaxLength(String str, int len1) {
		if (null == str)
			return true;
		int len = str.length();
		if (len <= len1)
			return true;
		return false;
	}

	/*
	 * 检查最短长度
	 * 
	 * @param str 检测的字符串 len1 最短长度
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMinLength(String str, int len1) {
		if (null == str)
			return true;
		int len = str.length();
		if (len >= len1)
			return true;
		return false;
	}

	/*
	 * 检查值范围
	 * 
	 * @param v 要检测的值 min 最小值 max 最大值
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateBetween(double v, double min, double max) {
		if (v >= min && v <= max)
			return true;
		return false;
	}

	/*
	 * 检查最小值
	 * 
	 * @param v 要检测的值 min 最小值 max 最大值
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMin(double v, double min) {
		if (v >= min)
			return true;
		return false;
	}

	/*
	 * 检查最大值
	 * 
	 * @param v 要检测的值 min 最小值
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMax(double v, double max) {
		if (v <= max)
			return true;
		return false;
	}

	/*
	 * 检查值范围
	 * 
	 * @param v 要检测的值 min 最小值 max 最大值
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateBetween(int v, int min, int max) {
		if (v >= min && v <= max)
			return true;
		return false;
	}

	/*
	 * 检查最小值
	 * 
	 * @param v 要检测的值 min 最小值 max 最大值
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMin(int v, int min) {
		if (v >= min)
			return true;
		return false;
	}

	/*
	 * 检查最大值
	 * 
	 * @param v 要检测的值 min 最小值
	 * 
	 * @return 通过 true 没通过 false
	 */
	public boolean validateMax(int v, int max) {
		if (v <= max)
			return true;
		return false;
	}
}
