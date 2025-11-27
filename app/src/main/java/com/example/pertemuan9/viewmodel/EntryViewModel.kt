package com.example.pertemuan9.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pertemuan9.repositori.RepositoriSiswa
import com.example.pertemuan9.room.Siswa

class EntryViewModel (private val repositoriSiswa: RepositoriSiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIstateSiswa())
        private set
    private fun validasiInput (uistate: DetailSiswa = uiStateSiswa.detailSiswa ): Boolean{
        return with(uistate){
            name.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

data class DetailSiswa(
    val id: Int = 0,
    val name: String = "",
    val alamat: String = "",
    val telpon: String = "",
)

fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    name = name,
    alamat = alamat,
    telpon = telpon,
)

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false ): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    name = name,
    alamat = alamat,
    telpon = telpon
)
