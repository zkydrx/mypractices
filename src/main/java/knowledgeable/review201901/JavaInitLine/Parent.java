package knowledgeable.review201901.JavaInitLine;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-20 Time: 10:28:40
 * Description:
 */
public class Parent {
	// 静态变量
	public static String pStaticField = "父类--静态变量";

	// 变量
	public String pField = "父类--变量";
	protected int i = 9;
	protected int j = 0;

	// 静态初始化块
	static {
		System.out.println(pStaticField);
		System.out.println("父类--静态初始化块");
	}

	// 初始化块
	{
		System.out.println(pField);
		System.out.println("父类--初始化块");
	}

	// 构造器
	public Parent() {
		System.out.println("父类--构造器");
		System.out.println("i=" + i + ",j=" + j);
		j = 20;
	}

}
