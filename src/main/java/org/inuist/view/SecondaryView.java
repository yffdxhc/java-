package org.inuist.view;

import org.inuist.controller.SecondaryController;

import java.util.Scanner;

/**
 * @author 18369
 * @date 2024/7/30 下午6:09
 */
public class SecondaryView {
    public static Scanner scanner = new Scanner(System.in);
    public static void secondaryView() {
        MainView.print("=========欢迎进入博客系统=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        MainView.print("1.浏览博客请输入‘1’");
        MainView.print("2.管理自己的博客请输入‘2’，此功能游客不可用");
        MainView.print("3.退出请输入‘3’");
        MainView.print("-------------------");
        String scan = scanner.nextLine();
        SecondaryController.secondaryController(scan);
    }

    public static void browseView(){
        MainView.print("=========欢迎浏览博客=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        MainView.print("1.查看本系统拥有的所有博客请输入‘1’");
        MainView.print("2.根据博客题目检索请输入‘2’");
        MainView.print("3.根据博客摘要检索请输入‘3’");
        MainView.print("4.返回上一级请输入‘4’");
        MainView.print("5.退出请输入‘5’");
        MainView.print("------------------");
        String scan = scanner.nextLine();
        SecondaryController.browseController(scan);
    }

    public static void manageView(){
        MainView.print("========这里是你的博客=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        MainView.print("1.写博客请输入‘1’");
        MainView.print("2.删博客请输入‘2’");
        MainView.print("3.修改博客请输入‘3’");
        MainView.print("4.查看博客请输入‘4’");
        MainView.print("5.返回上一级请输入‘5’");
        MainView.print("6.退出请输入‘6’");
        MainView.print("-------------------");
        String scan = scanner.nextLine();
        SecondaryController.manageController(scan);
    }
}
