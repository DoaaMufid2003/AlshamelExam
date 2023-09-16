package com.example.alshamelexam.ImagesAsyncTaskHttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alshamelexam.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImagesActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        imageView = findViewById(R.id.imageView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImageTask().execute("https://plus.unsplash.com/premium_photo-1675511339058-a6c62fbd69dc?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2793&q=80");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImageTask().execute("https://images.unsplash.com/photo-1575300807981-65abff0d63d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8cG9zdHN8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=800&q=60");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImageTask().execute("https://images.unsplash.com/photo-1551636898-47668aa61de2?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHBvc3RzfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImageTask().execute("https://images.unsplash.com/photo-1513673836403-6502cfb1974e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cG9zdHN8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=800&q=60");
            }
        });
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            String imageUrl = urls[0];
            Bitmap bitmap = null;

            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

}