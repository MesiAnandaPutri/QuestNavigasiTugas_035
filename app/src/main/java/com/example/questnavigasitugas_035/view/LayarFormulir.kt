package com.example.questnavigasitugas_035.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_035.R
import com.example.questnavigasitugas_035.ui.theme.GradientEnd
import com.example.questnavigasitugas_035.ui.theme.GradientStart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(
    nama: String,
    onNamaChange: (String) -> Unit,
    isNamaError: Boolean,
    alamat: String,
    onAlamatChange: (String) -> Unit,
    isAlamatError: Boolean,
    selectedJk: String,
    onJkChange: (String) -> Unit,
    isJkError: Boolean,
    listJk: List<String>,
    selectedStatus: String,
    onStatusChange: (String) -> Unit,
    isStatusError: Boolean,
    listStatus: List<String>,
    onSubmitClick: () -> Unit,
    onKembaliClick: () -> Unit,
    modifier: Modifier = Modifier,

    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    onConfirmDialog: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismissDialog,
            title = { Text(text = "Konfirmasi Pendaftaran", fontWeight = FontWeight.Bold) },
            text = { Text(text = "Data Anda berhasil disimpan. Lanjut ke daftar peserta?", style = MaterialTheme.typography.bodyLarge) },
            confirmButton = {
                Button(
                    onClick = onConfirmDialog,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(text = "Ya, Lanjut")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = onDismissDialog,
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(text = "Tidak")
                }
            }
        )
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.form_title),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
