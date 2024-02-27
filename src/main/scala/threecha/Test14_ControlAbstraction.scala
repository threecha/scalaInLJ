package main.scala.threecha

import java.util.concurrent.locks.Condition

object Test14_ControlAbstraction {
  /**
   * 抽象控制
   * 1. 传值参数
   * 2. 传名参数
   *
   * 区分：
   * 1. String=>Int 标识匿名函数，函数有输入[String]和输出[Int]
   * 2. =>Int 表示代码块 {} 代码块没有输入 但是可以有输出 比如Unit Int
   *
   * 传名参数 表示可以把代码块传入方法入参
   *
   */
  def main(args: Array[String]): Unit = {
    // 值传递
    def f1(input: Int): Int = input * 2

    println("值传递==>" + f1(12))

    def f2(input: => Int) = input * 2

    /**
     * 代码块 无法赋值给val
     */
    //    val temp:=>Int = {12}

    println("名传递==>" + f2(12))
    // f1 作为代码块传递给Input
    println("名传递==>" + f2(f1(1)))
    println("名传递==>" + f2({
      println("test for input value code {} ")
      12 // 这个是代码块的返回值
    }))


    /**
     * example
     * 使用自定义函数实现 while 关键字
     *
     * 函数柯里化 的参数也可以是代码块。如果柯里话的参数是个代码块 外层的括号是可以省略的
     */
    var n = 10
    while (n >= 1) {
      println(s"${n}")
      n -= 1
    }

    /**
     *
     * @param condition 输入条件
     * @return (=> Unit) => Unit 指的外层函数的返回参数 也就是doOption。 doOption的类型是 输入Unit 输出Unit
     */
    def myWhile(condition: => Boolean): (=> Unit) => Unit = {
      def doOption(op: => Unit): Unit = {
        if (condition) {
          op
          myWhile(condition)(op)
        }
      }

      doOption _ // 表示输出 doOption 函数 但是该函数的传参还不确定
    }

    /**
     * 继续简化
     *
     */
    def myWhile_v2(condition: => Boolean): (=> Unit) => Unit = {
      op => {
        if (condition) {
          op
          myWhile_v2(condition)(op)
        }
      }
    }

    /**
     * currying
     */

    def myWhile_v3(condition: => Boolean)(op: => Unit): Unit = {
      if (condition) {
        op
        myWhile_v3(condition)(op)
      }
    }

    n = 10
    myWhile_v3(n >= 1) {
      print(s"$n ")
      n -= 1
    }
    println()

    n = 10
    myWhile_v2(n >= 1) {
      print(s"$n ")
      n -= 1
    }
    println()

    n = 10
    myWhile(n >= 1) {
      print(s"$n ")
      n -= 1
    }
    println()


  }

}
