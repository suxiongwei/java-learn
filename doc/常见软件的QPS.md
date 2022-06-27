这里给出的 QPS 仅供参考，实际项目需要进行压测来计算。

- Nginx ：一般情况下，系统的性能瓶颈基本不会是 Nginx。单机 Nginx 可以达到 30w +。
- Redis: Redis 官方的性能测试报告：https://redis.io/topics/benchmarks 。从报告中，我们可以得出 Redis 的单机 QPS 可以达到 8w+（CPU 性能有关系，也和执行的命令也有关系比如执行 SET 命令甚至可以达到 10w+QPS）。
- MySQL: MySQL 单机的 QPS 为 大概在 4k 左右。
- Tomcat ：单机 Tomcat 的 QPS 在 2w 左右。这个和你的 Tomcat 配置有很大关系，举个例子 Tomcat 支持的连接器有 NIO、NIO.2 和 APR。AprEndpoint 是通过 JNI 调用 APR 本地库而实现非阻塞 I/O 的，性能更好，Tomcat 配置 APR 为 连接器的话，QPS 可以达到 3w 左右。更多相关内容可以自行搜索 Tomcat 性能优化。
