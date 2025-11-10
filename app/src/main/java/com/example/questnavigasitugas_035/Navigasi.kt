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
