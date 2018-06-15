package com.perpule.constants;

public class DBConstant {
    public static boolean IS_DEV = true;
    public static String getDBURL(){
        if (IS_DEV){
            return "jdbc:mysql://localhost/videoWalls";
        }else{
            return "";
        }
    }
    public static String getDBUsername(){
        if (IS_DEV){
            return "root";
        }else{
            return "";
        }
    }
    public static String getDBPassword(){
        if (IS_DEV){
            return null;
        }else{
            return "";
        }
    }

}
