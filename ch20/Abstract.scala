trait Abstract {
	type T //abstract type member
	def transform(x: T): T
	val initial: T //abstract val member
	val current: T
}

class Concrete extends Abstract {
	type T = String //give type member T as an alias of String
	def transform(x: String) : String = x + x
	val initial = "hi"
	val current = initial
	val haha: T = "hahah" //haha is String
}

val c = new Concrete()
println(c.initial)
println(c.transform("hello"))
println(c.haha)

trait AbstractTime {
	var hour: Int
	var minute: Int
	/*
	equals to
	def hour: Int
	def hour_= (x: Int)
	def minute: Int
	def minute_= (x: Int)
	*/
}

class ConcreteTime extends AbstractTime {
	private[this] var _hour: Int = 0
	def hour:Int = this._hour
	def hour_=(h: Int): Unit = {this._hour = h}

	private[this] var _minute: Int = 0
	def minute:Int = this._minute
	def minute_=(m: Int): Unit = {this._minute = m}
}

val ct = new ConcreteTime()
ct.hour = 10
println(ct.hour)

trait LazyRationalTrait {
	val numerArg: Int
	val denomArg: Int
	lazy val number = numerArg / g
	lazy val denom = denomArg / g
	override def toString = number + "/" + denom

	private lazy val g = {
		require(denomArg != 0)
		gcd(numerArg, denomArg)
	}

	private def gcd(a: Int, b: Int) : Int = {
		if (b == 0) a else gcd (b, a % b)
	}
}

val rt = new LazyRationalTrait{val numerArg = 5; val denomArg = 10}
println(rt)