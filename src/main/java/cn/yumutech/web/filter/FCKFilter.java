package cn.yumutech.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.FilterDispatcher;

/**
 * @author zhaowei
 * 
 */
@SuppressWarnings("deprecation")
public class FCKFilter extends FilterDispatcher {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String URI = request.getRequestURI();
        //url中是否有参数匹配的内容，根据结果转发请求
        String[] uriArray = URI.split("/ckfinder/core/connector/java/*/");
        int arrayLen = uriArray.length;
        if (arrayLen >= 2) {
            //servlet，ckfinder的相关处理
        	chain.doFilter(req, res);
        } else {
        	//交给Struts2处理
            super.doFilter(req, res, chain);
        }
    }

}
