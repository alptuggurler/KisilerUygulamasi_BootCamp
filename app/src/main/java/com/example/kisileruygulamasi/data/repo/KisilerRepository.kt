package com.example.kisileruygulamasi.data.repo

import android.util.Log
import com.example.kisileruygulamasi.data.datasource.KisilerDataSoruce
import com.example.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerRepository {
    var kisilerDataSoruce = KisilerDataSoruce()

    suspend fun kaydet(kisi_ad: String, kisi_tel: String) =
        kisilerDataSoruce.kaydet(kisi_ad, kisi_tel)

    suspend fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) =
        kisilerDataSoruce.guncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun sil(kisi_id: Int) = kisilerDataSoruce.sil(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kisilerDataSoruce.kisileriYukle()

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = kisilerDataSoruce.ara(aramaKelimesi)

}