package knowledgeable.review201901.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-19 Time: 15:44:38
 * Description:
 */
public class ShapeFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		return null;
	}

	@Override
	Shape getShape(String shape) {
		if (shape == null) {
			return null;
		}
		if (shape.equalsIgnoreCase("car")) {
			return new CarFactory();
		}

		if (shape.equalsIgnoreCase("computer")) {
			return new ComputerFactory();
		}

		return null;
	}
}
