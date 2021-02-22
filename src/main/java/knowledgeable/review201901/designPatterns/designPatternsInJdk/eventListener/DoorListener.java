package knowledgeable.review201901.designPatterns.designPatternsInJdk.eventListener;

import java.util.EventListener;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-05
 * Time: 20:39:24
 * Description:
 * 定义监听接口，负责监听DoorEvent事件
 */

public interface DoorListener extends EventListener
{
    void doorEvent(DoorEvent event);
}