package store.controller.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@WebListener
public class LoggerListener implements ServletRequestListener {

    private static final Logger LOG = LoggerFactory.getLogger(LoggerListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

        LOG.info("Пришел {} запрос с параметрами: {}", req.getMethod(), req.getParameterMap());
    }
}
