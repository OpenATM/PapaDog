package domain.model;

import java.io.Serializable;

public class BaseDTO implements Serializable {
  protected String idStr;

public String getIdStr() {
	return idStr;
}

public void setIdStr(String idStr) {
	this.idStr = idStr;
}
}
