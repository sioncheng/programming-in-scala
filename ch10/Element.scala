abstract class Element {
	def contents : Array[String]
	def height = contents.length
	def width = if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts:Array[String]) extends Element {
	def contents : Array[String] = conts
}

class ArrayElement2 (
	val contents : Array[String]
) extends Element{}

class LineElement(s : String) extends ArrayElement(Array(s)){
	//override val height : Int = 1
	//override val width : Int = s.length
}

class UniformElement (
	ch : Char,
	override val height : Int,
	override val width : Int
) extends Element {
	private val line = ch.toString * width
	def contents : Array[String] = Array.fill(height)(line)
}

def printElement(e : Element) = println(e.height + "," + e.width)


val arr = Array("s1","s22")
println(arr.length)

val ae : Element = new ArrayElement(arr)
printElement(ae)

val le : Element = new LineElement("s1")
printElement(le)

val ce : Element = new UniformElement('h',2,4)
printElement(ce)
