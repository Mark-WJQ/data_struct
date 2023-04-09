package 枚举
import scala.util.control.Breaks.{break, breakable}

/**
 * 从 d+1 开始尝试，基本方法是每一个值都测试 是否满足生理周期
 * 实际上不需要每个值都尝试，当我们找到第一个满足''情商'' 的 天数后 x，再找同时满足情商与体力的值 y，必然是在x 的基础上找，x + 23
 *
 */
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




