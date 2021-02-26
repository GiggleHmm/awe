package com.china315net.servicesystem.Controller;

import com.alibaba.fastjson.JSONObject;
import com.china315net.servicesystem.Entity.syscomp;
import com.china315net.servicesystem.Entity.syscompmenu;
import com.china315net.servicesystem.Entity.syscompmenu;
import com.china315net.servicesystem.Service.syscompService;
import com.china315net.servicesystem.Service.syscompmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.china315net.servicesystem.Commlib.comm.getJsonObject;

/**
 * @author asus
 */
@RestController
public class RestControllerT {

    @Autowired
    private syscompService syscompservice;

    @RequestMapping(value = "/syscomp/{pid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject getsyscomp(@PathVariable Integer pid, @RequestParam(name = "page") String page,@RequestParam(name = "limit") String limit) {
        Integer pg = Integer.parseInt(page);
        Integer lmt = Integer.parseInt(limit);
        Integer count = syscompservice.getsyscompcountbyCompid(pid);
        List<syscomp> list = syscompservice.getsyscompbyCompid(pid,lmt,(pg-1)*lmt);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", count);
        obj.put("data", list);
        return obj;
    }


    @RequestMapping(value = "/syscomp/edit", method = RequestMethod.POST, produces = "application/json")
    public JSONObject syscompEdit(@RequestBody JSONObject json) {
        syscomp entity = syscompservice.selectByPrimaryKey(json.getInteger("idd"));
        entity.setId(json.getInteger("id"));
        entity.setCompname(json.getString("compname"));
        entity.setBusinesstype(json.getShort("businesstype"));
        entity.setContents(json.getString("contents"));
        entity.setCreatetime(json.getDate("createtime"));
        entity.setCreateby(json.getString("createby"));
        entity.setUpdatetime(json.getDate("updatetime"));
        entity.setUpdateby(json.getString("updateby"));
        entity.setRemarks(json.getString("remarks"));
        entity.setDelflag(json.getByte("delflag"));
        return getJsonObject(syscompservice.updateByPrimaryKeySelective(entity));
    }

    @RequestMapping(value = "/syscomp/add", method = RequestMethod.POST, produces = "application/json")
    public JSONObject syscompPostAdd(@RequestBody JSONObject jo) {
        syscomp entity = new syscomp();
        entity.setId(jo.getInteger("id"));
        entity.setCompname(jo.getString("compname"));
        entity.setBusinesstype(jo.getShort("businesstype"));
        entity.setContents(jo.getString("contents"));
        entity.setCreatetime(jo.getDate("createtime"));
        entity.setCreateby(jo.getString("createby"));
        entity.setUpdatetime(jo.getDate("updatetime"));
        entity.setUpdateby(jo.getString("updateby"));
        entity.setRemarks(jo.getString("remarks"));
        entity.setDelflag(jo.getByte("delflag"));
        return getJsonObject(syscompservice.insertSelective(entity));
    }

    @Autowired
    private syscompmenuService syscompmenuservice;

    @RequestMapping(value = "/syscompmenu/{pid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject getsyscompmenu(@PathVariable Integer pid, @RequestParam(name = "page") String page,@RequestParam(name = "limit") String limit) {
        Integer pg = Integer.parseInt(page);
        Integer lmt = Integer.parseInt(limit);
        Integer count = syscompmenuservice.getsyscompmenucountbyCompid(pid);
        List<syscompmenu> list = syscompmenuservice.getsyscompmenubyCompid(pid,lmt,(pg-1)*lmt);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", count);
        obj.put("data", list);
        return obj;
    }

    @RequestMapping(value = "/syscompmenu/edit", method = RequestMethod.POST, produces = "application/json")
    public JSONObject syscompmenuEdit(@RequestBody JSONObject json) {
        syscompmenu entity = syscompmenuservice.selectByPrimaryKey(json.getInteger("idd"));
        entity.setId(json.getInteger("id"));
        entity.setCompid(json.getInteger("compid"));
        entity.setMenuid(json.getInteger("menuid"));
        entity.setMenuname(json.getString("menuname"));
        entity.setOrdernum(json.getInteger("ordernum"));
        entity.setRemarks(json.getString("remarks"));
        entity.setDelflag(json.getByte("delflag"));
        return getJsonObject(syscompmenuservice.updateByPrimaryKeySelective(entity));
    }


    @RequestMapping(value = "/syscompmenu/add", method = RequestMethod.POST, produces = "application/json")
    public JSONObject syscompmenuPostAdd(@RequestBody JSONObject jo) {
        syscompmenu entity = new syscompmenu();
        entity.setId(jo.getInteger("id"));
        entity.setCompid(jo.getInteger("compid"));
        entity.setMenuid(jo.getInteger("menuid"));
        entity.setMenuname(jo.getString("menuname"));
        entity.setOrdernum(jo.getInteger("ordernum"));
        entity.setRemarks(jo.getString("remarks"));
        entity.setDelflag(jo.getByte("delflag"));
        return getJsonObject(syscompmenuservice.insertSelective(entity));
    }
}