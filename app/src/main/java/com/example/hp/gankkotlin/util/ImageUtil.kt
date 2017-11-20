package com.example.hp.gankkotlin.util

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.example.hp.gankkotlin.R
import jp.wasabeef.glide.transformations.CropCircleTransformation
import java.io.File
import java.io.FileOutputStream


object ImageUtil {


    fun loadCircleImg(context: Context,
                      imageView: ImageView,
                      url: String?) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(CropCircleTransformation(context))
                .into(imageView)
    }


    fun loadLargeImg(context: Context,
                     imageView: ImageView,
                     url: String?) {
        Glide.with(context)
                .load(url)
                .into(imageView)
    }


    fun saveImageToGallery(context: Context, url: String?) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .skipMemoryCache(true)
                .into(object : SimpleTarget<Bitmap>() {
                    override fun onResourceReady(bitmap: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                        if (bitmap == null) {
                            Toast.makeText(context,context.resources.getString(R.string.pic_save_failed), Toast.LENGTH_SHORT).show()
                            return
                        }
                        if (!bitmap.isRecycled) {
//                      保存在系统相册的文件夹"gankKotiln"中,同时显示到系统图库所有图片
                            val dirName = "gankKotiln"
                            val appDir = File(Environment.getExternalStorageDirectory(), dirName)
                            if (!appDir.exists()) {
                                appDir.mkdir()
                            }
                            val fileName = "${System.currentTimeMillis()}.jpg"
                            val file = File(appDir, fileName)
                            try {
                                val fos = FileOutputStream(file)
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                                fos.flush()
                                fos.close()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            try {
                                MediaStore.Images.Media.insertImage(context.contentResolver,
                                        file.absolutePath, fileName, null)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            } finally {
                                bitmap.recycle()
                            }
                            MediaScannerConnection.scanFile(context, arrayOf(file.absolutePath), null, null)
                            Toast.makeText(context, context.resources.getString(R.string.pic_save_success), Toast.LENGTH_SHORT).show()
                        }
                    }
                })
    }
}