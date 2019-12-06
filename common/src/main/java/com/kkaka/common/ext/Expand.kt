package com.kkaka.common.ext

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kkaka.common.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Laizexin on 2019/12/2
 * @description 拓展函数
 */
fun <T> Observable<T>.execute(observer: Observer<T>) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun TextView.str(): String {
    return this.text.toString().trim()
}

fun ImageView.loadImage(context: Context, path: String, placeholder: Int = R.drawable.ic_placeholder, error: Int = R.drawable.ic_error,Cache: Boolean =false) {

    val options = RequestOptions()
        .placeholder(placeholder)
        .error(error)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .override(150, 200)

    Glide.with(context).load(path).apply(options).into(this)
}