package com.example.shopingapp.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.example.shopingapp.MyApplication
import com.example.shopingapp.data.db.AppDatabase
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * An Utility class that having ViewModelModule for binding ViewModels
 * that provides App, context and resources to the scope
 * */
@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Singleton
    @Provides
    fun provideApp(app: Application): MyApplication {
        return app as MyApplication
    }

    @Singleton
    @Provides
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    fun provideResource(context: Context): Resources {
        return context.resources
    }

    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d("RoomDatabaseModule", "onCreate")
            CoroutineScope(Dispatchers.IO).launch {
            }
        }
    }

    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "dbshopapp.db")
            .createFromAsset("database/dbshopapp.db")
//            .fallbackToDestructiveMigration()
            .addCallback(databaseCallback)
            .allowMainThreadQueries()
            .addMigrations(MIGRATION_1_2)
            .build()
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE momin_data Add COLUMN itemId INTEGER NOT NULL default(1)")
            database.execSQL("ALTER TABLE momin_data Add COLUMN brandname TEXT NOT NULL default(1)")
            database.execSQL("ALTER TABLE momin_data Add COLUMN minimumQty TEXT NOT NULL default(1)")
            database.execSQL("ALTER TABLE momin_data Add COLUMN rate TEXT NOT NULL default(1)")
            database.execSQL("ALTER TABLE momin_data Add COLUMN imageUrl TEXT NOT NULL default(1)")

            //create table namaze ghoufayla is pennding
        }
    }


    @Singleton
    @Provides
    fun providesMominDataDao(database: AppDatabase) = database.mominDataDao()

}