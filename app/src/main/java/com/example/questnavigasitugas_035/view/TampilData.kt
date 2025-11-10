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
