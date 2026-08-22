package custom_ui_components.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.easebuzz.payment.kit.R;
import datamodels.PWEStaticDataModel;

/* JADX INFO: loaded from: classes9.dex */
public class PWELoader extends ProgressBar {
    public String loader_style;
    public int pwe_color;
    public PWELoaderAnimation pwe_sprite;

    public PWELoader(Context context) {
        this(context, null);
    }

    public PWELoader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.PWETheme);
    }

    public PWELoader(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.PWETheme);
    }

    public PWELoader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.loader_style = PWEStaticDataModel.PWE_LOADER_STYLE;
        this.pwe_color = getResources().getColor(R.color.pwe_loader_color);
        init();
        setIndeterminate(true);
    }

    private void init() {
        PWELoaderAnimation pWELoaderAnimationCreate = PWELoaderFactory.create(this.loader_style);
        this.pwe_sprite = pWELoaderAnimationCreate;
        pWELoaderAnimationCreate.setColor(this.pwe_color);
        setIndeterminateDrawable(this.pwe_sprite);
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (!(drawable instanceof PWELoaderAnimation)) {
            throw new IllegalArgumentException("this d must be instanceof Sprite");
        }
        setIndeterminateDrawable((PWELoaderAnimation) drawable);
    }

    public void setIndeterminateDrawable(PWELoaderAnimation pWELoaderAnimation) {
        super.setIndeterminateDrawable((Drawable) pWELoaderAnimation);
        this.pwe_sprite = pWELoaderAnimation;
        if (pWELoaderAnimation.getColor() == 0) {
            this.pwe_sprite.setColor(this.pwe_color);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == 0) {
            this.pwe_sprite.start();
        }
    }

    @Override // android.widget.ProgressBar
    public PWELoaderAnimation getIndeterminateDrawable() {
        return this.pwe_sprite;
    }

    public void setColor(int i) {
        this.pwe_color = i;
        PWELoaderAnimation pWELoaderAnimation = this.pwe_sprite;
        if (pWELoaderAnimation != null) {
            pWELoaderAnimation.setColor(i);
        }
        invalidate();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof PWELoaderAnimation) {
            ((PWELoaderAnimation) drawable).stop();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.pwe_sprite != null && getVisibility() == 0) {
            this.pwe_sprite.start();
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        PWELoaderAnimation pWELoaderAnimation;
        super.onScreenStateChanged(i);
        if (i != 0 || (pWELoaderAnimation = this.pwe_sprite) == null) {
            return;
        }
        pWELoaderAnimation.stop();
    }
}
