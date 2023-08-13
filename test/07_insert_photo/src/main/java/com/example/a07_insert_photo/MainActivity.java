package com.example.a07_insert_photo;

import static android.os.Environment.DIRECTORY_PICTURES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "phptp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTextViewClick(View view){
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.pic_1);
//        saveToSystemGallery(getBaseContext(),bitmap);
        saveImageToGallery(bitmap,"jpg");
    }

    public static void saveToSystemGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "vgmap");
        if (!appDir.exists()) {
           boolean result= appDir.mkdir();
            Log.d(TAG, "saveToSystemGallery: "+result);
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(file.getAbsolutePath())));
    }

    public String saveImageToGallery(Bitmap bitmap, String type) {
        Log.d(TAG, "saveImageToGallery: ");
        // 首先保存图片
        File externalFileRootDir = getExternalFilesDir(null);
        do {
            externalFileRootDir = Objects.requireNonNull(externalFileRootDir).getParentFile();
        } while (Objects.requireNonNull(externalFileRootDir).getAbsolutePath().contains("/Android"));

        String saveDir = Objects.requireNonNull(externalFileRootDir).getAbsolutePath();
        Log.d(TAG, "saveImageToGallery saveDir: " + saveDir);
        String storePath = saveDir + File.separator + "dearxy";
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        String fileName = "";
        if ("jpg".equals(type)) {
            fileName = System.currentTimeMillis() + ".jpg";
        } else {
            fileName = System.currentTimeMillis() + ".png";
        }

        File file;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            String path = Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES).getPath();
            file = new File(path, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                //通过io流的方式来压缩保存图片
                if ("jpg".equals(type)) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                } else {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                }
                fos.flush();
                fos.close();

//                MediaStore.Images.Media.insertImage(getContentResolver(),
//                        file.getAbsolutePath(), fileName, null);
//                // 最后通知图库更新
//                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
//                        Uri.fromFile(new File(file.getPath()))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "saveImageToGallery: path" + file.getAbsolutePath());
            return file.getAbsolutePath();
        } else {
            file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                //通过io流的方式来压缩保存图片
                if ("jpg".equals(type)) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                } else {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                }
                fos.flush();
                fos.close();
//                MediaScannerConnection.scanFile(PhotoTranDealActivity.this,
//                        new String[]{file.toString()},
//                        new String[]{file.getName()}, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file.getAbsolutePath();
    }

}