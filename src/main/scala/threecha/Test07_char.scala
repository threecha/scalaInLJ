package main.scala.threecha

object Test07_char {
  // 字符串和类型提升
  def main(args: Array[String]): Unit = {
    val c1: Char = '\"' // 表示双引号
    val c2 = '\\'  // 表示反斜杠自身
    println(c1)
    println(c2)

    val c3  = '\n' // 表示换行符
    val c4  = '\t' // 表示制表符

    println("这里验证换行符 \n" + "line1" + c3 +  "value2" )
    println("这里验证制表符 \t" + "line1" + c4 +  "value2" )



    val c5 = 'a' // 字符
    val c6 = '9'
    println(c6.toInt)

    val c7 : Int = c6+1 // 隐式转换

    println(c7)
    println(c5.toByte)

    // 空类型Unit
    def mUnit():Unit = {
      println("Unit 测试方法")
    }
    val  a : Unit = mUnit()
    println(a)

    // 空引用类型 Null 唯一实例null
//    var tempThreeX = new ThreeX(30,"sancha")
//    tempThreeX = null
//    println(" test for Null " +  tempThreeX)

  }

}
