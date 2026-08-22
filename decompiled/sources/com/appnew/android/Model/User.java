package com.appnew.android.Model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class User implements Serializable {
    static User userprofile;
    private String age;
    private String allow_posting;
    private String c_code;
    private String category;
    private String creation_time;
    private String dams_password;
    private String dams_tokken;
    private String dams_username;
    private String device_tokken;
    private String device_type;
    private String email;
    private int expert_following;
    private String followers_count;
    private String following_count;
    private String gender;
    private String id;
    private String is_course_register;
    private String is_expert;
    private boolean is_following;
    private String is_mentor;
    private String is_moderate;
    private String is_nimbus;
    private String is_social;
    private Leadsquared leadsquared;
    private String mobile;
    private String name;
    private String otp;
    private String password;
    private String post_count;
    private String profile_picture;
    private String socialId;
    private String social_tokken;
    private String social_type;
    private String speciality;
    private String state;
    private String update_status;
    private String user_likes;
    private Registration user_registration_info;
    private String user_tokken;
    private ArrayList<AddressUser> address = null;
    private String dristi_user_id = "";
    private String id_card_front = "";
    private String id_card_back = "";
    private String is_verified = "";

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public static User newInstance() {
        User user = new User();
        userprofile = user;
        return user;
    }

    public static User copyInstance(User user) {
        userprofile = user;
        return user;
    }

    public static User getInstance() {
        if (userprofile == null) {
            userprofile = new User();
        }
        return userprofile;
    }

    public String getUser_tokken() {
        return this.user_tokken;
    }

    public void setUser_tokken(String user_tokken) {
        this.user_tokken = user_tokken;
    }

    public String getIs_nimbus() {
        return this.is_nimbus;
    }

    public void setIs_nimbus(String is_nimbus) {
        this.is_nimbus = is_nimbus;
    }

    public String getUser_likes() {
        return this.user_likes;
    }

    public void setUser_likes(String user_likes) {
        this.user_likes = user_likes;
    }

    public boolean isIs_following() {
        return this.is_following;
    }

    public void setIs_following(boolean is_following) {
        this.is_following = is_following;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIs_expert() {
        return this.is_expert;
    }

    public void setIs_expert(String is_expert) {
        this.is_expert = is_expert;
    }

    public int getExpert_following() {
        return this.expert_following;
    }

    public void setExpert_following(int expert_following) {
        this.expert_following = expert_following;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getIs_moderate() {
        return this.is_moderate;
    }

    public void setIs_moderate(String is_moderate) {
        this.is_moderate = is_moderate;
    }

    public String getDams_password() {
        return this.dams_password;
    }

    public void setDams_password(String dams_password) {
        this.dams_password = dams_password;
    }

    public String getDams_username() {
        return this.dams_username;
    }

    public void setDams_username(String dams_username) {
        this.dams_username = dams_username;
    }

    public String getPost_count() {
        return this.post_count;
    }

    public void setPost_count(String post_count) {
        this.post_count = post_count;
    }

    public Registration getUser_registration_info() {
        return this.user_registration_info;
    }

    public void setUser_registration_info(Registration user_registration_info) {
        this.user_registration_info = user_registration_info;
    }

    public boolean is_following() {
        return this.is_following;
    }

    public String getFollowers_count() {
        return this.followers_count;
    }

    public void setFollowers_count(String followers_count) {
        this.followers_count = followers_count;
    }

    public String getFollowing_count() {
        return this.following_count;
    }

    public void setFollowing_count(String following_count) {
        this.following_count = following_count;
    }

    public String getAllow_posting() {
        return this.allow_posting;
    }

    public void setAllow_posting(String allow_posting) {
        this.allow_posting = allow_posting;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getIs_course_register() {
        return this.is_course_register;
    }

    public void setIs_course_register(String is_course_register) {
        this.is_course_register = is_course_register;
    }

    public String getSocialId() {
        return this.socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getDams_tokken() {
        return this.dams_tokken;
    }

    public void setDams_tokken(String dams_tokken) {
        this.dams_tokken = dams_tokken;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSocial_tokken() {
        return this.social_tokken;
    }

    public void setSocial_tokken(String social_tokken) {
        this.social_tokken = social_tokken;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDevice_type() {
        return this.device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIs_social() {
        return this.is_social;
    }

    public void setIs_social(String is_social) {
        this.is_social = is_social;
    }

    public String getSocial_type() {
        return this.social_type;
    }

    public void setSocial_type(String social_type) {
        this.social_type = social_type;
    }

    public String getDevice_tokken() {
        return this.device_tokken;
    }

    public void setDevice_tokken(String device_tokken) {
        this.device_tokken = device_tokken;
    }

    public String getIs_mentor() {
        return this.is_mentor;
    }

    public void setIs_mentor(String is_mentor) {
        this.is_mentor = is_mentor;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUpdate_status() {
        return this.update_status;
    }

    public void setUpdate_status(String update_status) {
        this.update_status = update_status;
    }

    public ArrayList<AddressUser> getAddress() {
        return this.address;
    }

    public void setAddress(ArrayList<AddressUser> address) {
        this.address = address;
    }

    public Leadsquared getLeadsquared() {
        return this.leadsquared;
    }

    public void setLeadsquared(Leadsquared leadsquared) {
        this.leadsquared = leadsquared;
    }

    public String getDristi_user_id() {
        return this.dristi_user_id;
    }

    public void setDristi_user_id(String dristi_user_id) {
        this.dristi_user_id = dristi_user_id;
    }

    public String getId_card_front() {
        return this.id_card_front;
    }

    public void setId_card_front(String id_card_front) {
        this.id_card_front = id_card_front;
    }

    public String getId_card_back() {
        return this.id_card_back;
    }

    public void setId_card_back(String id_card_back) {
        this.id_card_back = id_card_back;
    }

    public String getIs_verified() {
        return this.is_verified;
    }

    public void setIs_verified(String is_verified) {
        this.is_verified = is_verified;
    }
}
