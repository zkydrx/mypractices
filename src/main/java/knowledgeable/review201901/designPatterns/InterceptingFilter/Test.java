package knowledgeable.review201901.designPatterns.InterceptingFilter;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-21 Time: 13:37:04
 * Description:
 */
public class Test {
	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager(new Target());

		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());
		Client client = new Client();

		client.setFilterManager(filterManager);

		client.sendRequest("Hello World!");

	}
}
