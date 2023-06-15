package custmer_ex;

public class CustMemberVO {
private int custNum;
private String custName;
private String custAddr;
private String custTel;
private String custEmail;

public CustMemberVO() {
	super();
}

public CustMemberVO(String custName, String custAddr, String custTel, String custEmail) {
	super();
	this.custName = custName;
	this.custAddr = custAddr;
	this.custTel = custTel;
	this.custEmail = custEmail;
}




public CustMemberVO(int custNum, String custName, String custAddr, String custTel, String custEmail) {
	super();
	this.custNum = custNum;
	this.custName = custName;
	this.custAddr = custAddr;
	this.custTel = custTel;
	this.custEmail = custEmail;
}

public int getCustNum() {
	return custNum;
}

public void setCustNum(int custNum) {
	this.custNum = custNum;
}

public String getCustName() {
	return custName;
}

public void setCustName(String custName) {
	this.custName = custName;
}

public String getCustAddr() {
	return custAddr;
}

public void setCustAddr(String custAddr) {
	this.custAddr = custAddr;
}

public String getCustTel() {
	return custTel;
}

public void setCustTel(String custTel) {
	this.custTel = custTel;
}

public String getCustEmail() {
	return custEmail;
}

public void setCustEmail(String custEmail) {
	this.custEmail = custEmail;
}

@Override
public String toString() {
	return "CustMemberVO [custNum=" + custNum + ", custName=" + custName + ", custAddr=" + custAddr + ", custTel="
			+ custTel + ", custEmail=" + custEmail + "]";
}


}
