package knowledgeable.review202101.msb.thread.four;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-31
 * Time: 12:06:13
 * Description:
 * java 协程的例子，（在用户空间，而非内核空间。这样效率更加高)
 * 1.直接使用循环语句的话大概是5400ms左右
 * 2.开启协程执行的话，大概需要300ms左右，
 * 3.开启线程执行的话大概需要5500ms左右，
 * 也就是所使用Quasar提供的协程类库，执行效率整整提高了18倍左右。不得不说真的很厉害，期待java推出自己的原生协程支持类
 */
public class FiberThreadMethod
{
    public static void main(String[] args)
    {
        Long start = System.currentTimeMillis();


        for (int i = 0; i < 10000; i++)
        {
            /**
             * 1.直接使用循环测试执行效率
             */
            cacl();
            /**
             * 2.使用协程方式测试执行效率
             */
            // Fiber<Void> fiber = new Fiber<>(new SuspendableRunnable(){
            //     @Override
            //     public void run() throws SuspendExecution, InterruptedException
            //     {
            //         cacl();
            //     }
            // });
            // fiber.start();
        }

        // /**
        //  * 3.使用线程方式测试执行效率
        //  */
        // Runnable runnable = () -> cacl();
        // Thread thread = new Thread(runnable);
        // thread.start();

        System.out.println(System.currentTimeMillis() - start);
    }

    static void cacl()
    {
        int result = 0;
        for (int i = 0; i < 10000; i++)
        {
            for (int i1 = 0; i1 < 200; i1++)
            {
                result += i1;
            }
        }
    }
}
