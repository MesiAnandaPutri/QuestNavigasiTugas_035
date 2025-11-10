package com.example.questnavigasitugas_035

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_035.view.Dashbord
import com.example.questnavigasitugas_035.view.Formulir
import com.example.questnavigasitugas_035.view.TampilData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class Navigasi {
    Login,
    Home,
    Formulir
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    // --- State Hoisting untuk Formulir ---
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedJk by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("") }

    // --- State untuk Validasi ---
    var isNamaError by remember { mutableStateOf(false) }
    var isAlamatError by remember { mutableStateOf(false) }
    var isJkError by remember { mutableStateOf(false) }
    var isStatusError by remember { mutableStateOf(false) }

    // --- State untuk Jeda & Dialog ---
    var isLoading by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    // --- Data Dropdown ---
    val listJk = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Belum Kawin", "Kawin", "Cerai")

    val coroutineScope = rememberCoroutineScope()

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Login.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Login.name) {
                Dashbord(
                    isLoading = isLoading,
                    onLoginClick = {
                        coroutineScope.launch {
                            isLoading = true
                            delay(2000L)
                            isLoading = false
                            navController.navigate(Navigasi.Home.name)
                        }
                    }
                )
            }
            composable(route = Navigasi.Home.name) {
                TampilData(
                    onBerandaClick = {
                        kembaliKeLogin(navController)
                    },
                    onFormulirClick = {
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }
            composable(route = Navigasi.Formulir.name) {
                Formulir(
                    nama = nama,
                    onNamaChange = { nama = it; isNamaError = false },
                    isNamaError = isNamaError,
                    alamat = alamat,
                    onAlamatChange = { alamat = it; isAlamatError = false },
                    isAlamatError = isAlamatError,

                    selectedJk = selectedJk,
                    onJkChange = { selectedJk = it; isJkError = false },
                    isJkError = isJkError,
                    listJk = listJk,

                    selectedStatus = selectedStatus,
                    onStatusChange = { selectedStatus = it; isStatusError = false },
                    isStatusError = isStatusError,
                    listStatus = listStatus,

                    onKembaliClick = {
                        kembaliKeHome(navController)
                    },
                    onSubmitClick = {
                        // Validasi semua field
                        isNamaError = nama.isEmpty()
                        isAlamatError = alamat.isEmpty()
                        isJkError = selectedJk.isEmpty()
                        isStatusError = selectedStatus.isEmpty()

                        if (!isNamaError && !isAlamatError && !isJkError && !isStatusError) {
                            showDialog = true
                        }
                    },

                    showDialog = showDialog,
                    onDismissDialog = { showDialog = false },
                    onConfirmDialog = {
                        showDialog = false

                        // --- KODE BARU UNTUK MENGOSONGKAN FORM ---
                        nama = ""
                        alamat = ""
                        selectedJk = ""
                        selectedStatus = ""
                        // --- AKHIR KODE BARU ---

                        // Pindah ke halaman list
                        kembaliKeHome(navController)
                    }
                )
            }
        }
    }
}

private fun kembaliKeHome(
    navController: NavHostController
) {
    navController.popBackStack(route = Navigasi.Home.name, inclusive = false)
}
