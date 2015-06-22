
val arg0 = if (!args.isEmpty) args(0) else "default"

println(arg0)

val friend = arg0 match {
	case "salt" => "pepper"
	case "chips" => "salsa"
	case "eggs" => "bacon"
	case _ => "huh?"
}

println(friend)