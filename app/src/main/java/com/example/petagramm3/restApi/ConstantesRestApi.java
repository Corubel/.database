package com.example.petagramm3.restApi;

public final class ConstantesRestApi {
   //https://graph.facebook.com/v10.0/17841446357372630/media?fields=id,media_type,username,media_url,like_count,owner,timestamp&access_token=EAALXSwjSbgsBAIfMyCYk1E5wJhQsYvd7mjC5M2tQk709jdeDYDw86JBZAZCwvoPhucMo3ZCDYl8VXDTcXunw2LSYSzbZAFvpr7yJ4KWKxMscqsUo4ZBrrdiXyiJJCNjR07auh4a9DQPiZCFfcSBCjE4l4BC0xfeIuylZAFEdxCz4kVVZBHXX5ZALc
    public static final String VERSION = "/v10.0/";
    public static final String ROOT_URL = " https:/" + "/graph.facebook.com" + VERSION;
    public static final String ACCESS_TOKEN = "EAALXSwjSbgsBAIfMyCYk1E5wJhQsYvd7mjC5M2tQk709jdeDYDw86JBZAZCwvoPhucMo3ZCDYl8VXDTcXunw2LSYSzbZAFvpr7yJ4KWKxMscqsUo4ZBrrdiXyiJJCNjR07auh4a9DQPiZCFfcSBCjE4l4BC0xfeIuylZAFEdxCz4kVVZBHXX5ZALc";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String KEY_GET_INFORMATION_USER = "17841446357372630/media?fields=id,media_type,username,media_url,like_count,owner,timestamp";
    public static final String URL_GET_RESENT_MEDIA_USER = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}
