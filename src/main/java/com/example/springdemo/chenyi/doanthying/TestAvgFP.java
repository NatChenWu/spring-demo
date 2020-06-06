package com.example.springdemo.chenyi.doanthying;

import org.junit.Test;

import java.util.*;

/**
 * @author: chenyi
 * @date: 2019-11-25:09:02
 * @desciption:
 */
public class TestAvgFP {


    public static void main(String[] args) {


    }

    @Test
    public void testas(){
        List<String> objects = new ArrayList<>();
        objects.add("A");
        objects.add("B");
        objects.add("C");
        objects.add("D");
        objects.add("E");
       // objects.add("F");

        ArrayList<ClassDTO> classDTOS = new ArrayList<>(1000);

        for (int i = 0; i < 100000; i++) {
            classDTOS.add(new ClassDTO(i+1,""+(i+1)));
        }


        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String object : objects) {
            hashMap.put(object,0);
        }

        // do :
        for (ClassDTO classDTO : classDTOS) {
            Integer id = classDTO.getId();
            int abs = id%objects.size();

            String next = ((abs == objects.size()-1) ? objects.get(0) : objects.get(abs+1));

            System.out.println(objects.get(abs)  + next);
            hashMap.put(objects.get(abs),hashMap.get(objects.get(abs))+1);
            hashMap.put(next,hashMap.get(next)+1);


        }

        Set<String> strings = hashMap.keySet();
        for (String string : strings) {
            System.out.println(string+"=="+ hashMap.get(string));
        }


    }



    class ClassDTO {

        private Integer id ;
        private String  name;

        public ClassDTO(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
