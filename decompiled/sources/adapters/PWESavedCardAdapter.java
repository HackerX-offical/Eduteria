package adapters;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEGeneralHelper;
import com.easebuzz.payment.kit.PWEPaymentInfoHandler;
import com.easebuzz.payment.kit.R;
import datamodels.CardDataModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import java.util.List;
import listeners.KeyBoardListener;
import listeners.PWESavedCardListener;

/* JADX INFO: loaded from: classes.dex */
public class PWESavedCardAdapter extends ArrayAdapter<CardDataModel> {
    private static boolean is_cvv = true;
    private static int lastSelectedPosition = -1;
    private List<CardDataModel> cardDataList;
    private Activity context;
    private PWEGeneralHelper generalHelper;
    public KeyBoardListener kbl;
    private View lastSelectedView;
    public PWEPaymentInfoHandler paymentInfoHandler;
    private PWESavedCardListener savedCardListener;
    private int selectedCankId;

    public PWESavedCardAdapter(Activity activity, ArrayList<CardDataModel> arrayList, PWEPaymentInfoHandler pWEPaymentInfoHandler) {
        super(activity, R.layout.pwe_item_saved_card, arrayList);
        this.selectedCankId = -1;
        this.context = activity;
        is_cvv = true;
        this.cardDataList = arrayList;
        this.generalHelper = new PWEGeneralHelper(activity);
        this.paymentInfoHandler = pWEPaymentInfoHandler;
        this.kbl = new KeyBoardListener();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pwe_item_saved_card, (ViewGroup) null, true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvCardNumber.setText(this.cardDataList.get(i).card_str);
        viewHolder.editCvv.setVisibility(4);
        viewHolder.editCvv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: adapters.PWESavedCardAdapter.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (PWESavedCardAdapter.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        viewHolder.editCvv.setBackground(PWESavedCardAdapter.this.context.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        viewHolder.editCvv.setBackground(PWESavedCardAdapter.this.context.getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        try {
            this.generalHelper.setImageToImageView(PWEStaticDataModel.REST_BASE_URL + this.generalHelper.getCardTypeObject(this.cardDataList.get(i).card_type).getCard_type_image(), viewHolder.imgCardType, PWEStaticDataModel.PWEDefaultCardTypeIcon);
        } catch (Exception unused) {
        }
        viewHolder.linearMainLayout.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWESavedCardAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PWESavedCardAdapter.this.kbl.hideKeyboard(PWESavedCardAdapter.this.context);
                if (!PWESavedCardAdapter.this.paymentInfoHandler.getPWEDeviceType().equals("NORMAL") || PWESavedCardAdapter.lastSelectedPosition == i) {
                    return;
                }
                PWESavedCardAdapter pWESavedCardAdapter = PWESavedCardAdapter.this;
                pWESavedCardAdapter.setSelectedCardId(((CardDataModel) pWESavedCardAdapter.cardDataList.get(i)).card_id);
                PWESavedCardAdapter.this.savedCardListener.updateDefaultCardSelectionFlag(false);
                PWESavedCardAdapter.this.selectSavedCard(view2, i);
            }
        });
        viewHolder.editCvv.addTextChangedListener(new TextWatcher() { // from class: adapters.PWESavedCardAdapter.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ((CardDataModel) PWESavedCardAdapter.this.cardDataList.get(i)).cvv = editable.toString();
                PWESavedCardAdapter.this.savedCardListener.updateCVV((CardDataModel) PWESavedCardAdapter.this.cardDataList.get(i), i);
                if (editable.toString().isEmpty()) {
                    return;
                }
                PWESavedCardAdapter pWESavedCardAdapter = PWESavedCardAdapter.this;
                pWESavedCardAdapter.updateErrorView(pWESavedCardAdapter.lastSelectedView, "", false);
            }
        });
        viewHolder.imgRemoveCard.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWESavedCardAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PWESavedCardAdapter.this.savedCardListener.deleteCard((CardDataModel) PWESavedCardAdapter.this.cardDataList.get(i), i);
            }
        });
        viewHolder.tvError.setOnClickListener(null);
        if (getSelectedCardId() == this.cardDataList.get(i).card_id) {
            this.savedCardListener.updateDefaultCardSelectionFlag(true);
            selectSavedCard(viewHolder.linearMainLayout, i);
        }
        return view;
    }

    public void selectSavedCard(View view, int i) {
        try {
            if (lastSelectedPosition != i) {
                updateErrorView(this.lastSelectedView, "", false);
                View view2 = this.lastSelectedView;
                if (view2 != null) {
                    deselect(view2);
                }
            }
            lastSelectedPosition = i;
            this.savedCardListener.selectCard(this.cardDataList.get(i), i);
            select(view);
            this.lastSelectedView = view;
        } catch (Error | Exception unused) {
        }
    }

    public void setSavedCardListener(PWESavedCardListener pWESavedCardListener) {
        this.savedCardListener = pWESavedCardListener;
    }

    private void select(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_selected_item_background));
        EditText editText = (EditText) linearLayout.findViewById(R.id.edit_cvv_number);
        if (is_cvv) {
            editText.setVisibility(0);
            editText.setText(this.cardDataList.get(lastSelectedPosition).cvv);
        } else {
            editText.setText("");
            editText.setVisibility(4);
            updateErrorView(this.lastSelectedView, "", false);
        }
    }

    private void deselect(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        EditText editText = (EditText) linearLayout.findViewById(R.id.edit_cvv_number);
        editText.getText().clear();
        editText.setVisibility(4);
        linearLayout.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_custom_card_background));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateErrorView(View view, String str, boolean z) {
        try {
            TextView textView = (TextView) ((LinearLayout) view.getParent()).findViewById(R.id.text_saved_card_error);
            if (z) {
                textView.setText(str);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        } catch (Error | Exception unused) {
        }
    }

    public void updateCVVFlag(boolean z) {
        is_cvv = z;
        selectSavedCard(this.lastSelectedView, lastSelectedPosition);
    }

    public void showValidationError(String str, boolean z) {
        updateErrorView(this.lastSelectedView, str, z);
    }

    public void removeCard(ArrayList<CardDataModel> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.cardDataList = arrayList2;
        arrayList2.addAll(arrayList);
        if (this.cardDataList.size() > 0) {
            setSelectedCardId(this.cardDataList.get(0).card_id);
        }
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        private EditText editCvv;
        private ImageView imgCardType;
        private ImageView imgRemoveCard;
        private LinearLayout linearMainLayout;
        private TextView tvCardNumber;
        private TextView tvError;

        public ViewHolder(View view) {
            this.imgCardType = (ImageView) view.findViewById(R.id.img_card_type);
            this.tvCardNumber = (TextView) view.findViewById(R.id.text_saved_card_no);
            this.editCvv = (EditText) view.findViewById(R.id.edit_cvv_number);
            this.imgRemoveCard = (ImageView) view.findViewById(R.id.ib_remove_card);
            this.linearMainLayout = (LinearLayout) view.findViewById(R.id.linear_main_layout);
            this.tvError = (TextView) view.findViewById(R.id.text_saved_card_error);
        }
    }

    public int getSelectedCardId() {
        return this.selectedCankId;
    }

    public void setSelectedCardId(int i) {
        this.selectedCankId = i;
        notifyDataSetChanged();
    }
}
