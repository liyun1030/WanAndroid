package com.kkaka.common.callback

import com.kingja.loadsir.callback.Callback
import com.kkaka.common.R

/**
 * @author Laizexin on 2019/12/2
 * @description
 */
class ErrorCallback : Callback() {
    override fun onCreateView(): Int = R.layout.layout_error
}