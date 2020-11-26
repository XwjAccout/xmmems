package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvRealtimeQualityLevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvRealtimeQualityLevelExample() {
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

        public Criteria andSectionNameIsNull() {
            addCriterion("sectionName is null");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNotNull() {
            addCriterion("sectionName is not null");
            return (Criteria) this;
        }

        public Criteria andSectionNameEqualTo(String value) {
            addCriterion("sectionName =", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotEqualTo(String value) {
            addCriterion("sectionName <>", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThan(String value) {
            addCriterion("sectionName >", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("sectionName >=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThan(String value) {
            addCriterion("sectionName <", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThanOrEqualTo(String value) {
            addCriterion("sectionName <=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLike(String value) {
            addCriterion("sectionName like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotLike(String value) {
            addCriterion("sectionName not like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameIn(List<String> values) {
            addCriterion("sectionName in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotIn(List<String> values) {
            addCriterion("sectionName not in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameBetween(String value1, String value2) {
            addCriterion("sectionName between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotBetween(String value1, String value2) {
            addCriterion("sectionName not between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("areaName is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("areaName is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("areaName =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("areaName <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("areaName >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("areaName >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("areaName <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("areaName <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("areaName like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("areaName not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("areaName in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("areaName not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("areaName between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("areaName not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelIsNull() {
            addCriterion("goalQualityLevel is null");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelIsNotNull() {
            addCriterion("goalQualityLevel is not null");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelEqualTo(String value) {
            addCriterion("goalQualityLevel =", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelNotEqualTo(String value) {
            addCriterion("goalQualityLevel <>", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelGreaterThan(String value) {
            addCriterion("goalQualityLevel >", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("goalQualityLevel >=", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelLessThan(String value) {
            addCriterion("goalQualityLevel <", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelLessThanOrEqualTo(String value) {
            addCriterion("goalQualityLevel <=", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelLike(String value) {
            addCriterion("goalQualityLevel like", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelNotLike(String value) {
            addCriterion("goalQualityLevel not like", value, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelIn(List<String> values) {
            addCriterion("goalQualityLevel in", values, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelNotIn(List<String> values) {
            addCriterion("goalQualityLevel not in", values, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelBetween(String value1, String value2) {
            addCriterion("goalQualityLevel between", value1, value2, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andGoalQualityLevelNotBetween(String value1, String value2) {
            addCriterion("goalQualityLevel not between", value1, value2, "goalQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelIsNull() {
            addCriterion("realQualityLevel is null");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelIsNotNull() {
            addCriterion("realQualityLevel is not null");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelEqualTo(String value) {
            addCriterion("realQualityLevel =", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelNotEqualTo(String value) {
            addCriterion("realQualityLevel <>", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelGreaterThan(String value) {
            addCriterion("realQualityLevel >", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("realQualityLevel >=", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelLessThan(String value) {
            addCriterion("realQualityLevel <", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelLessThanOrEqualTo(String value) {
            addCriterion("realQualityLevel <=", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelLike(String value) {
            addCriterion("realQualityLevel like", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelNotLike(String value) {
            addCriterion("realQualityLevel not like", value, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelIn(List<String> values) {
            addCriterion("realQualityLevel in", values, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelNotIn(List<String> values) {
            addCriterion("realQualityLevel not in", values, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelBetween(String value1, String value2) {
            addCriterion("realQualityLevel between", value1, value2, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andRealQualityLevelNotBetween(String value1, String value2) {
            addCriterion("realQualityLevel not between", value1, value2, "realQualityLevel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantIsNull() {
            addCriterion("firstPollutant is null");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantIsNotNull() {
            addCriterion("firstPollutant is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantEqualTo(String value) {
            addCriterion("firstPollutant =", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantNotEqualTo(String value) {
            addCriterion("firstPollutant <>", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantGreaterThan(String value) {
            addCriterion("firstPollutant >", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantGreaterThanOrEqualTo(String value) {
            addCriterion("firstPollutant >=", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantLessThan(String value) {
            addCriterion("firstPollutant <", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantLessThanOrEqualTo(String value) {
            addCriterion("firstPollutant <=", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantLike(String value) {
            addCriterion("firstPollutant like", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantNotLike(String value) {
            addCriterion("firstPollutant not like", value, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantIn(List<String> values) {
            addCriterion("firstPollutant in", values, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantNotIn(List<String> values) {
            addCriterion("firstPollutant not in", values, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantBetween(String value1, String value2) {
            addCriterion("firstPollutant between", value1, value2, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andFirstPollutantNotBetween(String value1, String value2) {
            addCriterion("firstPollutant not between", value1, value2, "firstPollutant");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNull() {
            addCriterion("online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(String value) {
            addCriterion("online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(String value) {
            addCriterion("online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(String value) {
            addCriterion("online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(String value) {
            addCriterion("online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(String value) {
            addCriterion("online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(String value) {
            addCriterion("online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLike(String value) {
            addCriterion("online like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotLike(String value) {
            addCriterion("online not like", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<String> values) {
            addCriterion("online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<String> values) {
            addCriterion("online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(String value1, String value2) {
            addCriterion("online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(String value1, String value2) {
            addCriterion("online not between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeIsNull() {
            addCriterion("moniterTime is null");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeIsNotNull() {
            addCriterion("moniterTime is not null");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeEqualTo(Date value) {
            addCriterion("moniterTime =", value, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeNotEqualTo(Date value) {
            addCriterion("moniterTime <>", value, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeGreaterThan(Date value) {
            addCriterion("moniterTime >", value, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("moniterTime >=", value, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeLessThan(Date value) {
            addCriterion("moniterTime <", value, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeLessThanOrEqualTo(Date value) {
            addCriterion("moniterTime <=", value, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeIn(List<Date> values) {
            addCriterion("moniterTime in", values, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeNotIn(List<Date> values) {
            addCriterion("moniterTime not in", values, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeBetween(Date value1, Date value2) {
            addCriterion("moniterTime between", value1, value2, "moniterTime");
            return (Criteria) this;
        }

        public Criteria andMoniterTimeNotBetween(Date value1, Date value2) {
            addCriterion("moniterTime not between", value1, value2, "moniterTime");
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