package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fabAnasayfa.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.anasayfaToKisiKayit)
        }

        var kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "1111")
        val k2 = Kisiler(2, "Mehmet", "2222")
        val k3 = Kisiler(3, "Beyza", "3333")
        val k4 = Kisiler(4, "Veli", "4444")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)


        val adapter = KisilerAdapter(requireContext(), kisilerListesi)
        binding.kisilerRv.adapter = adapter

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())// Alt alta
        //binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) // Yatay
        //binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false) // Dikey
        //binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) // İki sütunlu

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })
        return binding.root
    }
    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara", aramaKelimesi)

    }

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa", "onResume çalıştı")
    }
}