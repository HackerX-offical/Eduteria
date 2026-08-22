package a.a.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.billdesk.sdk.PaymentWebView;
import com.billdesk.sdk.UpiActivity;
import com.billdesk.utils.ConnectionUtil;
import com.billdesk.utils.PaymentLibConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class q extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UpiActivity f174a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(UpiActivity upiActivity, Looper looper) {
        super(looper);
        this.f174a = upiActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            HttpURLConnection httpURLConnectionA = ConnectionUtil.a(this.f174a.getApplicationContext(), this.f174a.f465c.optString("poll-url"));
            httpURLConnectionA.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnectionA.getOutputStream());
            outputStreamWriter.write(String.format("action=confirmPayment&txnAmt=%s&txnRef=%s&mercid=%s", PaymentLibConstants.f514e, this.f174a.q, PaymentLibConstants.f511b));
            outputStreamWriter.flush();
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionA.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    try {
                        break;
                    } catch (Exception unused) {
                        UpiActivity.a(this.f174a);
                        return;
                    }
                }
                sb.append(line);
            }
            this.f174a.w++;
            JSONObject jSONObject = new JSONObject(sb.toString());
            if ((!jSONObject.getString("code").equals("1") || !jSONObject.getString("status_code").equalsIgnoreCase("FAILURE")) && !jSONObject.getString("code").equals("0") && this.f174a.w < Integer.parseInt(this.f174a.f465c.getString("UPI_Status_Max_Count_"))) {
                UpiActivity.a(this.f174a);
                return;
            }
            if (this.f174a.A != null && this.f174a.A.isShowing()) {
                this.f174a.A.dismiss();
            }
            HashMap map = new HashMap();
            map.put("bankres", "eyJtZXRob2ROYW1lIjogImh0dHBzOi8vdGV6Lmdvb2dsZS5jb20vcGF5IiwiZGV0YWlscyI6IHsidHhuSWQiOiAiIiwicmVzcG9uc2VDb2RlIjogIlMiLCJBcHByb3ZhbFJlZk5vIjogIiIsIlN0YXR1cyI6ICJTVUNDRVNTIiwidHhuUmVmIjogIk5BIiwiVHJ0eG5SZWYiOiAiTkEiLCJzaWduYXR1cmUiOiAiIiwic2lnbmF0dXJlS2V5SWQiOiAiIn19");
            map.put("BRN", this.f174a.q);
            Intent intent = new Intent(this.f174a, (Class<?>) PaymentWebView.class);
            intent.putExtra("paymentDetail", map);
            intent.putExtra("url", this.f174a.r);
            this.f174a.startActivity(intent);
            this.f174a.finish();
        } catch (IOException e2) {
            Context applicationContext = this.f174a.getApplicationContext();
            UpiActivity upiActivity = this.f174a;
            String str = upiActivity.x;
            ConnectionUtil.a(applicationContext, upiActivity.s, e2);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
