package com.targetindia;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppMain {

    //static final Logger log = LoggerFactory.getLogger(AppMain.class);

    public static void logExample(String[] args) {
        // Log levels ==> TRACE, DEBUG, INFO, WARN, ERROR

        log.error("this is an error log");
        log.warn("this is an warning log");
        log.debug("this is an debug log");
        log.trace("this is an trace log");
        log.info("this is an information log");
    }
}
