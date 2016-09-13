package hyteck.com.br.headache;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HeadacheSplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mProgress = (ProgressBar) findViewById(R.id.progressBar);

        new Handler().postDelayed((Runnable) () -> {
            //Método que será executado uma vez.. Na abertura do app.
            isExternalStorageWritable();

            if (mProgressStatus < 100) {
                mProgressStatus = +(SPLASH_TIME_OUT / 100);

                // Update the progress bar
                mProgress.setProgress(mProgressStatus);
            }
            Intent i = new Intent(HeadacheSplashActivity.this, HeadacheListActivity.class);
            startActivity(i);
            finish();
        }, SPLASH_TIME_OUT);
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            isExternalStorageReadable();
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            Toast.makeText(this, "External Media Mounted but Read Only", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }


}
