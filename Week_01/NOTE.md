学习笔记
1、用 add first 或 add last 这套新的 API 改写 Deque 的代码
    Deque<String> deque = new LinkedList<>();
    deque.addLast("a");
    deque.addLast("b");
    deque.addLast("c");
    deque.addLast("d");
    System.out.println(deque);
    String peek = deque.peek();
    System.out.println(peek);
    System.out.println(deque);
    while (deque.size() > 0){
        System.out.println(deque.pollLast());
    }
    System.out.println(deque);
    
2、分析 Queue 和 Priority Queue 的源码
Queue 满足先进新出，类似真实世界的排队，特殊的队列有双端队列、优先级队列（优先级高的往前排，类似VIP客户）
java中的PriorityQueue是一种无界的，线程不安全的队列；PriorityQueue是一种通过数组实现的，并拥有优先级的队列；
PriorityQueue存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器



注意：
好记性不如烂笔头， 因此请尝试
1）给每一道自己写过，看过的题目写一篇解题报告，
2）对相关一类题型的总结报告，