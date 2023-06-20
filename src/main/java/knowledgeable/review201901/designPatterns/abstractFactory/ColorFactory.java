package knowledgeable.review201901.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-19 Time: 15:49:01
 * Description:
 */
public class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		if (color == null) {
			return null;
		}

		if (color.equalsIgnoreCase("blue")) {
			return new Blue();
		}
		if (color.equalsIgnoreCase("green")) {
			return new Green();
		}
		return null;
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}
}
