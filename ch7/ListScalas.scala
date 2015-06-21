val filesHere = (new java.io.File(".")).listFiles

for (file <- filesHere if file.isFile && file.getName.endsWith(".scala"))
	println(file)