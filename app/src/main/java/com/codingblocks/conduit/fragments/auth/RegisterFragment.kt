package com.codingblocks.conduit.fragments.auth

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.codingblocks.conduit.R
import com.codingblocks.conduit.viewmodels.UsersViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    var viewModel: UsersViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(UsersViewModel::class.java)
        }

        btnRegister.setOnClickListener {
            viewModel?.registerUser(
                etEmail.text.toString(),
                etUsername.text.toString(),
                etPassword.text.toString()
            )
        }

        viewModel?.currentUser?.observe(
            { lifecycle },
            {
                Toast.makeText(context, "Registered as " + it.username, Toast.LENGTH_SHORT).show()
                activity?.supportFragmentManager?.popBackStack()
            }
        )

    }

}
