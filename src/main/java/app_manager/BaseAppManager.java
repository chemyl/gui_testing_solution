package app_manager;

import steps.page_object.host.Footer;
import steps.page_object.host.Header;

public class BaseAppManager extends BaseManager {

    public final Header header = new Header();
    public final Footer footer = new Footer();
}
