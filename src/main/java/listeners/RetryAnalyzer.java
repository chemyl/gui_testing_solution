package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static configuration.MainTestConfig.RETRY_COUNT;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < RETRY_COUNT) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
