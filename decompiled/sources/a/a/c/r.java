package a.a.c;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.billdesk.sdk.UpiActivity;
import com.billdesk.utils.URLUtilActivity;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UpiActivity f175a;

    public r(UpiActivity upiActivity) {
        this.f175a = upiActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f175a.f465c.has("VPA-type")) {
            String string = this.f175a.t.getText().toString();
            EditText editText = this.f175a.t;
            if (editText != null && editText.getText().toString().equals("")) {
                this.f175a.t.setError("Can't be blank");
                return;
            }
            if (!Pattern.matches("^[a-zA-Z0-9.-]{3,40}\\@[a-zA-Z0-9.]{2,20}$", string)) {
                this.f175a.t.setError("Invalid UPI ID.");
                return;
            }
            this.f175a.E = "@" + string.split("@")[1];
            String str = this.f175a.x;
            String str2 = "vpaText==" + string + "\t, vpaBankId==" + this.f175a.E;
            Intent intent = new Intent(this.f175a, (Class<?>) URLUtilActivity.class);
            intent.putExtra("req_type", 111);
            intent.putExtra("url", this.f175a.f464b.optString("redirect-url"));
            this.f175a.f463a.put("txtVPA", string);
            intent.putExtra("paymentDetail", this.f175a.f463a);
            this.f175a.startActivityForResult(intent, 8544);
            return;
        }
        EditText editText2 = this.f175a.t;
        if (editText2 != null && editText2.getText().toString().equals("")) {
            this.f175a.t.setError("Can't be blank");
            return;
        }
        if (!Pattern.matches("^[a-zA-Z0-9.-]{3,40}", this.f175a.t.getText().toString())) {
            this.f175a.t.setError("Invalid " + this.f175a.f468f + InstructionFileId.DOT);
            return;
        }
        Spinner spinner = this.f175a.u;
        if (spinner != null && spinner.getSelectedItemPosition() == 0) {
            Toast.makeText(this.f175a, "Please select Bank UPI", 1).show();
            return;
        }
        UpiActivity upiActivity = this.f175a;
        StringBuilder sb = new StringBuilder("@");
        UpiActivity upiActivity2 = this.f175a;
        upiActivity.E = sb.append(upiActivity2.v[upiActivity2.u.getSelectedItemPosition()]).toString();
        Intent intent2 = new Intent(this.f175a, (Class<?>) URLUtilActivity.class);
        intent2.putExtra("req_type", 111);
        intent2.putExtra("url", this.f175a.f464b.optString("redirect-url"));
        this.f175a.f463a.put("txtVPA", this.f175a.t.getText().toString() + this.f175a.E);
        intent2.putExtra("paymentDetail", this.f175a.f463a);
        this.f175a.startActivityForResult(intent2, 8544);
    }
}
