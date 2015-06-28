
abstract class Element {
	def contents : Array[String]
	def height = contents.length
	def width = if (height == 0) 0 else contents(0).length
	def above(that:Element) : Element = Element.elem(this.contents ++ that.contents)
	def beside(that:Element) : Element = 
		Element.elem(
			for ((line1,line2) <- this.contents zip that.contents) yield line1 + line2
		)
	override def toString : String = this.contents mkString "\n"
}

object Element {

	def elem(arr : Array[String]) : Element = new ArrayElement(arr)
	def elem(line : String) : Element = new LineElement(line)
	def elem(ch : Char, width : Int, height : Int) : Element = 
		new UniformElement(ch,width,height)
		
	private class ArrayElement(conts:Array[String]) extends Element {
		def contents : Array[String] = conts
	}

	private class ArrayElement2 (
		val contents : Array[String]
	) extends Element{}

	private class LineElement(s : String) extends ArrayElement(Array(s)){
		//override val height : Int = 1
		//override val width : Int = s.length
	}

	private class UniformElement (
		ch : Char,
		override val height : Int,
		override val width : Int
	) extends Element {
		private val line = ch.toString * width
		def contents : Array[String] = Array.fill(height)(line)
	}
}


def printElement(e : Element) = println(e.height + "," + e.width)


val arr = Array("s1","s22")
println(arr.length)

val ae : Element = Element.elem(arr)
printElement(ae)

val le : Element = Element.elem("s1")
printElement(le)

val ce : Element = Element.elem('h',2,4)
printElement(ce)

println((ae above le).toString)
println((ae beside ce).toString)
