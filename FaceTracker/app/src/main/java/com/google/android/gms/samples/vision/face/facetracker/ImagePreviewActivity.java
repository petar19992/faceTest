package com.google.android.gms.samples.vision.face.facetracker;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.samples.vision.face.facetracker.ui.camera.FaceOverlayView;

import java.io.InputStream;

public class ImagePreviewActivity extends Activity {

    private FaceOverlayView mFaceOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        mFaceOverlayView = (FaceOverlayView) findViewById( R.id.face_overlay );

        Bitmap bitmap = BitmapFactory.decodeFile(MainActivity.path);

        mFaceOverlayView.setBitmap(bitmap);
    }
}
