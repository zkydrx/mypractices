package knowledgeable.review201901.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-02-21 Time: 20:15:46
 * Description:
 */
public class LockDemo3 implements Lock {

	Thread ower = null;
	AtomicReference<Thread> owner = new AtomicReference<>();

	@Override
	public void lock() {
		owner.compareAndSet(null, Thread.currentThread());

	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		owner.compareAndSet(Thread.currentThread(), null);
	}

	@Override
	public Condition newCondition() {
		return null;
	}
}
