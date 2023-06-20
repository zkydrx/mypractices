package knowledgeable.review201901.designPatterns.factory;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-19 Time: 15:14:00
 * Description:
 */
public class ThingFactory {
	public Factory getType(String thingType) {
		if (thingType == null) {
			return null;
		}
		if (thingType.equalsIgnoreCase("car")) {
			return new CarFactory();
		}

		if (thingType.equalsIgnoreCase("computer")) {
			return new ComputerFactory();
		}

		return null;
	}
}
