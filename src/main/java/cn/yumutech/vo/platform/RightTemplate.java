/**
 * 
 */
package cn.yumutech.vo.platform;

import java.io.Serializable;

/**
 * @author zhaowei
 *
 */
public class RightTemplate implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7400050827542366811L;

    private String code;
    
    private String name;
    
    private String hasright;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RightTemplate [code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", hasright=");
        builder.append(hasright);
        builder.append("]");
        return builder.toString();
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
    
    

}
