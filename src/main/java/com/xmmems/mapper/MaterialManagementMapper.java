package com.xmmems.mapper;

import com.xmmems.material.domain.CostSite;
import com.xmmems.material.domain.Inventorydetails;
import com.xmmems.material.domain.MaterialManagement;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MaterialManagementMapper extends Mapper<MaterialManagement> {
    public List<MaterialManagement> num(@Param("name") String name, @Param("siteId") Integer siteId, @Param("type") String type);

    @Select(" select m.*,num FROM (SELECT mid,SUM(num)as num FROM  inventorydetails  where mid=#{mid}  group by mid )as a ,material_management as m where a.mid=m.id")
    public MaterialManagement numBymid(@Param("mid") Integer mid);

    @Select(" SELECT m.siteId ,m.siteName,m.name,  sum(i.consume) as consume,case when m.type ='仪器' THEN sum(f.price*i.consume) when m.type ='试剂' THEN sum(r.price*i.consume)else sum(f.price*i.consume)\n" +
            "\tend as total,\n" +
            "case\n" +
            "\t\twhen m.type ='仪器' THEN f.price\n" +
            "    when m.type ='试剂' THEN r.price\n" +
            "\t\telse f.price\n" +
            "\tend as price\n" +
            " from material_management m LEFT JOIN monitoring_facility f on  m.fid=f.id LEFT  JOIN inventorydetails i on m.id=i.mid  \n" +
            "LEFT  JOIN reagent r on r.id=m.rid  where m.siteId=#{siteId}\n" +
            "GROUP BY m.id\n" +
            "\n" +
            "\n")
    public List<CostSite> costSite(@Param("siteId") Integer siteId);

}
