package com.example.pertemuan9.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context // 1. Perhatikan import ini

@Database(entities = [Siswa::class], version = 1, exportSchema = false )
abstract class DatabaseSiswa : RoomDatabase() {
abstract fun siswaDao(): SiswaDao

    companion object {
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa{
            return (Instance?: synchronized(this){
                Room.databaseBuilder(
                    context, DatabaseSiswa::class.java,
                    "Siswa_database")
                    .build().also{Instance = it}
            })
        }
    }
}