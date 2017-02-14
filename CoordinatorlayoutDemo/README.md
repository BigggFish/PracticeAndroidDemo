# CoordinatorlayoutDemo

解决CoordinaLayout中RecyclerView和NestedScrollView滑动卡顿问题,即fling事件处理不对的问题。

* RecyclerView 通过为AppbarLayout重新设置behavior来解决。
* NestedScrollView 通过重写NestedScrollView中onToucheEvent方法解决。

blog：http://blog.csdn.net/bigggfish/article/details/53585783
