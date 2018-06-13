package com.perpule.constants;

public class DBConstant {
    public static boolean IS_DEV = true;
    public static String getDBURL(){
        if (IS_DEV){
            return "jdbc:mysql://localhost/videowalls";
        }else{
            return "";
        }
    }
    public static String getDBUsername(){
        if (IS_DEV){
            return "joeydash";
        }else{
            return "";
        }
    }
    public static String getDBPassword(){
        if (IS_DEV){
            return "joeydash";
        }else{
            return "";
        }
    }

}
