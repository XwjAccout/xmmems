package com.xmmems.domain.site;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SiteMonitoringExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SiteMonitoringExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNull() {
            addCriterion("siteName is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("siteName is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("siteName =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("siteName <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("siteName >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("siteName >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("siteName <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("siteName <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("siteName like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("siteName not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("siteName in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("siteName not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("siteName between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("siteName not between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andAdIsNull() {
            addCriterion("ad is null");
            return (Criteria) this;
        }

        public Criteria andAdIsNotNull() {
            addCriterion("ad is not null");
            return (Criteria) this;
        }

        public Criteria andAdEqualTo(String value) {
            addCriterion("ad =", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotEqualTo(String value) {
            addCriterion("ad <>", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThan(String value) {
            addCriterion("ad >", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThanOrEqualTo(String value) {
            addCriterion("ad >=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThan(String value) {
            addCriterion("ad <", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThanOrEqualTo(String value) {
            addCriterion("ad <=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLike(String value) {
            addCriterion("ad like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotLike(String value) {
            addCriterion("ad not like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdIn(List<String> values) {
            addCriterion("ad in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotIn(List<String> values) {
            addCriterion("ad not in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdBetween(String value1, String value2) {
            addCriterion("ad between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotBetween(String value1, String value2) {
            addCriterion("ad not between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andDeviceIDIsNull() {
            addCriterion("deviceID is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIDIsNotNull() {
            addCriterion("deviceID is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIDEqualTo(Integer value) {
            addCriterion("deviceID =", value, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDNotEqualTo(Integer value) {
            addCriterion("deviceID <>", value, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDGreaterThan(Integer value) {
            addCriterion("deviceID >", value, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceID >=", value, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDLessThan(Integer value) {
            addCriterion("deviceID <", value, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDLessThanOrEqualTo(Integer value) {
            addCriterion("deviceID <=", value, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDIn(List<Integer> values) {
            addCriterion("deviceID in", values, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDNotIn(List<Integer> values) {
            addCriterion("deviceID not in", values, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDBetween(Integer value1, Integer value2) {
            addCriterion("deviceID between", value1, value2, "deviceID");
            return (Criteria) this;
        }

        public Criteria andDeviceIDNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceID not between", value1, value2, "deviceID");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeIsNull() {
            addCriterion("recordingTime is null");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeIsNotNull() {
            addCriterion("recordingTime is not null");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeEqualTo(Date value) {
            addCriterion("recordingTime =", value, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeNotEqualTo(Date value) {
            addCriterion("recordingTime <>", value, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeGreaterThan(Date value) {
            addCriterion("recordingTime >", value, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recordingTime >=", value, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeLessThan(Date value) {
            addCriterion("recordingTime <", value, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeLessThanOrEqualTo(Date value) {
            addCriterion("recordingTime <=", value, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeIn(List<Date> values) {
            addCriterion("recordingTime in", values, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeNotIn(List<Date> values) {
            addCriterion("recordingTime not in", values, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeBetween(Date value1, Date value2) {
            addCriterion("recordingTime between", value1, value2, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andRecordingTimeNotBetween(Date value1, Date value2) {
            addCriterion("recordingTime not between", value1, value2, "recordingTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeIsNull() {
            addCriterion("moniTime is null");
            return (Criteria) this;
        }

        public Criteria andMoniTimeIsNotNull() {
            addCriterion("moniTime is not null");
            return (Criteria) this;
        }

        public Criteria andMoniTimeEqualTo(Date value) {
            addCriterion("moniTime =", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeNotEqualTo(Date value) {
            addCriterion("moniTime <>", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeGreaterThan(Date value) {
            addCriterion("moniTime >", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("moniTime >=", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeLessThan(Date value) {
            addCriterion("moniTime <", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeLessThanOrEqualTo(Date value) {
            addCriterion("moniTime <=", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeIn(List<Date> values) {
            addCriterion("moniTime in", values, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeNotIn(List<Date> values) {
            addCriterion("moniTime not in", values, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeBetween(Date value1, Date value2) {
            addCriterion("moniTime between", value1, value2, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeNotBetween(Date value1, Date value2) {
            addCriterion("moniTime not between", value1, value2, "moniTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIsNull() {
            addCriterion("equipmentState is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIsNotNull() {
            addCriterion("equipmentState is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateEqualTo(String value) {
            addCriterion("equipmentState =", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotEqualTo(String value) {
            addCriterion("equipmentState <>", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateGreaterThan(String value) {
            addCriterion("equipmentState >", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateGreaterThanOrEqualTo(String value) {
            addCriterion("equipmentState >=", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateLessThan(String value) {
            addCriterion("equipmentState <", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateLessThanOrEqualTo(String value) {
            addCriterion("equipmentState <=", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateLike(String value) {
            addCriterion("equipmentState like", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotLike(String value) {
            addCriterion("equipmentState not like", value, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateIn(List<String> values) {
            addCriterion("equipmentState in", values, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotIn(List<String> values) {
            addCriterion("equipmentState not in", values, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateBetween(String value1, String value2) {
            addCriterion("equipmentState between", value1, value2, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andEquipmentStateNotBetween(String value1, String value2) {
            addCriterion("equipmentState not between", value1, value2, "equipmentState");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusIsNull() {
            addCriterion("communicationStatus is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusIsNotNull() {
            addCriterion("communicationStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusEqualTo(String value) {
            addCriterion("communicationStatus =", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusNotEqualTo(String value) {
            addCriterion("communicationStatus <>", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusGreaterThan(String value) {
            addCriterion("communicationStatus >", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusGreaterThanOrEqualTo(String value) {
            addCriterion("communicationStatus >=", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusLessThan(String value) {
            addCriterion("communicationStatus <", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusLessThanOrEqualTo(String value) {
            addCriterion("communicationStatus <=", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusLike(String value) {
            addCriterion("communicationStatus like", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusNotLike(String value) {
            addCriterion("communicationStatus not like", value, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusIn(List<String> values) {
            addCriterion("communicationStatus in", values, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusNotIn(List<String> values) {
            addCriterion("communicationStatus not in", values, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusBetween(String value1, String value2) {
            addCriterion("communicationStatus between", value1, value2, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andCommunicationStatusNotBetween(String value1, String value2) {
            addCriterion("communicationStatus not between", value1, value2, "communicationStatus");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("dataSource is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("dataSource is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(String value) {
            addCriterion("dataSource =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(String value) {
            addCriterion("dataSource <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(String value) {
            addCriterion("dataSource >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("dataSource >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(String value) {
            addCriterion("dataSource <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(String value) {
            addCriterion("dataSource <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLike(String value) {
            addCriterion("dataSource like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotLike(String value) {
            addCriterion("dataSource not like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<String> values) {
            addCriterion("dataSource in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<String> values) {
            addCriterion("dataSource not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(String value1, String value2) {
            addCriterion("dataSource between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(String value1, String value2) {
            addCriterion("dataSource not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1IsNull() {
            addCriterion("reservedAIN1 is null");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1IsNotNull() {
            addCriterion("reservedAIN1 is not null");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1EqualTo(String value) {
            addCriterion("reservedAIN1 =", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1NotEqualTo(String value) {
            addCriterion("reservedAIN1 <>", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1GreaterThan(String value) {
            addCriterion("reservedAIN1 >", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1GreaterThanOrEqualTo(String value) {
            addCriterion("reservedAIN1 >=", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1LessThan(String value) {
            addCriterion("reservedAIN1 <", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1LessThanOrEqualTo(String value) {
            addCriterion("reservedAIN1 <=", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1Like(String value) {
            addCriterion("reservedAIN1 like", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1NotLike(String value) {
            addCriterion("reservedAIN1 not like", value, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1In(List<String> values) {
            addCriterion("reservedAIN1 in", values, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1NotIn(List<String> values) {
            addCriterion("reservedAIN1 not in", values, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1Between(String value1, String value2) {
            addCriterion("reservedAIN1 between", value1, value2, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andReservedAIN1NotBetween(String value1, String value2) {
            addCriterion("reservedAIN1 not between", value1, value2, "reservedAIN1");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallIsNull() {
            addCriterion("accumulatedRainfall is null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallIsNotNull() {
            addCriterion("accumulatedRainfall is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallEqualTo(String value) {
            addCriterion("accumulatedRainfall =", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallNotEqualTo(String value) {
            addCriterion("accumulatedRainfall <>", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallGreaterThan(String value) {
            addCriterion("accumulatedRainfall >", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallGreaterThanOrEqualTo(String value) {
            addCriterion("accumulatedRainfall >=", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallLessThan(String value) {
            addCriterion("accumulatedRainfall <", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallLessThanOrEqualTo(String value) {
            addCriterion("accumulatedRainfall <=", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallLike(String value) {
            addCriterion("accumulatedRainfall like", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallNotLike(String value) {
            addCriterion("accumulatedRainfall not like", value, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallIn(List<String> values) {
            addCriterion("accumulatedRainfall in", values, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallNotIn(List<String> values) {
            addCriterion("accumulatedRainfall not in", values, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallBetween(String value1, String value2) {
            addCriterion("accumulatedRainfall between", value1, value2, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andAccumulatedRainfallNotBetween(String value1, String value2) {
            addCriterion("accumulatedRainfall not between", value1, value2, "accumulatedRainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityIsNull() {
            addCriterion("rainfallIntensity is null");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityIsNotNull() {
            addCriterion("rainfallIntensity is not null");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityEqualTo(String value) {
            addCriterion("rainfallIntensity =", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityNotEqualTo(String value) {
            addCriterion("rainfallIntensity <>", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityGreaterThan(String value) {
            addCriterion("rainfallIntensity >", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityGreaterThanOrEqualTo(String value) {
            addCriterion("rainfallIntensity >=", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityLessThan(String value) {
            addCriterion("rainfallIntensity <", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityLessThanOrEqualTo(String value) {
            addCriterion("rainfallIntensity <=", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityLike(String value) {
            addCriterion("rainfallIntensity like", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityNotLike(String value) {
            addCriterion("rainfallIntensity not like", value, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityIn(List<String> values) {
            addCriterion("rainfallIntensity in", values, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityNotIn(List<String> values) {
            addCriterion("rainfallIntensity not in", values, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityBetween(String value1, String value2) {
            addCriterion("rainfallIntensity between", value1, value2, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andRainfallIntensityNotBetween(String value1, String value2) {
            addCriterion("rainfallIntensity not between", value1, value2, "rainfallIntensity");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallIsNull() {
            addCriterion("five_minuteRainfall is null");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallIsNotNull() {
            addCriterion("five_minuteRainfall is not null");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallEqualTo(String value) {
            addCriterion("five_minuteRainfall =", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallNotEqualTo(String value) {
            addCriterion("five_minuteRainfall <>", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallGreaterThan(String value) {
            addCriterion("five_minuteRainfall >", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallGreaterThanOrEqualTo(String value) {
            addCriterion("five_minuteRainfall >=", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallLessThan(String value) {
            addCriterion("five_minuteRainfall <", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallLessThanOrEqualTo(String value) {
            addCriterion("five_minuteRainfall <=", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallLike(String value) {
            addCriterion("five_minuteRainfall like", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallNotLike(String value) {
            addCriterion("five_minuteRainfall not like", value, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallIn(List<String> values) {
            addCriterion("five_minuteRainfall in", values, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallNotIn(List<String> values) {
            addCriterion("five_minuteRainfall not in", values, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallBetween(String value1, String value2) {
            addCriterion("five_minuteRainfall between", value1, value2, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andFive_minuteRainfallNotBetween(String value1, String value2) {
            addCriterion("five_minuteRainfall not between", value1, value2, "five_minuteRainfall");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringIsNull() {
            addCriterion("rainfallDuring is null");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringIsNotNull() {
            addCriterion("rainfallDuring is not null");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringEqualTo(String value) {
            addCriterion("rainfallDuring =", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringNotEqualTo(String value) {
            addCriterion("rainfallDuring <>", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringGreaterThan(String value) {
            addCriterion("rainfallDuring >", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringGreaterThanOrEqualTo(String value) {
            addCriterion("rainfallDuring >=", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringLessThan(String value) {
            addCriterion("rainfallDuring <", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringLessThanOrEqualTo(String value) {
            addCriterion("rainfallDuring <=", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringLike(String value) {
            addCriterion("rainfallDuring like", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringNotLike(String value) {
            addCriterion("rainfallDuring not like", value, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringIn(List<String> values) {
            addCriterion("rainfallDuring in", values, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringNotIn(List<String> values) {
            addCriterion("rainfallDuring not in", values, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringBetween(String value1, String value2) {
            addCriterion("rainfallDuring between", value1, value2, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andRainfallDuringNotBetween(String value1, String value2) {
            addCriterion("rainfallDuring not between", value1, value2, "rainfallDuring");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationIsNull() {
            addCriterion("dailyPrecipitation is null");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationIsNotNull() {
            addCriterion("dailyPrecipitation is not null");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationEqualTo(String value) {
            addCriterion("dailyPrecipitation =", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationNotEqualTo(String value) {
            addCriterion("dailyPrecipitation <>", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationGreaterThan(String value) {
            addCriterion("dailyPrecipitation >", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationGreaterThanOrEqualTo(String value) {
            addCriterion("dailyPrecipitation >=", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationLessThan(String value) {
            addCriterion("dailyPrecipitation <", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationLessThanOrEqualTo(String value) {
            addCriterion("dailyPrecipitation <=", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationLike(String value) {
            addCriterion("dailyPrecipitation like", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationNotLike(String value) {
            addCriterion("dailyPrecipitation not like", value, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationIn(List<String> values) {
            addCriterion("dailyPrecipitation in", values, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationNotIn(List<String> values) {
            addCriterion("dailyPrecipitation not in", values, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationBetween(String value1, String value2) {
            addCriterion("dailyPrecipitation between", value1, value2, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andDailyPrecipitationNotBetween(String value1, String value2) {
            addCriterion("dailyPrecipitation not between", value1, value2, "dailyPrecipitation");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallIsNull() {
            addCriterion("ten_dayRainfall is null");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallIsNotNull() {
            addCriterion("ten_dayRainfall is not null");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallEqualTo(String value) {
            addCriterion("ten_dayRainfall =", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallNotEqualTo(String value) {
            addCriterion("ten_dayRainfall <>", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallGreaterThan(String value) {
            addCriterion("ten_dayRainfall >", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallGreaterThanOrEqualTo(String value) {
            addCriterion("ten_dayRainfall >=", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallLessThan(String value) {
            addCriterion("ten_dayRainfall <", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallLessThanOrEqualTo(String value) {
            addCriterion("ten_dayRainfall <=", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallLike(String value) {
            addCriterion("ten_dayRainfall like", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallNotLike(String value) {
            addCriterion("ten_dayRainfall not like", value, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallIn(List<String> values) {
            addCriterion("ten_dayRainfall in", values, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallNotIn(List<String> values) {
            addCriterion("ten_dayRainfall not in", values, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallBetween(String value1, String value2) {
            addCriterion("ten_dayRainfall between", value1, value2, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andTen_dayRainfallNotBetween(String value1, String value2) {
            addCriterion("ten_dayRainfall not between", value1, value2, "ten_dayRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallIsNull() {
            addCriterion("monthlyRainfall is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallIsNotNull() {
            addCriterion("monthlyRainfall is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallEqualTo(String value) {
            addCriterion("monthlyRainfall =", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallNotEqualTo(String value) {
            addCriterion("monthlyRainfall <>", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallGreaterThan(String value) {
            addCriterion("monthlyRainfall >", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallGreaterThanOrEqualTo(String value) {
            addCriterion("monthlyRainfall >=", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallLessThan(String value) {
            addCriterion("monthlyRainfall <", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallLessThanOrEqualTo(String value) {
            addCriterion("monthlyRainfall <=", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallLike(String value) {
            addCriterion("monthlyRainfall like", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallNotLike(String value) {
            addCriterion("monthlyRainfall not like", value, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallIn(List<String> values) {
            addCriterion("monthlyRainfall in", values, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallNotIn(List<String> values) {
            addCriterion("monthlyRainfall not in", values, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallBetween(String value1, String value2) {
            addCriterion("monthlyRainfall between", value1, value2, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andMonthlyRainfallNotBetween(String value1, String value2) {
            addCriterion("monthlyRainfall not between", value1, value2, "monthlyRainfall");
            return (Criteria) this;
        }

        public Criteria andValueCODIsNull() {
            addCriterion("valueCOD is null");
            return (Criteria) this;
        }

        public Criteria andValueCODIsNotNull() {
            addCriterion("valueCOD is not null");
            return (Criteria) this;
        }

        public Criteria andValueCODEqualTo(String value) {
            addCriterion("valueCOD =", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODNotEqualTo(String value) {
            addCriterion("valueCOD <>", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODGreaterThan(String value) {
            addCriterion("valueCOD >", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODGreaterThanOrEqualTo(String value) {
            addCriterion("valueCOD >=", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODLessThan(String value) {
            addCriterion("valueCOD <", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODLessThanOrEqualTo(String value) {
            addCriterion("valueCOD <=", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODLike(String value) {
            addCriterion("valueCOD like", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODNotLike(String value) {
            addCriterion("valueCOD not like", value, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODIn(List<String> values) {
            addCriterion("valueCOD in", values, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODNotIn(List<String> values) {
            addCriterion("valueCOD not in", values, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODBetween(String value1, String value2) {
            addCriterion("valueCOD between", value1, value2, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andValueCODNotBetween(String value1, String value2) {
            addCriterion("valueCOD not between", value1, value2, "valueCOD");
            return (Criteria) this;
        }

        public Criteria andZdzIsNull() {
            addCriterion("zdz is null");
            return (Criteria) this;
        }

        public Criteria andZdzIsNotNull() {
            addCriterion("zdz is not null");
            return (Criteria) this;
        }

        public Criteria andZdzEqualTo(String value) {
            addCriterion("zdz =", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzNotEqualTo(String value) {
            addCriterion("zdz <>", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzGreaterThan(String value) {
            addCriterion("zdz >", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzGreaterThanOrEqualTo(String value) {
            addCriterion("zdz >=", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzLessThan(String value) {
            addCriterion("zdz <", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzLessThanOrEqualTo(String value) {
            addCriterion("zdz <=", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzLike(String value) {
            addCriterion("zdz like", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzNotLike(String value) {
            addCriterion("zdz not like", value, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzIn(List<String> values) {
            addCriterion("zdz in", values, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzNotIn(List<String> values) {
            addCriterion("zdz not in", values, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzBetween(String value1, String value2) {
            addCriterion("zdz between", value1, value2, "zdz");
            return (Criteria) this;
        }

        public Criteria andZdzNotBetween(String value1, String value2) {
            addCriterion("zdz not between", value1, value2, "zdz");
            return (Criteria) this;
        }

        public Criteria andValueTOCIsNull() {
            addCriterion("valueTOC is null");
            return (Criteria) this;
        }

        public Criteria andValueTOCIsNotNull() {
            addCriterion("valueTOC is not null");
            return (Criteria) this;
        }

        public Criteria andValueTOCEqualTo(String value) {
            addCriterion("valueTOC =", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCNotEqualTo(String value) {
            addCriterion("valueTOC <>", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCGreaterThan(String value) {
            addCriterion("valueTOC >", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCGreaterThanOrEqualTo(String value) {
            addCriterion("valueTOC >=", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCLessThan(String value) {
            addCriterion("valueTOC <", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCLessThanOrEqualTo(String value) {
            addCriterion("valueTOC <=", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCLike(String value) {
            addCriterion("valueTOC like", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCNotLike(String value) {
            addCriterion("valueTOC not like", value, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCIn(List<String> values) {
            addCriterion("valueTOC in", values, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCNotIn(List<String> values) {
            addCriterion("valueTOC not in", values, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCBetween(String value1, String value2) {
            addCriterion("valueTOC between", value1, value2, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andValueTOCNotBetween(String value1, String value2) {
            addCriterion("valueTOC not between", value1, value2, "valueTOC");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureIsNull() {
            addCriterion("probeTemperature is null");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureIsNotNull() {
            addCriterion("probeTemperature is not null");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureEqualTo(String value) {
            addCriterion("probeTemperature =", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureNotEqualTo(String value) {
            addCriterion("probeTemperature <>", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureGreaterThan(String value) {
            addCriterion("probeTemperature >", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("probeTemperature >=", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureLessThan(String value) {
            addCriterion("probeTemperature <", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureLessThanOrEqualTo(String value) {
            addCriterion("probeTemperature <=", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureLike(String value) {
            addCriterion("probeTemperature like", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureNotLike(String value) {
            addCriterion("probeTemperature not like", value, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureIn(List<String> values) {
            addCriterion("probeTemperature in", values, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureNotIn(List<String> values) {
            addCriterion("probeTemperature not in", values, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureBetween(String value1, String value2) {
            addCriterion("probeTemperature between", value1, value2, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andProbeTemperatureNotBetween(String value1, String value2) {
            addCriterion("probeTemperature not between", value1, value2, "probeTemperature");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureIsNull() {
            addCriterion("atmosphericPressure is null");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureIsNotNull() {
            addCriterion("atmosphericPressure is not null");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureEqualTo(String value) {
            addCriterion("atmosphericPressure =", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureNotEqualTo(String value) {
            addCriterion("atmosphericPressure <>", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureGreaterThan(String value) {
            addCriterion("atmosphericPressure >", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureGreaterThanOrEqualTo(String value) {
            addCriterion("atmosphericPressure >=", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureLessThan(String value) {
            addCriterion("atmosphericPressure <", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureLessThanOrEqualTo(String value) {
            addCriterion("atmosphericPressure <=", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureLike(String value) {
            addCriterion("atmosphericPressure like", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureNotLike(String value) {
            addCriterion("atmosphericPressure not like", value, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureIn(List<String> values) {
            addCriterion("atmosphericPressure in", values, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureNotIn(List<String> values) {
            addCriterion("atmosphericPressure not in", values, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureBetween(String value1, String value2) {
            addCriterion("atmosphericPressure between", value1, value2, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andAtmosphericPressureNotBetween(String value1, String value2) {
            addCriterion("atmosphericPressure not between", value1, value2, "atmosphericPressure");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageIsNull() {
            addCriterion("batteryPercentage is null");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageIsNotNull() {
            addCriterion("batteryPercentage is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageEqualTo(String value) {
            addCriterion("batteryPercentage =", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageNotEqualTo(String value) {
            addCriterion("batteryPercentage <>", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageGreaterThan(String value) {
            addCriterion("batteryPercentage >", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageGreaterThanOrEqualTo(String value) {
            addCriterion("batteryPercentage >=", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageLessThan(String value) {
            addCriterion("batteryPercentage <", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageLessThanOrEqualTo(String value) {
            addCriterion("batteryPercentage <=", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageLike(String value) {
            addCriterion("batteryPercentage like", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageNotLike(String value) {
            addCriterion("batteryPercentage not like", value, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageIn(List<String> values) {
            addCriterion("batteryPercentage in", values, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageNotIn(List<String> values) {
            addCriterion("batteryPercentage not in", values, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageBetween(String value1, String value2) {
            addCriterion("batteryPercentage between", value1, value2, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andBatteryPercentageNotBetween(String value1, String value2) {
            addCriterion("batteryPercentage not between", value1, value2, "batteryPercentage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageIsNull() {
            addCriterion("externalVoltage is null");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageIsNotNull() {
            addCriterion("externalVoltage is not null");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageEqualTo(String value) {
            addCriterion("externalVoltage =", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageNotEqualTo(String value) {
            addCriterion("externalVoltage <>", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageGreaterThan(String value) {
            addCriterion("externalVoltage >", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("externalVoltage >=", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageLessThan(String value) {
            addCriterion("externalVoltage <", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageLessThanOrEqualTo(String value) {
            addCriterion("externalVoltage <=", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageLike(String value) {
            addCriterion("externalVoltage like", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageNotLike(String value) {
            addCriterion("externalVoltage not like", value, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageIn(List<String> values) {
            addCriterion("externalVoltage in", values, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageNotIn(List<String> values) {
            addCriterion("externalVoltage not in", values, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageBetween(String value1, String value2) {
            addCriterion("externalVoltage between", value1, value2, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andExternalVoltageNotBetween(String value1, String value2) {
            addCriterion("externalVoltage not between", value1, value2, "externalVoltage");
            return (Criteria) this;
        }

        public Criteria andPressureIsNull() {
            addCriterion("pressure is null");
            return (Criteria) this;
        }

        public Criteria andPressureIsNotNull() {
            addCriterion("pressure is not null");
            return (Criteria) this;
        }

        public Criteria andPressureEqualTo(String value) {
            addCriterion("pressure =", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotEqualTo(String value) {
            addCriterion("pressure <>", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureGreaterThan(String value) {
            addCriterion("pressure >", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureGreaterThanOrEqualTo(String value) {
            addCriterion("pressure >=", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLessThan(String value) {
            addCriterion("pressure <", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLessThanOrEqualTo(String value) {
            addCriterion("pressure <=", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureLike(String value) {
            addCriterion("pressure like", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotLike(String value) {
            addCriterion("pressure not like", value, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureIn(List<String> values) {
            addCriterion("pressure in", values, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotIn(List<String> values) {
            addCriterion("pressure not in", values, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureBetween(String value1, String value2) {
            addCriterion("pressure between", value1, value2, "pressure");
            return (Criteria) this;
        }

        public Criteria andPressureNotBetween(String value1, String value2) {
            addCriterion("pressure not between", value1, value2, "pressure");
            return (Criteria) this;
        }

        public Criteria andDepthIsNull() {
            addCriterion("depth is null");
            return (Criteria) this;
        }

        public Criteria andDepthIsNotNull() {
            addCriterion("depth is not null");
            return (Criteria) this;
        }

        public Criteria andDepthEqualTo(String value) {
            addCriterion("depth =", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotEqualTo(String value) {
            addCriterion("depth <>", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThan(String value) {
            addCriterion("depth >", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthGreaterThanOrEqualTo(String value) {
            addCriterion("depth >=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThan(String value) {
            addCriterion("depth <", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLessThanOrEqualTo(String value) {
            addCriterion("depth <=", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthLike(String value) {
            addCriterion("depth like", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotLike(String value) {
            addCriterion("depth not like", value, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthIn(List<String> values) {
            addCriterion("depth in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotIn(List<String> values) {
            addCriterion("depth not in", values, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthBetween(String value1, String value2) {
            addCriterion("depth between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andDepthNotBetween(String value1, String value2) {
            addCriterion("depth not between", value1, value2, "depth");
            return (Criteria) this;
        }

        public Criteria andRjyIsNull() {
            addCriterion("rjy is null");
            return (Criteria) this;
        }

        public Criteria andRjyIsNotNull() {
            addCriterion("rjy is not null");
            return (Criteria) this;
        }

        public Criteria andRjyEqualTo(String value) {
            addCriterion("rjy =", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotEqualTo(String value) {
            addCriterion("rjy <>", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyGreaterThan(String value) {
            addCriterion("rjy >", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyGreaterThanOrEqualTo(String value) {
            addCriterion("rjy >=", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLessThan(String value) {
            addCriterion("rjy <", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLessThanOrEqualTo(String value) {
            addCriterion("rjy <=", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLike(String value) {
            addCriterion("rjy like", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotLike(String value) {
            addCriterion("rjy not like", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyIn(List<String> values) {
            addCriterion("rjy in", values, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotIn(List<String> values) {
            addCriterion("rjy not in", values, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyBetween(String value1, String value2) {
            addCriterion("rjy between", value1, value2, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotBetween(String value1, String value2) {
            addCriterion("rjy not between", value1, value2, "rjy");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureIsNull() {
            addCriterion("oxygenPartialPressure is null");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureIsNotNull() {
            addCriterion("oxygenPartialPressure is not null");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureEqualTo(String value) {
            addCriterion("oxygenPartialPressure =", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureNotEqualTo(String value) {
            addCriterion("oxygenPartialPressure <>", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureGreaterThan(String value) {
            addCriterion("oxygenPartialPressure >", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureGreaterThanOrEqualTo(String value) {
            addCriterion("oxygenPartialPressure >=", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureLessThan(String value) {
            addCriterion("oxygenPartialPressure <", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureLessThanOrEqualTo(String value) {
            addCriterion("oxygenPartialPressure <=", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureLike(String value) {
            addCriterion("oxygenPartialPressure like", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureNotLike(String value) {
            addCriterion("oxygenPartialPressure not like", value, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureIn(List<String> values) {
            addCriterion("oxygenPartialPressure in", values, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureNotIn(List<String> values) {
            addCriterion("oxygenPartialPressure not in", values, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureBetween(String value1, String value2) {
            addCriterion("oxygenPartialPressure between", value1, value2, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andOxygenPartialPressureNotBetween(String value1, String value2) {
            addCriterion("oxygenPartialPressure not between", value1, value2, "oxygenPartialPressure");
            return (Criteria) this;
        }

        public Criteria andZdIsNull() {
            addCriterion("zd is null");
            return (Criteria) this;
        }

        public Criteria andZdIsNotNull() {
            addCriterion("zd is not null");
            return (Criteria) this;
        }

        public Criteria andZdEqualTo(String value) {
            addCriterion("zd =", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotEqualTo(String value) {
            addCriterion("zd <>", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdGreaterThan(String value) {
            addCriterion("zd >", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdGreaterThanOrEqualTo(String value) {
            addCriterion("zd >=", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdLessThan(String value) {
            addCriterion("zd <", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdLessThanOrEqualTo(String value) {
            addCriterion("zd <=", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdLike(String value) {
            addCriterion("zd like", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotLike(String value) {
            addCriterion("zd not like", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdIn(List<String> values) {
            addCriterion("zd in", values, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotIn(List<String> values) {
            addCriterion("zd not in", values, "zd");
            return (Criteria) this;
        }

        public Criteria andZdBetween(String value1, String value2) {
            addCriterion("zd between", value1, value2, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotBetween(String value1, String value2) {
            addCriterion("zd not between", value1, value2, "zd");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andDdlIsNull() {
            addCriterion("ddl is null");
            return (Criteria) this;
        }

        public Criteria andDdlIsNotNull() {
            addCriterion("ddl is not null");
            return (Criteria) this;
        }

        public Criteria andDdlEqualTo(String value) {
            addCriterion("ddl =", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotEqualTo(String value) {
            addCriterion("ddl <>", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThan(String value) {
            addCriterion("ddl >", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThanOrEqualTo(String value) {
            addCriterion("ddl >=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThan(String value) {
            addCriterion("ddl <", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThanOrEqualTo(String value) {
            addCriterion("ddl <=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLike(String value) {
            addCriterion("ddl like", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotLike(String value) {
            addCriterion("ddl not like", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlIn(List<String> values) {
            addCriterion("ddl in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotIn(List<String> values) {
            addCriterion("ddl not in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlBetween(String value1, String value2) {
            addCriterion("ddl between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotBetween(String value1, String value2) {
            addCriterion("ddl not between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andSalinityIsNull() {
            addCriterion("salinity is null");
            return (Criteria) this;
        }

        public Criteria andSalinityIsNotNull() {
            addCriterion("salinity is not null");
            return (Criteria) this;
        }

        public Criteria andSalinityEqualTo(String value) {
            addCriterion("salinity =", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityNotEqualTo(String value) {
            addCriterion("salinity <>", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityGreaterThan(String value) {
            addCriterion("salinity >", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityGreaterThanOrEqualTo(String value) {
            addCriterion("salinity >=", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityLessThan(String value) {
            addCriterion("salinity <", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityLessThanOrEqualTo(String value) {
            addCriterion("salinity <=", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityLike(String value) {
            addCriterion("salinity like", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityNotLike(String value) {
            addCriterion("salinity not like", value, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityIn(List<String> values) {
            addCriterion("salinity in", values, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityNotIn(List<String> values) {
            addCriterion("salinity not in", values, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityBetween(String value1, String value2) {
            addCriterion("salinity between", value1, value2, "salinity");
            return (Criteria) this;
        }

        public Criteria andSalinityNotBetween(String value1, String value2) {
            addCriterion("salinity not between", value1, value2, "salinity");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidIsNull() {
            addCriterion("totalDissolvedSolid is null");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidIsNotNull() {
            addCriterion("totalDissolvedSolid is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidEqualTo(String value) {
            addCriterion("totalDissolvedSolid =", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidNotEqualTo(String value) {
            addCriterion("totalDissolvedSolid <>", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidGreaterThan(String value) {
            addCriterion("totalDissolvedSolid >", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidGreaterThanOrEqualTo(String value) {
            addCriterion("totalDissolvedSolid >=", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidLessThan(String value) {
            addCriterion("totalDissolvedSolid <", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidLessThanOrEqualTo(String value) {
            addCriterion("totalDissolvedSolid <=", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidLike(String value) {
            addCriterion("totalDissolvedSolid like", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidNotLike(String value) {
            addCriterion("totalDissolvedSolid not like", value, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidIn(List<String> values) {
            addCriterion("totalDissolvedSolid in", values, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidNotIn(List<String> values) {
            addCriterion("totalDissolvedSolid not in", values, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidBetween(String value1, String value2) {
            addCriterion("totalDissolvedSolid between", value1, value2, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andTotalDissolvedSolidNotBetween(String value1, String value2) {
            addCriterion("totalDissolvedSolid not between", value1, value2, "totalDissolvedSolid");
            return (Criteria) this;
        }

        public Criteria andResistivityIsNull() {
            addCriterion("resistivity is null");
            return (Criteria) this;
        }

        public Criteria andResistivityIsNotNull() {
            addCriterion("resistivity is not null");
            return (Criteria) this;
        }

        public Criteria andResistivityEqualTo(String value) {
            addCriterion("resistivity =", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityNotEqualTo(String value) {
            addCriterion("resistivity <>", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityGreaterThan(String value) {
            addCriterion("resistivity >", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityGreaterThanOrEqualTo(String value) {
            addCriterion("resistivity >=", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityLessThan(String value) {
            addCriterion("resistivity <", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityLessThanOrEqualTo(String value) {
            addCriterion("resistivity <=", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityLike(String value) {
            addCriterion("resistivity like", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityNotLike(String value) {
            addCriterion("resistivity not like", value, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityIn(List<String> values) {
            addCriterion("resistivity in", values, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityNotIn(List<String> values) {
            addCriterion("resistivity not in", values, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityBetween(String value1, String value2) {
            addCriterion("resistivity between", value1, value2, "resistivity");
            return (Criteria) this;
        }

        public Criteria andResistivityNotBetween(String value1, String value2) {
            addCriterion("resistivity not between", value1, value2, "resistivity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityIsNull() {
            addCriterion("waterDensity is null");
            return (Criteria) this;
        }

        public Criteria andWaterDensityIsNotNull() {
            addCriterion("waterDensity is not null");
            return (Criteria) this;
        }

        public Criteria andWaterDensityEqualTo(String value) {
            addCriterion("waterDensity =", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityNotEqualTo(String value) {
            addCriterion("waterDensity <>", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityGreaterThan(String value) {
            addCriterion("waterDensity >", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityGreaterThanOrEqualTo(String value) {
            addCriterion("waterDensity >=", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityLessThan(String value) {
            addCriterion("waterDensity <", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityLessThanOrEqualTo(String value) {
            addCriterion("waterDensity <=", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityLike(String value) {
            addCriterion("waterDensity like", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityNotLike(String value) {
            addCriterion("waterDensity not like", value, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityIn(List<String> values) {
            addCriterion("waterDensity in", values, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityNotIn(List<String> values) {
            addCriterion("waterDensity not in", values, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityBetween(String value1, String value2) {
            addCriterion("waterDensity between", value1, value2, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andWaterDensityNotBetween(String value1, String value2) {
            addCriterion("waterDensity not between", value1, value2, "waterDensity");
            return (Criteria) this;
        }

        public Criteria andPhIsNull() {
            addCriterion("ph is null");
            return (Criteria) this;
        }

        public Criteria andPhIsNotNull() {
            addCriterion("ph is not null");
            return (Criteria) this;
        }

        public Criteria andPhEqualTo(String value) {
            addCriterion("ph =", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotEqualTo(String value) {
            addCriterion("ph <>", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThan(String value) {
            addCriterion("ph >", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThanOrEqualTo(String value) {
            addCriterion("ph >=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThan(String value) {
            addCriterion("ph <", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThanOrEqualTo(String value) {
            addCriterion("ph <=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLike(String value) {
            addCriterion("ph like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotLike(String value) {
            addCriterion("ph not like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhIn(List<String> values) {
            addCriterion("ph in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotIn(List<String> values) {
            addCriterion("ph not in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhBetween(String value1, String value2) {
            addCriterion("ph between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotBetween(String value1, String value2) {
            addCriterion("ph not between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXIsNull() {
            addCriterion("potentialREDOX is null");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXIsNotNull() {
            addCriterion("potentialREDOX is not null");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXEqualTo(String value) {
            addCriterion("potentialREDOX =", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXNotEqualTo(String value) {
            addCriterion("potentialREDOX <>", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXGreaterThan(String value) {
            addCriterion("potentialREDOX >", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXGreaterThanOrEqualTo(String value) {
            addCriterion("potentialREDOX >=", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXLessThan(String value) {
            addCriterion("potentialREDOX <", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXLessThanOrEqualTo(String value) {
            addCriterion("potentialREDOX <=", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXLike(String value) {
            addCriterion("potentialREDOX like", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXNotLike(String value) {
            addCriterion("potentialREDOX not like", value, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXIn(List<String> values) {
            addCriterion("potentialREDOX in", values, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXNotIn(List<String> values) {
            addCriterion("potentialREDOX not in", values, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXBetween(String value1, String value2) {
            addCriterion("potentialREDOX between", value1, value2, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andPotentialREDOXNotBetween(String value1, String value2) {
            addCriterion("potentialREDOX not between", value1, value2, "potentialREDOX");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultIsNull() {
            addCriterion("rainGaugeFault is null");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultIsNotNull() {
            addCriterion("rainGaugeFault is not null");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultEqualTo(String value) {
            addCriterion("rainGaugeFault =", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultNotEqualTo(String value) {
            addCriterion("rainGaugeFault <>", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultGreaterThan(String value) {
            addCriterion("rainGaugeFault >", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultGreaterThanOrEqualTo(String value) {
            addCriterion("rainGaugeFault >=", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultLessThan(String value) {
            addCriterion("rainGaugeFault <", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultLessThanOrEqualTo(String value) {
            addCriterion("rainGaugeFault <=", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultLike(String value) {
            addCriterion("rainGaugeFault like", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultNotLike(String value) {
            addCriterion("rainGaugeFault not like", value, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultIn(List<String> values) {
            addCriterion("rainGaugeFault in", values, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultNotIn(List<String> values) {
            addCriterion("rainGaugeFault not in", values, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultBetween(String value1, String value2) {
            addCriterion("rainGaugeFault between", value1, value2, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainGaugeFaultNotBetween(String value1, String value2) {
            addCriterion("rainGaugeFault not between", value1, value2, "rainGaugeFault");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressIsNull() {
            addCriterion("rainClearAddress is null");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressIsNotNull() {
            addCriterion("rainClearAddress is not null");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressEqualTo(String value) {
            addCriterion("rainClearAddress =", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressNotEqualTo(String value) {
            addCriterion("rainClearAddress <>", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressGreaterThan(String value) {
            addCriterion("rainClearAddress >", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressGreaterThanOrEqualTo(String value) {
            addCriterion("rainClearAddress >=", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressLessThan(String value) {
            addCriterion("rainClearAddress <", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressLessThanOrEqualTo(String value) {
            addCriterion("rainClearAddress <=", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressLike(String value) {
            addCriterion("rainClearAddress like", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressNotLike(String value) {
            addCriterion("rainClearAddress not like", value, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressIn(List<String> values) {
            addCriterion("rainClearAddress in", values, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressNotIn(List<String> values) {
            addCriterion("rainClearAddress not in", values, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressBetween(String value1, String value2) {
            addCriterion("rainClearAddress between", value1, value2, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andRainClearAddressNotBetween(String value1, String value2) {
            addCriterion("rainClearAddress not between", value1, value2, "rainClearAddress");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerIsNull() {
            addCriterion("communicationFailureCODanalyzer is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerIsNotNull() {
            addCriterion("communicationFailureCODanalyzer is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerEqualTo(String value) {
            addCriterion("communicationFailureCODanalyzer =", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerNotEqualTo(String value) {
            addCriterion("communicationFailureCODanalyzer <>", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerGreaterThan(String value) {
            addCriterion("communicationFailureCODanalyzer >", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerGreaterThanOrEqualTo(String value) {
            addCriterion("communicationFailureCODanalyzer >=", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerLessThan(String value) {
            addCriterion("communicationFailureCODanalyzer <", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerLessThanOrEqualTo(String value) {
            addCriterion("communicationFailureCODanalyzer <=", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerLike(String value) {
            addCriterion("communicationFailureCODanalyzer like", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerNotLike(String value) {
            addCriterion("communicationFailureCODanalyzer not like", value, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerIn(List<String> values) {
            addCriterion("communicationFailureCODanalyzer in", values, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerNotIn(List<String> values) {
            addCriterion("communicationFailureCODanalyzer not in", values, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerBetween(String value1, String value2) {
            addCriterion("communicationFailureCODanalyzer between", value1, value2, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andCommunicationFailureCODanalyzerNotBetween(String value1, String value2) {
            addCriterion("communicationFailureCODanalyzer not between", value1, value2, "communicationFailureCODanalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerIsNull() {
            addCriterion("waterQualityAnalyzer is null");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerIsNotNull() {
            addCriterion("waterQualityAnalyzer is not null");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerEqualTo(String value) {
            addCriterion("waterQualityAnalyzer =", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerNotEqualTo(String value) {
            addCriterion("waterQualityAnalyzer <>", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerGreaterThan(String value) {
            addCriterion("waterQualityAnalyzer >", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerGreaterThanOrEqualTo(String value) {
            addCriterion("waterQualityAnalyzer >=", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerLessThan(String value) {
            addCriterion("waterQualityAnalyzer <", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerLessThanOrEqualTo(String value) {
            addCriterion("waterQualityAnalyzer <=", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerLike(String value) {
            addCriterion("waterQualityAnalyzer like", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerNotLike(String value) {
            addCriterion("waterQualityAnalyzer not like", value, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerIn(List<String> values) {
            addCriterion("waterQualityAnalyzer in", values, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerNotIn(List<String> values) {
            addCriterion("waterQualityAnalyzer not in", values, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerBetween(String value1, String value2) {
            addCriterion("waterQualityAnalyzer between", value1, value2, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterQualityAnalyzerNotBetween(String value1, String value2) {
            addCriterion("waterQualityAnalyzer not between", value1, value2, "waterQualityAnalyzer");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmIsNull() {
            addCriterion("waterUpLevelAlarm is null");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmIsNotNull() {
            addCriterion("waterUpLevelAlarm is not null");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmEqualTo(String value) {
            addCriterion("waterUpLevelAlarm =", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmNotEqualTo(String value) {
            addCriterion("waterUpLevelAlarm <>", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmGreaterThan(String value) {
            addCriterion("waterUpLevelAlarm >", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmGreaterThanOrEqualTo(String value) {
            addCriterion("waterUpLevelAlarm >=", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmLessThan(String value) {
            addCriterion("waterUpLevelAlarm <", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmLessThanOrEqualTo(String value) {
            addCriterion("waterUpLevelAlarm <=", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmLike(String value) {
            addCriterion("waterUpLevelAlarm like", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmNotLike(String value) {
            addCriterion("waterUpLevelAlarm not like", value, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmIn(List<String> values) {
            addCriterion("waterUpLevelAlarm in", values, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmNotIn(List<String> values) {
            addCriterion("waterUpLevelAlarm not in", values, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmBetween(String value1, String value2) {
            addCriterion("waterUpLevelAlarm between", value1, value2, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterUpLevelAlarmNotBetween(String value1, String value2) {
            addCriterion("waterUpLevelAlarm not between", value1, value2, "waterUpLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmIsNull() {
            addCriterion("waterDownLevelAlarm is null");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmIsNotNull() {
            addCriterion("waterDownLevelAlarm is not null");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmEqualTo(String value) {
            addCriterion("waterDownLevelAlarm =", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmNotEqualTo(String value) {
            addCriterion("waterDownLevelAlarm <>", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmGreaterThan(String value) {
            addCriterion("waterDownLevelAlarm >", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmGreaterThanOrEqualTo(String value) {
            addCriterion("waterDownLevelAlarm >=", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmLessThan(String value) {
            addCriterion("waterDownLevelAlarm <", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmLessThanOrEqualTo(String value) {
            addCriterion("waterDownLevelAlarm <=", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmLike(String value) {
            addCriterion("waterDownLevelAlarm like", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmNotLike(String value) {
            addCriterion("waterDownLevelAlarm not like", value, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmIn(List<String> values) {
            addCriterion("waterDownLevelAlarm in", values, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmNotIn(List<String> values) {
            addCriterion("waterDownLevelAlarm not in", values, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmBetween(String value1, String value2) {
            addCriterion("waterDownLevelAlarm between", value1, value2, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andWaterDownLevelAlarmNotBetween(String value1, String value2) {
            addCriterion("waterDownLevelAlarm not between", value1, value2, "waterDownLevelAlarm");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchIsNull() {
            addCriterion("doorSwitch is null");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchIsNotNull() {
            addCriterion("doorSwitch is not null");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchEqualTo(String value) {
            addCriterion("doorSwitch =", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchNotEqualTo(String value) {
            addCriterion("doorSwitch <>", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchGreaterThan(String value) {
            addCriterion("doorSwitch >", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchGreaterThanOrEqualTo(String value) {
            addCriterion("doorSwitch >=", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchLessThan(String value) {
            addCriterion("doorSwitch <", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchLessThanOrEqualTo(String value) {
            addCriterion("doorSwitch <=", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchLike(String value) {
            addCriterion("doorSwitch like", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchNotLike(String value) {
            addCriterion("doorSwitch not like", value, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchIn(List<String> values) {
            addCriterion("doorSwitch in", values, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchNotIn(List<String> values) {
            addCriterion("doorSwitch not in", values, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchBetween(String value1, String value2) {
            addCriterion("doorSwitch between", value1, value2, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andDoorSwitchNotBetween(String value1, String value2) {
            addCriterion("doorSwitch not between", value1, value2, "doorSwitch");
            return (Criteria) this;
        }

        public Criteria andPowerDetectIsNull() {
            addCriterion("powerDetect is null");
            return (Criteria) this;
        }

        public Criteria andPowerDetectIsNotNull() {
            addCriterion("powerDetect is not null");
            return (Criteria) this;
        }

        public Criteria andPowerDetectEqualTo(String value) {
            addCriterion("powerDetect =", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectNotEqualTo(String value) {
            addCriterion("powerDetect <>", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectGreaterThan(String value) {
            addCriterion("powerDetect >", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectGreaterThanOrEqualTo(String value) {
            addCriterion("powerDetect >=", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectLessThan(String value) {
            addCriterion("powerDetect <", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectLessThanOrEqualTo(String value) {
            addCriterion("powerDetect <=", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectLike(String value) {
            addCriterion("powerDetect like", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectNotLike(String value) {
            addCriterion("powerDetect not like", value, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectIn(List<String> values) {
            addCriterion("powerDetect in", values, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectNotIn(List<String> values) {
            addCriterion("powerDetect not in", values, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectBetween(String value1, String value2) {
            addCriterion("powerDetect between", value1, value2, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andPowerDetectNotBetween(String value1, String value2) {
            addCriterion("powerDetect not between", value1, value2, "powerDetect");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1IsNull() {
            addCriterion("faultAIN1 is null");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1IsNotNull() {
            addCriterion("faultAIN1 is not null");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1EqualTo(String value) {
            addCriterion("faultAIN1 =", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1NotEqualTo(String value) {
            addCriterion("faultAIN1 <>", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1GreaterThan(String value) {
            addCriterion("faultAIN1 >", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1GreaterThanOrEqualTo(String value) {
            addCriterion("faultAIN1 >=", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1LessThan(String value) {
            addCriterion("faultAIN1 <", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1LessThanOrEqualTo(String value) {
            addCriterion("faultAIN1 <=", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1Like(String value) {
            addCriterion("faultAIN1 like", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1NotLike(String value) {
            addCriterion("faultAIN1 not like", value, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1In(List<String> values) {
            addCriterion("faultAIN1 in", values, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1NotIn(List<String> values) {
            addCriterion("faultAIN1 not in", values, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1Between(String value1, String value2) {
            addCriterion("faultAIN1 between", value1, value2, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andFaultAIN1NotBetween(String value1, String value2) {
            addCriterion("faultAIN1 not between", value1, value2, "faultAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1IsNull() {
            addCriterion("upperLimitAlarmAIN1 is null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1IsNotNull() {
            addCriterion("upperLimitAlarmAIN1 is not null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1EqualTo(String value) {
            addCriterion("upperLimitAlarmAIN1 =", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1NotEqualTo(String value) {
            addCriterion("upperLimitAlarmAIN1 <>", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1GreaterThan(String value) {
            addCriterion("upperLimitAlarmAIN1 >", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1GreaterThanOrEqualTo(String value) {
            addCriterion("upperLimitAlarmAIN1 >=", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1LessThan(String value) {
            addCriterion("upperLimitAlarmAIN1 <", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1LessThanOrEqualTo(String value) {
            addCriterion("upperLimitAlarmAIN1 <=", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1Like(String value) {
            addCriterion("upperLimitAlarmAIN1 like", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1NotLike(String value) {
            addCriterion("upperLimitAlarmAIN1 not like", value, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1In(List<String> values) {
            addCriterion("upperLimitAlarmAIN1 in", values, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1NotIn(List<String> values) {
            addCriterion("upperLimitAlarmAIN1 not in", values, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1Between(String value1, String value2) {
            addCriterion("upperLimitAlarmAIN1 between", value1, value2, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAlarmAIN1NotBetween(String value1, String value2) {
            addCriterion("upperLimitAlarmAIN1 not between", value1, value2, "upperLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1IsNull() {
            addCriterion("lowerLimitAlarmAIN1 is null");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1IsNotNull() {
            addCriterion("lowerLimitAlarmAIN1 is not null");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1EqualTo(String value) {
            addCriterion("lowerLimitAlarmAIN1 =", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1NotEqualTo(String value) {
            addCriterion("lowerLimitAlarmAIN1 <>", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1GreaterThan(String value) {
            addCriterion("lowerLimitAlarmAIN1 >", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1GreaterThanOrEqualTo(String value) {
            addCriterion("lowerLimitAlarmAIN1 >=", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1LessThan(String value) {
            addCriterion("lowerLimitAlarmAIN1 <", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1LessThanOrEqualTo(String value) {
            addCriterion("lowerLimitAlarmAIN1 <=", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1Like(String value) {
            addCriterion("lowerLimitAlarmAIN1 like", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1NotLike(String value) {
            addCriterion("lowerLimitAlarmAIN1 not like", value, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1In(List<String> values) {
            addCriterion("lowerLimitAlarmAIN1 in", values, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1NotIn(List<String> values) {
            addCriterion("lowerLimitAlarmAIN1 not in", values, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1Between(String value1, String value2) {
            addCriterion("lowerLimitAlarmAIN1 between", value1, value2, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAlarmAIN1NotBetween(String value1, String value2) {
            addCriterion("lowerLimitAlarmAIN1 not between", value1, value2, "lowerLimitAlarmAIN1");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateIsNull() {
            addCriterion("waterLevelState is null");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateIsNotNull() {
            addCriterion("waterLevelState is not null");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateEqualTo(String value) {
            addCriterion("waterLevelState =", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateNotEqualTo(String value) {
            addCriterion("waterLevelState <>", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateGreaterThan(String value) {
            addCriterion("waterLevelState >", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateGreaterThanOrEqualTo(String value) {
            addCriterion("waterLevelState >=", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateLessThan(String value) {
            addCriterion("waterLevelState <", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateLessThanOrEqualTo(String value) {
            addCriterion("waterLevelState <=", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateLike(String value) {
            addCriterion("waterLevelState like", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateNotLike(String value) {
            addCriterion("waterLevelState not like", value, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateIn(List<String> values) {
            addCriterion("waterLevelState in", values, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateNotIn(List<String> values) {
            addCriterion("waterLevelState not in", values, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateBetween(String value1, String value2) {
            addCriterion("waterLevelState between", value1, value2, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelStateNotBetween(String value1, String value2) {
            addCriterion("waterLevelState not between", value1, value2, "waterLevelState");
            return (Criteria) this;
        }

        public Criteria andWaterLevelIsNull() {
            addCriterion("waterLevel is null");
            return (Criteria) this;
        }

        public Criteria andWaterLevelIsNotNull() {
            addCriterion("waterLevel is not null");
            return (Criteria) this;
        }

        public Criteria andWaterLevelEqualTo(String value) {
            addCriterion("waterLevel =", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelNotEqualTo(String value) {
            addCriterion("waterLevel <>", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelGreaterThan(String value) {
            addCriterion("waterLevel >", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelGreaterThanOrEqualTo(String value) {
            addCriterion("waterLevel >=", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelLessThan(String value) {
            addCriterion("waterLevel <", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelLessThanOrEqualTo(String value) {
            addCriterion("waterLevel <=", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelLike(String value) {
            addCriterion("waterLevel like", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelNotLike(String value) {
            addCriterion("waterLevel not like", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelIn(List<String> values) {
            addCriterion("waterLevel in", values, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelNotIn(List<String> values) {
            addCriterion("waterLevel not in", values, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelBetween(String value1, String value2) {
            addCriterion("waterLevel between", value1, value2, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelNotBetween(String value1, String value2) {
            addCriterion("waterLevel not between", value1, value2, "waterLevel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}