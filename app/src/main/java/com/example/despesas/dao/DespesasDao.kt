package com.example.despesas.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.despesas.model.Despesa

@Dao
interface DespesasDao {

    @Insert
    fun salvar(despesa: Despesa): Long

    @Update
    fun atualizar(despesa: Despesa): Int

    @Query("SELECT * FROM tb_despesa ORDER BY desc_despesa COLLATE NOCASE ASC")
    fun listarTodasDespesas(): List<Despesa>

    @Query("SELECT * FROM tb_despesa WHERE id= :id")
    fun buscarPorId(id: Long): Despesa

}