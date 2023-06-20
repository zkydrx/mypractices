package workTest.event;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-11-13 Time: 16:24:43
 * Description: 事件
 */
public interface IEevent {
	void setEventListener(IEventListener arg);

	boolean ClickButton();

	boolean MoveMouse();

}
