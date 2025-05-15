package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSoruce(var kisilerDao: KisilerDao) {
    suspend fun kaydet(kisi_ad: String, kisi_tel: String) {
        val kisi = Kisiler(0, kisi_ad, kisi_tel)
       kisilerDao.kaydet(kisi)
    }

    suspend fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
        val kisi = Kisiler(kisi_id, kisi_ad, kisi_tel)
        kisilerDao.guncelle(kisi)
    }

    suspend fun sil(kisi_id:Int){
        val silineneKisi = Kisiler(kisi_id, "", "")
        kisilerDao.sil(silineneKisi)
        Log.e("Kişi Sil", kisi_id.toString())
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){

        return@withContext kisilerDao.kisileriYukle()
    }
    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kisilerDao.ara(aramaKelimesi)
    }
}