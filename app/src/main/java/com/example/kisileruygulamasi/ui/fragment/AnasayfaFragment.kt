package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fabAnasayfa.setOnClickListener{
            //Navigation.findNavController(it).navigate(R.id.anasayfaToKisiKayit)
            Navigation.gecisYap(it,R.id.anasayfaToKisiKayit)
        }

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val adapter = KisilerAdapter(requireContext(), it,viewModel)
            binding.kisilerRv.adapter = adapter
        }



        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())// Alt alta
        //binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) // Yatay
        //binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false) // Dikey
        //binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) // İki sütunlu

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }



    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa", "onResume çalıştı")
        viewModel.kisileriYukle()
    }
}