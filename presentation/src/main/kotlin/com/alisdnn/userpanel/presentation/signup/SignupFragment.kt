package com.alisdnn.userpanel.presentation.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alisdnn.userpanel.presentation.R
import com.alisdnn.userpanel.presentation.databinding.FragmentSignupBinding
import com.alisdnn.userpanel.presentation.extension.viewBinding
import com.alisdnn.userpanel.presentation.base.util.isValidEmail
import com.alisdnn.userpanel.presentation.base.util.isValidPassword
import com.alisdnn.userpanel.presentation.extension.observe
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
            formValidation()
        }
    }

    private fun setupViewModel() {
        viewModel.run {

            observe(isUserAdmin,::checkSignupProcess)

        }
    }

    private fun checkSignupProcess(isUserAdmin: Boolean) {
        if(isUserAdmin)
            navigateToAdminFragment()
        else
            navigateToProfileFragment()
    }

    private fun navigateToProfileFragment() {

    }

    private fun navigateToAdminFragment() {

    }

    private fun formValidation() {
        val fullname = binding.tietFullname.text.toString().trim()
        val fullnameTextInputLayout = binding.tilFullname
        val username = binding.tietUsername.text.toString().trim()
        val usernameTextInputLayout = binding.tilUsername
        val password = binding.tietPassword.text.toString().trim()
        val passwordTextInputLayout = binding.tilPassword
        val confirmPassword = binding.tietConfirmPassword.text.toString().trim()
        val confirmPasswordTextInputLayout = binding.tilConfirmPassword

        fullnameTextInputLayout.error = ""
        usernameTextInputLayout.error = ""
        passwordTextInputLayout.error = ""
        confirmPasswordTextInputLayout.error = ""
        binding.textViewSignupError.text = ""

        var isFormValid = true

        if (fullname.isEmpty()) {
            isFormValid = false
            fullnameTextInputLayout.error = "Please enter a name"
        }

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

        if (confirmPassword.isEmpty()) {
            isFormValid = false
            confirmPasswordTextInputLayout.error = "Please enter password confirmation"
        } else if (password != confirmPassword) {
            isFormValid = false
            confirmPasswordTextInputLayout.error =
                "Confirm password field is not equal to password"
        }


        if (isFormValid)
            viewModel.signupUser(username, fullname, password)

    }
}