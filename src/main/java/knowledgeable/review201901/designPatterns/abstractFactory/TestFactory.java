package knowledgeable.review201901.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-19 Time: 15:17:06
 * Description:
 */
public class TestFactory {
	public static void main(String[] args) {
		AbstractFactory shape = FactoryProducer.getFactory("shape");

		Shape computer = shape.getShape("computer");
		computer.create();

		Shape car = shape.getShape("car");
		car.create();

		AbstractFactory color = FactoryProducer.getFactory("color");

		Color blue = color.getColor("blue");
		blue.printColor();

		Color green = color.getColor("green");
		green.printColor();
	}
}
