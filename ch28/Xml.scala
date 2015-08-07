class Dog (n:String,a:Int) {
	val name : String = n
	val age : Int = a

	override def toString = name

	def toXML = 
		<dog>
			<name>{name}</name>
			<age>{age}</age>
		</dog>

}

object Dog  {
	def fromXML (node: scala.xml.Node) : Dog = {
		val name = (node \ "name").text
		var age = (node \ "age").text.toInt 
		new Dog(name,age)
	}
}

val d = new Dog("john",4)

println(d)
println(d.toXML)
println(Dog.fromXML(d.toXML))

def nodeMatch (node: scala.xml.Node) : String = node match{
	case <age>{aget}</age> => aget.text
	case _ => "ha"
}

println(nodeMatch(<age>12</age>))