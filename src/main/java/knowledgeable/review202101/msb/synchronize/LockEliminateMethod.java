package knowledgeable.review202101.msb.synchronize;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-01
 * Time: 17:01:11
 * Description:
 * lock eliminate (锁消除的小程序）
 * 上面的程序说明了锁消除的情况。
 * 由于StringBuffer是线程安全的，所以在调用append（）方法的时候不停地加锁与解锁。
 * 由于stringBuffer对象只在strAppendOther()这个方法中调用，所以不存在多线程共享stringBuffer的情况，
 * 此时jvm会把StringBuffer的加锁与解锁过程消除掉因此这种情况就是锁消除。
 */
public class LockEliminateMethod
{
    public String strAppendOther(String str1, String str2)
    {
        StringBuffer stringBuffer = new StringBuffer();
        String s = stringBuffer.append(str1).append(str2).toString();
        return s;
    }
}
