package org.inuist.view;

import org.inuist.controller.MainController;
import org.inuist.pojo.Usr;

import java.util.Scanner;

/**
 * @author 18369
 * @date 2024/7/30 上午8:55
 */
public class MainView {
    public static Scanner scanner = new Scanner(System.in);
    public static void print(String message){
        for(int i = 0; i < message.length(); i++){
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
    public static void mainView(){
        print("=========欢迎来到博客系统=========");
        print("1.登录请输入‘1’");
        print("2.注册请输入‘2’");
        print("3.游客请输入‘3’");
        print("4.退出请输入‘4’");
        print("-------------------");
        String scan = scanner.nextLine();
        MainController.mainController(scan);
    }
    public static void loginView(){
        print("=========现在位于登录界面=========");
        print("请输入用户名:");
        String name = scanner.nextLine();
        print("请输入密码:");
        String password = scanner.nextLine();
        Usr usr = new Usr(0,name,password,true);
        MainController.loginController(usr);
    }
    public static void registerView(){
        print("=========现在位于注册界面=========");
        print("请输入用户名:");
        String name = scanner.nextLine();
        print("请输入密码:");
        String password = scanner.nextLine();
        Usr usr = new Usr(0,name,password,true);
        MainController.registerController(usr);
    }
}
