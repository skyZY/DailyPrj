### DailyPrj作为一个日常学习Android相关知识技术的一个demo，会更新技术点，市面上第三方开源框架的学习使用。

#### 一.优化功能

###### 1.  Android 仿微信Viewpage+Fragment惰性加载(lazy-loading)

          **什么是lazy-loading呢？**顾名思义就是在必要的时候才加载，否则不进行View的绘制和数据的加载。
          原因是Viewpager一次只会显示一个页卡，那么刚开始的时候，只需加载第一张Fragment页卡，其他的不加载，当用户向右滑动切换再进行加载。
          因为其他Fragment对于用户来说是不可见的，如果一开始就把全部Fragment一起加载，可能造成启动时卡顿的问题，更重要的是可能白白耗费用户的流量，因为用户可能并不需要其他Fragment的信息。

Demo gif展示如下： 

参考文章：[https://www.jb51.net/article/121450.htm](https://www.jb51.net/article/121450.htm)

#### 二.设计模式

#### 三.常用架构
