import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
	def put(x:Int)
	def get():Int
}

class BasicIntQueue() extends IntQueue {
	private val buf = new ArrayBuffer[Int]()
	def put(x:Int) {
		buf += x
	}
	def get():Int = buf.remove(0)
}

trait Doubling extends IntQueue {
	abstract override def put(x:Int) {super.put(x*2)}
}

class DoubingIntQueue extends BasicIntQueue with Doubling

val iq : IntQueue = new DoubingIntQueue()
iq.put(2)
println(iq.get())