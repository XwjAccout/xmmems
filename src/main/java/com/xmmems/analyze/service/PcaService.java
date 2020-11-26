package com.xmmems.analyze.service;

import Jama.Matrix;
import com.fasterxml.jackson.core.type.TypeReference;
import com.xmmems.analyze.domain.PCA;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.dto.BaseSiteitemDTO;
import com.xmmems.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


/** 主成分分析
 * 二、算法原理
 * <p>
 * 1、数据准备
 * 假设有M个样本，每个样本有N个特征，例如第i个（i=1,2,…,M）样本为：
 * 这里写图片描述
 * 则M个样本构成了M行N列的数值矩阵A。
 * <p>
 * 2、数据归一化处理
 * 通常做法是将每一维的数据都减去该维的均值，使每一维的均值都为0。
 * <p>
 * 3、计算协方差矩阵
 * 协方差是一种用来度量两个随机变量关系的统计量，其定义为：
 * 这里写图片描述
 * M*N样本的协方差矩阵为：
 * 这里写图片描述
 * 4、求出协方差矩阵的特征值及对应的特征向量
 * 若AX=λX，则称λ是A的特征值，X是对应的特征向量。实际上可以这样理解：矩阵A作用在它的特征向量X上，仅仅使得X的长度发生了变化，缩放比例就是相应的特征值λ。
 * <p>
 * 特别地，当A是对称矩阵时，A的奇异值等于A的特征值，存在正交矩阵Q（Q-1=QT），使得：
 * 这里写图片描述
 * 对A进行奇异值分解就能求出所有特征值和Q矩阵。
 * <p>
 * A∗Q=Q∗DA∗Q=Q∗D,D是由特征值组成的对角矩阵
 * <p>
 * 由特征值和特征向量的定义知，Q的列向量就是A的特征向量。
 * <p>
 * 5、将特征向量按对应的特征值大小从上往下按行排列成矩阵，取前k行组成矩阵P，P为k行n列矩阵
 * <p>
 * 6、Y=AP’ 即为降维到k维后的数据，Y为M行k列矩阵
 */
@Service
@Transactional
public class PcaService {
    @Autowired
    private AnalyzeService analyzeService;
    @Autowired
    private MonitorService monitorService;

    private static final com.fasterxml.jackson.core.type.TypeReference<List<List<List<Double>>>> type = new TypeReference<List<List<List<Double>>>>() {
    };

    private static double[][] dimensionReduction(double[][] doubles) {
        //System.out.println("1、数据准备,获得样本集：" + primaryArray.length + "行，" + primaryArray[0].length + "列");
        //print(primaryArray, 1);

        //2、数据归一化处理
        double[][] averageArray = PCA.changeAverageToZero(doubles);
        //System.out.println("2、数据归一化处理,均值0化后的数据: " + averageArray.length + "行，" + averageArray[0].length + "列");
        //print(averageArray, 2);

        //3、计算协方差矩阵
        double[][] varMatrix = PCA.getVarianceMatrix(averageArray);
        //System.out.println("3、计算协方差矩阵: " + varMatrix.length + "行，" + varMatrix[0].length + "列");
        //print(varMatrix, 10);

        //4、求出协方差矩阵的特征值矩阵及对应的特征向量矩阵
        double[][] eigenvalueMatrix = PCA.getEigenvalueMatrix(varMatrix);
        //System.out.println("4-1、求出协方差矩阵之特征值矩阵: " + eigenvalueMatrix.length + "行，" + eigenvalueMatrix[0].length + "列");
        //print(eigenvalueMatrix, 8);

        double[][] eigenVectorMatrix = PCA.getEigenVectorMatrix(varMatrix);
        //System.out.println("4-2、求出协方差矩阵之特征向量矩阵: " + eigenVectorMatrix.length + "行，" + eigenVectorMatrix[0].length + "列");
        //print(eigenVectorMatrix, 8);

        //System.out.println("5、将特征向量按对应的特征值大小从上往下按行排列成矩阵，取前k行组成矩阵p，得出主成分矩阵(主特征向量): ");
        Matrix principalMatrix = PCA.getPrincipalComponent(eigenvalueMatrix, eigenVectorMatrix);
        //double[][] A = principalMatrix.getArray();  //A
        //int rowDimension = principalMatrix.getRowDimension();  //m
        //int columnDimension = principalMatrix.getColumnDimension();  //n
        //principalMatrix.print(20, 8);

        Matrix resultMatrix = PCA.getResult(averageArray, principalMatrix);
        //System.out.println("6、降维后的矩阵: " + resultMatrix.getRowDimension() + "行," + resultMatrix.getColumnDimension() + "列");
        //resultMatrix.print(4, 8);
        //print(resultMatrix.getArray(), 8);
        double[][] array = resultMatrix.getArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = formatToDouble(array[i][j], 3);
            }
        }

        //减少数据条
        return sub(array);
    }

    //减少数据条数
    private static double[][] sub(double[][] array) {
        if (array.length <= 30) {
            return array;
        } else {
            //取中间30条
            return Arrays.copyOfRange(array, array.length/2 - 15, array.length/2 + 15);
        }
        //return Arrays.copyOfRange(array, 0, 3);

    }

    public static void print(double[][] d, int scale) {
        System.out.println("------------");
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(format(d[i][j], scale) + "\t\t\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        System.out.println();
    }


    private static String format(Object d, int scale) {
        return new BigDecimal(d + "").setScale(scale, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString();
    }

    private static double formatToDouble(double d, int scale) {
        return new BigDecimal(d + "").setScale(scale, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().doubleValue();
    }


    /**
     * 主成分分析
     *
     * @param year        年份
     * @param itemIds     指标id集合
     * @param siteIds     站点id集合
     * @param analyzeType 分析类型 ： 时间分析 空间分析
     * @return pca降维后的结果集合，可能是一维，二维，三维等数组结果
     */
    public Object pca(Integer year, List<Integer> itemIds, List<Integer> siteIds, String analyzeType) {
        Map<String, Map<String, double[][]>> ObjectMap = new HashMap<>();
        for (Integer siteId : siteIds) {
            List<BaseSiteitemDTO> columns = monitorService.getColumns(siteId);
            List<Integer> collect = columns.stream().filter(e -> e.getCode() != null && e.getCode().startsWith("w")).map(BaseSiteitemDTO::getItemId).collect(Collectors.toList());
            List<Integer> realItemIds = collect.stream().filter(itemIds::contains).collect(Collectors.toList());
            // 1、数据准备,获得样本集
            Map<String, List<Object>> stringListMap = analyzeService.clusterGroupByMonth(siteId, year, realItemIds,"聚类分析");
            List<Object> Otimes = stringListMap.get("time");
            List<Object> Odatas = stringListMap.get("data");
            List<String> times = JsonUtils.toList(JsonUtils.toString(Otimes), String.class);
            List<List<List<Double>>> datas = JsonUtils.nativeRead(JsonUtils.toString(Odatas), type);

            //封装需要前端展示的数据
            Map<String, double[][]> tempMap = new HashMap<>();
            for (int i = 0; i < times.size(); i++) {
                String time = times.get(i);
                //System.out.println("开始月份" + time + "的降维：");
                List<List<Double>> lists = datas.get(i);
                double[][] doubles = new double[lists.size()][lists.get(0).size()];
                for (int j = 0; j < lists.size(); j++) {
                    List<Double> list = lists.get(j);
                    doubles[j] = list.stream().mapToDouble(dd -> dd).toArray();
                }
                double[][] pcadoubles = dimensionReduction(doubles);

                tempMap.put(time, pcadoubles);
            }

            String siteName = columns.get(0).getSiteName();
            ObjectMap.put(siteName, tempMap);
        }

        //自定义比较器
        Comparator<Map.Entry<String, double[][]>> valCmp = new Comparator<Map.Entry<String, double[][]>>() {
            @Override
            public int compare(Map.Entry<String, double[][]> o1, Map.Entry<String, double[][]> o2) {
                return o1.getValue()[0].length - o2.getValue()[0].length;  // 降序排序，如果想升序就反过来
            }
        };

        if (analyzeType.equals("时间分析")) {
            //按照主成分个数从小到大
            for (Map.Entry<String, Map<String, double[][]>> entry : ObjectMap.entrySet()) {
                String ksiteName = entry.getKey();
                Map<String, double[][]> vtimes = entry.getValue();
                Map<String, double[][]> temp = new LinkedHashMap<>();

                //将map转成List，map的一组key，value对应list一个存储空间
                ArrayList<Map.Entry<String, double[][]>> list = new ArrayList<>(vtimes.entrySet());//传入maps实体
                list.sort(valCmp); // 注意此处Collections 是java.util包下面的,传入List和自定义的valCmp比较器
                list.forEach(l -> temp.put(l.getKey(), l.getValue()));

                ObjectMap.put(ksiteName, temp);
            }

            //换返回格式
            List<Map<String, Object>> newList = new ArrayList<>();
            for (Map.Entry<String, Map<String, double[][]>> entry : ObjectMap.entrySet()) {
                String key = entry.getKey();
                Map<String, double[][]> value = entry.getValue();
                Map<String, Object> map = new HashMap<>();
                map.put("siteName", key);
                map.put("months", value.keySet());
                map.putAll(value);
                newList.add(map);

            }

            //System.out.println(JsonUtils.toString(newList).getBytes().length);
            return newList;
        } else if (analyzeType.equals("空间分析")) {
            Map<String, Map<String, double[][]>> spacesMap = new HashMap<>();

            ObjectMap.forEach((ksiteName, vtimes) -> {
                vtimes.forEach((kmonth, vp) -> {
                    Map<String, double[][]> stringMap = spacesMap.computeIfAbsent(kmonth, k -> new HashMap<>());
                    stringMap.put(ksiteName, vp);
                });
            });

            //按照主成分个数从小到大
            for (Map.Entry<String, Map<String, double[][]>> entry : spacesMap.entrySet()) {
                String kmonth = entry.getKey();
                Map<String, double[][]> vsites = entry.getValue();
                Map<String, double[][]> temp = new LinkedHashMap<>();

                //将map转成List，map的一组key，value对应list一个存储空间
                ArrayList<Map.Entry<String, double[][]>> list = new ArrayList<>(vsites.entrySet());//传入maps实体
                list.sort(valCmp); // 注意此处Collections 是java.util包下面的,传入List和自定义的valCmp比较器
                list.forEach(l -> temp.put(l.getKey(), l.getValue()));

                spacesMap.put(kmonth, temp);
            }

            //换返回格式
            List<Map<String, Object>> newList = new ArrayList<>();
            for (Map.Entry<String, Map<String, double[][]>> entry : spacesMap.entrySet()) {
                String key = entry.getKey();
                Map<String, double[][]> value = entry.getValue();
                Map<String, Object> map = new HashMap<>();
                map.put("month", key);
                map.put("siteNames", value.keySet());
                map.putAll(value);
                newList.add(map);

            }
            //System.out.println(JsonUtils.toString(newList).getBytes().length);
            return newList;
        }
        return null;
    }
}