package KnowledgeableReview201901.designPatterns.designPatternsInJdk.eventListener;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-05
 * Time: 20:36:35
 * Description:
 * 主程序，就想象成要开门的哪个人
 */
public class DoorMain
{
    public static void main(String[] args)
    {
        DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener1());// 给门1增加监听器
        manager.addDoorListener(new DoorListener2());// 给门2增加监听器
        // 开门
        manager.fireWorkspaceOpened();
        System.out.println("我已经进来了");
        // 关门
        manager.fireWorkspaceClosed();
    }
}
