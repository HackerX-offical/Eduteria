package helper;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.easebuzz.payment.kit.R;
import custom_ui_components.loader.PWELoader;
import custom_ui_components.loader.PWELoaderAnimation;
import custom_ui_components.loader.PWELoaderFactory;
import datamodels.PWEStaticDataModel;

/* JADX INFO: loaded from: classes9.dex */
public class PWECustomComponentHelper {
    private Context context;
    private PWELoader pwe_general_loader;
    private Dialog pwe_general_progress_dialog;

    public PWECustomComponentHelper(Context context) {
        this.context = context;
    }

    public void showPweLoader(Context context) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.custom_progress_bar_layout, (ViewGroup) null);
        Dialog dialog = new Dialog(context, R.style.MaterialDialogSheetTop);
        this.pwe_general_progress_dialog = dialog;
        dialog.setContentView(viewInflate);
        this.pwe_general_progress_dialog.setCancelable(false);
        this.pwe_general_progress_dialog.getWindow().setLayout(-1, -1);
        this.pwe_general_progress_dialog.getWindow().setGravity(17);
        this.pwe_general_loader = (PWELoader) viewInflate.findViewById(R.id.progress_pwe_general);
        PWELoaderAnimation pWELoaderAnimationCreate = PWELoaderFactory.create(PWEStaticDataModel.PWE_LOADER_STYLE);
        pWELoaderAnimationCreate.setColor(this.context.getResources().getColor(R.color.pwe_loader_color));
        this.pwe_general_loader.setIndeterminateDrawable(pWELoaderAnimationCreate);
        this.pwe_general_progress_dialog.show();
    }

    public Dialog getPWELoader(Context context, String str) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.custom_progress_bar_layout, (ViewGroup) null);
        Dialog dialog = new Dialog(context, R.style.WindowTransparent);
        this.pwe_general_progress_dialog = dialog;
        dialog.setContentView(viewInflate);
        this.pwe_general_progress_dialog.setCancelable(false);
        this.pwe_general_progress_dialog.getWindow().setLayout(-1, -1);
        this.pwe_general_progress_dialog.getWindow().setGravity(17);
        this.pwe_general_loader = (PWELoader) viewInflate.findViewById(R.id.progress_pwe_general);
        PWELoaderAnimation pWELoaderAnimationCreate = PWELoaderFactory.create(str);
        pWELoaderAnimationCreate.setColor(this.context.getResources().getColor(R.color.pwe_loader_color));
        this.pwe_general_loader.setIndeterminateDrawable(pWELoaderAnimationCreate);
        return this.pwe_general_progress_dialog;
    }
}
