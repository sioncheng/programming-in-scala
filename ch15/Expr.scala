sealed abstract class Expr //require the sub classes in the same file

case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

val vx = Var("x")
println(vx.name)

def simplifyTop(expr:Expr) = expr match {
	case UnOp("-", UnOp("-",e)) => e
	case BinOp("+", e, Number(0)) => e 
	case BinOp("*", e, Number(1)) => e
	case BinOp("/", e, Number(1)) => e
	case _ => expr 
}

val expr = simplifyTop(UnOp("-", UnOp("-",Number(100))))

println(expr == Number(100))

//constant patterns
def describe(x:Any) = x match {
	case 1 => "one"
	case true => "truth"
	case "hello" => "hi"
	case Nil => "the emplty list"
	case _ => "something else"
}

println(describe(1))
println(describe("hello"))
println(describe("hahah"))

//constructor patterns

def list03(x:Any) = x match {
	case List(0, _, _) => "found"
	case _ => "what?"
}

def list0(x:Any) = x match {
	case List(0, _*) => "found"
	case _ => "what?"
}

println(list03(List(0,1,2)))
println(list03(List(0,1,2,3)))
println(list0(List(0,1,2,3)))


//typed patterns
def generalSize(x:Any) = x match {
	case s : String => s.length
	case m : Map[_,_] => m.size
	case l : List[_] => l.length
	case _ => -1
}

println(generalSize("hahah"))
println(generalSize(List(1,2,3,4,5)))

//
def generalSizeFunc(x:Any) = {
	if (x.isInstanceOf[String]) {
		val s = x.asInstanceOf[String]
		s.length
	} else if (x.isInstanceOf[Map[_,_]]) {
		val m  = x.asInstanceOf[Map[_,_]]
		m.size
	} else if (x.isInstanceOf[List[_]]) {
		val l = x.asInstanceOf[List[_]]
		l.length
	} else {
		-1
	}
}
println(generalSizeFunc(List(1,2)))

def describeExpr(e:Expr) : String = (e: @unchecked) match {
	case Number(_) => "number"
	case Var(_) => "variable"
	//case _ => throw new RuntimeException 
}

println(describeExpr(Var("y")))

val abs = UnOp("abs",UnOp("abs",Var("1")))

//variable binding
val e = abs match {
	case UnOp("abs", e @ UnOp("abs",_)) => e
	case _ => 
}

println(e)

//patterns everywhere
val UnOp(left,right) = e
println(left)
println(right)

val Var(n) = right
println(n)