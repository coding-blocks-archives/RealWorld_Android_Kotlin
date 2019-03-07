package com.codingblocks.conduit.fragments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.codingblocks.conduit.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        btnLogin.setOnClickListener {
            viewModel.loginUser(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }

        viewModel.currentUser.observe(
            { lifecycle },
            {
                Toast.makeText(context, "Logged in as " + it.username, Toast.LENGTH_SHORT).show()
            }
        )
    }

}
