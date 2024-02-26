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
     */
    def function1(input:Int):Int = {
      println(s"current Input is ==> $input")
      input+1
    }
    // 通过下划线明确表示 将函数作为对象赋值
    val highOrderFunction1 = function1 _  
    // :Int => Int 明确的表述了函数类型 就不需要再加_
    val highOrderFunction1_1 : Int => Int = function1
    // 对计算后的值进行赋值
    val highOrderFunction1_2 = function1(12)


    def functionTest():Unit =  println("No Input params Just for Test")

    //
    val highOrderFunction2_1: () => Unit = functionTest
    val highOrderFunction2_2: Unit = functionTest()
    val highOrderFunction2_3 = functionTest _



  }

}
