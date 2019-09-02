package com.rabie.githublatestrepositories.viewmodels

import com.rabie.githublatestrepositories.data.repository.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppViewModelomponent {
    fun inject(viewModel:AppViewModel)
}