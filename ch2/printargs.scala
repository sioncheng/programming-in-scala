//scala printargs.scala scala is very good.

println("while loop, println.")
var i = 0 

while ( i < args.length ) {
    println(args(i))
    i += 1
}
println()

println("while loop, if, print.")
i = 0
while (i < args.length){
    if (i != 0){
        print(" ")
    }
    print(args(i))
    if (i == args.length - 1){
        println()
    }
    i += 1
}
println()

println("foreach, println.")
args.foreach(arg=>println(arg))
println()

println("for <-, print.")
for (arg <- args) {
    println(arg)
}
println()