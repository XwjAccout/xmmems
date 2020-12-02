package com.xmmems;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.auth.config.JwtProperties;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.DateFormat;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.domain.SimpleHourData;
import com.xmmems.domain.env.EnvHourData;
import com.xmmems.mapper.SimpleHourDataMapper;
import com.xmmems.mapper.EnvHourDataMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
//@org.mybatis.spring.annotation.MapperScan(basePackages = "com.xmmems.mapper")
@MapperScan(basePackages = "com.xmmems.mapper")
@EnableConfigurationProperties({JwtProperties.class})
@EnableScheduling
@EnableAsync
public class XmmemsApplication extends SpringBootServletInitializer {
    Log log = LogFactory.getLog(this.getClass());
    @Autowired
    private SimpleHourDataMapper simpleHourDataMapper;

    @Autowired
    private EnvHourDataMapper envHourDataMapper;

    public static void main(String[] args) {
        //SpringApplication.run(XmmemsApplication.class, args);
        System.setProperty("java.awt.headless", "false");
        //启动项目
        SpringApplicationBuilder builder = new SpringApplicationBuilder(XmmemsApplication.class);
        builder.headless(false);
        builder.run(args);
        //启动界面

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类1
        return builder.sources(XmmemsApplication.class);
    }

    private static final TypeReference<List<Map<String, String>>> type = new TypeReference<List<Map<String, String>>>() {
    };

    /**
     * 将复杂的 env_hour_data 一行小时数据 转存到simhourdata 中成多行同小时不同监测项目数据
     */
    //@Scheduled(fixedRate = 2*60*1000)
    //@Transactional
    public void env_hour_dataToSimhourdata() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        List<EnvHourData> list = envHourDataMapper.select1000();
        list.forEach(temp -> {
            String content = temp.getContent();
            Integer siteId = temp.getSiteId();
            Date genTime = temp.getGenTime();
            String siteName = temp.getSiteName();
            Integer id = temp.getId();

            List<Map<String, String>> items = JsonUtils.nativeRead(content, type);
            if (items != null) {
                String timeStr = DateFormat.formatAll(genTime);
                items.forEach(item -> {
                    String itemId = item.get("itemId");
                    String itemName = item.get("itemName");
                    String troubleCode = item.get("troubleCode");
                    String troubleName = item.get("troubleName");
                    String value = item.get("value");
                    String originValue = item.get("originValue");
                    String code = item.get("code");

                    SimpleHourData record = new SimpleHourData();
                    record.setTime(genTime);
                    record.setSiteId(siteId);
                    record.setItemId(Integer.parseInt(itemId.replace(".0", "")));

                    //根据联合主键（time，siteId，itemId）查询对象，如果存在该对象，则修改数据，如果不存在则新增数据
                   // SimpleHourData simpleHourData = simpleHourDataMapper.selectOne(record);

                    record.setTimeStr(timeStr);
                    record.setSiteName(siteName);
                    record.setItemName(itemName);
                    record.setValue(value);
                    record.setOriginValue(originValue);
                    record.setTroubleCode(troubleCode);
                    record.setTroubleName(troubleName);
                    record.setCode(code);
                    //record.setNumber();

                    try {
                        //if (null == null) {
                            record.setPreValue(value);
                            simpleHourDataMapper.insertSelective(record);
                        //} else {
                            //simpleHourDataMapper.updateByPrimaryKeySelective(record);
                        //}
                    } catch (Exception e) {
                       // throw new XMException(500, "从env_hour_data转换到simhourdata失败,具体信息为" + e.getMessage());
                    }
                });

                int i = envHourDataMapper.updateHandle(id);
                if (i <= 0) {
                    throw new XMException(500, "从env_hour_data转换到simhourdata失败");
                }
            }
        });

        //System.out.println(System.currentTimeMillis()-l);
    }

}
