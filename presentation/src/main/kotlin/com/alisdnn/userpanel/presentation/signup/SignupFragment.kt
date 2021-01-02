package com.alisdnn.userpanel.presentation.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alisdnn.userpanel.presentation.R
import com.alisdnn.userpanel.presentation.databinding.FragmentSignupBinding
import com.alisdnn.userpanel.presentation.extension.observe
import com.alisdnn.userpanel.presentation.extension.viewBinding
import com.alisdnn.userpanel.presentation.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : Fragment(R.layout.fragment_signup) {

    private val binding by viewBinding(FragmentSignupBinding::bind)

    private val viewModel: SignupViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupViewModel()
    }

    private fun setupUI() {
        activity?.title = "Signup"

        binding.buttonSignup.setOnClickListener {

        }
    }

    private fun setupViewModel() {
        viewModel.run {

        }
    }

}