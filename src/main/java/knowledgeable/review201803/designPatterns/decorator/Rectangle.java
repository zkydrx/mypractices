package knowledgeable.review201803.designPatterns.decorator;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-27 Time: 00:27:11
 * Description:
 */
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape:Rectangle");
	}
}
