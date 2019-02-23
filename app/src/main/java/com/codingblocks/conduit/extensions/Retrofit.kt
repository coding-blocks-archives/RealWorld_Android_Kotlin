package com.codingblocks.conduit.extensions

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

inline fun <T> Call<T>.enqueue(crossinline done: (t: Throwable?, response: Response<T>?) -> Unit) {
    this.enqueue(object: Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            done(t, null)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            done(null, response)
        }

    })
}