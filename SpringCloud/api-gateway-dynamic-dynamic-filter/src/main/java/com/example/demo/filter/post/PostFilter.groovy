package com.example.demo.filter.post

import com.example.demo.filter.pre.PreFilter
import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.slf4j.LoggerFactory

import javax.servlet.http.HttpServletRequest
import java.util.logging.*

class PostFilter extends ZuulFilter{
    static class A extends Logger{

        /**
         * Protected method to construct a logger for a named subsystem.
         * <p>
         * The logger will be initially configured with a null Level
         * and with useParentHandlers set to true.
         *
         * @param name A name for the logger.  This should
         *                          be a dot-separated name and should normally
         *                          be based on the package name or class name
         *                          of the subsystem, such as java.net
         *                          or javax.swing.  It may be null for anonymous Loggers.
         * @param resourceBundleName name of ResourceBundle to be used for localizing
         *                          messages for this logger.  May be null if none
         *                          of the messages require localization.
         * @throws MissingResourceException if the resourceBundleName is non-null and
         *             no corresponding resource can be found.
         */
        protected A(String name, String resourceBundleName) {
            super(name, resourceBundleName)
        }
    }
    static class B extends RequestContext{

    }
    @Override
    String filterType() {
        return "post";
    }

    @Override
    int filterOrder() {
        return 1000
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() throws ZuulException {


        System.out.println("=========  这一个是动态加载的过滤器：DynamicFilter");
        println "this is a pre filter:send ()---aaaaaa--------------"
       // A a =A.getLogger(PostFilter.class);//.info("this is a pre filter:send ()-----------------",B.getCurrentContext().getMethod())
        return null
    }
}
