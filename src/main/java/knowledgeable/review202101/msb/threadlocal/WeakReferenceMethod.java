package knowledgeable.review202101.msb.threadlocal;

import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-29
 * Time: 20:56:23
 * Description:
 * 弱引用
 * 使用场景：ThreadLocal,
 * 只要垃圾回收，直接就会被回收，不管是否内存溢出（OOM）
 */
public class WeakReferenceMethod
{
    public static void main(String[] args)
    {
        WeakReference<M> weakReference = new WeakReference<>(new M());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());

    }
}
