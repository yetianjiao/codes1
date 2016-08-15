/**
 * 
 */
package cn.yumutech.vo.platform;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhaowei
 *
 */
public class RoleRight implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 8541903945780620638L;

    private Integer role_id;
    
    private String righttemplate_code;
    
    private String hasright;
    
    private List<String> codes;
    

    /**
     * @return the role_id
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * @param role_id the role_id to set
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * @return the righttemplate_code
     */
    public String getRighttemplate_code() {
        return righttemplate_code;
    }

    /**
     * @param righttemplate_code the righttemplate_code to set
     */
    public void setRighttemplate_code(String righttemplate_code) {
        this.righttemplate_code = righttemplate_code;
    }

    /**
     * @return the hasright
     */
    public String getHasright() {
        return hasright;
    }

    /**
     * @param hasright the hasright to set
     */
    public void setHasright(String hasright) {
        this.hasright = hasright;
    }

 

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RoleRight [role_id=");
        builder.append(role_id);
        builder.append(", righttemplate_code=");
        builder.append(righttemplate_code);
        builder.append(", hasright=");
        builder.append(hasright);
        builder.append(", codes=");
        builder.append(codes);
        builder.append("]");
        return builder.toString();
    }

    /**
     * @return the codes
     */
    public List<String> getCodes() {
        return codes;
    }

    /**
     * @param codes the codes to set
     */
    public void setCodes(List<String> codes) {
        this.codes = codes;
    }
    
    
    
    
    
    

}
