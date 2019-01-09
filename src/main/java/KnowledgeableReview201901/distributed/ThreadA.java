package KnowledgeableReview201901.distributed;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-09
 * Time: 14:34:49
 * Description:
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}


