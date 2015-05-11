//scala printf.scala ./printf.scala

import scala.io.Source

def widthOfLength(s:String) = s.length.toString.length

if (args.length > 0){
    val lines = Source.fromFile(args(0)).getLines().toList
    val longestLine = lines.reduceLeft((x,y) => if (x.length > y.length) x else y)
    val maxWidth = widthOfLength(longestLine)
    for (line <- lines){
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
    }
} else {
    Console.err.println("please enter file path")
}