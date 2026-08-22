package com.appnew.android.EncryptionModel;

import com.appnew.android.Model.Extras;
import com.appnew.android.Utils.Const;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class EncryptionData implements Serializable {
    private static Extras Extras;
    private String aadhar_card;
    private String aadhar_no;
    private String activation_key;
    private String address;
    private String adhaar;
    private String alternate_number;
    private String amt;
    private String annotation_id;
    String answer;
    String answers;
    private String appId;
    private String attempt;
    String attempted;
    private String batch_id;
    private String blood_group;
    HashMap<String, String> body;
    private String c_center;
    private String c_code;
    private String c_l_s_name;
    private String caste_category;
    private String category;
    private String category_id;
    private String center_address;
    private String center_city;
    private String center_state;
    private String challenge_image;
    private String challenge_text;
    private String city;
    private String city_id;
    String class_center_id;
    private String comment;
    String comment_msg;
    String comment_type;
    String concept_id;
    private String contact_us_id;
    private String content_id;
    private String content_type;
    private String country;
    private String country_id;
    private String coupon_applied;
    private String coupon_code;
    private String course_bulk;
    private String course_id;
    private String course_ids;
    private String course_name;
    private String course_price;
    private String course_type;
    private EncryptionData data;
    private String date_of_birth;
    private String delay;
    private String delivery_charge;
    private String description;
    private String device_id;
    private String device_token;
    private String division;
    private String dob;
    private String doubt_audio;
    private String doubt_id;
    private String doubt_image;
    private String doubt_isbn;
    private String doubt_isbn_error_report;
    private String doubt_page_no;
    private String doubt_pdf;
    private String doubt_question_no;
    private String education_qualification;
    private String educator_id;
    private String email;
    private String end_date;
    private String end_time;
    private String extender_id;
    private String external_coupon;

    @SerializedName("extra_param")
    private Extras extras;
    private String f_mobile_no;
    private String f_occupation;
    public String father_contact;
    private String father_mobile;
    private String father_name;
    private String father_profession;
    private String file;
    private String file_id;
    private String file_ids;
    HashMap<String, String> finalResponse;
    private String first_attempt;
    private String folder_id;
    private String fone_pay_key;
    String fors;
    private String gender;
    private String gstin;
    private String guardian_name;
    private String guardian_number;
    HashMap<String, String> header;
    private String host;
    private String id;
    private String image;
    private String index;
    private String index_id;

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    String f306info;
    private String ip;
    private String is_address_same_permanent;
    private String is_default;
    private String is_download;
    private String is_expert;
    private String is_paid;
    private String is_pin;
    private String is_registration;
    private String is_same_whatsapp_no;
    private String is_social;
    private String is_trending;
    private String is_trial;
    private String is_unbookmarked;
    private String isbn_number;
    private String item_id;
    private String keyword;
    private String lang;
    private String lat;
    private String layer;
    private String limit;
    private String link;
    private String lng;
    private LocationInfo location;
    private String m_mobile_no;
    private String m_occupation;
    private String main_cat;
    private String master_cat;
    private String message;
    private String mobile;
    private String mother_name;
    private String my_answer;
    private String my_like;
    private String name;

    @SerializedName(Const.CLASS)
    private String new_class;
    String note_data;
    private String notification_code;
    private String notification_id;
    private String nr_id;
    private String nr_student;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String option_5;
    private String option_6;
    private String option_id;
    private String order_id;
    private String otp;
    private String p_address;
    private String p_city;
    private String p_class;
    private String p_pincode;
    private String p_state;
    private String page;
    private String parent_id;
    private String password;
    private String pay_via;
    private String payment_for;
    private String payment_meta;
    private String payment_mode;
    private String ph_status;
    private String photo;
    private String pid;
    private String pin_code;
    private String pincode;
    private String plan_id;
    private String plateform;
    private String platform;
    String poll_id;
    String poll_key;
    private String post_id;
    private String post_pin;
    private String post_transaction_id;
    private String post_type;
    private String pre_transaction_id;
    private String product_id;
    private String profession;
    public String profile_picture;
    public String proof_marksheet;
    private String quantity;
    private String que_count;
    String query_id;
    private String question;
    private String question_config_id;
    private String question_id;
    private String question_lang_id;
    private String quote;
    private String ranges;
    private String rating;
    private Integer rating_type;
    private String registration_id;
    private String remaining_time;
    private String reply_user_name;
    private String report_feedback_msg;
    private String resend;
    private String revert_api;
    private String revision_id;
    private String rid;
    String roll_no;
    private String scd;
    private String search;
    private String search_type;
    String servercourseid;
    private String setting_node;
    private String social_token;
    private String social_type;
    private String star_rating;
    private String start_date;
    private String start_time;
    private String state;
    private String state_id;
    private String stream;
    private String student_category;
    private String student_class;
    private String sub_cat;
    private String sub_cat_id;
    private String sub_cat_ids;
    private String sub_division;
    private String subject_id;
    private String subject_ids;
    private String subscription_code;
    private String tax;
    private String temp;
    private String test_center;
    String test_center_id;
    private String test_city;
    private String test_date;
    private String test_id;
    private String test_mode;
    private String test_name;
    private String test_segment_id;
    private String test_series_id;
    private String test_state;
    String text;
    private String tile_id;
    String time;
    String timeleft;
    private String title;
    String token;
    private String topic;
    private String topic_id;
    private String total_time;
    private String transaction_status;
    String transfer_to_id;
    String transfer_to_mobile;
    private String txn_id;
    String[] txn_ids;
    private String type;
    private String upvoted_key;
    private String url;
    private String user_id;
    private String user_mentor;
    private String valid_till;
    private String validity;
    private String video_id;
    private String view_time;
    private String whatsapp_no;

    public String getNotification_id() {
        return this.notification_id;
    }

    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBatch_id() {
        return this.batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getIsbn_number() {
        return this.isbn_number;
    }

    public void setIsbn_number(String isbn_number) {
        this.isbn_number = isbn_number;
    }

    public String getFone_pay_key() {
        return this.fone_pay_key;
    }

    public void setFone_pay_key(String fone_pay_key) {
        this.fone_pay_key = fone_pay_key;
    }

    public String getGstin() {
        return this.gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRid() {
        return this.rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getScd() {
        return this.scd;
    }

    public void setScd(String scd) {
        this.scd = scd;
    }

    public String getAmt() {
        return this.amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getIs_unbookmarked() {
        return this.is_unbookmarked;
    }

    public void setIs_unbookmarked(String is_unbookmarked) {
        this.is_unbookmarked = is_unbookmarked;
    }

    public String getContent_id() {
        return this.content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getIs_download() {
        return this.is_download;
    }

    public void setIs_download(String is_download) {
        this.is_download = is_download;
    }

    public String getContent_type() {
        return this.content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getMaster_cat() {
        return this.master_cat;
    }

    public void setMaster_cat(String master_cat) {
        this.master_cat = master_cat;
    }

    public String getMy_like() {
        return this.my_like;
    }

    public void setMy_like(String my_like) {
        this.my_like = my_like;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIndex() {
        return this.index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPost_pin() {
        return this.post_pin;
    }

    public void setPost_pin(String post_pin) {
        this.post_pin = post_pin;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getMain_cat() {
        return this.main_cat;
    }

    public void setMain_cat(String main_cat) {
        this.main_cat = main_cat;
    }

    public String getIs_pin() {
        return this.is_pin;
    }

    public void setIs_pin(String is_pin) {
        this.is_pin = is_pin;
    }

    public String getPost_type() {
        return this.post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getNew_class() {
        return this.new_class;
    }

    public void setNew_class(String new_class) {
        this.new_class = new_class;
    }

    public String getReport_feedback_msg() {
        return this.report_feedback_msg;
    }

    public void setReport_feedback_msg(String report_feedback_msg) {
        this.report_feedback_msg = report_feedback_msg;
    }

    public String getDivision() {
        return this.division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSub_division() {
        return this.sub_division;
    }

    public void setSub_division(String sub_division) {
        this.sub_division = sub_division;
    }

    public String getOption_id() {
        return this.option_id;
    }

    public void setOption_id(String option_id) {
        this.option_id = option_id;
    }

    public String getQuestion_config_id() {
        return this.question_config_id;
    }

    public void setQuestion_config_id(String question_config_id) {
        this.question_config_id = question_config_id;
    }

    public String getQuestion_lang_id() {
        return this.question_lang_id;
    }

    public void setQuestion_lang_id(String question_lang_id) {
        this.question_lang_id = question_lang_id;
    }

    public String getCenter_state() {
        return this.center_state;
    }

    public void setCenter_state(String center_state) {
        this.center_state = center_state;
    }

    public String getCenter_city() {
        return this.center_city;
    }

    public void setCenter_city(String center_city) {
        this.center_city = center_city;
    }

    public String getTest_city() {
        return this.test_city;
    }

    public void setTest_city(String test_city) {
        this.test_city = test_city;
    }

    public String getTest_state() {
        return this.test_state;
    }

    public void setTest_state(String test_state) {
        this.test_state = test_state;
    }

    public String getNr_id() {
        return this.nr_id;
    }

    public void setNr_id(String nr_id) {
        this.nr_id = nr_id;
    }

    public String getCity_id() {
        return this.city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getTest_mode() {
        return this.test_mode;
    }

    public void setTest_mode(String test_mode) {
        this.test_mode = test_mode;
    }

    public String getBlood_group() {
        return this.blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getAadhar_no() {
        return this.aadhar_no;
    }

    public void setAadhar_no(String aadhar_no) {
        this.aadhar_no = aadhar_no;
    }

    public String getNr_student() {
        return this.nr_student;
    }

    public void setNr_student(String nr_student) {
        this.nr_student = nr_student;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getP_class() {
        return this.p_class;
    }

    public void setP_class(String p_class) {
        this.p_class = p_class;
    }

    public String getC_l_s_name() {
        return this.c_l_s_name;
    }

    public void setC_l_s_name(String c_l_s_name) {
        this.c_l_s_name = c_l_s_name;
    }

    public String getF_mobile_no() {
        return this.f_mobile_no;
    }

    public void setF_mobile_no(String f_mobile_no) {
        this.f_mobile_no = f_mobile_no;
    }

    public String getF_occupation() {
        return this.f_occupation;
    }

    public void setF_occupation(String f_occupation) {
        this.f_occupation = f_occupation;
    }

    public String getMother_name() {
        return this.mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getM_mobile_no() {
        return this.m_mobile_no;
    }

    public void setM_mobile_no(String m_mobile_no) {
        this.m_mobile_no = m_mobile_no;
    }

    public String getTest_date() {
        return this.test_date;
    }

    public void setTest_date(String test_date) {
        this.test_date = test_date;
    }

    public String getTest_center() {
        return this.test_center;
    }

    public void setTest_center(String test_center) {
        this.test_center = test_center;
    }

    public String getM_occupation() {
        return this.m_occupation;
    }

    public void setM_occupation(String m_occupation) {
        this.m_occupation = m_occupation;
    }

    public String getStream() {
        return this.stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getC_center() {
        return this.c_center;
    }

    public void setC_center(String c_center) {
        this.c_center = c_center;
    }

    public String getP_city() {
        return this.p_city;
    }

    public void setP_city(String p_city) {
        this.p_city = p_city;
    }

    public String getP_state() {
        return this.p_state;
    }

    public void setP_state(String p_state) {
        this.p_state = p_state;
    }

    public String getP_pincode() {
        return this.p_pincode;
    }

    public void setP_pincode(String p_pincode) {
        this.p_pincode = p_pincode;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPin_code() {
        return this.pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getGuardian_name() {
        return this.guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public String getGuardian_number() {
        return this.guardian_number;
    }

    public void setGuardian_number(String guardian_number) {
        this.guardian_number = guardian_number;
    }

    public String getEducation_qualification() {
        return this.education_qualification;
    }

    public void setEducation_qualification(String education_qualification) {
        this.education_qualification = education_qualification;
    }

    public String getAadhar_card() {
        return this.aadhar_card;
    }

    public void setAadhar_card(String aadhar_card) {
        this.aadhar_card = aadhar_card;
    }

    public String getPh_status() {
        return this.ph_status;
    }

    public void setPh_status(String ph_status) {
        this.ph_status = ph_status;
    }

    public String getAlternate_number() {
        return this.alternate_number;
    }

    public void setAlternate_number(String alternate_number) {
        this.alternate_number = alternate_number;
    }

    public String getCaste_category() {
        return this.caste_category;
    }

    public void setCaste_category(String caste_category) {
        this.caste_category = caste_category;
    }

    public String getSocial_token() {
        return this.social_token;
    }

    public void setSocial_token(String social_token) {
        this.social_token = social_token;
    }

    public String getSocial_type() {
        return this.social_type;
    }

    public void setSocial_type(String social_type) {
        this.social_type = social_type;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
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

    public String getDoubt_image() {
        return this.doubt_image;
    }

    public void setDoubt_image(String doubt_image) {
        this.doubt_image = doubt_image;
    }

    public String getDoubt_audio() {
        return this.doubt_audio;
    }

    public void setDoubt_audio(String doubt_audio) {
        this.doubt_audio = doubt_audio;
    }

    public String getDoubt_isbn_error_report() {
        return this.doubt_isbn_error_report;
    }

    public void setDoubt_isbn_error_report(String doubt_isbn_error_report) {
        this.doubt_isbn_error_report = doubt_isbn_error_report;
    }

    public String getDoubt_pdf() {
        return this.doubt_pdf;
    }

    public void setDoubt_pdf(String doubt_pdf) {
        this.doubt_pdf = doubt_pdf;
    }

    public String getDoubt_page_no() {
        return this.doubt_page_no;
    }

    public void setDoubt_page_no(String doubt_page_no) {
        this.doubt_page_no = doubt_page_no;
    }

    public String getDoubt_question_no() {
        return this.doubt_question_no;
    }

    public void setDoubt_question_no(String doubt_question_no) {
        this.doubt_question_no = doubt_question_no;
    }

    public String getDoubt_isbn() {
        return this.doubt_isbn;
    }

    public void setDoubt_isbn(String doubt_isbn) {
        this.doubt_isbn = doubt_isbn;
    }

    public Extras getExtras() {
        return this.extras;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    public String getDelivery_charge() {
        return this.delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getRanges() {
        return this.ranges;
    }

    public void setRanges(String ranges) {
        this.ranges = ranges;
    }

    public String getAnnotation_id() {
        return this.annotation_id;
    }

    public void setAnnotation_id(String annotation_id) {
        this.annotation_id = annotation_id;
    }

    public String getActivation_key() {
        return this.activation_key;
    }

    public void setActivation_key(String activation_key) {
        this.activation_key = activation_key;
    }

    public String getAnswers() {
        return this.answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public LocationInfo getLocation() {
        return this.location;
    }

    public void setLocation(LocationInfo location) {
        this.location = location;
    }

    public String getTxn_id() {
        return this.txn_id;
    }

    public void setTxn_id(String txn_id) {
        this.txn_id = txn_id;
    }

    public String getExtender_id() {
        return this.extender_id;
    }

    public void setExtender_id(String extender_id) {
        this.extender_id = extender_id;
    }

    public String getInfo() {
        return this.f306info;
    }

    public void setInfo(String info2) {
        this.f306info = info2;
    }

    public String[] getTxn_ids() {
        return this.txn_ids;
    }

    public void setTxn_ids(String[] txn_ids) {
        this.txn_ids = txn_ids;
    }

    public String getTransfer_to_id() {
        return this.transfer_to_id;
    }

    public void setTransfer_to_id(String transfer_to_id) {
        this.transfer_to_id = transfer_to_id;
    }

    public String getTransfer_to_mobile() {
        return this.transfer_to_mobile;
    }

    public void setTransfer_to_mobile(String transfer_to_mobile) {
        this.transfer_to_mobile = transfer_to_mobile;
    }

    public String getComment_type() {
        return this.comment_type;
    }

    public void setComment_type(String comment_type) {
        this.comment_type = comment_type;
    }

    public String getComment_msg() {
        return this.comment_msg;
    }

    public void setComment_msg(String comment_msg) {
        this.comment_msg = comment_msg;
    }

    public String getQuery_id() {
        return this.query_id;
    }

    public void setQuery_id(String query_id) {
        this.query_id = query_id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNote_data() {
        return this.note_data;
    }

    public void setNote_data(String note_data) {
        this.note_data = note_data;
    }

    public String getConcept_id() {
        return this.concept_id;
    }

    public void setConcept_id(String concept_id) {
        this.concept_id = concept_id;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCoupon_code() {
        return this.coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public String getExternal_coupon() {
        return this.external_coupon;
    }

    public void setExternal_coupon(String external_coupon) {
        this.external_coupon = external_coupon;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getRevision_id() {
        return this.revision_id;
    }

    public void setRevision_id(String revision_id) {
        this.revision_id = revision_id;
    }

    public String getFors() {
        return this.fors;
    }

    public void setFors(String fors) {
        this.fors = fors;
    }

    public String getServercourseid() {
        return this.servercourseid;
    }

    public void setServercourseid(String servercourseid) {
        this.servercourseid = servercourseid;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPoll_id() {
        return this.poll_id;
    }

    public void setPoll_id(String poll_id) {
        this.poll_id = poll_id;
    }

    public String getChallenge_text() {
        return this.challenge_text;
    }

    public void setChallenge_text(String challenge_text) {
        this.challenge_text = challenge_text;
    }

    public String getChallenge_image() {
        return this.challenge_image;
    }

    public void setChallenge_image(String challenge_image) {
        this.challenge_image = challenge_image;
    }

    public String getQuestion_id() {
        return this.question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTest_segment_id() {
        return this.test_segment_id;
    }

    public void setTest_segment_id(String test_segment_id) {
        this.test_segment_id = test_segment_id;
    }

    public String getTest_id() {
        return this.test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getFirst_attempt() {
        return this.first_attempt;
    }

    public void setFirst_attempt(String first_attempt) {
        this.first_attempt = first_attempt;
    }

    public String getCourse_ids() {
        return this.course_ids;
    }

    public void setCourse_ids(String course_ids) {
        this.course_ids = course_ids;
    }

    public String getSubject_ids() {
        return this.subject_ids;
    }

    public void setSubject_ids(String subject_ids) {
        this.subject_ids = subject_ids;
    }

    public String getLimit() {
        return this.limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getQue_count() {
        return this.que_count;
    }

    public void setQue_count(String que_count) {
        this.que_count = que_count;
    }

    public String getTest_series_id() {
        return this.test_series_id;
    }

    public void setTest_series_id(String test_series_id) {
        this.test_series_id = test_series_id;
    }

    public String getPre_transaction_id() {
        return this.pre_transaction_id;
    }

    public void setPre_transaction_id(String pre_transaction_id) {
        this.pre_transaction_id = pre_transaction_id;
    }

    public String getTransaction_status() {
        return this.transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getPost_transaction_id() {
        return this.post_transaction_id;
    }

    public void setPost_transaction_id(String post_transaction_id) {
        this.post_transaction_id = post_transaction_id;
    }

    public String getCourse_price() {
        return this.course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public String getPay_via() {
        return this.pay_via;
    }

    public void setPay_via(String pay_via) {
        this.pay_via = pay_via;
    }

    public String getCoupon_applied() {
        return this.coupon_applied;
    }

    public void setCoupon_applied(String coupon_applied) {
        this.coupon_applied = coupon_applied;
    }

    public String getDevice_token() {
        return this.device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getCourse_bulk() {
        return this.course_bulk;
    }

    public void setCourse_bulk(String course_bulk) {
        this.course_bulk = course_bulk;
    }

    public String getFile_id() {
        return this.file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getPayment_meta() {
        return this.payment_meta;
    }

    public void setPayment_meta(String payment_meta) {
        this.payment_meta = payment_meta;
    }

    public String getAttempt() {
        return this.attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public String getSubscription_code() {
        return this.subscription_code;
    }

    public void setSubscription_code(String subscription_code) {
        this.subscription_code = subscription_code;
    }

    public String getPayment_for() {
        return this.payment_for;
    }

    public void setPayment_for(String payment_for) {
        this.payment_for = payment_for;
    }

    public String getPlan_id() {
        return this.plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getPayment_mode() {
        return this.payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getIs_paid() {
        return this.is_paid;
    }

    public void setIs_paid(String is_paid) {
        this.is_paid = is_paid;
    }

    public String getSub_cat_id() {
        return this.sub_cat_id;
    }

    public void setSub_cat_id(String sub_cat_id) {
        this.sub_cat_id = sub_cat_id;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDevice_tokken() {
        return this.device_token;
    }

    public void setDevice_tokken(String device_tokken) {
        this.device_token = device_tokken;
    }

    public String getIs_social() {
        return this.is_social;
    }

    public void setIs_social(String is_social) {
        this.is_social = is_social;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getIs_registration() {
        return this.is_registration;
    }

    public void setIs_registration(String is_registration) {
        this.is_registration = is_registration;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFile_ids() {
        return this.file_ids;
    }

    public void setFile_ids(String file_ids) {
        this.file_ids = file_ids;
    }

    public String getState_id() {
        return this.state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_mentor() {
        return this.user_mentor;
    }

    public void setUser_mentor(String user_mentor) {
        this.user_mentor = user_mentor;
    }

    public String getIs_trending() {
        return this.is_trending;
    }

    public void setIs_trending(String is_trending) {
        this.is_trending = is_trending;
    }

    public String getIs_same_whatsapp_no() {
        return this.is_same_whatsapp_no;
    }

    public void setIs_same_whatsapp_no(String is_same_whatsapp_no) {
        this.is_same_whatsapp_no = is_same_whatsapp_no;
    }

    public String getWhatsapp_no() {
        return this.whatsapp_no;
    }

    public void setWhatsapp_no(String whatsapp_no) {
        this.whatsapp_no = whatsapp_no;
    }

    public String getIs_address_same_permanent() {
        return this.is_address_same_permanent;
    }

    public void setIs_address_same_permanent(String is_address_same_permanent) {
        this.is_address_same_permanent = is_address_same_permanent;
    }

    public String getCenter_address() {
        return this.center_address;
    }

    public void setCenter_address(String center_address) {
        this.center_address = center_address;
    }

    public String getTest_name() {
        return this.test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getCourse_type() {
        return this.course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getSub_cat() {
        return this.sub_cat;
    }

    public void setSub_cat(String sub_cat) {
        this.sub_cat = sub_cat;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDoubt_id() {
        return this.doubt_id;
    }

    public void setDoubt_id(String doubt_id) {
        this.doubt_id = doubt_id;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getFolder_id() {
        return this.folder_id;
    }

    public void setFolder_id(String folder_id) {
        this.folder_id = folder_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
    }

    public String getType() {
        return this.type;
    }

    public String getRemaining_time() {
        return this.remaining_time;
    }

    public void setRemaining_time(String remaining_time) {
        this.remaining_time = remaining_time;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStar_rating() {
        return this.star_rating;
    }

    public void setStar_rating(String star_rating) {
        this.star_rating = star_rating;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_time() {
        return this.start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getTotal_time() {
        return this.total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public String getView_time() {
        return this.view_time;
    }

    public void setView_time(String view_time) {
        this.view_time = view_time;
    }

    public String getRevert_api() {
        return this.revert_api;
    }

    public void setRevert_api(String revert_api) {
        this.revert_api = revert_api;
    }

    public String getLayer() {
        return this.layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getIs_default() {
        return this.is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotification_code() {
        return this.notification_code;
    }

    public void setNotification_code(String notification_code) {
        this.notification_code = notification_code;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public HashMap<String, String> getFinalResponse() {
        return this.finalResponse;
    }

    public void setFinalResponse(HashMap<String, String> finalResponse) {
        this.finalResponse = finalResponse;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getProof_marksheet() {
        return this.proof_marksheet;
    }

    public void setProof_marksheet(String proof_marksheet) {
        this.proof_marksheet = proof_marksheet;
    }

    public String getFather_contact() {
        return this.father_contact;
    }

    public void setFather_contact(String father_contact) {
        this.father_contact = father_contact;
    }

    public String getIndex_id() {
        return this.index_id;
    }

    public void setIndex_id(String index_id) {
        this.index_id = index_id;
    }

    public String getResend() {
        return this.resend;
    }

    public void setResend(String resend) {
        this.resend = resend;
    }

    public HashMap<String, String> getHeader() {
        return this.header;
    }

    public void setHeader(HashMap<String, String> header) {
        this.header = header;
    }

    public HashMap<String, String> getBody() {
        return this.body;
    }

    public void setBody(HashMap<String, String> body) {
        this.body = body;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry_id() {
        return this.country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getDate_of_birth() {
        return this.date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIs_expert() {
        return this.is_expert;
    }

    public void setIs_expert(String is_expert) {
        this.is_expert = is_expert;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAdhaar() {
        return this.adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getFather_name() {
        return this.father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getFather_profession() {
        return this.father_profession;
    }

    public void setFather_profession(String father_profession) {
        this.father_profession = father_profession;
    }

    public String getP_address() {
        return this.p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getFather_mobile() {
        return this.father_mobile;
    }

    public void setFather_mobile(String father_mobile) {
        this.father_mobile = father_mobile;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRegistration_id() {
        return this.registration_id;
    }

    public void setRegistration_id(String registration_id) {
        this.registration_id = registration_id;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getContact_us_id() {
        return this.contact_us_id;
    }

    public void setContact_us_id(String contact_us_id) {
        this.contact_us_id = contact_us_id;
    }

    public String getReply_user_name() {
        return this.reply_user_name;
    }

    public void setReply_user_name(String reply_user_name) {
        this.reply_user_name = reply_user_name;
    }

    public String getSub_cat_ids() {
        return this.sub_cat_ids;
    }

    public void setSub_cat_ids(String sub_cat_ids) {
        this.sub_cat_ids = sub_cat_ids;
    }

    public String getStudent_category() {
        return this.student_category;
    }

    public void setStudent_category(String student_category) {
        this.student_category = student_category;
    }

    public void setSearchType(String search_type) {
        this.search_type = search_type;
    }

    public String getSearchType() {
        return this.search_type;
    }

    public void setKeyWord(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyWord() {
        return this.keyword;
    }

    public String getClass_center_id() {
        return this.class_center_id;
    }

    public void setClass_center_id(String class_center_id) {
        this.class_center_id = class_center_id;
    }

    public String getTest_center_id() {
        return this.test_center_id;
    }

    public void setTest_center_id(String test_center_id) {
        this.test_center_id = test_center_id;
    }

    public String getRoll_no() {
        return this.roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getStudent_class() {
        return this.student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getPoll_key() {
        return this.poll_key;
    }

    public void setPoll_key(String poll_key) {
        this.poll_key = poll_key;
    }

    public String getTemp() {
        return this.temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getUpvoted_key() {
        return this.upvoted_key;
    }

    public void setUpvoted_key(String upvoted_key) {
        this.upvoted_key = upvoted_key;
    }

    public String getEducator_id() {
        return this.educator_id;
    }

    public void setEducator_id(String educator_id) {
        this.educator_id = educator_id;
    }

    public String getSetting_node() {
        return this.setting_node;
    }

    public void setSetting_node(String setting_node) {
        this.setting_node = setting_node;
    }

    public String getAttempted() {
        return this.attempted;
    }

    public void setAttempted(String attempted) {
        this.attempted = attempted;
    }

    public String getTimeleft() {
        return this.timeleft;
    }

    public void setTimeleft(String timeleft) {
        this.timeleft = timeleft;
    }

    public EncryptionData getData() {
        return this.data;
    }

    public void setData(EncryptionData data) {
        this.data = data;
    }

    public String getPlateform() {
        return this.plateform;
    }

    public void setPlateform(String plateform) {
        this.plateform = plateform;
    }

    public String getMy_answer() {
        return this.my_answer;
    }

    public void setMy_answer(String my_answer) {
        this.my_answer = my_answer;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getValid_till() {
        return this.valid_till;
    }

    public void setValid_till(String valid_till) {
        this.valid_till = valid_till;
    }

    public String getOption_1() {
        return this.option_1;
    }

    public void setOption_1(String option_1) {
        this.option_1 = option_1;
    }

    public String getOption_2() {
        return this.option_2;
    }

    public void setOption_2(String option_2) {
        this.option_2 = option_2;
    }

    public String getOption_3() {
        return this.option_3;
    }

    public void setOption_3(String option_3) {
        this.option_3 = option_3;
    }

    public String getOption_4() {
        return this.option_4;
    }

    public void setOption_4(String option_4) {
        this.option_4 = option_4;
    }

    public String getOption_5() {
        return this.option_5;
    }

    public void setOption_5(String option_5) {
        this.option_5 = option_5;
    }

    public String getOption_6() {
        return this.option_6;
    }

    public void setOption_6(String option_6) {
        this.option_6 = option_6;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDelay() {
        return this.delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public Integer getRating_type() {
        return this.rating_type;
    }

    public void setRating_type(Integer rating_type) {
        this.rating_type = rating_type;
    }

    public String getIs_trial() {
        return this.is_trial;
    }

    public void setIs_trial(String is_trial) {
        this.is_trial = is_trial;
    }
}
