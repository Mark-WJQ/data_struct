package 枚举



@main def hello: Unit = {
  val N = 24;
  println(N)
/*   var a = 2;
  var b = 1;
  var c = 1;
  var d= 1; */
  for(a <- 2 to N){
    for(b <- 2 to a-1){
        for (c <- b to a-1) {
            for (d <- c to a-1){
                if(a*a*a == b*b*b + c*c*c + d*d*d){
                  val r = s"""Cube =$a
                  | Triple=($b,$c,$d)
                  """.stripMargin
                    println(r)
                }
            }
        }
    }

  }

  println("===============")

  for(b <- 2 to N){
    for(c <- b to N){
      for(d <- c to N){
        for (a <- d+1 to N){
          if(a*a*a == b*b*b + c*c*c + d*d*d){
                  val r = s"""Cube =$a
                  | Triple=($b,$c,$d)
                  """.stripMargin
                    println(r)
                }
        }
      }
    }
  }




}



