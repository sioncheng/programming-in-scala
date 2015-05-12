//oo in scala

import scala.collection.mutable.Map

class CheckSum{
    private var sum : Int = 0 
    def add(b:Byte) {sum += b}
    def check():Int = ~(sum & 0xFF) + 1
}

object CheckSum {
    private val cache = Map[String,Int]()

    def calculate(s:String) : Int = {
        if (cache.contains(s)) {
            cache(s)
        } else {
            val cc = new CheckSum
            for (c <- s) {
                cc.add(c.toByte)
            }
            val cs = cc.check()
            cache += (s -> cs)
            cs
        }
    }
}

//println(CheckSum.calculate("hello"))

//println(CheckSum.calculate("hello"))


