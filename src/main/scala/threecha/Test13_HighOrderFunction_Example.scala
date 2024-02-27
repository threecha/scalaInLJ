package main.scala.threecha


object Test13_HighOrderFunction_Example {
  def main(args: Array[String]): Unit = {


    /**
     * Example: 实现集合的+1操作
     *
     */
    val targetArrays = Array(12, 14, 29, 31, 100)

    def arrayOperation(input: Array[Int], op: Int => Int): Array[Int] = for (element <- input) yield op(element)

    def addOne(element: Int): Int = element + 1

    println(arrayOperation(targetArrays, addOne).mkString(","))
    println(arrayOperation(targetArrays, _ + 1).mkString(","))
    println(arrayOperation(targetArrays, a => a + 1).mkString(","))

    /**
     * example2: 定义一个匿名函数，并把它作为赋值给变量fun 函数有三个参数，类型分别为int String Char 返回值类型为Boolean
     *
     * 要求：调用函数fun(0,"",'0') 得到为false 其他情况得到的值为True
     *
     */
    val fun = (a: Int, b: String, c: Char) => if (a == 0 && b == "" && c == '0') false else true
    println(fun(1, "", '1'))
    println(fun(0, "", '0'))

    /**
     * example3: 定义一个函数func 他接受一个Int参数，返回值记作f1 f1接收一个String类型参数 返回函数f2 f2接受Char类型参数 返回一个Boolean值
     *
     * 要求：调用函数fun(0)("")('0') 得到为false 其他情况得到的值为True
     *
     */

    def func(a: Int): String => Char => Boolean =
      def f1(b: String): Char => Boolean = {
        def f2(c: Char): Boolean = {
          if (a == 0 && b == "" && c == '0') false else true
        }

        f2
      }

      f1

    // 以上就是一个套娃过程
    println(func(1)("")('0'))
    println(func(0)("")('0'))


    /**
     * 匿名函数最简原则
     *
     * 根据最简原则简化 :类型可以省略 因为可以推导出来
     */

    def func_v2(a: Int) =
      def f1(b: String) = {
        def f2(c: Char) = if (a == 0 && b == "" && c == '0') false else true

        f2
      }

      f1

    println(func_v2(1)("")('0'))
    println(func_v2(0)("")('0'))

    def func_v3(a: Int) = (b: String) => (c: Char) => if (a == 0 && b == "" && c == '0') false else true

    def func_v4(a: Int): String => Char => Boolean = b => c => if (a == 0 && b == "" && c == '0') false else true

    /**
     * v5 : 无法使用 因为无法完成正确的类型推倒
     */
    // def func_v5(a: Int) = b => c => if (a == 0 && b == "" && c == '0') false else true

    println(func_v3(1)("")('0'))
    println(func_v3(0)("")('0'))

    println(func_v4(1)("")('0'))
    println(func_v4(0)("")('0')) // 逐层调用


    /**
     * 函数柯里化
     *
     * 直接在外层定义参数 把内层函数的访问放在外层去定义
     *
     */

    // def func_v3(a: Int) = (b: String) => (c: Char) => if (a == 0 && b == "" && c == '0') false else true
    def func_v5(a: Int)(b: String)(c: Char) = if (a == 0 && b == "" && c == '0') false else true

    def funcCurrying(a: Int, b: Int) = a + b

    def funcCurrying_v1(a: Int)(b: Int) = a + b

    // funcCurrying_v1(1) 表示我们调用了柯里化函数 add 的第一个参数列表，提供了参数 1，而下划线 _ 则表示剩下的参数列表尚未提供，此时函数并未完全调用，而是返回了一个新的函数，该函数期望接受剩余的参数
    val addFirst = funcCurrying_v1(1) _
    val addNext = addFirst(2)

    println(addNext)


    /**
     * Currying 函数的展开形式
     *
     *  function _ ：_ 则表示剩下的参数列表尚未提供，此时函数并未完全调用，而是返回了一个新的函数，该函数期望接受剩余的参数
     */

    def funcCurrying_2(a: Int) =
      def f2(b: Int) = {
        a + b
      }

      f2 _
  }
}
