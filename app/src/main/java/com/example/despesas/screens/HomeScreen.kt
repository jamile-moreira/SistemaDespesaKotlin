package com.example.despesas.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.despesas.repository.DespesaRepository

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var despesasRepository = DespesaRepository(LocalContext.current)
    val despesas = despesasRepository.listarTodasDespesas()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(32.dp)) {
            for (despesa in despesas){
                Card(
                    modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = despesa.descricaoDespesa, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(text = despesa.dataDespesa)
                        Text(text = despesa.valor.toString())
                    }
                }
            }
        }
    }
}