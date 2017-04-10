package com.aptoto.framework;

/**
 * 当前操作者信息
 * @author Orion
 * @since 0.2-RELEASE
 * 2017年4月10日
 */
public class OPOwner {
    /**
     * 当前用户未知标识
     */
    public static final String UNKNOW_USER_FLAG = "UNKNOW_USER";
    /**
     * 来源系统未知标识
     */
    public static final String UNKNOW_APP_FLAG = "UNKNOW_APP";
    
    private static final ThreadLocal<String> currentUser = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return OPOwner.UNKNOW_USER_FLAG;
        }
    };
    private static final ThreadLocal<String> currentApp = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return OPOwner.UNKNOW_APP_FLAG;
        }
    };
    
    /**
     * 将所有变量恢复到原始状态
     * ★重要：线程启动前必须调用该方法，否则在线程池环境下会有脏数据
     */
    public static void reset() {
        currentUser.set(UNKNOW_USER_FLAG);
        currentApp.set(UNKNOW_APP_FLAG);
    }
    
    /*********************************************************
     *                                                       *
     *                  setter() & getter()                  *
     *                                                       *
     *********************************************************/
    
    /**
     * @param currentUser 当前用户标识
     */
    public static void setCurrentUser(String currentUser) {
        if (currentUser == null || currentUser.trim().equals(""))
            OPOwner.currentUser.set(UNKNOW_USER_FLAG);
        else
            OPOwner.currentUser.set(currentUser.trim());
    }
    
    public static void setCurrentApp(String currentApp) {
        if (currentApp == null || currentApp.trim().equals(""))
            OPOwner.currentApp.set(UNKNOW_APP_FLAG);
        else
            OPOwner.currentApp.set(currentApp);
    }
    
    /**
     * @return the currentuser 当前用户
     */
    public static String getCurrentUser() {
        return currentUser.get();
    }
    /**
     * @return the currentapp 来源系统
     */
    public static String getCurrentApp() {
        return currentApp.get();
    }
}
