package com.alisdnn.userpanel.presentation.user.login

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alisdnn.userpanel.presentation.R
import com.alisdnn.userpanel.presentation.databinding.FragmentLoginBinding
import com.alisdnn.userpanel.presentation.extension.viewBinding
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        activity?.title = "Login"
        setSharedElementTransitionOnEnter()

        binding.buttonLogin.setOnClickListener {
            formValidation()
        }
        binding.buttonSignup.setOnClickListener {
            navigateToSignUpFragment()
        }
    }

    private fun navigateToSignUpFragment() {
        val action = LoginFragmentDirections.navigateToSignupFragment()
        findNavController().navigate(action)
    }

    private fun formValidation() {
        val username = binding.tietUsername.text.toString().trim()
        val usernameTextInputLayout = binding.tilUsername
        val password = binding.tietPassword.text.toString().trim()
        val passwordTextInputLayout = binding.tilPassword

        usernameTextInputLayout.error = ""
        passwordTextInputLayout.error = ""
        var isFormValid = true

        if (username.isEmpty()) {
            isFormValid = false
            usernameTextInputLayout.error = "Please enter an email"
        } else if (!isValidEmail(username)) {
            isFormValid = false
            usernameTextInputLayout.error = "Incorrect Username!\nUsername must be an email"
        }

        if (password.isEmpty()) {
            isFormValid = false
            passwordTextInputLayout.error = "Please enter a password"
        } else if (!isValidPassword(password)) {
            isFormValid = false
            passwordTextInputLayout.error =
                "Password field must contain numerical and capital values"
        }
        if (isFormValid)
            viewModel.checkUserValidity(username, password)

    }

    private fun setSharedElementTransitionOnEnter() {
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 400L
            isElevationShadowEnabled = true
            pathMotion = MaterialArcMotion()
            startElevation = 9f
            endElevation = 9f
            scrimColor = Color.TRANSPARENT
        }
    }

}