package com.example.pertemuan9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan9.viewmodel.DetailSiswa
import com.example.pertemuan9.viewmodel.UIStateSiswa
import com.example.pertemuan9.viewmodel.toSiswa
import com.example.pertemuan9.viewmodel.toUIStateSiswa
import com.example.pertemuan9.repositori.RepositoriSiswa
import com.example.pertemuan9.view.route.DestinasiDetailSiswa
import com.example.pertemuan9.view.route.DestinasiEditSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel(){
    var uiStateSiswa by mutableStateOf(value = UIStateSiswa())
        private set
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiEditSiswa.itemIdArg])
