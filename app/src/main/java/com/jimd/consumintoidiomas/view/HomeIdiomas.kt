package com.jimd.consumintoidiomas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jimd.consumintoidiomas.data.dto.Idioma

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun homeIdiomas(){
    Scaffold {
        idiomas()
    }
}

@Composable
fun idiomas(viewModel: IdiomasViewModel = hiltViewModel()){
    LaunchedEffect(key1 = Unit){
        viewModel.getAllIdiomas()
    }
    val state = viewModel.state
    if (state.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }else{
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)){
            LazyColumn{
                items(state.idiomas){
                    myItem(it)
                }
            }
        }
    }
}
@Composable
fun myItem(idioma: Idioma){
    Column(modifier= Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Card {
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(15.dp)) {
                Text(text = idioma.codigo,modifier= Modifier
                    .padding(end = 25.dp)
                    .align(alignment = Alignment.CenterVertically), fontSize = 34.sp, fontWeight = FontWeight.Bold)
                Image(Icons.Default.ArrowForward, contentDescription = "", modifier=Modifier.align(alignment = Alignment.CenterVertically))
                Text(text = idioma.idioma,modifier= Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(alignment = Alignment.CenterVertically), textAlign = TextAlign.End,
                    fontSize = 24.sp, fontWeight = FontWeight.Bold)

            }
        }
    }
}