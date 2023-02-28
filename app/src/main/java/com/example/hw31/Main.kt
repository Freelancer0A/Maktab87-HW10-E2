package com.example.hw31

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.hw31.databinding.FragmentMainBinding

class Main : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var inputName: EditText
    private lateinit var inputUserName: EditText
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var inputPasswordRepeat: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        init()
        updateViews()
        buttonsClickListener()
        return binding.root
    }

    private fun updateViews() {
        viewModel.userName.observe(viewLifecycleOwner) { username ->
            inputUserName.setText(username)
        }
        viewModel.fullName.observe(viewLifecycleOwner) { fullName ->
            inputName.setText(fullName)
        }
        viewModel.email.observe(viewLifecycleOwner) { email ->
            inputEmail.setText(email)
        }
        viewModel.password.observe(viewLifecycleOwner) { password ->
            inputPassword.setText(password)
        }
        viewModel.rePass.observe(viewLifecycleOwner) { rePass ->
            inputPasswordRepeat.setText(rePass)
        }
    }

    private fun buttonsClickListener() {
        binding.btnRegister.setOnClickListener {
            if (fillProperty() && checkPasswords() && checkEmail()) {
                viewModel.setFullNAme(inputName.text.toString())
                viewModel.setUserName(inputUserName.text.toString())
                viewModel.setEmail(inputEmail.text.toString())
                viewModel.setPassword(inputPassword.text.toString())
                viewModel.setRePass(inputPasswordRepeat.text.toString())
                getGender()
            }
            binding.btnInfo.setOnClickListener {
                binding.root.findNavController().navigate(R.id.action_main_to_showInfo)
            }
        }
    }

    private fun getGender() {
        if (binding.radioGroup.checkedRadioButtonId == binding.radioMale.id) viewModel.setGender("Male")
        else viewModel.setGender("Female")
    }

    private fun checkEmail(): Boolean {
        val email = inputEmail.text.toString()
        return if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) true
        else {
            inputEmail.error = "enter valid email"
            false
        }
    }

    private fun fillProperty(): Boolean {
        if (inputName.text.toString() == "") {
            inputName.error = "enter your name"
            return false
        }
        if (inputUserName.text.toString() == "") {
            inputUserName.error = "enter your username"
            return false
        }
        if (inputEmail.text.toString() == "") {
            inputEmail.error = "enter your email"
            return false
        }
        if (inputPassword.text.toString() == "") {
            inputPassword.error = "enter your password"
            return false
        }
        if (inputPasswordRepeat.text.toString() == "") {
            inputPasswordRepeat.error = "repeat your username"
            return false
        }
        return true
    }

    private fun checkPasswords(): Boolean {
        return if (inputPassword.text.toString() == inputPasswordRepeat.text.toString()) {
            true
        } else {
            inputPasswordRepeat.error = "passwords not match"
            false
        }
    }

    private fun init() {
        inputName = binding.inFullName
        inputUserName = binding.inUserName
        inputEmail = binding.inEmail
        inputPassword = binding.inPassword
        inputPasswordRepeat = binding.inRetypePassword
    }
}