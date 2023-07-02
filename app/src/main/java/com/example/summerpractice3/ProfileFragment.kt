package com.example.summerpractice3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpractice3.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var binding: FragmentProfileBinding? = null
    private var adapter: PlanetAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = PlanetAdapter(
            list = PlanetRepository.list,
            glide = Glide.with(this),
            onItemClick = { planet ->
                findNavController().navigate(
                    R.id.action_profileFragment_to_informationFragment,
                    InformationFragment.createBundle(planet.id)
                )
            }
        )
        binding?.rvPlanets?.adapter = adapter
    }
}