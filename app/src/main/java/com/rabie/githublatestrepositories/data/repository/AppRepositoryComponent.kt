package com.rabie.githublatestrepositories.data.repository

import dagger.Component

@Component(modules = [AppModule::class])
interface AppRepositoryComponent {
    fun inject(appRepo:AppRepository)
}
