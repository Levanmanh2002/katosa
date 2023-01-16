package com.user.manhitdz.katosa.utils;

import com.user.manhitdz.katosa.model.GioHang;
import com.user.manhitdz.katosa.model.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String BASE_URL="http://alaris.vn/shop/";

    public static List<GioHang> manggiohang;

    public static List<GioHang> mangmuahang = new ArrayList<>();

    public static User user_current = new User();

    public static String ID_RECEIVED;

    public static final String SENDID = "idsend";
    public static final String RECEIVEDID = "idreceived";
    public static final String MESS = "message";
    public static final String DATETIME = "datetime";
    public static final String PATH_CHAT = "chat";
}
