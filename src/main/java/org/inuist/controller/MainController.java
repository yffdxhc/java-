package org.inuist.controller;

import com.sun.xml.internal.bind.v2.TODO;
import org.inuist.dao.UsrDAO;
import org.inuist.dao.impl.UsrDAOImpl;
import org.inuist.pojo.Usr;
import org.inuist.view.MainView;

import java.util.Scanner;

/**
 * @author 18369
 * @date 2024/7/30 上午8:53
 */
public class MainController {
    private static UsrDAO usrDAO=new UsrDAOImpl();
    public static void mainController(String userOptionInput) {
        switch (userOptionInput) {
            case "1":
                MainView.loginView();
                break;
                case "2":
                    MainView.registerView();
                    break;
                    case "3":
                        //TODO
                        MainView.print("功能尚在建设...........");
                        break;
                        case "4":
                            MainView.print("正在退出，请稍后.........");
                            return;
            default:
                MainView.print("输入异常，请重新输入");
        }
    }
    public static void loginController(Usr inputUsr) {
        boolean isLogin = usrDAO.login(inputUsr.getUname(),inputUsr.getUpassword());
        if (isLogin) {
            //TODO
            MainView.print("功能尚在建设..........");
        }else {
            MainView.print("登录信息有误，请重新登录.......");
            MainView.loginView();
        }
    }
    public static void registerController(Usr inputUsr) {
        boolean isRegister = usrDAO.register(inputUsr);
        if (isRegister) {
            usrDAO.insert(inputUsr);
            MainView.print("注册成功！");
            MainView.print("正在返回主页面......");
            MainView.mainView();
        }else {
            MainView.print("用户名已被占用，请重新注册");
            MainView.registerView();
        }
    }
}
