package main.scala.threecha

/**
 *  Example: 实现集合的+1操作
 */
object Test13_HighOrderFunction_Example {
  def main(args: Array[String]): Unit = {
    val targetArrays = Array(12,14,29,31,100)

    def arrayOperation(input:Array[Int],op:Int=>Int):Array[Int]= for(element <- input)yield op(element)
    def addOne(element:Int):Int = element+1

    println(arrayOperation(targetArrays,addOne).mkString(","))
    println(arrayOperation(targetArrays,_+1).mkString(","))
    println(arrayOperation(targetArrays,a => a+1 ).mkString(","))

  }

}
