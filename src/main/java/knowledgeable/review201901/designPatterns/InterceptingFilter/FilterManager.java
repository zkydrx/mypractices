package knowledgeable.review201901.designPatterns.InterceptingFilter;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-21 Time: 13:33:05
 * Description:
 */
public class FilterManager {
	FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String request) {
		filterChain.execute(request);
	}

}
