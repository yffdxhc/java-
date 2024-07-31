package org.inuist.controller;

import org.inuist.dao.PostDAO;
import org.inuist.dao.impl.PostDAOImpl;
import org.inuist.pojo.Usr;
import org.inuist.view.MainView;
import org.inuist.view.SecondaryBrowsingView;
import org.inuist.view.SecondaryManagingView;
import org.inuist.view.SecondaryView;

/**
 * @author 18369
 * @date 2024/7/30 下午6:24
 */
public class SecondaryController {
    public static Usr usr = new Usr();
    static PostDAO postDAO=new PostDAOImpl();
    public static void secondaryController(String userOptionInput) {
        switch (userOptionInput) {
            case "1":
                MainView.print("正在进入浏览界面，请稍后..........");
                SecondaryView.browseView();
                break;
                case "2":
                    if(usr.getUid()==null){
                        MainView.print("游客没有可管理的博客，请登录后重试............");
                        MainView.print("返回游客模式............");
                        SecondaryView.secondaryView();
                        break;
                    }
                    MainView.print("正在进入管理博客界面，请稍后............");
                    SecondaryView.manageView();
                    break;
                    case "3":
                        MainView.print("正在退出系统............");
                        break;
            default:
                MainView.print("输入异常，请重新输入");
                SecondaryView.secondaryView();
        }
    }

    public static void browseController(String userOptionInput) {
        switch (userOptionInput) {
            case "1":
                SecondaryBrowsingView.allBlogs();
                break;
                case "2":
                    SecondaryBrowsingView.titleLikeGet();
                    break;
                    case "3":
                        SecondaryBrowsingView.summaryLikeGet();
                        break;
                        case "4":
                            MainView.print("正在返回上一级............");
                            break;
                            case "5":
                                MainView.print("正在退出博客系统，请稍后............");
                                break;
            default:
                MainView.print("输入异常，请重新输入");
                SecondaryView.secondaryView();
        }
    }

    public static void manageController(String userOptionInput){
        switch (userOptionInput) {
            case "1":
                SecondaryManagingView.writePostView();
                break;
                case "2":
                    SecondaryManagingView.managePostView();
                            case "3":
                                MainView.print("正在返回上一级，请稍后............");
                                SecondaryView.secondaryView();
                                break;
                                case "4":
                                    MainView.print("正在退出系统，请稍后............");
                                    break;
            default:
                MainView.print("输入异常，请重新输入");
                SecondaryView.manageView();
        }
    }

}
