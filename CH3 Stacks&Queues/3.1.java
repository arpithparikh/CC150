//describe how you would use a single array to implement three stacks
//for stack1, we use [0, n/3)
//for stack2, we use [n/3, 2n/3)
//for stack3, we use [2n/3, n)
//solution1, fixed size division
Solution:
首先确定3个位置,数组的头，数组的尾，和数组的middle位置。
三个堆栈的栈底可以分别是数组的头，数组的尾，和数组的middle位置。
第一个堆栈的栈顶变化是从index 0开始往数组的middle位置变化随着元素的入栈
第二个堆栈的栈顶变化可以是从middle位置往数组尾变化，也可以是往数组头变化。我们假设往数组尾变化。
第三个堆栈的栈顶变化是从数组尾部，往数组Middle位置变化。

第一个堆栈当元素push到Middle之前一个位置时，栈就满了。
第二个堆栈的栈顶指针当和第三个堆栈的栈顶指针相遇时，即两个堆栈都满。
