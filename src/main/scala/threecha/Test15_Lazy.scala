package main.scala.threecha

object Test15_Lazy {
  def main(args: Array[String]): Unit = {
    /**
     * 变量声明为 lazy 后 会在调用时候加载
     *
     *
     */
    lazy val tempValue = add(1,2)
    println("code index is 11")
    def add(a:Int,b:Int) = {
      println("code index is 13")
      a+b
    }

    println(tempValue)// 调用时候 加载


  }
}
