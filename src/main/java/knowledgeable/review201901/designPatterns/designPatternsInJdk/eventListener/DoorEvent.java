package knowledgeable.review201901.designPatterns.designPatternsInJdk.eventListener;

import java.util.EventObject;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-01-05 Time: 20:40:16
 * Description: 定义事件对象，必须继承EventObject
 */
public class DoorEvent extends EventObject {

	private static final long serialVersionUID = 6496098798146410884L;

	private String doorState = "";// 表示门的状态，有“开”和“关”两种

	public DoorEvent(Object source, String doorState) {
		super(source);
		this.doorState = doorState;
	}

	public void setDoorState(String doorState) {
		this.doorState = doorState;
	}

	public String getDoorState() {
		return this.doorState;
	}

}
