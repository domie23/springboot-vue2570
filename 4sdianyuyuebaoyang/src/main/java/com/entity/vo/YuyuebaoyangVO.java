package com.entity.vo;

import com.entity.YuyuebaoyangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预约保养
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuyuebaoyang")
public class YuyuebaoyangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yuyuebaoyang_time")
    private Date yuyuebaoyangTime;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约车辆
     */

    @TableField(value = "cheliang_id")
    private Integer cheliangId;


    /**
     * 保养项目
     */

    @TableField(value = "yuyuebaoyang_types")
    private String yuyuebaoyangTypes;


    /**
     * 预约状态
     */

    @TableField(value = "yuyuebaoyang_status_types")
    private Integer yuyuebaoyangStatusTypes;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getYuyuebaoyangTime() {
        return yuyuebaoyangTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setYuyuebaoyangTime(Date yuyuebaoyangTime) {
        this.yuyuebaoyangTime = yuyuebaoyangTime;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：预约车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：保养项目
	 */
    public String getYuyuebaoyangTypes() {
        return yuyuebaoyangTypes;
    }


    /**
	 * 获取：保养项目
	 */

    public void setYuyuebaoyangTypes(String yuyuebaoyangTypes) {
        this.yuyuebaoyangTypes = yuyuebaoyangTypes;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getYuyuebaoyangStatusTypes() {
        return yuyuebaoyangStatusTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setYuyuebaoyangStatusTypes(Integer yuyuebaoyangStatusTypes) {
        this.yuyuebaoyangStatusTypes = yuyuebaoyangStatusTypes;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
