package com.waleed.fwdfirstapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.waleed.fwdfirstapp.R
import com.waleed.fwdfirstapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding
    private var email = ""
    private var password = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        loginBinding.loginButton.setOnClickListener { view: View ->
            navigateToWelcome(view)
        }

        loginBinding.registerButton.setOnClickListener { view: View ->
            navigateToWelcome(view)
        }

        return loginBinding.root
    }

    private fun navigateToWelcome(view: View) {

        email = loginBinding.editTextEmail.text.toString()
        password = loginBinding.editTextPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Please enter email and password first", Toast.LENGTH_LONG)
                .show()

        } else {
            view.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToOnBoardFragment(
                )
            )

        }
    }
}
