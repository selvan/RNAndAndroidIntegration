package com.example.rnandandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.rnandandroid.MyReactActivity
import com.example.rnandandroid.R
import com.example.rnandandroid.databinding.FragmentFirstBinding
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap




/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity is MyReactActivity) {
            binding.fireAnEvent.setOnClickListener {
                val myReactActivity = activity as MyReactActivity
                val params: WritableMap = Arguments.createMap()
                params.putString("shouldShow", true.toString())
                myReactActivity.sendAnEventToRN("showOverlay", params)
            }
        } else {
            binding.fireAnEvent.visibility = View.GONE
        }
        
        binding.buttonFirst.setOnClickListener {
            Log.d("FirstFragment", "Button is clicked")

             findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

//            val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//            navHostFragment.navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}