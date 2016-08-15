package cn.yumutech.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 翻页（带文件）基类
 * 
 * @author zhaowei
 * 
 */
@Controller
@Scope("prototype")
public class PageMultiAction extends BaseAction {

    private static final long serialVersionUID = -8627334637890884509L;

    private int memoryType;

    public int getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(int memoryType) {
        this.memoryType = memoryType;
    }

}
