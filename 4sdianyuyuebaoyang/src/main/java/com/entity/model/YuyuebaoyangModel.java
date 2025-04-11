package com.entity.model;

import com.entity.YuyuebaoyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约保养
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuyuebaoyangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyuebaoyangTime;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约车辆
     */
    private Integer cheliangId;


    /**
     * 保养项目
     */
    private Integer yuyuebaoyangTypes;


    /**
     * 预约状态
     */
    private Integer yuyuebaoyangStatusTypes;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getYuyuebaoyangTime() {
        return yuyuebaoyangTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setYuyuebaoyangTime(Date yuyuebaoyangTime) {
        this.yuyuebaoyangTime = yuyuebaoyangTime;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：预约车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：保养项目
	 */
    public Integer getYuyuebaoyangTypes() {
        return yuyuebaoyangTypes;
    }


    /**
	 * 设置：保养项目
	 */
    public void setYuyuebaoyangTypes(Integer yuyuebaoyangTypes) {
        this.yuyuebaoyangTypes = yuyuebaoyangTypes;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getYuyuebaoyangStatusTypes() {
        return yuyuebaoyangStatusTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setYuyuebaoyangStatusTypes(Integer yuyuebaoyangStatusTypes) {
        this.yuyuebaoyangStatusTypes = yuyuebaoyangStatusTypes;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
