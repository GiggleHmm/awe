package com.china315net.serviceactivity.Controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.china315net.serviceactivity.Entity.*;
import com.china315net.serviceactivity.Service.*;
import com.china315net.serviceactivity.commlib.common;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin()
@RequestMapping("/rest")
public class MainRestController {
    common comm = new common();

    @Autowired
    tjactivityService activitService;
    @ApiOperation(value="返回客户活动信息列表", notes = "这里的id是公司id，目前是2，今后授权机制建立后会失去作用，随便传一个即可,支持通用分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "current",name = "当前页"),
            @ApiImplicitParam(value = "pageSize",name = "页行数"),
            @ApiImplicitParam(value = "sorter",name = "排序地段"),
            @ApiImplicitParam(value = "查询条件",name = "默认:like;between：传递值中间需用and隔开;=:传递值两侧加-")
    })
    @RequestMapping(value = "/tjactivity/list/{id}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject gettjactivitylist(@PathVariable Integer id, HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String current = map.get("current") != null ? map.get("current")[0] : null;
        String pageSize = map.get("pageSize") != null ? map.get("pageSize")[0] : null;
        String sorter = map.get("sorter") != null ? map.get("sorter")[0] : null;
        String filter = "";
        for (String f : tjactivity.keyfields) {
            if (map.get(f) != null) {
                if (map.get(f)[0].contains(" and ")) {
                    filter += " and (t." + f + " between " + map.get(f)[0] + ")";
                } else if (map.get(f)[0].contains("-")) {
                    filter += " and t." + f + "=" + map.get(f)[0].replace("-", "");
                } else {
                    filter += " and t." + f + " like '%" + map.get(f)[0] + "%'";
                }
            }
        }
        Integer sindex = current != null ? Integer.parseInt(current) - 1 : 0;
        sindex = sindex < 0 ? 0 : sindex;
        Integer ps = pageSize != null ? Integer.parseInt(pageSize) : 0;
        Integer count = activitService.getCountByFilter(2, filter);
        Integer offset = ps * sindex;
        List<activityall> list = activitService.selectAllSmart(2, filter, sorter, ps, offset);
        return comm.ReturnQureyObj(sindex + 1, ps, true, count, list);
    }

    @ApiOperation(value="根据活动id查询活动信息")
    @ApiImplicitParam(name="id", value="活动唯一ID", required = true)
    @RequestMapping(value = "/tjactivity/{id}", method = RequestMethod.GET, produces = "application/json")
    public tjactivity getAcitivityObj(@PathVariable Integer id) {
        return activitService.selectByPrimaryKey(id);
    }

    @ApiOperation(value="新增活动信息",notes = "接收到的内容将被解析成JSONObject")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "aname",name = "活动名称"),
            @ApiImplicitParam(value = "asid",name = "策略ID"),
            @ApiImplicitParam(value = "cdtp",name = "码类型"),
            @ApiImplicitParam(value = "actto",name = "活动对象"),
            @ApiImplicitParam(value = "dayfanwei",name = "起始日期,间隔: , "),
            @ApiImplicitParam(value = "yzm",name = "是否有验证码"),
            @ApiImplicitParam(value = "yxj",name = "优先级"),
            @ApiImplicitParam(value = "beizhu",name = "备注")
    })

    @RequestMapping(value = "/tjactivity/add", method = RequestMethod.POST, produces = "application/json")
    public JSONObject activityPostAdd(@RequestBody JSONObject json) {
        JSONObject jo = json;
        tjactivity data = new tjactivity();
        data.setCompid(2);
        if (jo.getString("yzm") != null) {
            data.setYzm(jo.getString("yzm").toLowerCase().equals("on") ? (byte) 1 : (byte) 0);
        } else {
            data.setYzm((byte) 0);
        }
        data.setAname(jo.getString("aname"));
        data.setAsid(jo.getInteger("asid"));
        data.setObcodetype(jo.getString("cdtp"));
        data.setFaceto(jo.getInteger("actto"));
        String dayfanweistring = jo.getString("dayfanwei");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] tmp = dayfanweistring.split(",");
        data.setStm(Timestamp.valueOf(tmp[0] + " 00:00:00"));
        data.setEtm(Timestamp.valueOf(tmp[1] + " 00:00:00"));
        data.setRemarks(jo.getString("beizhu"));
        data.setPriority(jo.getInteger("yxj"));
        data.setCreatedate(Timestamp.valueOf(LocalDateTime.now()));
        Integer rst = activitService.insertSelective(data);
        if (rst > 0) {
            return (JSONObject) JSONObject.parse("{\"msg\":\"ok\",\"rst\":" + rst + "}");
        } else {
            return (JSONObject) JSONObject.parse("{\"msg\":\"fail\",\"rst\":" + rst + "}");
        }
    }

    @ApiOperation(value="修改活动信息",notes = "接收到的内容将被解析成JSONObject")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "活动ID"),
            @ApiImplicitParam(value = "aname",name = "活动名称"),
            @ApiImplicitParam(value = "asid",name = "策略ID"),
            @ApiImplicitParam(value = "cdtp",name = "码类型"),
            @ApiImplicitParam(value = "actto",name = "活动对象"),
            @ApiImplicitParam(value = "dayfanwei",name = "起始日期,间隔: , "),
            @ApiImplicitParam(value = "yzm",name = "是否有验证码"),
            @ApiImplicitParam(value = "yxj",name = "优先级"),
            @ApiImplicitParam(value = "beizhu",name = "备注")
    })

    @RequestMapping(value = "/tjactivity/edit", method = RequestMethod.POST, produces = "application/json")
    public JSONObject activityPostEdit(@RequestBody JSONObject json) {
        JSONObject jo = json;
        tjactivity data = new tjactivity();
        data.setId(jo.getInteger("id"));
        data.setCompid(2);
        if (jo.get("yzm") == null) {
            data.setYzm((byte) 0);
        } else {
            data.setYzm(jo.getString("yzm").toLowerCase().equals("on") ? (byte) 1 : (byte) 0);
        }
        data.setAname(jo.getString("aname"));
        data.setAsid(jo.getInteger("asid"));
        data.setObcodetype(jo.getString("cdtp"));
        data.setFaceto(jo.getInteger("actto"));
        String dayfanweistring = jo.getString("dayfanwei");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] tmp = dayfanweistring.split(",");
        data.setStm(Timestamp.valueOf(tmp[0] + " 00:00:00"));
        data.setEtm(Timestamp.valueOf(tmp[1] + " 00:00:00"));
        data.setRemarks(jo.getString("beizhu"));
        data.setPriority(jo.getInteger("yxj"));
        data.setCreatedate(Timestamp.valueOf(LocalDateTime.now()));
        return getJsonObject(activitService.updateByPrimaryKeySelective(data));
    }

    @ApiOperation(value="修改活动其他信息，列表中的'其他'",notes = "将用RequestBody方式接收上传内容，并转换成JSONObject")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "活动id"),
            @ApiImplicitParam(value = "anyfahuodate",name = "是否不限发货时间"),
            @ApiImplicitParam(value = "chuchangdayfanwei",name="出厂日期范围，间隔：, "),
            @ApiImplicitParam(value = "khddh",name = "客户订单号")
    })

    @RequestMapping(value = "/tjactivity/actothermodify", method = RequestMethod.POST, produces = "application/json")
    public JSONObject activityPostOtherModify(@RequestBody JSONObject json) {
        JSONObject jo = json;
        tjactivity data = new tjactivity();
        data = activitService.selectByPrimaryKey(jo.getInteger("id"));
        if (jo.get("anyfahuodate") != null) {
            data.setAnyfahuodate(jo.getString("anyfahuodate").equals("on") ? 1 : 0);
        } else {
            data.setAnyfahuodate(0);
        }
        String chuchangdayfanwei = jo.getString("chuchangdayfanwei");
        String[] fhdatearray = chuchangdayfanwei.split("-");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        try {
            data.setSfahuodate(simpleDateFormat.parse(fhdatearray[0]));
            data.setEfahuodate(simpleDateFormat.parse(fhdatearray[1]));
            data.setKhddh(jo.getString("khddh"));
            return getJsonObject(activitService.updateByPrimaryKeySelective(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getJsonObject(0);
    }

    @ApiOperation(value="根据Id删除活动信息")
    @RequestMapping(value = "/tjactivity/del/{acid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject activityPostEdit(@PathVariable Integer acid) {
        return getJsonObject(activitService.deleteByPrimaryKey(acid));
    }

    @Autowired
    private tjactivitystrategyService activity_strategyService;
    @ApiOperation(value = "根据公司id获取所有活动策略", notes = "这里的id是公司id，目前是2，今后授权机制建立后会失去作用，随便传一个即可,不支持通用分页")
    @RequestMapping(value = "/tjactivitystrategyall/{id}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject getAcitivityStrategyAll(@PathVariable Integer id) {
        Integer count = activity_strategyService.getAllCountByCompid(id);
        List<tjactivitystrategy> list = activity_strategyService.selectActivitStrategyByCompID(id);
        return comm.ReturnQureyObj(1, count, true, count, list);
    }

    @ApiOperation(value = "根据公司id获取所有活动策略用于下拉列表", notes = "这里的id是公司id，目前是2，今后授权机制建立后会失去作用")
    @RequestMapping(value = "/tjactivitystrategyfordroplist/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<selectlist> getAcitivityStrategyForDropList(@PathVariable Integer id) {
        return activity_strategyService.selectActivitStrategyByCompIDForSelect(id);
    }

    @ApiOperation(value = "根据公司Id返回所有活动策略信息")
    @RequestMapping(value = "/tjactivitystrategy/{compid}", method = RequestMethod.GET, produces = "application/json")
    public List<tjactivitystrategy> getAcitivityStrategy(@PathVariable Integer compid) {
        return activity_strategyService.selectActivitStrategyByCompID(compid);
    }

    @ApiOperation(value = "修改策略信息",notes = "将用RequestBody方式接收上传内容，并转换成JSONObject")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "策略id"),
            @ApiImplicitParam(value = "strategyname",name = "策略名称"),
            @ApiImplicitParam(value = "md",name = "模式"),
            @ApiImplicitParam(value = "totalwinrate",name = "中奖率"),
            @ApiImplicitParam(value = "packagenum",name = "包装中间数量"),
            @ApiImplicitParam(value = "maxtimeself",name = "最多几次后中奖"),
            @ApiImplicitParam(value = "beizhu",name = "备注")
    })
    @RequestMapping(value = "/tjactivitystrategy/edit", method = RequestMethod.POST, produces = "application/json")
    public JSONObject actstrategyPostEdit(@RequestBody JSONObject json) {
        JSONObject jo = json;
        tjactivitystrategy data = new tjactivitystrategy();
        data.setId(jo.getInteger("id"));
        data.setCompid(2);
        data.setStrategyname(jo.getString("strategyname"));
        data.setMd(jo.getByte("md"));
        if (jo.getInteger("totalwinrate") == null) {
            data.setTotalwinrate(0);
        } else {
            data.setTotalwinrate(jo.getInteger("totalwinrate"));
        }
        if (jo.getInteger("packagenum") == null) {
            data.setPackagenum(0);
        } else {
            data.setPackagenum(jo.getInteger("packagenum"));
        }
        if (jo.getInteger("maxtimeself") == null) {
            data.setMaxtimeself(0);
        } else {
            data.setMaxtimeself(jo.getInteger("maxtimeself"));
        }
        data.setRemarks(jo.getString("beizhu"));
        data.setCreatedate(Timestamp.valueOf(LocalDateTime.now()));
        return getJsonObject(activity_strategyService.updateByPrimaryKeySelective(data));
    }

    @Autowired
    private activityprizesService prizeservice;
    @ApiOperation(value = "根据活动Id获取奖项信息",notes = "不支持分页")
    @RequestMapping(value = "/tjactivityprizes/{acid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject getAcitivityPrizes(@PathVariable Integer acid) {
        Integer count = prizeservice.getActivityPrizeCount(acid);
        List<tjactivityprizes> list = prizeservice.getactivityprizeByAcid(acid);
        return comm.ReturnQureyObj(1, count, true, count, list);
    }
    @ApiOperation(value = "修改奖项信息",notes = "将用RequestBody方式接收上传内容，并转换成JSONObject")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "id",name = "奖项id"),
            @ApiImplicitParam(value = "awtype",name = "奖项类别ID"),
            @ApiImplicitParam(value = "prizevalue",name = "额度"),
            @ApiImplicitParam(value = "pvl",name = "百分比"),
            @ApiImplicitParam(value = "awnm",name = "奖项名称"),
            @ApiImplicitParam(value = "bz",name = "备注"),
            @ApiImplicitParam(value = "awtpnm",name = "奖项类别名称")
    })
    @RequestMapping(value = "/tjactivityprize/edit", method = RequestMethod.POST, produces = "application/json")
    public JSONObject actprizePostEdit(@RequestBody JSONObject json) {
        tjactivityprizes actprize = prizeservice.selectByPrimaryKey(json.getInteger("id"));
        actprize.setAwtype(json.getInteger("awtype"));
        actprize.setPrizevalue(json.getDoubleValue("prizevalue"));
        actprize.setPercentvl(json.getInteger("pvl"));
        actprize.setAwnm(json.getString("awnm"));
        actprize.setRemarks(json.getString("bz"));
        actprize.setAwtypenm(json.getString("awtpnm"));
        return getJsonObject(prizeservice.updateByPrimaryKeySelective(actprize));
    }

    @ApiOperation(value = "新增活动奖项信息",notes = "将用RequestBody方式接收上传内容，并转换成JSONObject，acid必不可少")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "acid",name = "活动ID"),
            @ApiImplicitParam(value = "awtype",name = "奖项类别ID"),
            @ApiImplicitParam(value = "prizevalue",name = "额度"),
            @ApiImplicitParam(value = "pvl",name = "百分比"),
            @ApiImplicitParam(value = "awnm",name = "奖项名称"),
            @ApiImplicitParam(value = "bz",name = "备注"),
            @ApiImplicitParam(value = "awtpnm",name = "奖项类别名称")
    })
    @RequestMapping(value = "/tjactivityprize/add", method = RequestMethod.POST, produces = "application/json")
    public JSONObject actprizePostAdd(@RequestBody JSONObject jo) {
        tjactivityprizes enactprize = new tjactivityprizes();
        enactprize.setAcid(jo.getInteger("acid"));
        enactprize.setAwtype(jo.getInteger("awtype"));
        enactprize.setAwnm(jo.getString("awnm"));
        enactprize.setPrizevalue(jo.getDoubleValue("prizevalue"));
        enactprize.setPercentvl(jo.getInteger("pvl"));
        enactprize.setRemarks(jo.getString("bz"));
        enactprize.setAwtypenm(jo.getString("awtpnm"));
        return getJsonObject(prizeservice.insertSelective(enactprize));
    }

    @ApiOperation(value = "根据奖项Id删除奖项信息")
    @RequestMapping(value = "/tjactivityprize/del/{actprzid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject actprizeDel(@PathVariable Integer actprzid) {
        return getJsonObject(prizeservice.deleteByPrimaryKey(actprzid));
    }


    @Autowired
    private com.china315net.serviceactivity.Service.tjawardtypeService tjawardtypeService;
    @ApiOperation(value = "根据返回公司Id查询奖项类型")
    @RequestMapping(value = "/tjawardtype/list/{compid}", method = RequestMethod.GET, produces = "application/json")
    public List<tjawardtype> getawtypeBycompid(@PathVariable Integer compid) {
        List<tjawardtype> pawdtypelist = tjawardtypeService.getawtypebyCompID(0);
        List<tjawardtype> restlist = new LinkedList<>();
        for (tjawardtype tp : pawdtypelist) {
            restlist.add(tp);
            List<tjawardtype> temp = tjawardtypeService.getawtypebyParentID(tp.getId(), compid);
            if (temp.size() > 0) {
                for (tjawardtype ctp : temp) {
                    ctp.setAwardtype("  ----  " + ctp.getAwardtype());
                    restlist.add(ctp);
                }
            }
        }
        return restlist;
    }

    private JSONObject getJsonObject(int i) {
        Integer rstcout = i;
        if (rstcout > 0) {
            return (JSONObject) JSONObject.parse("{\"msg\":\"ok\",\"rst\":" + rstcout + "}");
        } else {
            return (JSONObject) JSONObject.parse("{\"msg\":\"fail\",\"rst\":" + rstcout + "}");
        }
    }

    @Autowired
    com.china315net.serviceactivity.Service.tjactivityproductService tjactivityproductService;
    @ApiOperation(value = "根据活动Id获取限定产品信息",notes = "acid是活动id,支持分页，传入current和pageSize即可")
    @RequestMapping(value = "/tjactivityproduct/{acid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject getActivityProductByAcid(@PathVariable(name = "acid") Integer acid,HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String current = map.get("current") != null ? map.get("current")[0] : null;
        String pageSize = map.get("pageSize") != null ? map.get("pageSize")[0] : null;
        Integer pg = current!=null?Integer.parseInt(current):1;
        pg = pg<1?1:pg;
        Integer lmt = pageSize!=null?Integer.parseInt(pageSize):10;
        List<tjactivityproduct> rst = tjactivityproductService.getactivityproductbyAcid(acid, lmt, (pg - 1) * lmt);
        Integer count = tjactivityproductService.getacitivityproductcountbyAcid(acid);
        return comm.ReturnQureyObj(pg, lmt, true, count, rst);
    }

    @ApiOperation(value = "修改活动产品名称",notes = "将用RequestBody方式接收上传内容，并转换成JSONObject")
    @RequestMapping(value = "/tjactivityproduct/edit", method = RequestMethod.POST, produces = "application/json")
    public JSONObject tjactivityproductEdit(@RequestBody JSONObject json) {
        JSONObject jo = json;
        tjactivityproduct entity = tjactivityproductService.selectByPrimaryKey(jo.getInteger("nmid"));
        entity.setProdnm(jo.getString("nmprodnm"));
        tjactivityproductService.updateByPrimaryKeySelective(entity);
        return getJsonObject(1);
    }

    @ApiOperation(value = "删除活动产品")
    @ApiImplicitParam(name="aprdid", value="活动产品唯一ID", required = true)
    @RequestMapping(value = "/tjactivityproduct/del/{aprdid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject tjactivityproductdel(@PathVariable Integer aprdid) {
        Integer count = tjactivityproductService.deleteByPrimaryKey(aprdid);
        return getJsonObject(count);
    }

    @ApiOperation(value = "新增活动限定的产品",notes = "产品是通过选择添加的，将用RequestBody方式接收上传内容，并转换成JSONObject")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "活动id",value = "acid"),
            @ApiImplicitParam(name = "选择返回的JSON数组:[{\"Infor_ID\":1,\"Products_Name\":\"xxxx\"}]",value = "data")
    })
    @RequestMapping(value = "/tjactivityprod/add", method = RequestMethod.POST, produces = "application/json")
    private JSONObject tjactivityproductadd(@RequestBody JSONObject jo) {
        Integer acid = jo.getInteger("acid");
        JSONArray proarr = jo.getJSONArray("data");
        tjactivityproduct entity = new tjactivityproduct();
        Integer cout = 0;
        for (int i = 0; i < proarr.size(); i++) {
            entity.setAcid(acid);
            entity.setProdid(proarr.getJSONObject(i).getInteger("Infor_ID"));
            entity.setProdnm(proarr.getJSONObject(i).getString("Products_Name"));
            tjactivityproductService.insertSelective(entity);
            cout++;
        }
        return getJsonObject(cout);
    }

    @Autowired
    private tjactivityterminalService tjactivityterminalservice;
    @ApiOperation(value = "根据活动Id查询限定终端店",notes = "acid：活动ID必不可少,支持分页，传入current和pageSize即可")
    @RequestMapping(value = "tjactivityterminal/{acid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject gettjactivityterminal(@PathVariable Integer acid,HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String current = map.get("current") != null ? map.get("current")[0] : null;
        String pageSize = map.get("pageSize") != null ? map.get("pageSize")[0] : null;
        Integer pg = current != null ? Integer.parseInt(current) : 1;
        pg = pg < 1 ? 1 : pg;
        Integer lmt = pageSize != null ? Integer.parseInt(pageSize) : 10;
        Integer count = tjactivityterminalservice.gettjactivityterminalcountbyacid(acid);
        List<tjactivityterminal> list = tjactivityterminalservice.gettjactivityterminalbyacid(acid, lmt, (pg - 1) * lmt);
        return comm.ReturnQureyObj(pg, lmt, true, count, list);
    }

    @ApiOperation(value = "新增活动限定终端店",notes = "需从列表中选择")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "活动Id",value = "acid",required = true),
            @ApiImplicitParam(name = "选择返回的JSON数组:[{\"CompID\":1,\"CompName\":\"xxxx\"}]",value = "data")
    })
    @RequestMapping(value = "tjactivityterminal/add", method = RequestMethod.POST, produces = "application/json")
    public JSONObject tjactivityterminalPostAdd(@RequestBody JSONObject jo) {
        tjactivityterminal entity = new tjactivityterminal();
        Integer acid = jo.getInteger("acid");
        JSONArray proarr = jo.getJSONArray("data");
        Integer cout = 0;
        for (int i = 0; i < proarr.size(); i++) {
            entity.setAcid(acid);
            entity.setTerminalid(proarr.getJSONObject(i).getInteger("CompID"));
            entity.setTerminalnm(proarr.getJSONObject(i).getString("CompName"));
            tjactivityterminalservice.insertSelective(entity);
            cout++;
        }
        return getJsonObject(cout);
    }
    @ApiOperation(value = "根据id删除活动限制的终端店")
    @RequestMapping(value = "tjactivityterminal/del/{actiterminalid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject tjactivityterminalPostAdd(@PathVariable Integer actiterminalid) {
        Integer count = tjactivityterminalservice.deleteByPrimaryKey(actiterminalid);
        return getJsonObject(count);
    }

    @Autowired
    private tjactivityagentService tjactivityagentservice;
    @ApiOperation(value = "根据活动id返回限定的经销商信息",notes = "支持分页，传入current和pageSize即可")
    @RequestMapping(value = "tjactivityagent/{acid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject gettjactivityagent(@PathVariable Integer acid, HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String current = map.get("current") != null ? map.get("current")[0] : null;
        String pageSize = map.get("pageSize") != null ? map.get("pageSize")[0] : null;
        Integer pg = current != null ? Integer.parseInt(current) : 1;
        pg = pg < 1 ? 1 : pg;
        Integer lmt = pageSize != null ? Integer.parseInt(pageSize) : 10;
        Integer count = tjactivityagentservice.gettjactivityagentcountbyacid(acid);
        List<tjactivityagent> list = tjactivityagentservice.gettjactivityagentbyacid(acid, lmt, (pg - 1) * lmt);
        return comm.ReturnQureyObj(pg,lmt,true,count,list);
    }

    @ApiOperation(value = "新增活动限定经销商信息",notes = "需从列表中选择")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "活动Id",value = "acid",required = true),
            @ApiImplicitParam(name = "选择返回的JSON数组:[{\"CompID\":1,\"CompName\":\"xxxx\"}]",value = "data")
    })
    @RequestMapping(value = "tjactivityagent/add", method = RequestMethod.POST, produces = "application/json")
    public JSONObject tjactivityagentPostAdd(@RequestBody JSONObject jo) {
        tjactivityagent entity = new tjactivityagent();
        Integer acid = jo.getInteger("acid");
        JSONArray jarr = jo.getJSONArray("data");
        Integer cout = 0;
        for (int i = 0; i < jarr.size(); i++) {
            entity.setAcid(acid);
            entity.setAgentid(jarr.getJSONObject(i).getInteger("CompID"));
            entity.setAgentname(jarr.getJSONObject(i).getString("CompName"));
            tjactivityagentservice.insertSelective(entity);
            cout++;
        }
        return getJsonObject(cout);
    }

    @ApiOperation(value = "根据id删除活动限定经销商")
    @RequestMapping(value = "tjactivityagent/del/{actagentid}", method = RequestMethod.GET, produces = "application/json")
    public JSONObject tjactivityagentPostDel(@PathVariable Integer actagentid) {
        Integer cout = tjactivityagentservice.deleteByPrimaryKey(actagentid);
        return getJsonObject(cout);
    }
}
