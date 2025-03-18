package com.example.despesas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.despesas.dao.DespesasDao
import com.example.despesas.model.Despesa

@Database(entities = [Despesa::class], version = 1)
abstract class DespesaBd: RoomDatabase() {

    abstract fun despesaDao(): DespesasDao
    //singleton
    companion object {
        private lateinit var instanciaBd: DespesaBd
        fun getBancoDados(context: Context): DespesaBd {
            if (!::instanciaBd.isInitialized) {
                instanciaBd = Room
                    .databaseBuilder(
                        context,
                        DespesaBd::class.java,
                        "bd_despesa"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instanciaBd
        }
    }
}