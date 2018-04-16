package com.tw;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }
    static Map<String,String> arr =new HashMap();

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc =new Scanner(System.in);
        Integer i= systemoutContext(sc);
        while(i!=3){
            DiffCase(i,sc);
            i=systemoutContext(sc);
        }
    }

    /**
     * 显示主页面
     * @param sc
     * @return
     */
    public static int systemoutContext(Scanner sc){
        System.out.println("1. 添加学生");
        System.out.println("2. 生成成绩单");
        System.out.println("3. 退出");
        System.out.println("请输入你的选择（1～3）：");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * 校验学生信息格式
     * @param input
     * @return
     */
    public static boolean check_StuInfo_Format(String input){
        String regExChina = "[\u4e00-\u9fa5]";
        String regExFloat="^[0-9]\\d*$";
        Boolean state=false;
        String[] in=input.split(",");
        if (in.length== 1||in.length==2) {
            return false;
        }
        state=Pattern.compile(regExChina).matcher(in[0]).find();
        state=state& Pattern.compile(regExFloat).matcher(in[1]).find();
        for (int i = 2; i <in.length ; i++) {
            String[] courses= in[i].split(":");
            if (courses.length==1){
                return false;
            }
            state=state&Pattern.compile(regExChina).matcher(courses[0]).find();
            state=state&Pattern.compile(regExFloat).matcher(courses[1]).find();
        }
        return state;
    }

    /**
     * 校验学号格式
     * @param input
     * @return
     */
    public static boolean check_StuID_Format(String input){
        String regExFloat="^[0-9]\\d*$";
        Boolean state=false;
        String[] in=input.split(",");
        state=Pattern.compile(regExFloat).matcher(in[0]).find();
        for (int i = 1; i <in.length ; i++) {
            state=state&Pattern.compile(regExFloat).matcher(in[i]).find();
        }
        return state;
    }

    /**
     * 保存学生信息
     * @param input
     */
    public static void saveInfo(String input){
        String[] in =input.split(",");
        int count=0;
        float avg=0;
        String stu=in[0];
        int i = 2;
        for (; i <in.length ; i++) {
            String[] courses= in[i].split(":");
            stu=stu+"|"+courses[1];
            count+=Integer.parseInt(courses[1]);
        }
        avg=count/i;
        stu=stu+"|"+avg+"|"+count+"|";
        arr.put(in[1],stu);
    }

    /**
     * 功能选择
     * @param i
     * @param sc
     */
    public static void DiffCase(int i,Scanner sc) {
     switch (i) {
         case 1: {
             System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
             String string = sc.nextLine();
             while (!check_StuInfo_Format(string)) {
                 System.out.println("请输入正确的学生信息（格式：姓名, 学号, 学科: 成绩, ...）：");
                 string = sc.nextLine();
             }
             saveInfo(string);
             System.out.println("学生" + string.split(",")[0] + "的成绩被添加");
             break;
         }
         case 2: {
             System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
             String string = sc.nextLine();
             while (!check_StuID_Format(string)) {
                 System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                 string = sc.nextLine();
             }
             System.out.println();
             System.out.println("成绩");
             System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
             System.out.println("========================");
             for (int j = 0; j < string.split(",").length; j++) {
                 if(arr.containsKey(string.split(",")[j])) {
                     System.out.println(arr.get(string.split(",")[j]));
                 }
             }
             System.out.println("========================");
             System.out.println();
            break;
         }
         case 3:break;
     }
 }
}
