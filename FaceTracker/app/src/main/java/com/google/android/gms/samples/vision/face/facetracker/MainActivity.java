package com.google.android.gms.samples.vision.face.facetracker;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button galerija, kamera;
    int RESULT_LOAD_IMAGE=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        galerija= (Button) findViewById(R.id.galerija);
        kamera= (Button) findViewById(R.id.kamera);

        galerija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,FaceTrackerActivity.class);
                startActivity(i);
            }
        });
    }
    public static String path;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex); //VAZNO
            cursor.close();
            path=picturePath;
            Intent i =new Intent(MainActivity.this,ImagePreviewActivity.class);
            startActivity(i);
        }
    }
}
