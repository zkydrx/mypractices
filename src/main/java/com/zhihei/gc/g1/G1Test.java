package com.zhihei.gc.g1;

import java.util.Random;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-17 Time: 15:07:44
 * Description: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 * -XX:MaxGCPauseMillis=100 -XX:G1HeapRegionSize=1
 * <p>
 * 如下列表为 G1 GC垃圾收集器常用配置参数：
 * <p>
 * 可选项及默认值 描述 -XX:+UseG1GC 采用 Garbage First (G1) 收集器 -XX:MaxGCPauseMillis=n
 * 设置最大GC 暂停时间。这是一个大概值，JVM 会尽可能的满足此值 -XX:InitiatingHeapOccupancyPercent=n
 * 设置触发标记周期的 Java 堆占用率阈值。默认占用率是整个 Java 堆的 45%。默认值 45.
 * <p>
 * -XX:NewRatio=n new/old 年代的大小比例. 默认值 2. -XX:SurvivorRatio=n eden/survivor
 * 空间的大小比例. 默认值 8. -XX:MaxTenuringThreshold=n 对象晋升年代的最大阀值。默认值
 * 15.这个参数需要注意的是：最大值是15，不要超过这个数啊，要不然会被人笑话。原因为：JVM内部使用 4 bit （1111）来表示这个数。
 * -XX:ParallelGCThreads=n 设置在垃圾回收器的并行阶段使用的线程数。默认值因与 JVM 运行的平台而不同。
 * -XX:ConcGCThreads=n 并发垃圾收集器使用的线程数。默认值因与 JVM 运行的平台而不同。 -XX:G1ReservePercent=n
 * 设置作为空闲空间的预留内存百分比以降低晋升失败的可能性。默认值10 -XX:G1HeapRegionSize=n
 * 使用G1，Java堆被划分为大小均匀的区域。这个参数配置各个子区域的大小。此参数的默认值根据堆大小的人工进行确定。最小值为 1Mb 且最大值为 32Mb。
 * -XX:G1PrintRegionLivenessInfo 默认值false, 在情理阶段的并发标记环节,输出堆中的所有 regions 的活跃度信息
 * -XX:G1PrintHeapRegions 默认值false, G1 将输出那些 regions 被分配和回收的信息
 * -XX:+PrintSafepointStatistics 输出具体的停顿原因 -XX: PrintSafepointStatisticsCount=1
 * 输出具体的停顿原因 -XX:+PrintGCApplicationStoppedTime 停顿时间输出到GC日志中
 * -XX:-UseBiasedLocking 取消偏向锁 -XX:+UseGCLogFileRotation 开启滚动日志输出，避免内存被浪费
 * -XX:+PerfDisableSharedMem 关闭 jstat 性能统计输出特性，使用 jmx 代替
 * <p>
 * <p>
 * JVM GC 日志参数：
 * <p>
 * -verbose:gc -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xloggc:/appl/gclogs/gc.log
 * 备注：-Xloggc的目录需要提前建好。
 */
public class G1Test {
	public static void main(String[] args) {
		String str = "zky";
		for (;;) {
			str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
			str.intern();
		}
	}
}
