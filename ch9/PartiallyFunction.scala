def f(x:Int, y:Int) = x + y

println(f(1,2))

val pf = f(1,_:Int)

println(pf(2))
println(pf)

val ppf = f _
println(f(1,2))
println(ppf)

