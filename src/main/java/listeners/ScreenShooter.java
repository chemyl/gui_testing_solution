package listeners;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShooter implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            getScreenShot();
        }
    }

    @Attachment(value = "screenShot saved", type = "image/png")
    private byte[] saveScreenShot(byte[] screenShot) {
        return screenShot;
    }

    private void getScreenShot() {
        File screenShot = Screenshots.takeScreenShotAsFile();
        try {
            assert screenShot != null;
            saveScreenShot(Files.toByteArray(screenShot));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
