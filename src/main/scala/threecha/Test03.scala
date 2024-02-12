package main.scala.threecha

object Test03 {
  // test03 用于验证字符串相关方法
  def main(args: Array[String]): Unit = {
    val `val` = 42
    println(`val`)
    println(`val`)

    val age = "12"
    val name = "zhangSan"
    println(age+ name)

    //字符串的常见用法
    val number = 2.2365//  默认Double 类型
    println(s"number = ${number}")// 模板字符串
    println(f"number = ${number}%.2f")// 保留两位小数 使用%传入字符串模板
    println(raw"number = ${number}%.2f")// 原始输出

    val sql =
      """
        | SELECT *
        | FROM STUDENT
        | WHERE
        | ID < 5
        |""".stripMargin // .stripMargin表示忽略边界



    println(sql)
    val sqlV2 =
      s"""
         |select
         |${name}
         |from tableA
         |where id > ${age}
         |""".stripMargin


    print(sqlV2)

  }
}
