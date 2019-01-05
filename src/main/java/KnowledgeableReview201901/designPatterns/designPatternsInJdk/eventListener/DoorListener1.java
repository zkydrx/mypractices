package KnowledgeableReview201901.designPatterns.designPatternsInJdk.eventListener;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-05
 * Time: 20:38:16
 * Description:
 * 该类为 门1监听接口的实现，做具体的开门，关门动作
 */
public class DoorListener1 implements DoorListener
{
    @Override
    public void doorEvent(DoorEvent event)
    {
        // TODO Auto-generated method stub
        if (event.getDoorState() != null && event.getDoorState().equals("open"))
        {
            System.out.println("门1打开");
        }
        else
        {
            System.out.println("门1关闭");
        }
    }

}
