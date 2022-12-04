package 枚举
import scala.util.control.Breaks.{break, breakable}

@main def 生理周期: Unit = 
  val N = 21252
  var p,e,i,d,caseNo=0
  p =5
  e=20
  i=34
  d= 325
  for(k <- d to N){
    if((k-p)%23==0 && (k-e)%28==0 && (k-i)%33==0){
        println(s"""caseNo:$caseNo,${k-d}
        """.stripMargin)
        caseNo +=1
    }
  }


  breakable{

  
    for(k <- d to N ){
        if ((k-p)%23==0){
            for (x <- k to N by 23){
                if((x -e)%28 ==0){
                    for(y <- x to N by 23*28){
                        if((y-i)%33 == 0){
                            println(s"""caseNo:$caseNo,${y-d} """.stripMargin)
                            caseNo +=1
                            break
                        }
                    }
                }
            }
        }
    }

  }




