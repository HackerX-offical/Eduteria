package com.appnew.android.Zoom;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.eduteria.app.app.R;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.material.appbar.AppBarLayout;
import info.bideens.barcode.BarcodeReader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ScannerActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {
    AppBarLayout appBar;
    BarcodeReader barcodeReader;
    private boolean fromIsbn = false;

    @Override // info.bideens.barcode.BarcodeReader.BarcodeReaderListener
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
    }

    @Override // info.bideens.barcode.BarcodeReader.BarcodeReaderListener
    public void onScannedMultiple(List<Barcode> barcodes) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("QR Code Scanner");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getIntent() != null) {
            this.fromIsbn = getIntent().getBooleanExtra("isIsbn", false);
        }
        this.barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
        toolbar.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.ScannerActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScannerActivity.this.onBackPressed();
            }
        });
    }

    @Override // info.bideens.barcode.BarcodeReader.BarcodeReaderListener
    public void onScanned(Barcode barcode) {
        this.barcodeReader.playBeep();
        String str = barcode.displayValue;
        if (this.fromIsbn) {
            if (Boolean.valueOf(str.matches("[0-9]+")).booleanValue()) {
                if (str.length() == 13) {
                    Intent intent = new Intent();
                    intent.putExtra("code", str);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                showToast();
                return;
            }
            showToast();
            return;
        }
        Helper.logPrinter("testDatais", "d", str, "");
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("test_code") && jSONObject.has(Const.TESTSERIES_ID)) {
                Intent intent2 = new Intent();
                intent2.putExtra("code", str);
                setResult(-1, intent2);
                finish();
                return;
            }
            showToast();
        } catch (JSONException unused) {
            showToast();
        }
    }

    @Override // info.bideens.barcode.BarcodeReader.BarcodeReaderListener
    public void onScanError(String errorMessage) {
        Toast.makeText(getApplicationContext(), "Error occurred while scanning " + errorMessage, 0).show();
    }

    @Override // info.bideens.barcode.BarcodeReader.BarcodeReaderListener
    public void onCameraPermissionDenied() {
        setResult(0, new Intent());
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    private void showToast() {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.ScannerActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showToast$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showToast$0() {
        Toast.makeText(this, "Scan valid QR code", 0).show();
    }
}
