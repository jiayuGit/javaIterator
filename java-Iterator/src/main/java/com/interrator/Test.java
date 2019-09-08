package com.interrator;

import org.apache.commons.codec.digest.DigestUtils;

import java.lang.reflect.Field;
import java.sql.*;

public class Test {
    static byte[] c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".getBytes();
    public static void main(String[]   agr) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, SQLException {
        String s="aa";
        String s3 = "a"+"a";
        String s1 = new String("a")+"a";
        String s2 = new String("aa");
        System.out.println(s==s1);
        System.out.println(s==s3);
        System.out.println(s==s2);
        Class class1=s2.getClass();
        Field f=class1.getDeclaredField("value");
        f.setAccessible(true);
        System.out.println(s.hashCode()+" "+ f.get(s1).hashCode());
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://39.107.239.27:3306/mars_bank?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull",
                "mars_bank","oSFgdAALM68i1iE5");
        System.out.println(conn);
        Statement st = conn.createStatement();
        ResultSet rs=st.executeQuery("select * from sys_user");
        String a=null;
        while(rs.next()){
            a=rs.getString("password");
            System.out.println("id="+rs.getInt("id")+" user_name="+rs.getString("user_name")+
                    " password="+rs.getString("password") +" 密码长度"+rs.getString("password").length());
        }


        conn.close();

    }
}
