import CheckSum.calculate

object Summer {
    def main(args : Array[String]){
        for (arg <- args){
           println("check sum of " + arg + " : " + calculate(arg))
        }
    }
}