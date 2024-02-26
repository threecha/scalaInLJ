package main.scala.threecha

/**
 * 高阶函数
 *
 * 1. 参数类型可以省略 可以根据形式参数进行推导
 * 2.
 */
object Test12_HighOrderFunction {
  def main(args: Array[String]): Unit = {

    /**
     * 1. 函数作为值进行传递
     *
     * 下面2种写法是等价的
     *
     * val highOrderFunction1 = function1 _
     * val highOrderFunction1_1 : Int => Int = function1
     *
     *
     * 2. 函数作为参数进行传递
     *
     * 3. 函数作为返回值进行返回
     *
     * {值类型可以用到的地方 都可以用函数来替代}
     */
    def function1(input: Int): Int = {
      println(s"current Input is ==> $input")
      input + 1
    }

    // 通过下划线明确表示 将函数作为对象赋值
    val highOrderFunction1 = function1 _
    // :Int => Int 明确的表述了函数类型 就不需要再加_
    val highOrderFunction1_1: Int => Int = function1
    // 对计算后的值进行赋值
    val highOrderFunction1_2 = function1(12)


    def functionTest(): Unit = println("No Input params Just for Test")

    //
    val highOrderFunction2_1: () => Unit = functionTest
    val highOrderFunction2_2: Unit = functionTest()
    val highOrderFunction2_3 = functionTest _


    /**
     * 2. 函数作为参数进行传递
     *
     */
    def function2(option: (Int, Int) => Int, a: Int, b: Int): Int = option(a, b)

    def add(a: Int, b: Int): Int = a + b

    // 尝试把 add作为参数进行传递
    println(function2(add, 12, 17))
    println(function2((a, b) => a + b, 12, 17))
    println(function2(_ + _, 12, 17))


    /**
     * 3.函数作为函数的返回值进行返回
     * val highOrderFunction2_1: () => Unit = functionTest
     */
    def function3(): Int => Unit = {
      def f4(input: Int): Unit = println(s"the f4 input is $input")

      f4 // 这里函数作为了返回值
    }

    println(function3()(29))
  }
}
