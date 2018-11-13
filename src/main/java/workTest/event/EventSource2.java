package workTest.event;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-13
 * Time: 16:29:13
 * Description:
 * 事件源：事件发生的地点
 */
public class EventSource2 implements IEevent
{
    private IEventListener ml;
    boolean button;
    boolean mouse;

    @Override
    public void setEventListener(IEventListener arg)
    {
        ml = arg;
    }

    @Override
    public boolean ClickButton()
    {
        // TODO Auto-generated method stub
        return button;
    }

    @Override
    public boolean MoveMouse()
    {
        // TODO Auto-generated method stub
        return mouse;
    }

    // 触发事件
    public void buttonEventHappened()
    {
        button = true;
        ml.doEvent(this);
    }

}
