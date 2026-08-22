package com.appnew.android.feeds;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes6.dex */
public class LoadImage extends AsyncTask<Object, Void, Bitmap> {
    private LevelListDrawable mDrawable;
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(Object... params) {
        String str = (String) params[0];
        this.mDrawable = (LevelListDrawable) params[1];
        this.textView = (TextView) params[2];
        try {
            return BitmapFactory.decodeStream(new URL(str).openStream());
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (MalformedURLException e3) {
            e3.printStackTrace();
            return null;
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            this.mDrawable.addLevel(1, 1, new BitmapDrawable(bitmap));
            this.mDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.mDrawable.setLevel(1);
            this.textView.setText(this.textView.getText());
        }
    }
}
