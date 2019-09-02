package com.rabie.githublatestrepositories.data.repository


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSerializer
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.rabie.githublatestrepositories.BuildConfig
import com.rabie.githublatestrepositories.data.remote.AppApi
import com.rabie.githublatestrepositories.data.remote.AppService

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        val builder = GsonBuilder()
                .registerTypeAdapter(List::class.java, JsonSerializer<List<*>> { list, t, jsc ->
                    if (list.size == 1) {
                        // Don't put single element lists in a json array
                        Gson().toJsonTree(list[0])
                    } else {
                        Gson().toJsonTree(list)
                    }
                });
        return builder.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().readTimeout(60,TimeUnit.SECONDS).addInterceptor(loggingInterceptor).build()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))

                .build()
    }

    @Singleton
    @Provides
    fun provideUserAPI(retrofit: Retrofit): AppApi {
        return retrofit.create(AppApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUserService(userApi: AppApi): AppService {
        return AppService(userApi)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userService: AppService): AppRepository {
        return AppRepository(userService )
    }

}