val filesHere = (new java.io.File(".")).listFiles

val scalaFiles = for {
	file <- filesHere if file.isFile && file.getName.endsWith(".scala")
} yield file

for (file <- scalaFiles)
	println(file)