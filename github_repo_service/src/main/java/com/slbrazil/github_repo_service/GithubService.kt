package com.slbrazil.github_repo_service

import com.slbrazil.github_common_model.GitRepositories

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubService {

    @Headers("Accept: application/vnd.github.v3+jsonn")
    @GET("/search/repositories")
    suspend fun search(@Query("q")  keywords: String, @Query("page") page: Int,
                       @Query("per_page")  per_page: Int): GitRepositories

}