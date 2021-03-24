package com.wl.androidlearning.hilt

import android.app.Application
import com.wl.androidlearning.MyApplication
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun providerMyApplication(application:Application):MyApplication{
        return application as MyApplication
    }
}