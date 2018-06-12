object implicitTest {
  //隐式方法定义
  implicit def folat2int(x : Float) : Int = x.toInt
  implicit def double2int(x : Double) : Int = x.toInt

  //隐式类定义，类只能有一个参数
  implicit class Dog(Str : String){
    def bark = println("name is barking")
  }

  def main(args: Array[String]): Unit = {
    val intValue : Int = 2.222;
    "".bark
    println(intValue)
  }
}


