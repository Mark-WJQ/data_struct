1. 广搜一般用于状态标识比较简单、求最优策略的问题
   2. 优点：是一种完备策略，即只要问题有解，他就一定可以找到解。并且广度优先搜索找到的解，**_还一定是路径最短的解_**
   3. 缺点：盲目性较大，尤其是当目标节点距初始节点较远时，将产生许多无用的节点，因此其搜索效率较低，需保存所有扩展出的状态，占用的空间大
4. 深搜几乎可以用于任何问题、
   5. 只需要保存从起始状态到当前状态路径上的节点
6. 根据题目要求凭借自己的经验和对两个搜索的熟练程度做出选择