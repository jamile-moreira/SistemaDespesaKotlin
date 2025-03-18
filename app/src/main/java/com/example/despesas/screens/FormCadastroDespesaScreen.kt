package com.example.despesas.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.despesas.model.Despesa
import com.example.despesas.repository.DespesaRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormCadastroDespesaScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val despesaRepository = DespesaRepository(context)

    var descricaoState = remember {
        mutableStateOf("")
    }

    var dataState = remember {
        mutableStateOf("")
    }

    var valorState = remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Botão voltar"
                    )
                    Text(text = "Nova Dispesa")
                }

            }
        )
    }) { paddingValue ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            Column(modifier = Modifier.padding(32.dp)) {
                OutlinedTextField(
                    value = descricaoState.value,
                    onValueChange = {
                        descricaoState.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Descrição da despesa")
                    }
                )
                OutlinedTextField(
                    value = dataState.value,
                    onValueChange = {
                        dataState.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Data da despesa")
                    }
                )
                OutlinedTextField(
                    value = valorState.value,
                    onValueChange = {
                        valorState.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Valor da despesa")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal
                    )
                )
                Button(
                    onClick = {
                        val despesa = Despesa(
                            descricaoDespesa = descricaoState.value,
                            dataDespesa = dataState.value,
                            valor = valorState.value.toDouble()
                        )
                        var numeroDespesa = despesaRepository.salvar(despesa)
                        if (numeroDespesa > 0) {
                            Toast.makeText(
                                context,
                                "Despesa $numeroDespesa cadastro com sucesso!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Gravar Despesa")
                }
            }
        }
    }
}

@Preview
@Composable
private fun FormCadastroDespesaScreenPreviwe() {
    FormCadastroDespesaScreen()
}