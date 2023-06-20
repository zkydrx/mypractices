package knowledgeable.review201901.designPatterns.InterceptingFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-21 Time: 13:30:26
 * Description:
 */
public class FilterChain {
	private List<Filter> filters = new ArrayList<>();
	private Target target;

	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	public void execute(String request) {
		for (Filter filter : filters) {
			filter.execute(request);
		}
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
