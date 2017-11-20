package com.example.hp.gankkotlin.view.activity

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.hp.gankkotlin.R
import com.example.hp.gankkotlin.util.ImageUtil
import kotlinx.android.synthetic.main.activity_picture_detail.*


class PictureDetailActivity:BaseActivity() {

    private val saveImgCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        initView()
        initControl()
    }

    private fun initView(){
        large_detail_scale_pic.visibility = View.GONE
        large_detail_photo_pic.visibility = View.VISIBLE
    }

    private fun initControl(){

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            saveImgCode -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                runOnUiThread {
                    ImageUtil.saveImageToGallery(this, "")
                }
            } else {
                Toast.makeText(this,resources.getString(R.string.pic_per_request_fail), Toast.LENGTH_SHORT).show()
            }
        }

    }
}