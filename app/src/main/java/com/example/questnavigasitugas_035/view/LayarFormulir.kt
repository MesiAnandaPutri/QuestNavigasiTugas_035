package com.example.questnavigasitugas_035.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
                    IconButton(onClick = onKembaliClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Kembali",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
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
                .padding(all = dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = onNamaChange,
                label = { Text(text = stringResource(id = R.string.nama_lengkap)) },
                placeholder = { Text(text = stringResource(id = R.string.form_nama_placeholder)) },
                isError = isNamaError,
                supportingText = {
                    if (isNamaError) {
                        Text(text = stringResource(id = R.string.validation_error), color = MaterialTheme.colorScheme.error)
                    }
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    errorBorderColor = MaterialTheme.colorScheme.error,
                    focusedLabelColor = MaterialTheme.colorScheme.secondary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    cursorColor = MaterialTheme.colorScheme.secondary,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.7f),
                    errorContainerColor = Color.Red.copy(alpha = 0.1f)
                )
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                // 1. Label
                Text(
                    text = stringResource(id = R.string.jenis_kelamin),
                    style = MaterialTheme.typography.bodySmall,
                    color = if (isJkError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(start = 4.dp, bottom = 4.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listJk.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(end = 24.dp)
                                .clickable { onJkChange(item) }
                        ) {
                            RadioButton(
                                selected = (item == selectedJk),
                                onClick = { onJkChange(item) },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MaterialTheme.colorScheme.primary,
                                    unselectedColor = if (isJkError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                                )
                            )
                            Text(
                                text = item,
                                color = if (isJkError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }

                if (isJkError) {
                    Text(
                        text = stringResource(id = R.string.validation_error),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }


            DropdownMenuBox(
                label = stringResource(id = R.string.status_perkawinan),
                pilihan = listStatus,
                selectedOption = selectedStatus,
                onOptionSelected = onStatusChange,
                placeholder = stringResource(id = R.string.form_pilih_status),
                isError = isStatusError // <-- Terapkan error state
            )

            OutlinedTextField(
                value = alamat,
                onValueChange = onAlamatChange,
                label = { Text(text = stringResource(id = R.string.alamat)) },
                placeholder = { Text(text = stringResource(id = R.string.form_alamat_placeholder)) },
                isError = isAlamatError,
                supportingText = {
                    if (isAlamatError) { // <-- Perbaikan typo
                        Text(text = stringResource(id = R.string.validation_error), color = MaterialTheme.colorScheme.error)
                    }
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    errorBorderColor = MaterialTheme.colorScheme.error,
                    focusedLabelColor = MaterialTheme.colorScheme.secondary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    cursorColor = MaterialTheme.colorScheme.secondary,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.7f),
                    errorContainerColor = Color.Red.copy(alpha = 0.1f)
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = onKembaliClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .padding(end = 8.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onSurface,
                        containerColor = Color.Transparent
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = Brush.horizontalGradient(
                            colors = listOf(MaterialTheme.colorScheme.tertiary, MaterialTheme.colorScheme.secondary)
                        ), width = 2.dp
                    )
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali", modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(text = stringResource(id = R.string.form_button_kembali))
                }
                Button(
                    onClick = onSubmitClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                        .padding(start = 8.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Icon(Icons.Filled.Done, contentDescription = "Submit", modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(text = stringResource(id = R.string.submit))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuBox(
    label: String,
    pilihan: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    isError: Boolean // <-- Parameter error
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            readOnly = true,
            value = selectedOption.ifEmpty { placeholder },
            onValueChange = {},
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                errorBorderColor = MaterialTheme.colorScheme.error,
                focusedLabelColor = MaterialTheme.colorScheme.secondary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                cursorColor = MaterialTheme.colorScheme.secondary,
                focusedContainerColor = Color.White.copy(alpha = 0.9f),
                unfocusedContainerColor = Color.White.copy(alpha = 0.7f),
                errorContainerColor = Color.Red.copy(alpha = 0.1f)
            ),
            isError = isError, // <-- Terapkan error state
            shape = MaterialTheme.shapes.medium
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            pilihan.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}