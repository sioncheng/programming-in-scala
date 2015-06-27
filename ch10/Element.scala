abstract class Element {
	def contents : Array[String]
	val height = contents.length
	val width = if (height == 0) 0 else contents(0).length
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

val arr = Array("s1","s22")
println(arr.length)

val ae : Element = new ArrayElement(arr)
println(ae.height + "," + ae.width)

val le : Element = new LineElement("s1")
println(le.height + "," + le.width)
