package test.Enum;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-07-06 Time: 19:28:10
 * Description:
 */
public class TestEnum {
	public static void main(String[] args) {

		System.out.println(AEnum.newInstance("C").getCode());

		System.out.println(MonthEnum.getMonthEnum("1").say("是一年的第一个月，也是要为新的一年开一个好头的月份。"));
		String name = MonthEnum.getMonthEnum("12").name();

		System.out.println(name);

		System.out.println(MonthEnum.getMonthEnum("3").say("是一年中的第") + (MonthEnum.getMonthEnum("3").ordinal() + 1)
				+ "的月份，同时也是春暖花开的好季节，适合去踏青。");

	}
}
