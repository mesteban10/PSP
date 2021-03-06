package com.mestabn.psp_playground.commons.glide

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.fromUrl(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .into(this);
}