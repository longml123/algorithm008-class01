一、递归Recursion
    递归现实例子：盗梦空间
        向下进入不同梦境中，向上又回归原来层；
        通过声音同步回到上一层；
        每一层环境和周围的人都是一份拷贝，主角等人穿越不同层级梦境（发生和携带变化）。
    
   递归程序结构
        1、递归终止条件recursion termintor
        2、处理当前层逻辑
        3、进入下一层drill down
        4、清理当前层（不是必要）
    
   模板代码
        public void recursion（int level, int param）{
            if(level > max_level) return;
            process(level, param);
            recursion(level + 1 , newParam)
            //restore current status
        }
     
   思考要点：
        1、不要人头递归（状态树）；
        2、找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）；程序是由if else for while recurdion
        3、数据归纳法；用N推到出N+1
