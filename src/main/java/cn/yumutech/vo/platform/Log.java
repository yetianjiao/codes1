/**
 * 
 */
package cn.yumutech.vo.platform;

import java.util.Date;

import cn.yumutech.vo.SearchBaseObject;

/**
 * 日志模型
 * 
 * @author zhaowei
 * 
 */
public class Log extends SearchBaseObject {

    private static final long serialVersionUID = 3928006964666130729L;

    /**
     * 编号
     */
    private Long id;

    /**
     * controller
     */
    private String controller;

    /**
     * action
     */
    private String action;

    /**
     * 事件描述
     */
    private String event;

    /**
     * 操作人id
     */
    private Integer op_user_id;

    /**
     * 操作人名
     */
    private String op_user_name;

    /**
     * 操作时间
     */
    private Date op_time;

    /**
     * 访问ip
     */
    private String ip;

    /**
     * 产品代号
     */
    private String product_code;

    /**
     * 产品名称
     */
    private String product_name;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the controller
     */
    public String getController() {
        return controller;
    }

    /**
     * @param controller
     *            the controller to set
     */
    public void setController(String controller) {
        this.controller = controller;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action
     *            the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event
     *            the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * @return the op_user_id
     */
    public Integer getOp_user_id() {
        return op_user_id;
    }

    /**
     * @param op_user_id
     *            the op_user_id to set
     */
    public void setOp_user_id(Integer op_user_id) {
        this.op_user_id = op_user_id;
    }

    /**
     * @return the op_user_name
     */
    public String getOp_user_name() {
        return op_user_name;
    }

    /**
     * @param op_user_name
     *            the op_user_name to set
     */
    public void setOp_user_name(String op_user_name) {
        this.op_user_name = op_user_name;
    }

    /**
     * @return the op_time
     */
    public Date getOp_time() {
        return op_time;
    }

    /**
     * @param op_time
     *            the op_time to set
     */
    public void setOp_time(Date op_time) {
        this.op_time = op_time;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     *            the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the product_code
     */
    public String getProduct_code() {
        return product_code;
    }

    /**
     * @param product_code
     *            the product_code to set
     */
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name
     *            the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Log [id=");
        builder.append(id);
        builder.append(", controller=");
        builder.append(controller);
        builder.append(", action=");
        builder.append(action);
        builder.append(", event=");
        builder.append(event);
        builder.append(", op_user_id=");
        builder.append(op_user_id);
        builder.append(", op_user_name=");
        builder.append(op_user_name);
        builder.append(", op_time=");
        builder.append(op_time);
        builder.append(", ip=");
        builder.append(ip);
        builder.append(", product_code=");
        builder.append(product_code);
        builder.append(", product_name=");
        builder.append(product_name);
        builder.append("]");
        return builder.toString();
    }

}
