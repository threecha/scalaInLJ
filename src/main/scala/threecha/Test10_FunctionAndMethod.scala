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
    // 测试可变参数
    moreInOneParam("我的家乡在","东北","松花江上头")
    mixParams(29,"湖北","threeX")
    defaultParam(29)
    //使用自定义传参
    defaultParam(29,"threeX")
    defaultParamWithNoEnd(name = "3X")
    moreThenOneDefaultParam(15)

  }

  private def sayHi(): Unit={
    println("Hi I am 3X out method")
  }

  // 测试可变参数
  private def moreInOneParam(params:String*):Unit = {
    println(params)
  }

  // 可变参数 + 普通参数请款 可变参数一般放在末尾
  private def mixParams(age:Int,names:String*):Unit = {
    println(s"我的age $age" + names )
  }

  // 方法带默认值情况 默认值也是一般放在最后
  private def defaultParam(age:Int,name:String = "3X"):Unit = {
    println(s"age==$age+name==>$name")
  }

  // 多个默认参数

  private def moreThenOneDefaultParam(age: Int, name: String = "3X",city:String="SK"): Unit = {
    println(s"age==$age+name==>$name+$city")
  }

  private def defaultParamWithNoEnd(age: Int = 35, name: String): Unit = {
    println(s"age==$age+name==>$name")
  }
}
