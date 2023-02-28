package com.example.hw31

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hw31.databinding.FragmentShowInfoBinding

class ShowInfo : Fragment() {

    private lateinit var inputName: TextView
    private lateinit var inputUserName: TextView
    private lateinit var inputEmail: TextView
    private lateinit var inputPassword: TextView
    private lateinit var gender: TextView
    private lateinit var binding: FragmentShowInfoBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowInfoBinding.inflate(inflater, container, false)
        init()
        show()
        return binding.root
    }

    private fun show() {
        viewModel.fullName.observe(viewLifecycleOwner) { s ->
            inputName.text = s
        }
        viewModel.userName.observe(viewLifecycleOwner) { s ->
            inputUserName.text = s
        }
        viewModel.email.observe(viewLifecycleOwner) { s ->
            inputEmail.text = s
        }
        viewModel.password.observe(viewLifecycleOwner) { s ->
            inputPassword.text = s
        }
        viewModel.gender.observe(viewLifecycleOwner) { s ->
            gender.text = s
        }
    }

    private fun init() {
        inputName = binding.tvFullName
        inputUserName = binding.tvUserName
        inputEmail = binding.tvEmail
        inputPassword = binding.tvPassword
        gender = binding.tvGender
    }
}