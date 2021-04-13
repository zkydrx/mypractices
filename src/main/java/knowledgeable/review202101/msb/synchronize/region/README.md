## Synchronized 的作用范围

```
synchronized 关键字代表这个方法加锁,相当于不管哪一个线程（例如线程A），运行到这个方法时,都要检查有没有其它线程B（或者C、 D等）
正在用这个方法(或者该类的其他同步方法)，有的话要等正在使用synchronized方法的线程B（或者C 、D）运行完这个方法后再运行此线程A,
没有的话,锁定调用者,然后直接运行。

```

### 总结：

- 修饰代码块：大括号括起来的代码，作用于调用的对象。
- 修饰方法：整个方法，作用于调用的对象。
- 修饰静态方法：整个静态方法，作用于所有对象。
- 修饰类：括号括起来的部分，作用于所有对象。