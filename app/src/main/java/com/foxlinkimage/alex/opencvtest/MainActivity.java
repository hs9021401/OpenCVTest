package com.foxlinkimage.alex.opencvtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.InstallCallbackInterface;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybtn = (Button)findViewById(R.id.jump);
        mybtn.setOnClickListener(this);
    }

    private LoaderCallbackInterface mLoaderCallback = new LoaderCallbackInterface() {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                    Log.i("OPENCV", "OpenCV loaded successfully");
                    Covert2Gray();
                    break;
                case LoaderCallbackInterface.INIT_FAILED:
                    Log.i("OPENCV", "OpenCV init failed");
                    break;
                case LoaderCallbackInterface.INCOMPATIBLE_MANAGER_VERSION:
                    Log.i("OPENCV", "Incompatible Version");
                    break;
                case LoaderCallbackInterface.MARKET_ERROR:
                    Log.i("OPENCV", "Market Error");
                    break;
                default:
                    Log.i("OPENCV", "OpenCV Manager Install");
                    break;
            }
        }

        @Override
        public void onPackageInstall(int operation, InstallCallbackInterface callback) {
            Log.i("OPENCV", "Open market to install OpenCV Manager....");
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
    }

    public void Covert2Gray() {
        String file_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/CapRTSP/kk.jpg";
        Bitmap myBmp = BitmapFactory.decodeFile(file_path);
        Mat tmp = new Mat(myBmp.getWidth(), myBmp.getHeight(), CvType.CV_8UC1);
        Utils.bitmapToMat(myBmp, tmp);
        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_RGB2GRAY);

        Utils.matToBitmap(tmp, myBmp);

        ImageView img = (ImageView)findViewById(R.id.img);
        img.setImageBitmap(myBmp);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.jump:
                Intent intent = new Intent(MainActivity.this, FdActivity.class);
                startActivity(intent);
                break;
        }

    }
}
