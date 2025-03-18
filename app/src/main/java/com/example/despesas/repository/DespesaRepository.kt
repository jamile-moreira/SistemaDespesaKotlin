package com.example.despesas.repository

import android.content.Context
import com.example.despesas.database.DespesaBd
import com.example.despesas.model.Despesa

class DespesaRepository(context: Context) {

    private val bd = DespesaBd.getBancoDados(context).despesaDao()

    fun salvar(despesa: Despesa): Long {
        return bd.salvar(despesa)
    }

    fun atualizar(despesa: Despesa): Int {
        return bd.atualizar(despesa)
    }

    fun listarTodasDespesas(): List<Despesa> {
        return bd.listarTodasDespesas()
    }

    fun buscarDespesaPorId(id: Long): Despesa {
        return bd.buscarPorId(id)
    }

}