package com.appnew.android.testmodule.model;

import com.appnew.android.Model.ExpectedRank;
import com.appnew.android.Model.Topper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ResultTestSeries_Report implements Serializable {
    private DataResult data;
    private ArrayList<Errors> error;
    private String is_android_price;
    private String message;
    String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIs_android_price() {
        return this.is_android_price;
    }

    public void setIs_android_price(String is_android_price) {
        this.is_android_price = is_android_price;
    }

    public ArrayList<Errors> getError() {
        return this.error;
    }

    public void setError(ArrayList<Errors> error) {
        this.error = error;
    }

    public DataResult getData() {
        return this.data;
    }

    public void setData(DataResult data) {
        this.data = data;
    }

    public class DataResult implements Serializable {
        private String allow_duplicate_rank;
        private String answer_shuffle;
        private String avg_score;
        private String backend_user_id;
        private String best_score;
        private String chapter_id;
        private String correct_count;
        ArrayList<CutOff> cut_off;
        private String cut_off_message;
        private String cutoff;
        private String description;
        private String difficulty_level;
        private int disqualified;
        private String download_pdf;
        private String end_date;
        ExpectedRank expected_rank;
        private String fail_message;
        private String feedback_allowed;
        private String general_message;
        String hide_rank;
        private String hide_score;
        private String id;
        private String image;
        private String incorrect_count;
        private String is_calc_allowed;
        private String is_reattempt;
        private String lang_id;
        private String marks;
        String mode;
        private String multiple_video;
        private String multiple_video_title;
        private String non_attempt;
        private String pass_message;
        private String pass_percentage;
        private String passing_cutoff;
        private String percentage;
        private String percentile;
        Prize prize;
        private String publish;
        ArrayList<QuestionDumps> question_dump;
        private String question_pdf;
        private String question_skip;
        ArrayList<Questions2> questions;

        @SerializedName("questions_hindi")
        @Expose
        private ArrayList<Questions2> questionsHindi = null;
        private String result_date;
        private String reward_points;
        private String session;
        private String set_type;
        private String shuffle;
        private String skip_total;
        String solution_date;
        private String start_date;
        private String stream;
        private String sub_stream;
        private String sub_topic_id;
        private String subject;
        private String teacher_id;
        private String template_id;
        Test_assets test_assets;
        ArrayList<TestReportVideos> test_report_videos;
        ArrayList<TestSections> test_sections;
        private String test_series_name;
        String test_series_type;
        private String test_type;
        private String time_boundation;
        private String time_in_mins;
        private String time_remain;
        ArrayList<TopTenList> top_ten_list;
        private String topic_id;
        Topper topper;
        String total_mandatory;
        private String total_marks;
        String total_optional;
        private String total_questions;
        private String total_user_attempt;
        private String unit_id;
        private String user_rank;
        private String video_url;
        private String watermark;

        public DataResult() {
        }

        public String getQuestion_skip() {
            return this.question_skip;
        }

        public void setQuestion_skip(String question_skip) {
            this.question_skip = question_skip;
        }

        public int getDisqualified() {
            return this.disqualified;
        }

        public void setDisqualified(int disqualified) {
            this.disqualified = disqualified;
        }

        public String getSkip_total() {
            return this.skip_total;
        }

        public void setSkip_total(String skip_total) {
            this.skip_total = skip_total;
        }

        public ExpectedRank getExpected_rank() {
            return this.expected_rank;
        }

        public void setExpected_rank(ExpectedRank expected_rank) {
            this.expected_rank = expected_rank;
        }

        public Topper getTopper() {
            return this.topper;
        }

        public void setTopper(Topper topper) {
            this.topper = topper;
        }

        public String getCut_off_message() {
            return this.cut_off_message;
        }

        public void setCut_off_message(String cut_off_message) {
            this.cut_off_message = cut_off_message;
        }

        public String getHide_score() {
            return this.hide_score;
        }

        public void setHide_score(String hide_score) {
            this.hide_score = hide_score;
        }

        public Prize getPrize() {
            return this.prize;
        }

        public void setPrize(Prize prize) {
            this.prize = prize;
        }

        public String getTotal_mandatory() {
            return this.total_mandatory;
        }

        public void setTotal_mandatory(String total_mandatory) {
            this.total_mandatory = total_mandatory;
        }

        public String getTotal_optional() {
            return this.total_optional;
        }

        public void setTotal_optional(String total_optional) {
            this.total_optional = total_optional;
        }

        public Test_assets getTest_assets() {
            return this.test_assets;
        }

        public void setTest_assets(Test_assets test_assets) {
            this.test_assets = test_assets;
        }

        public String getHide_rank() {
            return this.hide_rank;
        }

        public void setHide_rank(String hide_rank) {
            this.hide_rank = hide_rank;
        }

        public String getMode() {
            return this.mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getDownload_pdf() {
            return this.download_pdf;
        }

        public void setDownload_pdf(String download_pdf) {
            this.download_pdf = download_pdf;
        }

        public String getQuestion_pdf() {
            return this.question_pdf;
        }

        public void setQuestion_pdf(String question_pdf) {
            this.question_pdf = question_pdf;
        }

        public String getPercentage() {
            return this.percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTemplate_id() {
            return this.template_id;
        }

        public void setTemplate_id(String template_id) {
            this.template_id = template_id;
        }

        public String getImage() {
            return this.image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTest_series_name() {
            return this.test_series_name;
        }

        public void setTest_series_name(String test_series_name) {
            this.test_series_name = test_series_name;
        }

        public String getDifficulty_level() {
            return this.difficulty_level;
        }

        public void setDifficulty_level(String difficulty_level) {
            this.difficulty_level = difficulty_level;
        }

        public String getTest_type() {
            return this.test_type;
        }

        public void setTest_type(String test_type) {
            this.test_type = test_type;
        }

        public String getBackend_user_id() {
            return this.backend_user_id;
        }

        public void setBackend_user_id(String backend_user_id) {
            this.backend_user_id = backend_user_id;
        }

        public String getTeacher_id() {
            return this.teacher_id;
        }

        public void setTeacher_id(String teacher_id) {
            this.teacher_id = teacher_id;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSession() {
            return this.session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getTotal_questions() {
            return this.total_questions;
        }

        public void setTotal_questions(String total_questions) {
            this.total_questions = total_questions;
        }

        public String getTime_in_mins() {
            return this.time_in_mins;
        }

        public void setTime_in_mins(String time_in_mins) {
            this.time_in_mins = time_in_mins;
        }

        public String getTotal_marks() {
            return this.total_marks;
        }

        public void setTotal_marks(String total_marks) {
            this.total_marks = total_marks;
        }

        public String getShuffle() {
            return this.shuffle;
        }

        public void setShuffle(String shuffle) {
            this.shuffle = shuffle;
        }

        public String getAnswer_shuffle() {
            return this.answer_shuffle;
        }

        public void setAnswer_shuffle(String answer_shuffle) {
            this.answer_shuffle = answer_shuffle;
        }

        public String getTime_boundation() {
            return this.time_boundation;
        }

        public void setTime_boundation(String time_boundation) {
            this.time_boundation = time_boundation;
        }

        public String getPass_message() {
            return this.pass_message;
        }

        public void setPass_message(String pass_message) {
            this.pass_message = pass_message;
        }

        public String getGeneral_message() {
            return this.general_message;
        }

        public void setGeneral_message(String general_message) {
            this.general_message = general_message;
        }

        public String getFail_message() {
            return this.fail_message;
        }

        public void setFail_message(String fail_message) {
            this.fail_message = fail_message;
        }

        public String getPass_percentage() {
            return this.pass_percentage;
        }

        public void setPass_percentage(String pass_percentage) {
            this.pass_percentage = pass_percentage;
        }

        public String getAllow_duplicate_rank() {
            return this.allow_duplicate_rank;
        }

        public void setAllow_duplicate_rank(String allow_duplicate_rank) {
            this.allow_duplicate_rank = allow_duplicate_rank;
        }

        public String getStart_date() {
            return this.start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public String getEnd_date() {
            return this.end_date;
        }

        public void setEnd_date(String end_date) {
            this.end_date = end_date;
        }

        public String getResult_date() {
            return this.result_date;
        }

        public void setResult_date(String result_date) {
            this.result_date = result_date;
        }

        public String getPublish() {
            return this.publish;
        }

        public void setPublish(String publish) {
            this.publish = publish;
        }

        public String getReward_points() {
            return this.reward_points;
        }

        public void setReward_points(String reward_points) {
            this.reward_points = reward_points;
        }

        public String getSet_type() {
            return this.set_type;
        }

        public void setSet_type(String set_type) {
            this.set_type = set_type;
        }

        public String getStream() {
            return this.stream;
        }

        public void setStream(String stream) {
            this.stream = stream;
        }

        public String getSub_stream() {
            return this.sub_stream;
        }

        public void setSub_stream(String sub_stream) {
            this.sub_stream = sub_stream;
        }

        public String getSubject() {
            return this.subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getUnit_id() {
            return this.unit_id;
        }

        public void setUnit_id(String unit_id) {
            this.unit_id = unit_id;
        }

        public String getChapter_id() {
            return this.chapter_id;
        }

        public void setChapter_id(String chapter_id) {
            this.chapter_id = chapter_id;
        }

        public String getTopic_id() {
            return this.topic_id;
        }

        public void setTopic_id(String topic_id) {
            this.topic_id = topic_id;
        }

        public String getSub_topic_id() {
            return this.sub_topic_id;
        }

        public void setSub_topic_id(String sub_topic_id) {
            this.sub_topic_id = sub_topic_id;
        }

        public String getLang_id() {
            return this.lang_id;
        }

        public void setLang_id(String lang_id) {
            this.lang_id = lang_id;
        }

        public String getVideo_url() {
            return this.video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getIs_calc_allowed() {
            return this.is_calc_allowed;
        }

        public void setIs_calc_allowed(String is_calc_allowed) {
            this.is_calc_allowed = is_calc_allowed;
        }

        public String getFeedback_allowed() {
            return this.feedback_allowed;
        }

        public void setFeedback_allowed(String feedback_allowed) {
            this.feedback_allowed = feedback_allowed;
        }

        public String getIs_reattempt() {
            return this.is_reattempt;
        }

        public void setIs_reattempt(String is_reattempt) {
            this.is_reattempt = is_reattempt;
        }

        public String getCutoff() {
            return this.cutoff;
        }

        public void setCutoff(String cutoff) {
            this.cutoff = cutoff;
        }

        public String getWatermark() {
            return this.watermark;
        }

        public void setWatermark(String watermark) {
            this.watermark = watermark;
        }

        public String getMultiple_video_title() {
            return this.multiple_video_title;
        }

        public void setMultiple_video_title(String multiple_video_title) {
            this.multiple_video_title = multiple_video_title;
        }

        public String getMultiple_video() {
            return this.multiple_video;
        }

        public void setMultiple_video(String multiple_video) {
            this.multiple_video = multiple_video;
        }

        public String getTotal_user_attempt() {
            return this.total_user_attempt;
        }

        public void setTotal_user_attempt(String total_user_attempt) {
            this.total_user_attempt = total_user_attempt;
        }

        public String getUser_rank() {
            return this.user_rank;
        }

        public void setUser_rank(String user_rank) {
            this.user_rank = user_rank;
        }

        public String getMarks() {
            return this.marks;
        }

        public void setMarks(String marks) {
            this.marks = marks;
        }

        public String getBest_score() {
            return this.best_score;
        }

        public void setBest_score(String best_score) {
            this.best_score = best_score;
        }

        public String getAvg_score() {
            return this.avg_score;
        }

        public void setAvg_score(String avg_score) {
            this.avg_score = avg_score;
        }

        public String getCorrect_count() {
            return this.correct_count;
        }

        public void setCorrect_count(String correct_count) {
            this.correct_count = correct_count;
        }

        public String getIncorrect_count() {
            return this.incorrect_count;
        }

        public void setIncorrect_count(String incorrect_count) {
            this.incorrect_count = incorrect_count;
        }

        public String getNon_attempt() {
            return this.non_attempt;
        }

        public void setNon_attempt(String non_attempt) {
            this.non_attempt = non_attempt;
        }

        public String getTime_remain() {
            return this.time_remain;
        }

        public void setTime_remain(String time_remain) {
            this.time_remain = time_remain;
        }

        public ArrayList<QuestionDumps> getQuestion_dump() {
            return this.question_dump;
        }

        public void setQuestion_dump(ArrayList<QuestionDumps> question_dump) {
            this.question_dump = question_dump;
        }

        public ArrayList<CutOff> getCut_off() {
            return this.cut_off;
        }

        public void setCut_off(ArrayList<CutOff> cut_off) {
            this.cut_off = cut_off;
        }

        public String getPercentile() {
            return this.percentile;
        }

        public void setPercentile(String percentile) {
            this.percentile = percentile;
        }

        public ArrayList<TopTenList> getTop_ten_list() {
            return this.top_ten_list;
        }

        public void setTop_ten_list(ArrayList<TopTenList> top_ten_list) {
            this.top_ten_list = top_ten_list;
        }

        public ArrayList<TestReportVideos> getTest_report_videos() {
            return this.test_report_videos;
        }

        public void setTest_report_videos(ArrayList<TestReportVideos> test_report_videos) {
            this.test_report_videos = test_report_videos;
        }

        public ArrayList<TestSections> getTest_sections() {
            return this.test_sections;
        }

        public void setTest_sections(ArrayList<TestSections> test_sections) {
            this.test_sections = test_sections;
        }

        public ArrayList<Questions2> getQuestionsHindi() {
            return this.questionsHindi;
        }

        public void setQuestionsHindi(ArrayList<Questions2> questionsHindi) {
            this.questionsHindi = questionsHindi;
        }

        public ArrayList<Questions2> getQuestions() {
            return this.questions;
        }

        public void setQuestions(ArrayList<Questions2> questions) {
            this.questions = questions;
        }

        public String getPassing_cutoff() {
            return this.passing_cutoff;
        }

        public void setPassing_cutoff(String passing_cutoff) {
            this.passing_cutoff = passing_cutoff;
        }

        public String getSolution_date() {
            return this.solution_date;
        }

        public String getTest_series_type() {
            return this.test_series_type;
        }
    }

    public class Errors implements Serializable {
        public Errors() {
        }
    }

    public class Test_assets implements Serializable {
        String hide_attempted_used;

        public Test_assets() {
        }

        public String getHide_attempted_used() {
            return this.hide_attempted_used;
        }

        public void setHide_attempted_used(String hide_attempted_used) {
            this.hide_attempted_used = hide_attempted_used;
        }
    }
}
