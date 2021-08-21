package com.vinayylogics.oops.tightvsloosecoupling.testbasics;

import java.util.ArrayList;
import java.util.List;

public class ForeachTest {

    public static void main(String[] args) {
      List<String> dataList = new ArrayList<>();
      dataList.add("a");
      dataList.add("b");
      dataList.add("c");
      dataList.add("d");
      dataList.add("e");
      /*for (String data: dataList){
          System.out.println(data);
          dataList.remove("c");
      }*/
//     dataList = dataList.stream().dropWhile(s -> s.equals("c")).collect(Collectors.toList());
     dataList.removeIf(s -> s.equals("e"));
     System.out.println(dataList);
    }
}
