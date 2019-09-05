package com.example.myrecyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailCharacter extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESC = "extra_desc";
    public static final String EXTRA_IMG = "extra_img";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_character);

        String name = getIntent().getStringExtra("extra_name");
        String desc = getIntent().getStringExtra("extra_desc");
        String img = getIntent().getStringExtra("extra_img");

        TextView nameDetail = findViewById(R.id.tv_item_name_details);
        nameDetail.setText(name);

        TextView descDetail = findViewById(R.id.tv_item_desc_details);
        descDetail.setText(desc);

        ImageView imgDetail = findViewById(R.id.img_item_photo_details);
        Glide.with(this)
                .asBitmap()
                .load(img)
                .into(imgDetail);
    }
}
