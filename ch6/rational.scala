class Rational (n:Int,d:Int) {
    require(d != 0)

    val number : Int = n
    val denom : Int = d

    def this(n:Int) = this(n,1)

    def + (that : Rational) : Rational = {
        new Rational(this.number * that.denom + that.number * this.denom, 
            this.denom * that.denom)
    }

    def * (that : Rational) : Rational = {
        new Rational(this.number * that.number, this.denom * that.denom)
    }

    override def toString() : String = {
        this.number + "/" + this.denom
    }
}


val r1 = new Rational(2,1)

println(r1)

val r2 = new Rational(3,1)

println(r1 + r2)

val r3 = new Rational(4,1)

println(r1 + r2 * r3)

val r4 = new Rational(5)

println(r1.+(r4))
