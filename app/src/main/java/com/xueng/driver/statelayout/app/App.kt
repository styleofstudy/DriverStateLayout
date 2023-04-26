package com.xueng.driver.statelayout.app

import android.app.Application
import com.xueng.driver.statelayout.StateConfig
import com.xueng.driver.statelayout.handler.FadeStateChangedHandler

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        StateConfig.apply {
            emptyLayout = R.layout.layout_empty
            errorLayout = R.layout.layout_error
            loadingLayout = R.layout.layout_loading
            stateChangedHandler=FadeStateChangedHandler()
            setRetryIds(R.id.msg,R.id.iv)

        }
    }

}