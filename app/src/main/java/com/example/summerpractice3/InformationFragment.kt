package com.example.summerpractice3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.summerpractice3.databinding.FragmentInformationBinding

class InformationFragment : Fragment(R.layout.fragment_information) {
    private var binding: FragmentInformationBinding? = null
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformationBinding.bind(view)
        binding?.button?.setOnClickListener {
            findNavController().navigateUp()
        }
        val planet = getInfo()
        setInfo(planet)
        setImage(planet)
    }

    private fun getInfo(): Planet {
        val id = arguments?.getInt(ARG_ID)
        return PlanetRepository.list.single { it.id == id }
    }

    private fun setInfo(planet: Planet) {
        binding?.id?.text = "ID: ${planet.id}"
        binding?.name?.text = "Name: ${planet.name}"
        binding?.desc?.text = "Desc: ${planet.capitalkrator}"
    }

    private fun setImage(planet: Planet) {
        binding?.imageView?.let {
            Glide.with(this)
                .load(planet.url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.error)
                .apply(options)
                .into(binding!!.imageView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(ARG_ID, id)
            return bundle
        }
    }
}