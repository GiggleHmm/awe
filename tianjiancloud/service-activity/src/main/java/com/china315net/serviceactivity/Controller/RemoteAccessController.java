package com.china315net.serviceactivity.Controller;
import com.alibaba.fastjson.JSONObject;
import com.china315net.serviceactivity.commlib.common;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin()
@RequestMapping("/remote")
public class RemoteAccessController {
    private RestTemplate restTemplate = new RestTemplate();
    common comm = new common();
    @ApiOperation(value ="根据公司ID查询所有产品信息",notes = "通用分页查询模式，pnm:产品名称;pcd:产品编码")
    @RequestMapping(value = "schwlprod/{compid}",method = RequestMethod.GET)
    public JSONObject searchwuliuproduct(@PathVariable Integer compid, @RequestParam(name = "current") String current, @RequestParam(name = "pageSize") String pageSize, @RequestParam(name = "pnm") String pnm, @RequestParam(name = "pcd") String pcd){
        String baseurl = "http://os.china315net.com/micservice/getwlproduct.ashx?compid="+compid+"&page="+current+"&limit="+pageSize;

        if(pnm!=null&&pnm.length()>0){
            baseurl += "&pnm="+pnm;
        }
        if(pcd!=null&&pcd.length()>0){
            baseurl += "&pcd="+pcd;
        }
        JSONObject obj = JSONObject.parseObject(restTemplate.getForObject(baseurl,String.class));
        return comm.ReturnQureyObj(Integer.parseInt(current),Integer.parseInt(pageSize),true,Integer.parseInt(obj.get("count").toString()),obj.getJSONArray("data"));
    }
    @ApiOperation(value ="根据公司ID查询所有经销商信息",notes = "通用分页查询模式，anm:经销商名称")
    @RequestMapping(value = "schagent/{compid}",method = RequestMethod.GET)
    public JSONObject searchagentinfo(@PathVariable Integer compid,@RequestParam(name = "current") String current,@RequestParam(name = "pageSize") String pageSize,@RequestParam(name = "anm") String anm){
        String baseurl = "http://os.china315net.com/micservice/getAgentInfo.ashx?compid="+compid+"&page="+current+"&limit="+pageSize;
        if(anm!=null&&anm.length()>0){
            baseurl += "&anm="+anm;
        }
        JSONObject obj = JSONObject.parseObject(restTemplate.getForObject(baseurl,String.class));
        return comm.ReturnQureyObj(Integer.parseInt(current),Integer.parseInt(pageSize),true,Integer.parseInt(obj.get("count").toString()),obj.getJSONArray("data"));
    }
    @ApiOperation(value ="根据公司ID查询所有终端店信息",notes = "通用分页查询模式，tnm:终端店名称")
    @RequestMapping(value = "schtermial/{compid}",method = RequestMethod.GET)
    public JSONObject searchtermialinfo(@PathVariable Integer compid,@RequestParam(name = "current") String current,@RequestParam(name = "pageSize") String pageSize,@RequestParam(name = "tnm") String tnm){
        String baseurl = "http://os.china315net.com/micservice/getTerminalInfo.ashx?compid="+compid+"&page="+current+"&limit="+pageSize;
        if(tnm!=null&&tnm.length()>0){
            baseurl += "&tnm="+tnm;
        }
        JSONObject obj = JSONObject.parseObject(restTemplate.getForObject(baseurl,String.class));
        return comm.ReturnQureyObj(Integer.parseInt(current),Integer.parseInt(pageSize),true,Integer.parseInt(obj.get("count").toString()),obj.getJSONArray("data"));
    }
}
