package org.inuist.view;

import org.inuist.controller.SecondaryBrowsingController;
import org.inuist.controller.SecondaryController;
import org.inuist.controller.SecondaryManagingController;
import org.inuist.pojo.Post;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author 18369
 * @date 2024/7/31 下午2:29
 */
public class SecondaryManagingView {
    private static Scanner scanner = new Scanner(System.in);
    public static void writePostView(){
        MainView.print("=========现在处于写博客界面=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        MainView.print("请输入博客的题目：");
        String title = scanner.nextLine();
        MainView.print("请输入博客的摘要：");
        String summary = scanner.nextLine();
        MainView.print("请输入博客的内容：");
        String content = scanner.nextLine();
        Post post = new Post(0,title, summary, content,
                SecondaryController.usr.getUid(),
                new Date(Calendar.getInstance().getTime().getTime()),true);
        SecondaryManagingController.writePostController(post);
    }


    public static void managePostView(){
        MainView.print("=========现在处于管理博客界面=========");
        System.out.printf("=========当前用户id：%d=========", SecondaryController.usr.getUid());
        System.out.println();
        System.out.printf("=========当前用户名：%s=========",SecondaryController.usr.getUname());
        System.out.println();
        SecondaryManagingController.startManagePostView();
        System.out.printf("=========当前为第%d页=========", SecondaryManagingController.page+1);
        System.out.println();
        MainView.print("=========下一页请输入‘1’=========");
        MainView.print("=========上一页请输入‘2’=========");
        MainView.print("=========删除博客请输入‘3’=========");
        MainView.print("=========修改博客请输入‘4’=========");
        MainView.print("=========返回上一级请输入‘5’=========");
        MainView.print("=========退出请输入‘6’=========");
        String usrInput = scanner.nextLine();
        SecondaryManagingController.managePostController(usrInput);
    }
}
