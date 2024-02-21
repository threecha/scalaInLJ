package main.scala.threecha

object Test10_Function_Anonymous {
  /**
   * 匿名函数 Anonymous Function
   * 不关心函数名称时，函数名称和def也可以省略，去掉返回值类型，将=修改为=>定义为匿名函数
   *
   *
   * 匿名函数最简原则
   * 1. 参数类型可以省略，【根据高阶函数可以自动推导的情况下】
   * 2. 若省略类型后 参数唯一  可以删除参数列表括号
   * 3. 匿名函数主体只有一行 {}可以省略
   * 4. 如果参数只出现一次 那么参数也可以省略 后面出现的参数用_代替
   * 5. 若可以推断出当前传入的 print 是函数体，而不是调用语句 那么可以省掉下划线。直接讲函数名作为参数传递
   *
   */
  def main(args: Array[String]): Unit = {
    // scala 的参数类型可以是函数 可以定义函数作为参数 转而将函数作为函数入参实现套娃
    val template = (name: String) => println(name)
    val temp = (temp1: String) => println(temp1) // 如果参数只出现一次 参数可以沈略 且使用_代替

    /**
     * 匿名函数赋值给val 可以和正常函数一样调用使用
     * 也可以作为函数的传参
     *
     */
    template("中下游")
    temp("中下游 test case for Anonymous")

    def f0(input: String): Unit = println(input)

    // 定义好的函数 无法继续给赋值给val参数
    // 理解为 只有匿名函数可以赋值
    val tempFunction = f0 _

    /**
     * 使用函数作为方法的入参传递
     * functionStringToUnit("methodWithFunctionParams Result is True")
     * {}里调用方法传值
     */

    def methodWithFunctionParams(functionStringToUnit: String => Unit): Unit = {
      functionStringToUnit("methodWithFunctionParams Result is True")
    }

    def methodWithFunctionParamsTypes(functionWithParamsToUnit: (String, String) => Unit): Unit = {
      functionWithParamsToUnit("functionWithParamsToUnit Result is param one", "functionWithParamsToUnit Result is param two")
    }


    /**
     * 传递匿名函数类型 val
     */
    methodWithFunctionParams(temp)

    /**
     * 可以直接传递函数 而不用val类型来代替函数
     */
    methodWithFunctionParams((input: String) => println(input))

    /**
     * 匿名函数最简原则
     * 1. 参数类型可以省略，【根据高阶函数可以自动推导的情况下】
     * 2. 若省略类型后 参数唯一  可以删除参数列表括号
     * 3. 匿名函数主体只有一行 {}可以省略
     * 4. 如果参数只出现一次 那么参数也可以省略 后面出现的参数用_代替
     * 5. 若可以推断出当前传入的 print 是函数体，而不是调用语句 那么可以省掉下划线。直接讲函数名作为参数传递
     *
     * 高阶函数：
     * 匿名函数作为 值传递 入参 返回值
     * 1.值传递 经过赋值后变为一个lambda表达式
     */

    /**
     * 原则1 & 2
     * 可推断情况下 省略类型
     */
    methodWithFunctionParams(input => println(input))

    /**
     * 原则2 & 3
     * 参数有多 不能省略括号
     * 函数主体超过1行 不能省略{}
     */

    methodWithFunctionParamsTypes((input1th, input2th) => {
      println(input1th)
      println(input2th)
    })

    /**
     * 原则4
     * 如果参数只出现一次 则参数可以省略 后面参数可以使用_ 
     */
    methodWithFunctionParams(println(_))

    /**
     * 原则5
     * 可以推断出函数体 而不是调用 直接传递函数名
     */
    methodWithFunctionParams(println)

    /**
     * Example:
     *
     */
    def calculate(f: (Int, Int) => Int): Unit = {
      println(f(1, 2))
    }

    println("Example for calculate=====> ")
    //a+b
    calculate((a: Int, b: Int) => a + b)
    //a-b
    calculate((a: Int, b: Int) => a - b)
    // 省略类型 多个参数无法删除括号
    calculate((a, b) => a + b)
    calculate((a, b) => a - b)

    // 只使用一次可以使用_代替
    calculate(_ + _) //  a+b
    calculate(_ - _) //  a-b
    calculate(-_ + _) //  b-a = -a+b


  }
}
