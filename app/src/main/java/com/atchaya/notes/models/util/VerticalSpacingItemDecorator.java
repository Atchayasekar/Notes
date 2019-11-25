package com.atchaya.notes.models.util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpacingItemDecorator  extends RecyclerView.ItemDecoration {

    private final int VerticalSpaceHeight;

    public  VerticalSpacingItemDecorator( int verticalSpaceHeight){
        this.VerticalSpaceHeight =verticalSpaceHeight;

    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,@NonNull RecyclerView.stat
                         outRect.bottom = verticalSpaceHeight;}





}