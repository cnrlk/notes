package com.caneru.notesjava.util;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;


public class MainBindingAdapter {

    @BindingAdapter("caneru:setImage")
    public static void setImage(ImageView image, String imageUrl) {
        if (imageUrl == null) {
            image.setImageURI(null);
        } else {
            Glide.with(image.getContext()).load(imageUrl).into(image);
        }
    }

}
