package com.xmmems.service;

import com.google.gson.Gson;
import com.xmmems.domain.env.EnvRealtimeData;
import com.xmmems.domain.env.EnvWarnRecord;
import com.xmmems.domain.env.EnvWarningRule;
import com.xmmems.domain.inspect;
import com.xmmems.dto.PageResult;
import com.xmmems.dto.RealtimeData;
import com.xmmems.service.warning.WarnRecordService;
import com.xmmems.service.warning.WarningRuleService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class DateScheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private WarningRuleService warningRuleService;
    @Autowired
    private WarnRecordService warnRecordService;
    //每隔2秒执行一次
////    @Scheduled(cron = "0 46 10 ? * *")
//    public  void testTasks() {
//        //实时数据
//        List<EnvRealtimeData> list = monitorService.getRealTimeDataNoaccountId("asc");
//        //报警规则
//        PageResult<EnvWarningRule> pageResult = warningRuleService.pageQuery(1, 500,null);
//        String json=null;
//       for (int i=0;i<list.size();i++) {
//           json = list.get(i).getContent();
//           RealtimeData[] array = new Gson().fromJson(json, RealtimeData[].class);
//           List<RealtimeData> lista = Arrays.asList(array);
//           for (int j = 0; j < lista.size(); j++) {
//               //报警规则
//               for (int k = 0; k < pageResult.getRows().size(); k++) {
//                   //转换类型用于判断
//                   Double num = Double.parseDouble(lista.get(j).getValue());
//                   Double rangeMin = Double.parseDouble(pageResult.getRows().get(k).getRangeMin());
//                   Double rangeMax = Double.parseDouble(pageResult.getRows().get(k).getRangeMax());
//                   if(pageResult.getRows().get(k).getRangeTypeName().equals("最大最小范围内")){
//                       //判断
//                       if (num > rangeMin && num < rangeMax
//                               && lista.get(j).getItemName().equals(pageResult.getRows().get(k).getItemName())
//                               && list.get(i).getSiteId().equals(pageResult.getRows().get(k).getSiteId())&&pageResult.getRows().get(k).getIsUsed().equals(1)) {
//                           System.out.println("添加报警数据");
//                           EnvWarnRecord envWarnRecord=new EnvWarnRecord();
//                           envWarnRecord.setSiteId(list.get(i).getSiteId());
//                           envWarnRecord.setSiteName(list.get(i).getSiteName());
//                           envWarnRecord.setExcepItemName( lista.get(j).getItemName());
//                           envWarnRecord.setExcepItemId(lista.get(j).getItemId());
//                           envWarnRecord.setExcepTime(new Date());
//                           envWarnRecord.setExcepItemValue(lista.get(j).getValue());
//                           envWarnRecord.setWarnType("1");
//                           String msg=envWarnRecord.getExcepItemName()+"监测值"+envWarnRecord.getExcepItemValue()+",超出正常范围["+rangeMin+","+rangeMax+"]";
//                           envWarnRecord.setExcepDesc(msg);
//                           warnRecordService.save(envWarnRecord);
//                       }
//                   }else{
//                           //判断
//                           if (num < rangeMin && num > rangeMax
//                                   && lista.get(j).getItemName().equals(pageResult.getRows().get(k).getItemName())
//                                   && list.get(i).getSiteId().equals(pageResult.getRows().get(k).getSiteId())&&pageResult.getRows().get(k).getIsUsed().equals(1)) {
//                               System.out.println("添加报警数据");
//                               EnvWarnRecord envWarnRecord=new EnvWarnRecord();
//                               envWarnRecord.setSiteId(list.get(i).getSiteId());
//                               envWarnRecord.setSiteName(list.get(i).getSiteName());
//                               envWarnRecord.setExcepItemName( lista.get(j).getItemName());
//                               envWarnRecord.setExcepItemId(lista.get(j).getItemId());
//                               envWarnRecord.setExcepTime(new Date());
//                               envWarnRecord.setExcepItemValue(lista.get(j).getValue());
//                               envWarnRecord.setWarnType("1");
//                               String msg=envWarnRecord.getExcepItemName()+"监测值"+envWarnRecord.getExcepItemValue()+",超出正常范围["+rangeMin+","+rangeMax+"]";
//                               envWarnRecord.setExcepDesc(msg);
//                               warnRecordService.save(envWarnRecord);
//                           }
//                   }
//
//               }
//
//           }
//       }
//    }

}
