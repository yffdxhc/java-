package org.inuist.view;

import org.inuist.controller.SecondaryBrowsingController;
import org.inuist.controller.SecondaryController;

import java.util.Scanner;

/**
 * @author 18369
 * @date 2024/7/31 上午9:17
 */
public class SecondaryBrowsingView {
    private static Scanner in = new Scanner(System.in);
    public static void allBlogs(){
        MainView.print("=========这里是所有博客=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        SecondaryBrowsingController.startAllBlogs();
        System.out.printf("=========当前为第%d页=========",SecondaryBrowsingController.page+1);
        System.out.println();
        MainView.print("=========下一页请输入‘1’=========");
        MainView.print("=========上一页请输入‘2’=========");
        MainView.print("=========返回上一级请输入‘3’=========");
        MainView.print("=========退出请输入‘4’=========");
        String usrInput = in.nextLine();
        SecondaryBrowsingController.allBlogs(usrInput);
    }

    public static void titleLikeGet(){
        MainView.print("=========这里根据题目检索博客=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        MainView.print("请输入你要搜索的标题：");
        String usrInput = in.nextLine();
        SecondaryBrowsingController.titlelike=usrInput;
        titleLikePost();
    }

    public static void titleLikePost(){
        MainView.print("=========这里是根据题目检索博客=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        System.out.printf("=========当前检索的题目：%s=========",SecondaryBrowsingController.titlelike);
        System.out.println();
        SecondaryBrowsingController.startTitleLikePots();
        System.out.printf("=========当前为第%d页=========",SecondaryBrowsingController.titlepage+1);
        System.out.println();
        MainView.print("=========下一页请输入‘1’=========");
        MainView.print("=========上一页请输入‘2’=========");
        MainView.print("=========返回上一级请输入‘3’=========");
        MainView.print("=========退出请输入‘4’=========");
        String usrInput = in.nextLine();
        SecondaryBrowsingController.titleLikePots(usrInput);
    }

    public static void summaryLikeGet(){
        MainView.print("=========这里根据摘要检索博客=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        MainView.print("请输入你要搜索的摘要关键字：");
        String usrInput = in.nextLine();
        SecondaryBrowsingController.summarylike=usrInput;
        summaryLikePost();
    }

    public static void summaryLikePost(){
        MainView.print("=========这里是根据摘要检索博客=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        System.out.printf("=========当前检索的摘要关键字：%s=========",SecondaryBrowsingController.summarylike);
        System.out.println();
        SecondaryBrowsingController.startSummaryLikePosts();
        System.out.printf("=========当前为第%d页=========",SecondaryBrowsingController.summarypage+1);
        System.out.println();
        MainView.print("=========下一页请输入‘1’=========");
        MainView.print("=========上一页请输入‘2’=========");
        MainView.print("=========返回上一级请输入‘3’=========");
        MainView.print("=========退出请输入‘4’=========");
        String usrInput = in.nextLine();
        SecondaryBrowsingController.summaryLikePosts(usrInput);
    }
}
