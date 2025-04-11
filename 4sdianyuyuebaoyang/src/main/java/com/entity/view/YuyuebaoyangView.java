package com.entity.view;

import com.entity.YuyuebaoyangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 预约保养
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yuyuebaoyang")
public class YuyuebaoyangView extends YuyuebaoyangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 保养项目的值
		*/
		private String yuyuebaoyangValue;
		/**
		* 预约状态的值
		*/
		private String yuyuebaoyangStatusValue;



		//级联表 cheliang
			/**
			* 车辆编号
			*/
			private String cheliangUuidNumber;
			/**
			* 车辆名称
			*/
			private String cheliangName;
			/**
			* 车辆图片
			*/
			private String cheliangPhoto;
			/**
			* 车辆信息 的 用户
			*/
			private Integer cheliangYonghuId;
			/**
			* 车辆型号
			*/
			private Integer cheliangTypes;
				/**
				* 车辆型号的值
				*/
				private String cheliangValue;
			/**
			* 车辆品牌
			*/
			private Integer pinpaiTypes;
				/**
				* 车辆品牌的值
				*/
				private String pinpaiValue;
			/**
			* 车辆颜色
			*/
			private String cheliangYanse;
			/**
			* 购置时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date cheliangTime;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public YuyuebaoyangView() {

	}

	public YuyuebaoyangView(YuyuebaoyangEntity yuyuebaoyangEntity) {
		try {
			BeanUtils.copyProperties(this, yuyuebaoyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 保养项目的值
			*/
			public String getYuyuebaoyangValue() {
				return yuyuebaoyangValue;
			}
			/**
			* 设置： 保养项目的值
			*/
			public void setYuyuebaoyangValue(String yuyuebaoyangValue) {
				this.yuyuebaoyangValue = yuyuebaoyangValue;
			}
			/**
			* 获取： 预约状态的值
			*/
			public String getYuyuebaoyangStatusValue() {
				return yuyuebaoyangStatusValue;
			}
			/**
			* 设置： 预约状态的值
			*/
			public void setYuyuebaoyangStatusValue(String yuyuebaoyangStatusValue) {
				this.yuyuebaoyangStatusValue = yuyuebaoyangStatusValue;
			}





				//级联表的get和set cheliang
					/**
					* 获取： 车辆编号
					*/
					public String getCheliangUuidNumber() {
						return cheliangUuidNumber;
					}
					/**
					* 设置： 车辆编号
					*/
					public void setCheliangUuidNumber(String cheliangUuidNumber) {
						this.cheliangUuidNumber = cheliangUuidNumber;
					}
					/**
					* 获取： 车辆名称
					*/
					public String getCheliangName() {
						return cheliangName;
					}
					/**
					* 设置： 车辆名称
					*/
					public void setCheliangName(String cheliangName) {
						this.cheliangName = cheliangName;
					}
					/**
					* 获取： 车辆图片
					*/
					public String getCheliangPhoto() {
						return cheliangPhoto;
					}
					/**
					* 设置： 车辆图片
					*/
					public void setCheliangPhoto(String cheliangPhoto) {
						this.cheliangPhoto = cheliangPhoto;
					}
					/**
					* 获取：车辆信息 的 用户
					*/
					public Integer getCheliangYonghuId() {
						return cheliangYonghuId;
					}
					/**
					* 设置：车辆信息 的 用户
					*/
					public void setCheliangYonghuId(Integer cheliangYonghuId) {
						this.cheliangYonghuId = cheliangYonghuId;
					}

					/**
					* 获取： 车辆型号
					*/
					public Integer getCheliangTypes() {
						return cheliangTypes;
					}
					/**
					* 设置： 车辆型号
					*/
					public void setCheliangTypes(Integer cheliangTypes) {
						this.cheliangTypes = cheliangTypes;
					}


						/**
						* 获取： 车辆型号的值
						*/
						public String getCheliangValue() {
							return cheliangValue;
						}
						/**
						* 设置： 车辆型号的值
						*/
						public void setCheliangValue(String cheliangValue) {
							this.cheliangValue = cheliangValue;
						}
					/**
					* 获取： 车辆品牌
					*/
					public Integer getPinpaiTypes() {
						return pinpaiTypes;
					}
					/**
					* 设置： 车辆品牌
					*/
					public void setPinpaiTypes(Integer pinpaiTypes) {
						this.pinpaiTypes = pinpaiTypes;
					}


						/**
						* 获取： 车辆品牌的值
						*/
						public String getPinpaiValue() {
							return pinpaiValue;
						}
						/**
						* 设置： 车辆品牌的值
						*/
						public void setPinpaiValue(String pinpaiValue) {
							this.pinpaiValue = pinpaiValue;
						}
					/**
					* 获取： 车辆颜色
					*/
					public String getCheliangYanse() {
						return cheliangYanse;
					}
					/**
					* 设置： 车辆颜色
					*/
					public void setCheliangYanse(String cheliangYanse) {
						this.cheliangYanse = cheliangYanse;
					}
					/**
					* 获取： 购置时间
					*/
					public Date getCheliangTime() {
						return cheliangTime;
					}
					/**
					* 设置： 购置时间
					*/
					public void setCheliangTime(Date cheliangTime) {
						this.cheliangTime = cheliangTime;
					}








				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}







}
