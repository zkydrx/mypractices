package knowledgeable.review201901.designPatterns.designPatternsInJdk.eventListener;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-05
 * Time: 20:37:34
 * Description:
 * 事件源对象，在这里你可以把它想象成一个控制开门关门的遥控器，
 * (如果是在swing中，就类似一个button)
 */
public class DoorManager
{
    private Collection list;

    /**
     * 添加事件
     *
     * @param listener DoorListener
     */
    public void addDoorListener(DoorListener listener)
    {
        if (list == null)
        {
            list = new HashSet();
        }
        list.add(listener);
    }

    /**
     * 移除事件
     *
     * @param listener DoorListener
     */
    public void removeDoorListener(DoorListener listener)
    {
        if (list == null)
        {
            return;
        }
        list.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened()
    {
        if (list == null)
        {
            return;
        }
        DoorEvent event = new DoorEvent(this, "open");
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed()
    {
        if (list == null)
        {
            return;
        }
        DoorEvent event = new DoorEvent(this, "close");
        notifyListeners(event);
    }

    /**
     * 通知所有的DoorListener
     */
    private void notifyListeners(DoorEvent event)
    {
        Iterator iter = list.iterator();
        while (iter.hasNext())
        {
            DoorListener listener = (DoorListener) iter.next();
            listener.doorEvent(event);
        }
    }
}
