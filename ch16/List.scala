var ll = List(1,2,3)

val first::second::third = ll

println(first)
println(second)
println(third)


def insert(x : Int, l : List[Int]) : List[Int] = {
	if (l.isEmpty || x < l.head) x :: l
	else l.head :: insert(x, l.tail)
}


def iSort(l : List[Int]) : List[Int] = {
	if (l.isEmpty) Nil 
	else insert(l.head,iSort(l.tail))
}


println(insert(4,insert(5,ll)))

val lll = List(234,23,423,404,3,1,-1)
println(iSort(lll))
println(insert(9,iSort(lll)))


def append[T](xs : List[T], ys : List[T]) : List[T] = xs match {
	case List() => ys
	case x :: xs1 => x :: append(xs1,ys)
}

println(iSort(append(ll,lll)))