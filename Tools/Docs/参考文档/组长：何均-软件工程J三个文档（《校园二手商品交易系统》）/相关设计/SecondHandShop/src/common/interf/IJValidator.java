package common.interf;

public interface IJValidator {
	public boolean validateEmpty(String str);
	public boolean validateAttack(String str);
	public boolean validateLaw(String str);
	public boolean validateUrl(String str);
	public boolean validateIp(String str);
	public boolean validateTel(String str);
	public boolean validateMail(String str);
	public boolean validateMobile(String str);
	public boolean validateIDNo(String str);
	public boolean validateZipcode(String str);
	public boolean validateBetweenLength(String str,int len1,int len2);
	public boolean validateMaxLength(String str,int len1);
	public boolean validateMinLength(String str,int len1);
	public boolean validateBetween(double v,double min,double max);
	public boolean validateMin(double v,double min);
	public boolean validateMax(double v,double max);
	public boolean validateBetween(int v,int min,int max);
	public boolean validateMin(int v,int min);
	public boolean validateMax(int v,int max);
}
