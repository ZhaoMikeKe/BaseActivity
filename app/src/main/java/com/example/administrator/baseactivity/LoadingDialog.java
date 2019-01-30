package com.example.administrator.baseactivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;


/**
 * Created by Administrator on 2018/3/23.
 * 正在加载
 */

public class LoadingDialog extends Dialog {


    ImageView loadingImageAnimation;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.MyTransparent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        loadingImageAnimation = findViewById(R.id.loading_image_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) loadingImageAnimation.getBackground();
        animationDrawable.start();
    }
}
