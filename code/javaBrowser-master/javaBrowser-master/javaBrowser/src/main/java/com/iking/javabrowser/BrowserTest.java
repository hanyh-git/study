package com.iking.javabrowser;



import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;

public class Browser {
    public static void main(String[] args) {
        String url = "";
        JFrame frame = new JFrame();
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView();

        frame.setUndecorated(true);
        frame.setLocation(0, 0);
        frame.add(browserView);
        //全屏显示
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // 是否显示
        frame.setVisible(true);
        //是否在屏幕最上层显示
        frame.setAlwaysOnTop(true);
        //加载地址
        browser.(url);

//        System.out.println(frame.getX());
//        System.out.println(frame.getY());
//        list.add(frame);
        frame.addWindowListener(new WindowAdapter() {
            // 窗口关闭时间监听
            @Override
            public void windowClosing(WindowEvent e){
                System.out.println("窗口关闭...");
            }
        });
    }

    }
}
