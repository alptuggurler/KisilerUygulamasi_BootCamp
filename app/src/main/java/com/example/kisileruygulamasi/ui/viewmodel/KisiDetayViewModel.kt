package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel  @Inject constructor(var kisilerRepository : KisilerRepository) : ViewModel(){

    fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.guncelle(kisi_id, kisi_ad, kisi_tel)
        }

    }
}