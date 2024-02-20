package main.scala.threecha

import jdk.internal.util.xml.impl.Input

object Test10_Simplify {
  /**
   *
   * 能省则省。
   * 1 最后一行代码会作为返回值，可以省略return。
   * 2 函数体只有一行代码的话，可以省略花括号。
   * 3 如果返回值类型能够自动推断那么可以省略。
   * 4 如果函数体中用return做返回，那么返回值类型必须指定。
   * 5 如果声明返回Unit，那么函数体中使用return返回的值也不起作用。
   * 6 如果期望是无返回值类型，那么可以省略=。这时候没有返回值，函数也可以叫做过程。【2.13.0已废弃，能编过不过会提示。】
   * 7 无参函数如果声明时没有加()，调用时可以省略()。【如果声明时有()调用也可以省略，不过2.13.3废弃了。】
   * 8 不关心函数名称时，函数名称和def也可以省略，去掉返回值类型，将=修改为=>定义为匿名函数
   */

  def main(args: Array[String]): Unit = {
    // 省略return
    def f1(input: String): String = {
      val output = input
      output
    }

    println("output==> " + f1("my input is 3X test for function1"))

    // 函数如果只有一行代码 可以省略花括号
    def f2(input: String): Unit = println(input)

    println(f2("test for function2"))

    //如果返回值类型能够自动推断那么可以省略。
    def f3(input: String): Unit = println(input)

    // 自动推断为 String
    def f3v2(input: Int) = input.toString

    // 使用return作为返回值 那么一定需要指定返回值类型
    def f4(input: Int): String = {
      val temp = input
      return temp.toString
    }

    //如果声明返回Unit，那么函数体中使用return返回的值也不起作用
    def f5(input: String): Unit = {
      print(s"function5 input==>$input")
      return input // 这一行没起到作用
    }
    //输出中会额外带有一个()是因为Unit 在表现形式上就是一个()
    println(f5("text for function5"))

    // 无参数函数 在调用时候括号可以省略[已不支持]
    def f7(): Unit = print("test case for function7")

    println(f7()) // 在scala3.n版本中已无法省略括号

    // 无返回值类型 已不支持 去掉等号写法
    def f6(input: String): Unit = {
      print("test case for function6")
    }

    //不关心函数名称时，函数名称和def也可以省略，去掉返回值类型，将=修改为=>定义为匿名函数
    def f8(input: Int) = {
      val temp = (input:Int) => input.toString
      val output = temp
      print(s"test case for function8 [anonymous function] ${output}")
      output
    }
    f8(29)


  }


}
