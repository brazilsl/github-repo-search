package com.slbrazil.gitrepo

import com.slbrazil.github_repo_service.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.ServiceComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object GithubModule {

    @Provides
    fun provideGithubService() : GithubService {
        val retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()

       return retrofit.create(GithubService::class.java)

    }

}