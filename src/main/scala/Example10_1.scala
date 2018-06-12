object Example10_1 extends App {

  /**
    * 隐式对象创建
    *
    * @tparam T
    */
  trait Multiplicable[T] {
    def multiply(x: T): T
  }

  implicit object MultiplicableInt extends Multiplicable[Int] {
    override def multiply(x: Int): Int = {
      x * x
    }
  }

  implicit object MultiplicableString extends Multiplicable[String] {
    override def multiply(x: String): String = {
      x * 2
    }
  }

  //  def multiply1[T:Multiplicable](x:T) ={
  //    //implicitly方法，访问隐式对象
  //    val ev = implicitly[Multiplicable[T]]
  //    //根据具体的类型调用相应的隐式对象中的方法
  //    ev.multiply(x)
  //  }

  //和def multiply1[T:Multiplicable](x:T)作用一样
  def multiply1[T: Multiplicable](x: T)(implicit ev: Multiplicable[T]) = {
    //根据具体的类型调用相应的隐式对象中的方法
    ev.multiply(x)
  }

  println(multiply1(5))
  println(multiply1("5"))
}
