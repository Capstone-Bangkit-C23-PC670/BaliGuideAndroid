package com.capstone.baliguide_app.ui.homepage.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.baliguide_app.databinding.FragmentHomeBinding
import com.capstone.baliguide_app.ui.cafe.CafeActivity
import com.capstone.baliguide_app.ui.culinary.CulinaryActivity
import com.capstone.baliguide_app.ui.homepage.HomeActivity
import com.capstone.baliguide_app.ui.homepage.HomepageActivity
import com.capstone.baliguide_app.ui.hotel.HotelActivity
import com.capstone.baliguide_app.ui.login.LoginActivity
import com.capstone.baliguide_app.ui.souvenir.SouvenirActivity
import com.capstone.baliguide_app.ui.tourism.TourismActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.cafeButton.setOnClickListener{
            val intent = Intent(requireContext(), CafeActivity::class.java)
            startActivity(intent)
        }

        binding.souvenirsButton.setOnClickListener{
            val intent = Intent(requireContext(), SouvenirActivity::class.java)
            startActivity(intent)
        }

        binding.hotelsButton.setOnClickListener{
            val intent = Intent(requireContext(), HotelActivity::class.java)
            startActivity(intent)
        }

        binding.culinaryButton.setOnClickListener{
            val intent = Intent(requireContext(), CulinaryActivity::class.java)
            startActivity(intent)
        }

        binding.touristButton.setOnClickListener{
            val intent = Intent(requireContext(), TourismActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}