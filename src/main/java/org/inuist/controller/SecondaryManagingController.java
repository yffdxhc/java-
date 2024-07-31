package org.inuist.controller;

import org.inuist.pojo.Post;
import org.inuist.view.MainView;
import org.inuist.view.SecondaryManagingView;
import org.inuist.view.SecondaryView;

/**
 * @author 18369
 * @date 2024/7/31 下午2:28
 */
public class SecondaryManagingController {
    public static int page=0;
    public static void writePostController(Post post){
        SecondaryController.postDAO.addPost(post);
        MainView.print("您已添加一份博客，正在返回您的主页面.............");
        SecondaryView.manageView();
    }

    public static void startManagePostView(){
        System.out.println(SecondaryController.postDAO.getPostsByUidWithLimit
                (SecondaryController.usr.getUid(), page*3, 3));
    }

    public static void managePostController(String usrInput){
        switch (usrInput){
            case "1":
                page++;
                SecondaryManagingView.managePostView();
                break;
                case "2":
                    if(page==0){
                        System.out.println("没有前一页，请不要再尝试了............");
                        SecondaryManagingView.managePostView();
                        break;
                    }
                    page--;
                    SecondaryManagingView.managePostView();
                    break;
                    case "3":
                        //TODO
                        System.out.println("删除博客功能尚在建设............");
                        break;
                        case "4":
                            //TODO
                            System.out.println("修改博客功能尚在建设............");
                            break;
                            case "5":
                                SecondaryView.manageView();
                                break;
                                case "6":
                                    MainView.print("正在退出系统，请稍后............");
                                    break;
            default:
                MainView.print("输入异常，请重新输入..........");
                SecondaryManagingView.managePostView();
        }
    }
}
