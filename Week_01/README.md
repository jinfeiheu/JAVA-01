学习笔记

> JDK8默认采用并行parallel收集器，
> 还有串行，并发，G1总共4种策略

### 使用并行【Parallel Scavenge(新生代) + Parallel Old(老年代)】
> 采用多线程的垃圾收集线程，吞吐量高，STW时间较长

### 使用串行【Serial(新生代) + Serial Old(老年代)】
> 只能单线程收集

### 使用并发【Parallel New(新生代) + Concurrent MarkSweep(老年代)】
> 新生代使用并行，老年采用并发，可以与工作线程同时执行。full gc的同时也可以进行young gc。
> 吞吐量较低，低延时

### 使用G1(新生代 + 老年代)
> 同时回收新生代和老年代，CMS进化版，标记-整理算法，更低的延时
