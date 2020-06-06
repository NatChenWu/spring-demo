//package com.example.springdemo.chenyi.doanthying;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.junit.Test;
//
//import java.util.HashMap;
//
///**
// * @author: chenyi
// * @date: 2019-11-27:18:54
// * @desciption:
// */
//public class TestJson {
//
//    @Test
//    public void  test(){
//        HashMap<String, Object> hashMap = new HashMap<>();
//        HashMap<String, String>  neikuKey = new HashMap<>();
//
//        neikuKey.put("abc","abc");
//        neikuKey.put("bca","abc");
//
//        hashMap.put("waibi",JSON.toJSONString(neikuKey));
//
//        String s = JSONObject.toJSONString(hashMap);
//        JSONObject jsonObject = JSON.parseObject(s);
//        jsonObject.("waibi","abcedfa");
//        System.out.println(jsonObject.toString());
//
//    }
//
//
//
//}
