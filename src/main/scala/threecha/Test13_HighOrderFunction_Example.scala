package main.scala.threecha


object Test13_HighOrderFunction_Example {
  def main(args: Array[String]): Unit = {


    /**
     * Example: 实现集合的+1操作
     *
     */
    val targetArrays = Array(12,14,29,31,100)

    def arrayOperation(input:Array[Int],op:Int=>Int):Array[Int]= for(element <- input)yield op(element)
    def addOne(element:Int):Int = element+1

    println(arrayOperation(targetArrays,addOne).mkString(","))
    println(arrayOperation(targetArrays,_+1).mkString(","))
    println(arrayOperation(targetArrays,a => a+1 ).mkString(","))

    /**
     * example2: 定义一个匿名函数，并把它作为赋值给变量fun 函数有三个参数，类型分别为int String Char 返回值类型为Boolean
     *
     * 要求：调用函数fun(0,"",'0') 得到为false 其他情况得到的值为True
     *
     */
    val fun = (a:Int,b:String,c:Char) => if(a==0 && b=="" && c =='0') false else true
    println(fun(1,"",'1'))
    println(fun(0,"",'0'))

    /**
     * example3: 定义一个函数func 他接受一个Int参数，返回值记作f1 f1接收一个String类型参数 返回函数f2 f2接受Char类型参数 返回一个Boolean值
     *
     * 要求：调用函数fun(0)("")('0') 得到为false 其他情况得到的值为True
     *
     */

   def func(a:Int):String => Char => Boolean =
     def f1(b:String):Char => Boolean = {
       def f2(c:Char):Boolean ={
         if (a == 0 && b == "" && c == '0') false else true
       }
       f2
     }
     f1

    // 以上就是一个套娃过程
    println(func(1)("")('0'))
    println(func(0)("")('0'))
  }
}
