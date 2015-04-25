import scala.collection._
import scala.util.Random
object fortr{
  def main(args:Array[String]){
    val order = Array(1025,1026,1027,1030)
    val data = Seq.fill(4294900)(Seq.fill(8)(Random.nextInt(1024)))
    val pair = data.map(_.zip(order.init:+1))
    val start_t = System.currentTimeMillis
    val zipnum = pair.map(_.foldRight(0)((a,b)=>a._1+b*a._2))
    val end_t = System.currentTimeMillis
    println (end_t - start_t)
//    println (zipnum)
    def f(zip:Int, curone:Int):Int = {
      val rez = zip % curone
  //    println (rez)
  //
      (zip - rez)/curone
    }
    val unziped = zipnum.map(order.foldLeft(_)(f))
  }
}
