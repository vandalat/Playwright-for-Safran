package com.safran.steps;

import com.microsoft.playwright.Page;
import com.safran.utilities.BrowserUtils;
import com.safran.utilities.Driver;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;

public class Hooks {





    @After
    public void tearDown()  {
        BrowserUtils.sleep(3);
        Driver.getInstance().close();
    }
}
