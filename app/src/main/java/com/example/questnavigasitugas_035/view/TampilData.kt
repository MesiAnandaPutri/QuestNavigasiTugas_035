package com.example.questnavigasitugas_035.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_035.R
import com.example.questnavigasitugas_035.ui.theme.GradientEnd
import com.example.questnavigasitugas_035.ui.theme.GradientStart
import com.example.questnavigasitugas_035.ui.theme.MediumGray
import kotlinx.coroutines.delay

data class FormData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

private val listPendaftar = listOf(
    FormData(
        nama = "Asroni Sukirman",
        gender = "Laki-laki",
        status = "Cerai",
        alamat = "Sleman"
    ),
    FormData(
        nama = "Aprilia Kurniati",
        gender = "Perempuan",
        status = "Lajang",
        alamat = "Bantul"
    ),
    FormData(
        nama = "Haris Setyawan",
        gender = "Laki-laki",
        status = "Kawin",
        alamat = "Jogja"
    ),
    FormData(
        nama = "Haris Setyawan",
        gender = "Laki-laki",
        status = "Kawin",
        alamat = "Jogja"
    ),
    FormData(
        nama = "Haris Setyawan",
        gender = "Laki-laki",
        status = "Kawin",
        alamat = "Jogja"
    ),
    FormData(
        nama = "Haris Setyawan",
        gender = "Laki-laki",
        status = "Kawin",
        alamat = "Jogja"
    ),
    FormData(
        nama = "Haris Setyawan",
        gender = "Laki-laki",
        status = "Kawin",
        alamat = "Jogja"
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isDataLoading by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = true) {
        delay(1500L)
        isDataLoading = false
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.list_title),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(GradientStart, GradientEnd)
                    )
                )
                .padding(paddingValues = isiRuang)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isDataLoading) {
                Spacer(modifier = Modifier.weight(1f))
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(48.dp)
                )
                Text(
                    text = "Memuat data...",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 16.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            } else {
                if (listPendaftar.isEmpty()) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Belum ada data pendaftar.",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(32.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(listPendaftar) { peserta ->
                            CardItem(peserta = peserta)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = onBerandaClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .padding(end = 8.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = MaterialTheme.colorScheme.onTertiary
                        )
                    ) {
                        Icon(Icons.Filled.Home, contentDescription = "Beranda", modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(text = stringResource(id = R.string.list_button_beranda))
                    }
                    Button(
                        onClick = onFormulirClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .padding(start = 8.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Formulir", modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(text = stringResource(id = R.string.list_button_formulir))
                    }
                }
            }
        }
    }
}
