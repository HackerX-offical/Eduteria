package com.appnew.android.CreateTest.Model;

import com.appnew.android.testmodule.model.Question;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestQuesData implements Serializable {
    private Data data;
    private String message;
    private boolean status;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Data {

        @SerializedName("questions")
        private ArrayList<Question> data;
        private ArrayList<Question> questions_hindi;

        public Data() {
        }

        public ArrayList<Question> getData() {
            return this.data;
        }

        public void setData(ArrayList<Question> data) {
            this.data = data;
        }

        public ArrayList<Question> getQuestions_hindi() {
            return this.questions_hindi;
        }

        public void setQuestions_hindi(ArrayList<Question> questions_hindi) {
            this.questions_hindi = questions_hindi;
        }
    }
}
