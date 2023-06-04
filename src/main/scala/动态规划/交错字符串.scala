package 动态规划

object 交错字符串 {

  def main(args: Array[String]): Unit = {
    println(isInterleavev1("db","b","cbb"))
  }

  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    val l1 = s1.length
    val l2 = s2.length
    val l3 = s3.length
    if (l1+l2 != l3 ){
      return false
    }
    val arr = Array.ofDim[Boolean](l1 + 1, l2 + 1)
    arr(0)(0) = true;
    for (i <- 1 to l1){
      if(arr(i-1)(0) && s1(i-1) == s3(i-1)){
        arr(i)(0) = true;
      }
    }

    for (j <- 1 to l2) {
      if (arr(0)(j-1) && s2(j-1) == s3(j - 1)) {
        arr(0)(j) = true;
      }
    }


    for (i <- 1 to l1) {
      for (j <- 1 to l2) {
        val t  = s3(i+j-1)
        if ((arr(i-1)(j) && t == s1(i-1))|| (arr(i)(j-1) && t == s2(j-1)) ){
          arr(i)(j) = true;
        }
      }
    }
    arr(l1)(l2)
  }


  def isInterleavev1(s1: String, s2: String, s3: String): Boolean = {
    val l1 = s1.length
    val l2 = s2.length
    val l3 = s3.length
    if (l1 + l2 != l3) {
      return false
    }
    val arr = Array.ofDim[Boolean](l2 + 1)
    if (l2 == 0 && s1 != s3){
      return false
    }
      arr(0) = true

    for (j <- 1 to l2) {
      if (arr(j - 1) && s2(j - 1) == s3(j - 1)) {
        arr(j) = true;
      }
    }

    for (i <- 1 to l1) {
      for (j <- 0 to l2) {
        val t = s3(i + j - 1)
        if ((arr(j) && t == s1(i - 1)) || ( j >0 && arr(j - 1) && t == s2(j - 1))) {
          arr(j) = true;
        }else{
          arr(j) = false
        }
      }
    }
    arr(l2)
  }

}
