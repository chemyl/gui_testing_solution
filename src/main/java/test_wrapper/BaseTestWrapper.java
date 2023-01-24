package test_wrapper;

import app_manager.BaseApiManager;
import app_manager.BaseAppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static constants.GlobalConstant.DESKTOP;
import static constants.GlobalConstant.MOBILE;

public class BaseTestWrapper {

    protected static final BaseAppManager app = new BaseAppManager();
    protected static final BaseApiManager api = new BaseApiManager();

    @BeforeMethod(groups = {DESKTOP})
    public void setUpDesktop() {
        app.initDesktopTypeDriver();
    }

    @BeforeMethod(groups = {MOBILE})
    public void setUpMobile() {
        app.initMobileTypeDriver();
    }

    @AfterMethod(groups = {DESKTOP, MOBILE})
    public void tearDown() {
        app.stopDriver();
    }
}