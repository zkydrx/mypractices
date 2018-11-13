package workTest.event;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-13
 * Time: 16:23:41
 * Description:
 * 事件源：事件发生的地点
 */
public class EventSource implements IEevent
{
    private IEventListener mEventListener;
    boolean button;
    boolean mouse;

    //注册监听器
    @Override
    public void setEventListener(IEventListener arg)
    {
        mEventListener = arg;
    }

    //触发事件
    public void mouseEventHappened()
    {
        mouse = true;
        mEventListener.doEvent(this);
    }

    @Override
    public boolean ClickButton()
    {
        return button;
        // TODO Auto-generated method stub

    }

    @Override
    public boolean MoveMouse()
    {
        // TODO Auto-generated method stub
        return mouse;
    }
}
