package com.example.todaysproject.dependency_injection

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todaysproject.feature_currencies.data.local.AppDatabase
import com.example.todaysproject.feature_currencies.data.local.RoomDao
import com.example.todaysproject.feature_currencies.data.remote.api.CoinPaprikaApi
import com.example.todaysproject.feature_currencies.data.remote.api.CoinPaprikaApi.Companion.BASE_URL
import com.example.todaysproject.feature_currencies.data.repository.AppRepositoryImplementation
import com.example.todaysproject.feature_currencies.domain.repository.AppRepository
import com.example.todaysproject.feature_currencies.domain.use_cases.CurrencyUseCases
import com.example.todaysproject.feature_currencies.domain.use_cases.GetCurrencyById
import com.example.todaysproject.feature_currencies.domain.use_cases.GetCurrencyList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(app: Application): RoomDatabase {
        return Room.databaseBuilder(
            app,
            RoomDatabase::class.java,
            "room_db"
        ).build()
    }  

    @Provides
    @Singleton
    fun provideRepository(roomDatabase: AppDatabase, coinPaprikaApi: CoinPaprikaApi): AppRepository{
        return AppRepositoryImplementation(
            roomDao = roomDatabase.dao,
            coinPaprikaApi = coinPaprikaApi
        )
    }

    @Provides
    @Singleton
    fun provideCurrencyUseCases(appRepository: AppRepository): CurrencyUseCases {
        return CurrencyUseCases(
            getCurrencyById = GetCurrencyById(appRepository),
            getCurrencyList = GetCurrencyList(appRepository)
        )
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

}