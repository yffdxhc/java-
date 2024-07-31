package org.inuist.controller;

import org.inuist.view.MainView;
import org.inuist.view.SecondaryBrowsingView;
import org.inuist.view.SecondaryView;

/**
 * @author 18369
 * @date 2024/7/30 下午8:01
 */
public class SecondaryBrowsingController {
    public static String titlelike="";
    public static String summarylike="";
    public static int page=0;
    public static int titlepage=0;
    public static int summarypage=0;
    public static void startAllBlogs(){
        System.out.println(SecondaryController.postDAO.getPostsWithLimit(page* 3L,3));
    }
    public static void allBlogs(String usrInput){
        switch (usrInput){
            case "1":
                page++;
                SecondaryBrowsingView.allBlogs();
                break;
                case "2":
                    if(page==0){
                        System.out.println("没有上一页，请不要再尝试了...........");
                        SecondaryBrowsingView.allBlogs();
                        break;
                    }
                    page--;
                    SecondaryBrowsingView.allBlogs();
                    break;
                    case "3":
                        SecondaryView.browseView();
                        break;
                        case "4":
                            MainView.print("正在退出系统，请稍后............");
                            return;
            default:
                MainView.print("输入异常，请重新输入............");
                SecondaryBrowsingView.allBlogs();
        }
    }

    public static void startTitleLikePots(){
        System.out.println(SecondaryController.postDAO.getPostsByTitleLikeWithLimit(titlelike,titlepage* 3,3));
    }

    public static void titleLikePots(String usrInput){
        switch (usrInput){
            case "1":
                titlepage++;
                SecondaryBrowsingView.titleLikePost();
                break;
            case "2":
                if(titlepage==0){
                    System.out.println("没有上一页，请不要再尝试了...........");
                    SecondaryBrowsingView.titleLikePost();
                    break;
                }
                titlepage--;
                SecondaryBrowsingView.titleLikePost();
                break;
            case "3":
                SecondaryView.browseView();
                break;
            case "4":
                MainView.print("正在退出系统，请稍后............");
                return;
            default:
                MainView.print("输入异常，请重新输入............");
                SecondaryBrowsingView.titleLikePost();
        }
    }

    public static void startSummaryLikePosts(){
        System.out.println(SecondaryController.postDAO.getPostsBySummaryLikeWithLimit(summarylike,summarypage* 3,3));
    }

    public static void summaryLikePosts(String usrInput){
        switch (usrInput){
            case "1":
                summarypage++;
                SecondaryBrowsingView.summaryLikePost();
                break;
            case "2":
                if(summarypage==0){
                    System.out.println("没有上一页，请不要再尝试了...........");
                    SecondaryBrowsingView.summaryLikePost();
                    break;
                }
                summarypage--;
                SecondaryBrowsingView.summaryLikePost();
                break;
            case "3":
                SecondaryView.browseView();
                break;
            case "4":
                MainView.print("正在退出系统，请稍后............");
                return;
            default:
                MainView.print("输入异常，请重新输入............");
                SecondaryBrowsingView.summaryLikePost();
        }
    }
}
