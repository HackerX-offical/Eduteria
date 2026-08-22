package com.appnew.android.Response;

import com.appnew.android.Model.PostFile;
import com.appnew.android.Response.ParentResponse.PostParentResponse;
import com.appnew.android.home.model.myNotesData.NoteTags;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class PostResponse extends PostParentResponse implements Serializable {
    private String coins_for_post;
    private String display_picture;
    private String lat;
    private String location;
    private String lon;
    public PostData post_data;
    private String post_headline;
    String q_id;
    String question;
    private String quiz_attempt;
    private String quiz_coins;
    private String quiz_id;
    private String quiz_no_of_questions;
    private String quiz_time;
    String report_id;
    private String state;
    private String test_segment_id;
    private String video_id;

    public PostResponse() {
    }

    public PostResponse(String post_headline, String creation_time) {
        this.post_headline = post_headline;
        setCreation_time(creation_time);
    }

    public String getReport_id() {
        return this.report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getQ_id() {
        return this.q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTest_segment_id() {
        return this.test_segment_id;
    }

    public void setTest_segment_id(String test_segment_id) {
        this.test_segment_id = test_segment_id;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getCoins_for_post() {
        return this.coins_for_post;
    }

    public void setCoins_for_post(String coins_for_post) {
        this.coins_for_post = coins_for_post;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getQuiz_no_of_questions() {
        return this.quiz_no_of_questions;
    }

    public void setQuiz_no_of_questions(String quiz_no_of_questions) {
        this.quiz_no_of_questions = quiz_no_of_questions;
    }

    public String getQuiz_time() {
        return this.quiz_time;
    }

    public void setQuiz_time(String quiz_time) {
        this.quiz_time = quiz_time;
    }

    public String getQuiz_coins() {
        return this.quiz_coins;
    }

    public void setQuiz_coins(String quiz_coins) {
        this.quiz_coins = quiz_coins;
    }

    public String getQuiz_attempt() {
        return this.quiz_attempt;
    }

    public void setQuiz_attempt(String quiz_attempt) {
        this.quiz_attempt = quiz_attempt;
    }

    public String getQuiz_id() {
        return this.quiz_id;
    }

    public void setQuiz_id(String quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getPost_headline() {
        return this.post_headline;
    }

    public void setPost_headline(String post_headline) {
        this.post_headline = post_headline;
    }

    public String getDisplay_picture() {
        return this.display_picture;
    }

    public void setDisplay_picture(String display_picture) {
        this.display_picture = display_picture;
    }

    public PostData getPost_data() {
        return this.post_data;
    }

    public void setPost_data(PostData post_data) {
        this.post_data = post_data;
    }

    public PostData createLiveStreamData() {
        return new PostData();
    }

    public class PostData implements Serializable {
        private String answer_five;
        private String answer_four;
        private String answer_given_by_user;
        private String answer_one;
        private String answer_three;
        private String answer_two;
        private String id;
        private String mcq_attempt;
        private String mcq_coins;
        private MCQVoting mcq_voting;
        private ArrayList<PostFile> post_file;
        private String post_id;
        private String post_text_type;
        private String question;
        private String right_answer;
        private String status;
        private ArrayList<NoteTags> tag;
        private String text;

        public PostData() {
        }

        public String getMcq_attempt() {
            return this.mcq_attempt;
        }

        public void setMcq_attempt(String mcq_attempt) {
            this.mcq_attempt = mcq_attempt;
        }

        public String getMcq_coins() {
            return this.mcq_coins;
        }

        public void setMcq_coins(String mcq_coins) {
            this.mcq_coins = mcq_coins;
        }

        public String getPost_text_type() {
            return this.post_text_type;
        }

        public void setPost_text_type(String post_text_type) {
            this.post_text_type = post_text_type;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public ArrayList<PostFile> getPost_file() {
            return this.post_file;
        }

        public void setPost_file(ArrayList<PostFile> post_file) {
            this.post_file = post_file;
        }

        public ArrayList<NoteTags> getTag() {
            return this.tag;
        }

        public void setTag(ArrayList<NoteTags> tag) {
            this.tag = tag;
        }

        public MCQVoting getMcq_voting() {
            return this.mcq_voting;
        }

        public void setMcq_voting(MCQVoting mcq_voting) {
            this.mcq_voting = mcq_voting;
        }

        public String getAnswer_given_by_user() {
            return this.answer_given_by_user;
        }

        public void setAnswer_given_by_user(String answer_given_by_user) {
            this.answer_given_by_user = answer_given_by_user;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAnswer_one() {
            return this.answer_one;
        }

        public void setAnswer_one(String answer_one) {
            this.answer_one = answer_one;
        }

        public String getRight_answer() {
            return this.right_answer;
        }

        public void setRight_answer(String right_answer) {
            this.right_answer = right_answer;
        }

        public String getAnswer_four() {
            return this.answer_four;
        }

        public void setAnswer_four(String answer_four) {
            this.answer_four = answer_four;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAnswer_two() {
            return this.answer_two;
        }

        public void setAnswer_two(String answer_two) {
            this.answer_two = answer_two;
        }

        public String getQuestion() {
            return this.question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getPost_id() {
            return this.post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getAnswer_five() {
            return this.answer_five;
        }

        public void setAnswer_five(String answer_five) {
            this.answer_five = answer_five;
        }

        public String getAnswer_three() {
            return this.answer_three;
        }

        public void setAnswer_three(String answer_three) {
            this.answer_three = answer_three;
        }

        public class MCQVoting implements Serializable {
            private String answer_five;
            private String answer_four;
            private String answer_one;
            private String answer_three;
            private String answer_two;

            public MCQVoting() {
            }

            public String getAnswer_one() {
                return this.answer_one;
            }

            public void setAnswer_one(String answer_one) {
                this.answer_one = answer_one;
            }

            public String getAnswer_four() {
                return this.answer_four;
            }

            public void setAnswer_four(String answer_four) {
                this.answer_four = answer_four;
            }

            public String getAnswer_two() {
                return this.answer_two;
            }

            public void setAnswer_two(String answer_two) {
                this.answer_two = answer_two;
            }

            public String getAnswer_five() {
                return this.answer_five;
            }

            public void setAnswer_five(String answer_five) {
                this.answer_five = answer_five;
            }

            public String getAnswer_three() {
                return this.answer_three;
            }

            public void setAnswer_three(String answer_three) {
                this.answer_three = answer_three;
            }

            public String toString() {
                return "ClassPojo [answer_one = " + this.answer_one + ", answer_four = " + this.answer_four + ", answer_two = " + this.answer_two + ", answer_five = " + this.answer_five + ", answer_three = " + this.answer_three + Constants.AES_SUFFIX;
            }
        }
    }
}
