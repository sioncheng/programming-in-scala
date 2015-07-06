abstract class Expr

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