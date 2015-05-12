//oo in scala
class checkSum{
    private var sum : Int = 0 
    def add(b:Int) {sum += b}
    def check():Int = ~(sum & 0xFF) + 1
}

var c1 = new checkSum
c1.add(10)
println(c1.check())