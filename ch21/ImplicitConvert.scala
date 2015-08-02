import scala.language.implicitConversions

val i = 1
println(i + "abc")

val j = 1
println("abc" + j)

implicit def doubleToInt(d: Double) = d.toInt

val d : Int = 3.5 //type conversion
println(d)

class Rational(n: Int, d: Int) extends Ordered[Rational] {
	require(d != 0)

    val numberArg : Int = n
    val denomArg : Int = d

    def this(n:Int) = this(n,1)

    def + (that : Rational) : Rational = {
        new Rational(this.number * that.denom + that.number * this.denom, 
            this.denom * that.denom)
    }

    def * (that : Rational) : Rational = {
        new Rational(this.number * that.number, this.denom * that.denom)
    }

    override def compare(that : Rational) = {
    	println("compare called")
    	println(this)
    	println(that)
    	(this.number*that.denom)-(that.number*that.denom)
    }

	lazy val number = numberArg / g
	lazy val denom = denomArg / g
	override def toString = number + "/" + denom

	private lazy val g = {
		require(denomArg != 0)
		gcd(numberArg, denomArg)
	}

	private def gcd(a: Int, b: Int) : Int = {
		if (b == 0) a else gcd (b, a % b)
	}
}



var half = new Rational(2,4)
println(half)

implicit def intToRational(x:Int) : Rational = new Rational(x)

println(half + 2) //type conversion

def maxListImplicitParam[T] (elements:List[T]) (implicit orderer: T => Ordered[T]) : T = {
	elements match {
		case List() => throw new IllegalArgumentException("empty list!")
		case List(x) => x
		case x :: rest => 
			val maxRest = maxListImplicitParam(rest)(orderer)
			if (x > maxRest) x else maxRest
	}
}

println(maxListImplicitParam(List(2,45,13,4)))

println(maxListImplicitParam(List(new Rational(1,2),new Rational(3,4),new Rational(4,5))))