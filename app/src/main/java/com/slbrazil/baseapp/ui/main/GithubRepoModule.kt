package com.slbrazil.baseapp.ui.main

import com.slbrazil.gitrepo.GithubRepository
import com.slbrazil.gitrepo.GitHubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ServiceComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class GithubRepoModule {

    @Binds
    abstract fun bindGithubRepository(gitHubRepositoryImpl: GitHubRepositoryImpl) : GithubRepository

}