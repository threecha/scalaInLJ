package main.scala.threecha

import java.io.{File, PrintWriter}


object Test06_FileIO {

  def main(args: Array[String]): Unit = {
    import scala.io.Source
    // 从文件中读取数据
    Source.fromFile("src/main/resources/test06.txt").foreach(print)

    // 写入数据到文件里
    val writer = new PrintWriter(new File("src/main/resources/test06_outPut.txt"))
    writer.write("line1==>value1")
    writer.close()
  }

}
