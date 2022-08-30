package com.example.namo.Bottom.Home.Record

import android.annotation.SuppressLint
import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.annotation.GlideModule;

@GlideModule
class GlideModule : AppGlideModule() {


    @SuppressLint("CheckResult")
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        builder.apply { RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL) }
    }

}
