预习课
一、数据结构与算法
    学习方式：
        1、课前预习，基础知识预习查看；
        2、课上思考问题，跟着一起思考，回答问题。
        3、课后练习，按照老师指导做。
        
    目标：
        1、达到职业顶尖选手水平
        2、互联公司面试offer；
        3、leetcode 300+。
        
    精通一个领域：
        切碎知识点chunk it up 
        刻意练习 Deliberrate Practicing
        反馈 feedback
        
    数据结构
        一维：
            基础：数组array（String），链表linked list
            高级：栈stack，队列 queue，上端队列 deque， 集合 set，映射 map（hash or map）etc；
        二维：
            基础：数tree，图graph
            高级：二叉搜索树 binary searach tree（red-black tree，AVL），堆 heap，并查集 disjoint set，字典树 Tric，etc
        特殊：
            位运算 Bitwise，布隆过滤器 BoomFilter
            LRU Cache
            注意：了解每个数据结构的原理和代码框架
   算法
        if-else，switch——> branch
        for,while,loop --> iteration
        递归 Recursion（Divide & Conquer，backtrace）
        
        搜索 Search：深度优先搜索 Depth first search，广度优先搜索 Breadth first search，A*，etc
        动态规划 Dynamic Programming
        二分查找 Binary Search
        贪心 Greedy
        数学：Math，几何 Geometry
        注意：在头脑中回忆上面每种算法的思想和代码模板
        
    切题四件套
        1、读题，确认规则
        2、解析思路，多种解法都考虑到，从中找打最优解
        3、写代码
        4、测试程序
    
    五毒神掌：
        1、第一遍看题，读题思考5-10min，
            没思路看题解（多种），背下来题解，达到默写程度。
        2、第二遍后独立写代码，进行测试，看好的题解。
        3、第三遍一天以后在来一遍，
        4、第四遍一个周以后在来一遍。
        5、面试前在过一遍之前练习过的题目。
    
    1.学习的过程中首先要注重预习。基础知识自己预习和查看。 
    2.课堂互动，跟着老师一起思考回答问题。 
    3.课后作业，按照切题方法。 
    4.《异类：不一样的成功启示录》 
    5.想要精通一个领域。 
        1）Chunk it up 切碎知识点。
        2）Deliberate Practicing 刻意练习。
        3）Feedback 反馈，又分为主动反馈和被动反馈。 
    6.数据结构分为一维数据结构、二维数据结构和特殊数据结构， 
    7.刻意练习，1）过遍数（五毒神掌）2）练习缺陷、弱点地方 
    8.切题四件套。
        1）反复多看这个题目，确保自己对这个题目的理解是正确的。2
        ）看到题目之后，想所有可能解法来解这个题目，而不是用想到的第一个解法来解这个题目，把每一种想到的解法进行时间和空间复杂度进行分析，从中找出最优的一种解法。
        3）多写代码。4
        ）多例几个测试样例。 
    9.五遍刷题法（五毒神掌）
        (1)第一遍1）先花5分钟时间读题和思考。2）如果没思路，直接看解法即可，注意：多解法，比较解法优劣。3）背诵、默写好的解法。
        （2）第二遍，1）开始自己写代码，不要看别人的解法。2）使用多种解法，体会自己的解法以及优化自己的解法。
        （3）第三遍，1）过了一天后，再重复做题。2）根据不同解法的熟练程度，对自己不是特别熟练的题目进行专项训练。
        （4）第四遍，过了一周之后，再返回来练习相同的题目。同时对自己不是特别熟练的题目进行专项练习。
        （5）第五遍，1）面试前一周进行恢复性训练，把之前做过的题目再重新做一遍。
        
        
     Spring IoC有什么好处呢？
      
    是依赖倒置原则——把原本的高层建筑依赖底层建筑“倒置”过来，变成底层建筑依赖高层建筑。
    高层建筑决定需要什么，底层去实现这样的需求，但是高层并不用管底层是怎么实现的。
    这样就不会出现前面的“牵一发动全身”的情况。
    
    所以我们需要进行控制反转（IoC），及上层控制下层，而不是下层控制着上层。我们用依赖注入（Dependency Injection）这种方式来实现控制反转。
    所谓依赖注入，就是把底层类作为参数传入上层类，实现上层类对下层类的“控制”
    
    这里我只需要修改轮胎类就行了，不用修改其他任何上层类。这显然是更容易维护的代码。
    不仅如此，在实际的工程中，这种设计模式还有利于不同组的协同合作和单元测试：
    比如开发这四个类的分别是四个不同的组，那么只要定义好了接口，四个不同的组可以同时进行开发而不相互受限制；
    而对于单元测试，如果我们要写Car类的单元测试，就只需要Mock一下Framework类传入Car就行了，而不用把Framework, Bottom, Tire全部new一遍再来构造Car。
    
    显然你也应该观察到了，因为采用了依赖注入，在初始化的过程中就不可避免的会写大量的new。
    这里IoC容器就解决了这个问题。这个容器可以自动对你的代码进行初始化，你只需要维护一个Configuration（可以是xml可以是一段代码）
    ，而不用每次初始化一辆车都要亲手去写那一大段初始化的代码。这是引入IoC Container的第一个好处。IoC Container的第二个好处是：
    我们在创建实例的时候不需要了解其中的细节。在上面的例子中，我们自己手动创建一个车instance时候，是从底层往上层new的：
    
    而IoC Container在进行这个工作的时候是反过来的，它先从最上层开始往下找依赖关系，到达最底层之后再往上一步一步new（有点像深度优先遍历）
    
    实际项目中，有的Service Class可能是十年前写的，有几百个类作为它的底层。假设我们新写的一个API需要实例化这个Service，我们总不可能回头去搞清楚这几百个类的构造函数吧？IoC Container的这个特性就很完美的解决了这类问题——因为这个架构要求你在写class的时候需要写相应的Config文件，所以你要初始化很久以前的Service类的时候，前人都已经写好了Config文件，你直接在需要用的地方注入这个Service就可以了。这大大增加了项目的可维护性且降低了开发难度。
   
   来源：https://www.zhihu.com/question/23277575/answer/169698662
    
------------
1.学习的过程中首先要注重预习。基础知识自己预习和查看。
2.课堂互动，跟着老师一起思考回答问题。
3.课后作业，按照切题方法。
4.《异类：不一样的成功启示录》
5.想要精通一个领域。
    1）Chunk it up 切碎知识点。
    2）Deliberate Practicing 刻意练习。
    3）Feedback 反馈，又分为主动反馈和被动反馈。
6.数据结构分为一维数据结构、二维数据结构和特殊数据结构，
7.刻意练习，1）过遍数（五毒神掌）2）练习缺陷、弱点地方
8.切题四件套。
    1）反复多看这个题目，确保自己对这个题目的理解是正确的。
    2）看到题目之后，想所有可能解法来解这个题目，
        而不是用想到的第一个解法来解这个题目，
        把每一种想到的解法进行时间和空间复杂度进行分析，
        从中找出最优的一种解法。
    3）多写代码。
    4）多例几个测试样例。
9.五遍刷题法（五毒神掌）
    (1)第一遍
        1）先花5分钟时间读题和思考。
        2）如果没思路，直接看解法即可，注意：多解法，比较解法优劣。
        3）背诵、默写好的解法。
   （2）第二遍，
        1）开始自己写代码，不要看别人的解法。
        2）使用多种解法，体会自己的解法以及优化自己的解法。
   （3）第三遍，1）过了一天后，再重复做题。
        2）根据不同解法的熟练程度，对自己不是特别熟练的题目进行专项训练。
   （4）第四遍，过了一周之后，再返回来练习相同的题目。
        同时对自己不是特别熟练的题目进行专项练习。
   （5）第五遍，1）面试前一周进行恢复性训练，把之前做过的题目再重新做一遍。    