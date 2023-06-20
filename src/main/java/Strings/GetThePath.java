package Strings;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-10-24 Time: 15:55:09
 * Description:
 */
public class GetThePath {
	public static void main(String[] args) {
		String s = "{\"contractList\":[{\"contractNumber\":\"20181024155358820\","
				+ "\"contractTitle\":\"*****：*****\",\"createTime\":1540367638774," + "\"id\":13175,"
				+ "\"mD5\":\"bade150419e350601f744edab48b6a09\",\"modelId\":600,\"path\":\"http://image"
				+ ".*****/file/20181024/abc/*****551cee5e4d959ab37ac9fc1a197c" + ".pdf\","
				+ "\"sHA1\":\"abc\",\"status\":10," + "\"termTime\":33065740438774}],\"info\":1}";
		System.out.println("index:,   " + s.indexOf(","));
		System.out.println("index:path   " + s.indexOf("path"));
		System.out.println("path+7   " + s.indexOf("path") + 7);
		System.out.println(s.indexOf(",", s.indexOf("path")) - 1);
		String substring = s.substring(s.indexOf("path") + 7, s.indexOf(",", s.indexOf("path")) - 1);
		/**
		 * 就算用这种方式都比较直白吧！！！ 虽然还是比较傻。
		 */
		String substring1 = s.substring(s.indexOf("path") + 7, s.indexOf(".pdf") + 4);
		System.out.println(substring.length());
		System.out.println(substring);
		System.out.println(substring1);
	}
}
