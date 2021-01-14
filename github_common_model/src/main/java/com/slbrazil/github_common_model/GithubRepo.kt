package com.slbrazil.github_common_model

class GithubRepo {

     var ownerName: String = ""
     var repoName: String = ""
     var noOfForks: Int = 0
     var noOfStarts: Int = 0
     var avatar: String = "";

     override fun equals(other: Any?): Boolean {
          if (this === other) return true
          if (javaClass != other?.javaClass) return false

          other as GithubRepo

          if (ownerName != other.ownerName) return false
          if (repoName != other.repoName) return false
          if (noOfForks != other.noOfForks) return false
          if (noOfStarts != other.noOfStarts) return false
          if (avatar != other.avatar) return false

          return true
     }

     override fun hashCode(): Int {
          var result = ownerName.hashCode()
          result = 31 * result + repoName.hashCode()
          result = 31 * result + noOfForks
          result = 31 * result + noOfStarts
          result = 31 * result + avatar.hashCode()
          return result
     }

     override fun toString(): String {
          return "GithubRepo(repoName='$repoName')"
     }


}