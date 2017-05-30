package com.gui.handler;

import com.gui.exception.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by gui on 2017/5/29.
 */
public class ControllerExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String domainException(DomainException e) {
        StringBuilder builder = new StringBuilder(e.toString());
        StackTraceElement[] stacks = e.getStackTrace();
        if (stacks.length > 0) builder.append("\n\tat ").append(stacks[0]);

        if (e.getCause() != null) {
            StringWriter stringWriter = new StringWriter();
            e.getCause().printStackTrace(new PrintWriter(stringWriter));
            builder.append("\n\tCaused by: ").append(stringWriter);
        }

        //log.error(builder.toString());

        return "";
    }

}
