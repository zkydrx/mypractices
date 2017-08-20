# Practice
基础练习题

1.编写一个Java程序输出1！+2！+3！+……+n！的和?


    public class GetSumMethod
    {
        /**
         * 利用递归写的一个阶乘运算，发现非常的占用资源。慎用。
         * 递归能不用，尽量不用，结构虽然简单，但是数据量一大很容易栈溢出。
         */
        public int getJieCheng(int n)
        {
            if(n == 1)
            {
                return n;
            }
            else
            {
                return getJieCheng(n-1)*n;
            }
        }
        /**
         * 利用迭代相乘的办法得到阶乘。
         * @param n
         * @return
         */
        public long getJieChengOne(int n)
        {
            long temp = 1L;
            for(int i= 1; i<= n; i++)
            {
                temp *= i;
            }
            return temp;
        }

        public long getSum(int n)
        {
            long sum = 0L;
            /**
             * 此处注意0阶乘是零。
             */
            for(int i = 1; i <= n; i++)
            {
                sum+=getJieCheng(i);
            }
            return sum;
        }

        public long getSumOne(int n)
        {
            long sum = 0L;
            /**
             * 此处注意0阶乘是零。
             */
            for(int i = 1; i <= n; i++)
            {
                sum+=getJieChengOne(i);
            }
            return sum;
        }

        @Test
        public void testGetJieCheng()
        {
            long time2= System.currentTimeMillis();
            long sum1 = getSumOne(10000);
            time2= System.currentTimeMillis() -time2;
            System.out.println("迭代用时："+time2);
            long time1=System.currentTimeMillis();
            long sum = getSum(10000);
            time1=System.currentTimeMillis()-time1;
            System.out.println("递归用时："+time1);
        }
    }


偶然间碰到这个题，很简单，但也容易出错。比如大多数程序员都是从零开始计数，殊不知，0的阶乘不是0而是1。反正当时我写的时候没想起来0的阶乘是1想当然的认为0的阶乘是0对结果不会有影响。后来发现是不是应该从1开始试试，结果一试瞬间就明白了，0的阶乘是0不是1.

还有阶乘虽然结构简单，但是效率极低，而且特别容易栈溢出。

对程序进行的性能测试。当都计算10000的阶乘累加和的时候。

迭代用时：78
递归用时：312

递归的耗时正好是迭代的4倍。

当计算30000的阶乘累加时：

迭代用时：621
递归用时：3167

递归的耗时是迭代的5倍多。

所以由此可见，递归运算十分的占用内存资源，而且运行效率低下。所以能不用尽量不用。

