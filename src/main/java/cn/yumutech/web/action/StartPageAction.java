package cn.yumutech.web.action;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 起始页面Action
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class StartPageAction extends BaseAction {

    private static final long serialVersionUID = 5474278715367950584L;

    private static final Logger logger = Logger.getLogger(StartPageAction.class);

    public String index() throws Exception {

        try {

        } catch (Exception ex) {
            logger.error("Exception Stack Info: ", ex);
            throw ex;
        }

        return SUCCESS;
    }

}
