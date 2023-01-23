package configuration;

import static java.lang.System.getProperty;

public class MainTestConfig {
    static public final int RETRY_COUNT = Integer.parseInt(getProperty("retryCount"));
    static public final String BASE_URL = getProperty("baseUrl");
    static public final String BROWSER = getProperty("browser");
    static public final String BROWSER_SIZE_DESKTOP = getProperty("browserSizeDesktop");
    static public final String BROWSER_SIZE_MOBILE = getProperty("browserSizeMobile");
    static public final String MOBILE_DEVICE = getProperty("mobileDevice");
    static public final int ACTION_TIMEOUT = Integer.parseInt(getProperty("actionTimeout"));
    static public final int SEARCH_ELEMENT_TIMEOUT = Integer.parseInt(getProperty("searchElementTimeout"));
    static public final int PAGE_LOAD_TIMEOUT = Integer.parseInt(getProperty("pageLoadTimeout"));
    static public final Boolean SELENOID_ENABLE = Boolean.valueOf(getProperty("selenoidEnable"));
    static public final String SELENOID_URL = getProperty("selenoidUrl");
    static public final String SELENOID_BROWSER_VERSION = getProperty("selenoidBrowserVersion");
    static public final String SELENOID_SESSION_NAME = getProperty("selenoidSessionName");
}
