package knowledgeable.review201803.designPatterns.InterceptingFilter;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-21 Time: 13:35:40
 * Description:
 */
public class Client {
	FilterManager filterManager;

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public void sendRequest(String request) {
		filterManager.filterRequest(request);
	}

}
