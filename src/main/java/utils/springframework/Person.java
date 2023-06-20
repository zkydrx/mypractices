package utils.springframework;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-08-08 Time: 20:29:02
 * Description:
 */
public class Person {
	private String name;
	private BigDecimal height;
	private BigDecimal weight;
	private String tradeMark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getTradeMark() {
		return tradeMark;
	}

	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", height=" + height + ", weight=" + weight + ", tradeMark='"
				+ tradeMark + '\'' + '}';
	}
}
