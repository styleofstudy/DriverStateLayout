package com.xueng.driver.statelayout.app

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.xueng.driver.app.DriverBaseActivity
import com.xueng.driver.statelayout.app.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : DriverBaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun initContent() {
        binding.state.onRefresh {
            // 一般这里进行网络请求, 推荐使用 https://github.com/liangjingkanji/Net
            thread {
                Thread.sleep(2000)
                showContent()
            }
        }.showLoading()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> binding.state.showLoading()
            R.id.menu_content -> binding.state.showContent()
            R.id.menu_error -> binding.state.showError(NullPointerException())
            R.id.menu_empty -> binding.state.showEmpty()
            R.id.menu_skeleton -> startActivity(Intent(this, SkeletonAnimationActivity::class.java))
        }
        return true
    }
}