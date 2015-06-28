

trait Philosophical {
	def philosophize(){
		println("I consume memory,therefore I am !")
	}
}

class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs{
	override def toString = "green"
	override def philosophize(){
		println("I am not easy being " + toString + "!")
	}
}


val f : Frog = new Frog()
f.philosophize()

val a : Animal = f
println(a.toString)

val p : Philosophical = f
p.philosophize()