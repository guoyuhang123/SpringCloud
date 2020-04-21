package com.gyh.file;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class WebFile2 extends ZuulFilter {
    @Override
    public String filterType() {
        System.out.println("后置过滤器");
        return "pre";
    }

    @Override
    public int filterOrder() {
        System.out.println("优先级别");

        return 1;
    }

    @Override
    public boolean shouldFilter() {


        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("ruul过滤器执行的过程");
        System.out.println("ruul过滤器执行的过程3");
        return null;
    }
}
