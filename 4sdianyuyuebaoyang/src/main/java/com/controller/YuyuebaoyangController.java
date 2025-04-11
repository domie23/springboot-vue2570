
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 预约保养
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yuyuebaoyang")
public class YuyuebaoyangController {
    private static final Logger logger = LoggerFactory.getLogger(YuyuebaoyangController.class);

    @Autowired
    private YuyuebaoyangService yuyuebaoyangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CheliangService cheliangService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yuyuebaoyangService.queryPage(params);

        //字典表数据转换
        List<YuyuebaoyangView> list =(List<YuyuebaoyangView>)page.getList();
        for(YuyuebaoyangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YuyuebaoyangEntity yuyuebaoyang = yuyuebaoyangService.selectById(id);
        if(yuyuebaoyang !=null){
            //entity转view
            YuyuebaoyangView view = new YuyuebaoyangView();
            BeanUtils.copyProperties( yuyuebaoyang , view );//把实体数据重构到view中

                //级联表
                CheliangEntity cheliang = cheliangService.selectById(yuyuebaoyang.getCheliangId());
                if(cheliang != null){
                    BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangId(cheliang.getId());
                    view.setCheliangYonghuId(cheliang.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(yuyuebaoyang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuebaoyangEntity yuyuebaoyang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yuyuebaoyang:{}",this.getClass().getName(),yuyuebaoyang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yuyuebaoyang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YuyuebaoyangEntity> queryWrapper = new EntityWrapper<YuyuebaoyangEntity>()
            .eq("yuyuebaoyang_time", new SimpleDateFormat("yyyy-MM-dd").format(yuyuebaoyang.getYuyuebaoyangTime()))
            .eq("yonghu_id", yuyuebaoyang.getYonghuId())
            .eq("cheliang_id", yuyuebaoyang.getCheliangId())
            .eq("yuyuebaoyang_types", yuyuebaoyang.getYuyuebaoyangTypes())
            .eq("yuyuebaoyang_status_types", yuyuebaoyang.getYuyuebaoyangStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyuebaoyangEntity yuyuebaoyangEntity = yuyuebaoyangService.selectOne(queryWrapper);
        if(yuyuebaoyangEntity==null){
            yuyuebaoyang.setCreateTime(new Date());
            yuyuebaoyangService.insert(yuyuebaoyang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuyuebaoyangEntity yuyuebaoyang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yuyuebaoyang:{}",this.getClass().getName(),yuyuebaoyang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //根据字段查询是否有相同数据
        Wrapper<YuyuebaoyangEntity> queryWrapper = new EntityWrapper<YuyuebaoyangEntity>()
            .notIn("id",yuyuebaoyang.getId())
            .andNew()
            .eq("yonghu_id", yuyuebaoyang.getYonghuId())
            .eq("cheliang_id", yuyuebaoyang.getCheliangId())
            .eq("yuyuebaoyang_types", yuyuebaoyang.getYuyuebaoyangTypes())
            .eq("yuyuebaoyang_status_types", yuyuebaoyang.getYuyuebaoyangStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuyuebaoyangEntity yuyuebaoyangEntity = yuyuebaoyangService.selectOne(queryWrapper);
        if(yuyuebaoyangEntity==null){
            yuyuebaoyangService.updateById(yuyuebaoyang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yuyuebaoyangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<YuyuebaoyangEntity> yuyuebaoyangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YuyuebaoyangEntity yuyuebaoyangEntity = new YuyuebaoyangEntity();
//                            yuyuebaoyangEntity.setYuyuebaoyangTime(new Date(data.get(0)));          //预约时间 要改的
//                            yuyuebaoyangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yuyuebaoyangEntity.setCheliangId(Integer.valueOf(data.get(0)));   //预约车辆 要改的
//                            yuyuebaoyangEntity.setYuyuebaoyangTypes(Integer.valueOf(data.get(0)));   //保养项目 要改的
//                            yuyuebaoyangEntity.setYuyuebaoyangStatusTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            yuyuebaoyangEntity.setCreateTime(date);//时间
                            yuyuebaoyangList.add(yuyuebaoyangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yuyuebaoyangService.insertBatch(yuyuebaoyangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
