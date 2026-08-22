package com.billdesk.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;

/* JADX INFO: loaded from: classes6.dex */
public class ErrorFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f399a = 134545;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400b = 134534;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f401c = 22343;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f402d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f404f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PaymentLibConstants.u.tryAgain();
            c cVar = ErrorFragment.this.f404f;
            if (cVar != null) {
                cVar.tryAgain();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PaymentLibConstants.u.cancelTransaction();
            c cVar = ErrorFragment.this.f404f;
            if (cVar != null) {
                cVar.cancel();
            }
        }
    }

    public interface c {
        void cancel();

        void tryAgain();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f404f = (c) activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f404f = (c) context;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = new RelativeLayout(getActivity());
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f402d = getArguments().getString("msg");
        TextView textView = new TextView(getActivity());
        this.f403e = textView;
        textView.setGravity(17);
        this.f403e.setText(this.f402d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.f399a);
        this.f403e.setTextColor(-16777216);
        this.f403e.setTextSize(16.0f);
        layoutParams.setMargins(0, 0, 0, (int) Helper.a(getActivity(), 30.0f));
        this.f403e.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f403e);
        ImageView imageView = new ImageView(getActivity());
        imageView.setId(this.f399a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        byte[] bArrDecode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAQAAAAEACAYAAABccqhmAAAfjElEQVR42u2de4yVd5nHP+9kQiaEEBYJISxLWJwgVkRsEBFrZStixV6sbe3l7UWtvd8kXrss2xjs1lorbdXSUmtvHmuvtvQiVmQRkUVkuyyLOEsmhEWcnZ3MTmYnk8lkcnLO/vE8B44IM+ecOee8t+8nORnaUph539/z/T2/5/dcQAghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCHFKAj2CdFDM0QbMAKYCk8s+LUCbfyqh37+OAEP+ddg/A/4ZDMJjv09IAESDjLrENGAOMNc/f+P/bmbZ18lN/vZGgF7/dAFHgD/619LnqP8+glDvUwIgRjPyNmA+sBB4F9BeZvRTEvrjFVwIDgIHgN8DHf7rfqAgYZAAZM3YW4DpwCI39vcAC9z4J2TkURSAHmA/sAf4LfCWewwSBQlAagy+BWh1A18GvB9Y6rt6i57QX4hClwvC74DdwC5gKAgp6PFIAJJi8G1u5B/1r6dHcD5PC8MuCNuBf/ZfD8hLkADEyeBb3H1fAXzMd3oZfOMEYS+wFXjdBSEvD0EC0Gyjn+QGfy5wFjBbTyYSusvEYAt2IyHvQALQEKOfCpwNnA+s1C4f2+PCq8ALwGF5BhKA8Rr9dOA84ALgTGCinkwiGMGCiM8DLwNHJQYSgEqMnjL3/krf6SfpySReDHa4GLwE9EoMJAAnGv0EYDEQAp/CUmpF+hgAXgMed1EYznq8IMiw4Zdc/MuBzwKnobv5LHEQeBr4iccL8hKAbBh+K3Y3f73v9lNkC5k/IrwJbMBuFDLlFQQZMXqwqP15bvhLsQw9IcrZ50LwHNCXBSEIUm74JTf/8274s7TGRQV0A08BjwKH0hw0DFJs+LOBm4HPYCWzQlTLEJZTcB+wP41CEKTQ8OcDtwOXomQdUR+GsXyC+4C9aQoYBiky/AXAl4GLqLz7jRDVMOJCsB7YkwYhCFJg+O1u+JejTD3RPCF4A1jnHkFBAtB8w58FfNHP+HL1RVQxgp8Ad5PQYGGQMMMHy9K7FbgBK9ARImr6gY3AA0B3koQgSJDxT8ICe2tR+a2IJ90eH9gI9CchjyBIgOG3YpV467BmG0LEnX3AGuDNILSuyBKA2s757b7jf5rsNMwU6SCP3RjcCXTE9VgQxNDwwfLzb8KCfDrni6THBx4EvouVIksAxnD3lwH3Aku0dkSK6MCuqzfHKX8giInhg+Xs34FF95XII9LICFZjcCfQFQdvIIiB8U8AVgH3APO0RkQGOOSb3ctRBwmDCA0fLJnnLiyLT+W5IkvksbLjNVhDkuwIgJ/1V2KJE+1aCyLDHMGC3S9HERsIIjD+Ka56t+isL8Sx2MBG4Os0+aYgaKLht2CtuL6PIvxRu57llKYbieh5C+thsbtZeQNBk4x/InAdFv1UD776GnPed5A8MIilow5iHXDLP//nXwdPIgAnVlG2AX+F5WBMKfuU/nlC2acVxW/qyYDbycYgZCjRAlBWvLMey+MXtRn5sH8OYxHkLuCP2DjtHv9004Q+dmWzE2b6ZxZWm/F2YI5/SiLRJnGomZewxjZHG/lOgwYulBas1/6jwEK9z4oYxkpMe4EDWE7574FO/wzEvcDEBWKai8I84D3AIqzt+mT3NpTWXRkdwLXAzkYdCYIGLYIJ2NXefSiV91QU3Nj7/ez3a//aQcJKSitcE63AXBeFBcB7fYOY7qKgOMTJ6ccyCJ9qRM5A0IAXPQWr3LtB7t9fGPwg0AfsAn6DDbPc14yzXkxFoc3FYCnwYf861Y8OEoQ/XzsPA2uDkL5YCoC7fu3AY1j5rrDz+wA20/5VYBtWGTasR3PSNTTJjwtLgY/4r6fqyHCMHcA1wMF6HQWDOhr/UmzUUtYTe0b8DL/TjX47EWZ6JVwQpvpmcgFwlh8Xsi4Gh7BRdjvqcUwM6vCSWrARWxvIbv/9PBaZ3wy8jgVtemXCdReD5cCF/nVahsWgD8sXeGG82YPBOF9KG5bRt47sZfUVsADNTuAZrPuLjL45YjDdReB8/zqd7MWbhrHMwfvHc6QMxvESJmMVfNeRrYDNEDZZ9hlgk5/HNG8+OjGY4R7o1VhAMWut4TcCXw1C+psmAK7AjwHnZGi373GDf8Zd/JGYGAAcT7opZeeV7uGnYEk7leyOpWSjfhe5IY5nFOb9GYyUffJxEj6/ej7DheBsfwZZ2Zg2A1cHIT0NF4BijllAjmxE+vNY9t2TwI+IKJjnRt7mu1sbll05Fwu4/i2WkTe97FPvXXDEhaCv7NProvjfHv/o9K9DJTGJ8FnNxSZEhVjeQRaOpzuBMAg53BABKLvmexYr6kn7+WoflsX4Ur3vXsd4zi2+a0/yXXwhlk03z/95pv+3ODKApScf8c8fsMSmA+5ZDDbTa/AalJXAje4dpP14sB+4BDhQqfgGVRj/QuB50t21ZwC7tnsUC+oNN2GRtrqrPgOrkvyAn2Xnk57CqUEXgv3A74DdLhADTXrGE7BrxNtdCCaleA0fchHYU4kIBBUa/zI/+6Z1IMcgsBVrRrqzkbuU7/CTfSc/k+MJL3PITiS74MeF/cCvgC2+cPsb/OxLMyZWY7cHaRWCbj/+bB1LBIIKjP8sN/7pKXxQQ1h21b3AtkZ1ZPGFNw3Lff8EljR1GkpqKReEg+4Z/MLPs92NSpHOiBD0YQlDm0YTgaAC43+W9CX4DGP5+OuxNs0jDVhkE1w0zwDO9QU3S7ZesUe2C0uqegM40oijQpkQfNHXetqChQPAlaOJQJAx4x/BKu7W+0MZrvOCanGjX+bnsOUp9ZyavYh3Aj8F3sTaaY/U+b1NAM7DWtUtSNlRbFQROJUALMHy2NOyeAtY0Ok+4Ikg/IuuOONZPGDBukVu9Gd7rETVbI1xa7dh19DbqXP/PK9kvQ5Ls52Vonc4gKVQbznxeQUneQjzgZ9hQam0/PAvAHcHIZ11dh9nA590wz8dlT83U9APYLdSP8HyM0bq+G7bsRr8T5Oem5ge4NwgZPcpBcALLn7pu1nSyWNBpXXYlV6hTotjEnZdV8o4k4sfLf1YJtzjwK4gZKCOx7llfixYnpL4QCfwd0HI0b8QAN/Rcq56Sd8durCZAxvrsSDczZ+KJZVciwX2FMGPn+C/BTyCpWzX5XjgBW9XuBCk4Wi3xT2B4RMF4Cos5TXJjPjLXxuEdNTJ8GdgaaXXYMlQOtsn43jwiB/9eurh/fnReB1W/5J0b2B1EHL/MQHw4McffLEnlaPYmLEnxhvdLzP8S7E0Us0sTCYH/WjwY6y7bmGc6yIt3kA/8K4gpKskALe5y5zUXX8rVhK5r46Gfz2WjiuSzxGsevUJLKdA3gB8IwhZG/ii/zeSGfjrwa72Hhrv1Z4HQD+N5YvL8NNJJ/Bd9wjGFSMo8wbWkswU+cPA24NijpnYkIkkuTN5LIX3DizyO54XOQkL7n0VS9XVGT/9MYJ9vnFsGm+QuJjjNP+zVpC8a+B3BsUcK7D866QwhLVIXldrFxR/ca1YTv4d/vIU1c8WeSzD8C6sDmRkHGtpsscFbiJZdQUXt5CshJ8uLEur5hZIxdyxpiZ3Y7nmq2T8maRUB/Ai8EAxx1w/DleNexFrsLjRkQQ9gzknGwwZV7dtD3BhEPJErVV7fm67yA3/S1hZrsg2k7AhNr8ArvPdvBYRyAchP8ZamO/0NRt3JibhvDuCpXueH4TsqtHwWzxy+yg2u0CzCsWJzMVG1z9bzLHUMwFrEYK3sG7FP4T4D4CJuwD0Y62Prw1CusZxPrsB+DkWtW3TWhejHAvOxgrhvuY3Q7WIQK8fVb8I1TfqbLYADMb0ezuM5dt/s5bGEMUcrcUcS7GCkQdIbzcjUX+mYff8zxZzLKnFG/Cg4kNYKe6hmP6cgy1wvDAgRuwHLgtCNtWSveW7/lf8rL8SVemJ2jbHFe4N3FZLbCAIIQh5E6sW3RvDuMCRwAcr/DEmRlLAOsF8Ngg5WIPhg3UuvhfL0pLhi3qQx5qR3AHsr3FTmovFoJbH6Oj9jpYgpBvGXzhTJ+N/Dbi4RuNvxa70XsVq9GX8op6xgVXuUV7uHYSq9QYOAZcBL7mgRM1RoLOkRFtjoLBPYNNNumow/pLL/wxK4xWNYxZWZXiPT8eqVgR6sKrShyHyyVJbg5BCqRhoPlYPEEWEfBi4H8vsG6rS8Esu/z1YTzft+qJZ3uo2LMq/r9ojgeejfAlLP48iczAPfDAI2V3yADqwAolmU8qgWluD8Zfcslew4ZAyftEsWrCmua8Al1Z7JPBy9X/C2o71RfD9b8K6Zf1ZQ5A5wG9pXourPg+q/KAGBZ0I3Ob/v7L5RJQMAd8G7q22ItWvFy/FulQ3y+76ffc/UFKykiodBm6lOdlLPViiRC3GP9Vd/q/L+EUMmAj8PbDBK2ur8QQKnj78WZpzHT/iXseBY9/DSRTpa25cjXKpDwHXByFbqv0f/QHfh9Xtq2xXxI3tvonuq7ZEvZhjGXZNeFoDz/3f8uN24aQCUHa2vgv4AvWtkisV9FxbS+ceb9W8AUvOEPV5H6XrqFYJat3odO92Sw3e7TwXgTPq/D7ywHeANScW0p1qMEirC8Cd1CdKOQI8h5XxdlX5UMB67j9GOtqVN/IsOoCldg9gpdO9fub7X4+5DPgRb9gFoHTca/MFN8Fd2slYOuzbsG7I07BWaZM5Prp8oh75KenFOks9V23lql8vrgOuoj63cgN+ZP7Wyb6XsWYDrvJvZlGNilTAcvrvBn5UbbNOP5Kchd29ztW6OiamPb7IDvl57vd+huzzT2+9B516pLskBlOwO/F3u8vaXvbf1FvhuOGtwVrTj9TwrK/CgtxzarS9vB9J1gHbT+WNVDIevNQr7zKsO+60CuIDA274LwJPeYCx2gXXil3vfZdsD98YdOM+CPyLH6MOYTPyYlFu6rcyM12kFwMfcFGYSbYDtcPuRd9fS8chv5m71e2gki7Eeff8DmBzPZ8b63o9qFKV2l2RZgF/fYIbWAD+B5tN3gl0BmFtd5xu/J931yVrC6j0EjuwEuZd/uu+es7Ba7Ag4BtFOzZd5yPuKczMoIcwjAXf7q5VsIs5Zruwvt9FdvIJG0QP8F9u+PuwzscVxR+CGC6eVmxA4z2kc277qdz6I1ij01ewyrEj9RpnFoN32uKbxkKsWcaZvpFMyND7XVurJ9BIghgulCuwzixpN/68G/1WN/o9QHdSdvlxegfTsfmK53uMZzbpz+QcxlKHN9Y7PpMKAfCFsRIr6Jma4oXQ68b+jBv/0bQb/RjvfBZWIhu6mzstxT9yP5b0syku3l2cBKAdK+VNYzVf6TbkBTf8A3FzBWPw/id4nOBiLOg8l3TmJhwFPjHeKVapEgCPIj9O8icTn+zstw8buvpylnf7GryCc3y3XEj6+jhuwfpe9EsA7KVfhI0mn5Aiw9/tsYzNcXjRCRWDyVjm583YbUJahKDg8YAHoz4KBDF5yT/HpvSkyfDfGO/YqRp3z4kcz9abhCXtlH+dNIohDWGJRP3+dcg//Vhux1AUHkzZ+LY0CcFh4ENBGG1PzjgIwDlYFDzJ570C1sh0PfBSMwzfj03TsIh6O/AeYIH/u8lln0njeLbDbvglUej1hfuf2J1zKd24rxk7mQvB2b57Lib5NwdfxVJ0sykAfu33CJb0k1SO+M/wQ++v2KidfSoWGFsKvI/jmXYzItoRC278PVhg6y3gN1gS2NFaWrlX8TymYtfFt/pzSCo7gY+Nd7J1kgVgMvBLV/OkMYh1UVoPdNRbxX23m43VYXwUK4iaS7zzIwouCIewZKZfcDwzrd61CWDJRDcDnyOZV8cDwDtrHXqTBgGYAfwHybr7zWP3+OuAN+u5sN2tPw0418+87ST7Xrzg3sE+j/PsAA7W0zvwzNFlWM79mQk8FrwnyivBqAVgEfCvCTr/d2PFSRt9/FM9nkGpxmIFcKHv+Gmtf+h3z+Cn2FVYZ73yIYo5prgnsBq7RkwKHw5CtmdVAM7Bkn+SsOtvx8oz99Qj4OXez0os8WUJ2at47MFuTJ7Hmmd01eGZtmB5A+uwYGGrBCDeAnAedgMQZ/qw2YLfq7W68YQF2o41grwEy3rMeieeAlbq/BKWJdkx3mNV2UDYLyZAWCUAMV6Yb2FXNdvGs+t7H/jTscy2VVBd88iMeQVbse5PO8bT78DFdinWjKbeLbYkAHUSgKVYk4u4UWphtiYIOTJOwz8Li1SfgboYV8oQNnhjAzbBZmgc72A6Vor7OeLZxux9QcierArAbCypJE6ZXX2+azxU68Iri0yv9nO++ufVxjB2c7ABS6mu9X20YXkDX4+Z95UH3uFzAzMpAFOAX2GBmzhwwI12S40TYFuwKP6t2IDSKbLhugnBVmzq884a22uVjgTrsbyTOBwJuoH3NiqBLAkC0Iq1Qf5MDM7724Dbg5D9Nf4s7W74l5LtHoaNZAALFq6n9jHds/3/j8Msya3AuY3MmhyLSFXQo73PEO245BHgKSCsxfiLOSYVc1yHJbrcJuNvKJN9s/g58A/FXPVJUh7TuQZ4CCJvqvq6xzuis8Go32jE1YBDWO/B79Q4120RloF2NmqHHcX5eY8//6019N9vA27CAoRRHNW6sBl9h6N8iJGfg7xy7t4IvIB+bE7aN2sw/qnAV7AkpvNk/JHQ6pvG88B9xVx12X9+xfggdkPTE8GR816o/YYpNR6AG1SzOwL1YJNbXqhm5/AClDOw0WnL0EjyuFDAUozvoMoArntyq7AeDrOb9P1uAy4cb2JZagTAX8Qc31EXNPivOuyqv7nKhdLm5887sRJcET/6sOGx36umJ4ML+5lYWXeje1IeAi6IS0/AOGVHHQau9a+NYj/WffaNKo1/BpYOvF7GH2umYnf9uWKuckMOQvBsvBDL/mwU3cD1EA/jj5UHUKbEy12J59Xxj85jVy6rg/D4bPQKv5/FbvjLUN5+kujwY161R4L5WOLRmXV+34d8g9sWp4EvsVrQ3lRjG3ABVi5ajwc1AHwbuKxK42/FssdeJN655OLkzAeeBq7zkutK12CHewJPQV1KlUs5JhditxWxmvYUxPXteaT9M9Re3z2CtVy6y1W3mmBfGzYefQ3ZGU+WVoaAh4F11XRn9sD0FdhNUa0zCnqx/hEP1at/RGYEwF9Cix8FQiy1dh5jX7mVJu88jgX6Bqr8Oydhgb5bSF8/+qySx4ay3B6ElV/5lbUd+xTWpakdS/SaMMaOf9R3/e8Cb8V5xmOQhLdXNk9uDnZL8C6Ot7gu9aH7k5+zOoDDtZSSembZvcDl6G4/bRSAN4Aba2nF7R7BdKxF21QsK7HlJF5nL3a/3xWnGYCJFoAmicws7C54FbrfT7MIbAeuDUI69TgkACXjn+tHBgX7ssFu4LPVBIUlAOne+Z/EGneI7LATuDLKWvw40JJx45+G3fkulz1kjmXAY8VcttuztWTY+CdilYCr5PZnljOB9V6RKgHIkPGD5RhcIePPNC3YFd8NfuUsAcgIp2HdfnXVJ1qxZLNFEoBs7P4tWDXgbK194cwAVnv6twQg5czFmngIUc5KGl8KHEv3J2ssIRuDOfqx8tMBrPfdMJX3n5uIpUFPxNplTSf9Mw2mY3kg+yUA6eYDKfR8RrDxWvuBX2P15t3YCPNh/+/5Sttpe/VcKxYjmYilXM/0c/KHsHTsuSlcPx/ECocyQ6YSgfz8/zN395LOANYG65fAZqyRSm+jC0/8nDwNK4z5OJZDsZB0VE3uAD46npFk8gDiTcmlTSp5391fwfrjH662oem4dwwrcOkGuos5dvjRYDZ2nXa+i0FS19UUFzIJQEopnWuTeJ7fjA3N3AP0e/OUaN3H8Jgnsr+YYz/wPY4PQT0bq5pL2gaRqRLwrAnABJJ1938UG1L6OHCwlpFYTRaDPmBLMcc2rHfDldikpDkJeuYtEoD00pKQF9yDtaR6BDgU54YSoxwTDhRzrPGf4Vos81Jj0SUAkTIS8/PdIPAjrAlp53gM34N1M/18Phdrq/Y2P+eWmlq0+PGi9Pf0ufj8EZtc0+deyJFaAmP+/R8u5ljrXsztwFXE90qxAMkSWwlA9QY2GNOFtwNrab2jxum3U7FrujOAd2NJLaXONRNr8HwKLpYDQF8xRwfw7x6D2BuEdFUpBJ3FHKuBZ/3nXB5Db2yIiGf1Nd1by9IP60VArwLnxOjb6gPuBn5QZdPKFqymYQnwMax9+QwaH+Qcdi/hLexKdSdwoMrW21PcE1hDvIapbgU+HudYiwRg/CLwJazvXxzYgRUl7arUgHynXwlc7UY/NcKdtOACtgfIYT34uyv8OUrDVe8GVsTEG/hGELJWHkC6BWAhljwzLcJvYxjLOLurknbR7rksAi7B7tvnEL/bjLzHC17Driv3VnJV6d7ALS6EUSYTDQAfC0J2SQDSLQCtWEDqioi+hW6s1/xzlbiaLlirsQKmpNyr97oQbAB2jyUE/k5WYcHPuRF9zy9jw2OGJQDpF4HT/fza7PPnXuxKbMxe8cUc7VjU/NKIvZXxxjfeAO4JwtGLbNzLOQ3rzLy8yd9nP3BuELIja7aQVQFowYZ//GMT/9o3scGQh0fbEb1P4e3A57CgXhoSU7o5PiGnf4x3MwOb8HtpE3/2+4EvJ6GPvwSgfiIwHQtcrWjwX1XA7va/PNpUGt8BV2JBsUWkLyOtVMdwJ2NMZ/YefaXpTI2OdewELqllWIgEIPkiMA94HitgaQQjwIPYXLqBUb6PqdiV2OdJf939IPBD4OtBSN8oz6QNuM2FoFFXmweBi4MwPuO6m02mG2IGIQexwpW9DVroa4C1Yxj/Qqy67wsZMH6wSP8twOvFHEtGeTfDwHeAW/2MXm86/N3vy7QNIEqTgTZQv/voLj/Hv3yqc6XHIT6N5STMyuij7/EdfuOpjgT+nFb4+6nXDcF24EYsgQkJgCi54TdhV261XrcVgC3Ynfa+URb1RGCt74RZHz8+BDwE3BmEJ0/D9fjIPI+PnEftKez9/nc9UM2UYAlAdkSgBatn/yp2L13p2XMEy4b7PvBaBef9B7Aot4aQGnms7Pn20RKjXDjP8WPBYiqv3R9yYb4Hy0vI65FLAEYTgjZ3N5cB78TyBSae5IzfA/zBjf8QMDjGFd8M4FE0jWg07+nq0dKJ3RuYhGVDLi57PyfGT4ax68c/ALuw6sphPWYJQK2ewYkGm6/m/OjG/zQ2hFTGf2oR2AqE1bjoLgonelOFpPVRkACkV0Amu/GfI+OvSARewMZ3D+lxNBYtxsYbP8AdcvurWpOfwq5FhQQg8SzGEnwU8KucVuB2z5EQEoBEcw3JLeaJkunAxXoMEoAku/9TaHytQZo5K6tjuyUA6WA+8Wp5lTRmkuxBLok4a4nG0YwefWPRD3T6pwv4E9aw42RXZBNdsN6OZd7Ni/j40obd7/dpKUkAksiEiJ5xJ9aI4+dY885BYKiKvoMtLgYT3Ys5E2s8urTJP08ryZzkJAEQ4IY3QvP69+3F0l3fBPpqLXRxoSi1UO8BthdzfAcb9/ViE59fHpS9pxhAcumiuXMIerBahL56V7l5Uk6zC2iG5f5LAJLMQWhqp5kVwJPFXP0rDL2IaX2Tn18PjekFICQAjcd3zU1Nfp+frLcI+J/1GJbU1Ey2Z71eXwKQfJ72o0AiRcArIzdgdfjNpBfr2SgkAIk/BqyjucGskgg8PR4RcON/FLi8yWtlGOsUtE/LRwKQ9GMAwA+A70FTG1G0+K5dkycQofHnsTbdG1XO24T1qUfQHMpc6auabFAFbOrNlZWW1xZzTPAz/+URfK9PATeqeYcEII0iMBl40t1z4igCERo//j1ePVpLNSEBSLoITMOCWysjEIFNWLedoRga/xtu/L1aJRKAtIvATOAZLMU2Fp6AG/+j2NDUZhv/NmwwZ7dWhwQgKyIwG5tKtCQiEQhL5+yId/6d2HSeLq0KCUDWRGCOi8DiCERgE3CZ/zoq49/jxn9Yq0ECkGUReAWa3v6qJAKDERn/PuB8Gb8EQCJgQ0pfBBZEIAJEYPz7gQt9NqOQAIhijvnAq0B7yn9UGX+MUCZgXJQ4pAO4EGvmkVY6gUtk/BIAcXIR2JdiEej0nf+A3rSOAGL048BC4KfUbxx21BwCLnCBExIAkSERkPFLAERGRUDGLwEQGRUBGb8EQNRRBF4B5iTkWz6MJfnI+CUAImMiIOOXAIgGicACLFloToyN/9wgZL/eVjJQHkCS1NoM6xMQy0QaGb88ANEkT6AdeB2b3RcHDrrb36G3IwEQ2RKBg8AngjDVKcw6AojYHQc6gY9DpC63jF8CICIUgUMeE4gi4n5Axq8jgIjHcWAW8DOa109gP/DxIGzq3EMhD0CcwhM4CnwU2N2Ev26vjF8egIinJzAdSxZa2qC/Yo+7/T162vIARPw8gR4sMLi9AX/8Dhm/BEDEXwT6scDg5jr+sW9iST4yfgmASIAIDAIXAC/U4Y/bhFX19evJSgBEckRgGOv7/zDUNGW3ADyB9e0f0hOVAIjkiUAeuBlYW6UIFIBvA9cEISN6kileI3oE2aCY4yJsAtDkMX7rMLAaeDgI9dwkACJNIjAduAiYdorf0gO8rCGdQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCAH8P7LeauJsgPf9AAAAAElFTkSuQmCC", 0);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        imageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(imageView);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(5, -16777216);
        gradientDrawable.setColor(-1);
        Button button = new Button(getActivity());
        button.setId(this.f400b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) Helper.a(getActivity(), 100.0f), -2);
        layoutParams3.addRule(3, imageView.getId());
        layoutParams3.addRule(13);
        layoutParams3.setMargins(0, (int) Helper.a(getActivity(), 15.0f), 0, 0);
        button.setLayoutParams(layoutParams3);
        button.setText("RETRY");
        button.setBackground(gradientDrawable);
        button.setLayoutParams(layoutParams3);
        button.setOnClickListener(new a());
        relativeLayout.addView(button);
        Button button2 = new Button(getActivity());
        button2.setId(this.f401c);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) Helper.a(getActivity(), 100.0f), -2);
        layoutParams4.addRule(3, this.f400b);
        layoutParams4.addRule(13);
        layoutParams4.setMargins(0, (int) Helper.a(getActivity(), 10.0f), 0, 0);
        button2.setText("CANCEL");
        button2.setBackground(gradientDrawable);
        button2.setLayoutParams(layoutParams4);
        button2.setOnClickListener(new b());
        relativeLayout.addView(button2);
        return relativeLayout;
    }
}
