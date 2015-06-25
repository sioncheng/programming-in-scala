def add(x:Int) = (y:Int) =>{ x + y }

def addOne = add(1)

println(addOne(10))
println(addOne(100))

def sum(x:Int)(y:Int) = x + y

def sumOne = sum(1) _

println(sumOne(10))
println(sumOne(100))