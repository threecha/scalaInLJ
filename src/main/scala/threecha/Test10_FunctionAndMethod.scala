package main.scala.threecha

object Test10_FunctionAndMethod {
  // 函数可以在任意地方定义
  def main(args: Array[String]): Unit = {
    def sayHi():Unit = {
      println("hi I am 3x in method")
    }
    sayHi()// 可以在方法里定义函数

    // 下面2种定义方法是等价的
    this.sayHi()
    Test10_FunctionAndMethod.sayHi()
  }

  def sayHi(): Unit={
    println("Hi I am 3X out method")
  }
}
