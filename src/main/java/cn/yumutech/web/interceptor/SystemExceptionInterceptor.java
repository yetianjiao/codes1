package cn.yumutech.web.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * This class will write the log to the file and console when error occurs.
 * 
 * @author zhaowei
 */
public final class SystemExceptionInterceptor extends AbstractInterceptor {

    /** */
    private static final long serialVersionUID = 1174066315561192878L;

    /** */
    private Logger logger = Logger.getLogger(SystemExceptionInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            invocation.invoke();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

        return null;
    }
}
