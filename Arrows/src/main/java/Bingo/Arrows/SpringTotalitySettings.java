package Bingo.Arrows;

public class SpringTotalitySettings {
	 
	public String HubURL;
	private String driver; 
	private final String jdbc = "jdbc:mysql://192.168.230.132:3306/bingoboxdeplyrecord";
	private final String dbTree = "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String MySQLURL = jdbc+dbTree;
	private String userName;
	private String pwd;
	public String getHubURL() {
		return HubURL;
	}
	public void setHubURL(String hubURL) {
		HubURL = hubURL;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getMySQLURL() {
		return MySQLURL;
	}
	public void setMySQLURL(String mySQLURL) {
		MySQLURL = mySQLURL;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getJdbc() {
		return jdbc;
	}
	public String getDbTree() {
		return dbTree;
	}
	
}
