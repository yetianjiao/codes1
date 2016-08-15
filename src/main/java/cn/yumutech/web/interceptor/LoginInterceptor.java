package cn.yumutech.web.interceptor;

import java.util.Map;

import cn.yumutech.util.Constants;
import cn.yumutech.vo.platform.User;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.MDC;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Login拦截器
 * 
 * @author zhaowei
 * 
 */
public class LoginInterceptor extends AbstractInterceptor {
    /**
     * 
     */
    private static final long serialVersionUID = -3568072095394324635L;

    public static final String GOING_TO_URL_KEY = "GOING_TO";

    @SuppressWarnings("rawtypes")
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionContext actionContext = invocation.getInvocationContext();

        Map session = actionContext.getSession();
        if (session != null && session.get(Constants.SESSION_USER) != null) {
            User user = (User) session.get(Constants.SESSION_USER);
            MDC.put("UserId", user.getUsername());
            return invocation.invoke();
        }

        if (session != null)
            setGoingToURL(session, invocation);
        return "login";
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void setGoingToURL(Map session, ActionInvocation invocation) {
        String url = "";
        String namespace = invocation.getProxy().getNamespace();
        if (StringUtils.isNotBlank(namespace) && !namespace.equals("/")) {
            url = url + namespace;
        }
        String actionName = invocation.getProxy().getActionName();
        if (StringUtils.isNotBlank(actionName)) {
            url = url + "/" + actionName + ".action";
        }
        session.put(GOING_TO_URL_KEY, url);
    }

}