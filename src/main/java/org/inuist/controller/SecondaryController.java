package org.inuist.controller;

import org.inuist.pojo.Usr;
import org.inuist.view.MainView;
import org.inuist.view.SecondaryView;

/**
 * @author 18369
 * @date 2024/7/30 下午6:24
 */
public class SecondaryController {
    public static Usr usr = new Usr();
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
                //TODO
                MainView.print("查看本系统拥有的所有博客功能尚在建设............");

                break;
                case "2":
                    //TODO
                    MainView.print("根据博客题目检索功能尚在建设...............");
                    break;
                    case "3":
                        //TODO
                        MainView.print("根据博客摘要检索功能尚在建设............");
                        break;
                        case "4":
                            MainView.print("正在返回上一级............");
                            SecondaryView.secondaryView();
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
                //TODO
                MainView.print("写博客功能尚在建设............");
                break;
                case "2":
                    //TODO
                    MainView.print("删除博客功能尚在建设............");
                    break;
                    case "3":
                        //TODO
                        MainView.print("修改博客功能尚在建设...........");
                        break;
                        case "4":
                            //TODO
                            MainView.print("产看博客功能尚在建设............");
                            break;
                            case "5":
                                MainView.print("正在返回上一级，请稍后............");
                                SecondaryView.secondaryView();
                                break;
                                case "6":
                                    MainView.print("正在退出系统，请稍后............");
                                    break;
            default:
                MainView.print("输入异常，请重新输入");
                SecondaryView.manageView();
        }
    }

}
