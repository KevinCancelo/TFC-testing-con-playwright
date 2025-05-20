package com.tfc.tshelpers.pagecomponents;

import com.microsoft.playwright.Page;
import com.tfc.tshelpers.base.PCHeaderBase;

public class PCHeaderFactory {
    
    public static PCHeaderBase createPCHeader(Page page, String language, String country){
              PCHeaderBase pcHeader;

              boolean isMobile = Boolean.parseBoolean(System.getProperty("isMobile").toLowerCase());
              pcHeader = isMobile ? new PCHeaderMobile(page,language,country) : new PCHeaderDesktop(page,language,country);
              return pcHeader;
        }
}
