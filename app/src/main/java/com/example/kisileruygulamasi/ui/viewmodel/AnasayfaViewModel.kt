package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    var kisilerRepository = KisilerRepository()
    val kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()//View model oluşturuldu esnada çalışır.
    }

    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.sil(kisi_id)
            kisileriYukle()
        }
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            val liste = kisilerRepository.kisileriYukle()
            kisilerListesi.value = liste
        }
    }
    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            val liste = kisilerRepository.ara(aramaKelimesi)
            kisilerListesi.value = liste
        }
    }


}