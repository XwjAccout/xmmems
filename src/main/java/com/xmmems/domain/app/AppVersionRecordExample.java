package com.xmmems.domain.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppVersionRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppVersionRecordExample() {
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

        public Criteria andVersionCodeIsNull() {
            addCriterion("versionCode is null");
            return (Criteria) this;
        }

        public Criteria andVersionCodeIsNotNull() {
            addCriterion("versionCode is not null");
            return (Criteria) this;
        }

        public Criteria andVersionCodeEqualTo(Integer value) {
            addCriterion("versionCode =", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotEqualTo(Integer value) {
            addCriterion("versionCode <>", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeGreaterThan(Integer value) {
            addCriterion("versionCode >", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("versionCode >=", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeLessThan(Integer value) {
            addCriterion("versionCode <", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("versionCode <=", value, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeIn(List<Integer> values) {
            addCriterion("versionCode in", values, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotIn(List<Integer> values) {
            addCriterion("versionCode not in", values, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeBetween(Integer value1, Integer value2) {
            addCriterion("versionCode between", value1, value2, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("versionCode not between", value1, value2, "versionCode");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNull() {
            addCriterion("versionName is null");
            return (Criteria) this;
        }

        public Criteria andVersionNameIsNotNull() {
            addCriterion("versionName is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNameEqualTo(String value) {
            addCriterion("versionName =", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotEqualTo(String value) {
            addCriterion("versionName <>", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThan(String value) {
            addCriterion("versionName >", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameGreaterThanOrEqualTo(String value) {
            addCriterion("versionName >=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThan(String value) {
            addCriterion("versionName <", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLessThanOrEqualTo(String value) {
            addCriterion("versionName <=", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameLike(String value) {
            addCriterion("versionName like", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotLike(String value) {
            addCriterion("versionName not like", value, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameIn(List<String> values) {
            addCriterion("versionName in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotIn(List<String> values) {
            addCriterion("versionName not in", values, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameBetween(String value1, String value2) {
            addCriterion("versionName between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andVersionNameNotBetween(String value1, String value2) {
            addCriterion("versionName not between", value1, value2, "versionName");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNull() {
            addCriterion("platformType is null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNotNull() {
            addCriterion("platformType is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeEqualTo(Integer value) {
            addCriterion("platformType =", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotEqualTo(Integer value) {
            addCriterion("platformType <>", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThan(Integer value) {
            addCriterion("platformType >", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("platformType >=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThan(Integer value) {
            addCriterion("platformType <", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThanOrEqualTo(Integer value) {
            addCriterion("platformType <=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIn(List<Integer> values) {
            addCriterion("platformType in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotIn(List<Integer> values) {
            addCriterion("platformType not in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeBetween(Integer value1, Integer value2) {
            addCriterion("platformType between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("platformType not between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeIsNull() {
            addCriterion("updateType is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeIsNotNull() {
            addCriterion("updateType is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeEqualTo(Integer value) {
            addCriterion("updateType =", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeNotEqualTo(Integer value) {
            addCriterion("updateType <>", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeGreaterThan(Integer value) {
            addCriterion("updateType >", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("updateType >=", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeLessThan(Integer value) {
            addCriterion("updateType <", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("updateType <=", value, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeIn(List<Integer> values) {
            addCriterion("updateType in", values, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeNotIn(List<Integer> values) {
            addCriterion("updateType not in", values, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeBetween(Integer value1, Integer value2) {
            addCriterion("updateType between", value1, value2, "updateType");
            return (Criteria) this;
        }

        public Criteria andUpdateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("updateType not between", value1, value2, "updateType");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publishTime is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publishTime is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publishTime =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publishTime <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publishTime >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publishTime >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publishTime <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publishTime <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publishTime in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publishTime not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publishTime between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publishTime not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNull() {
            addCriterion("isPublish is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNotNull() {
            addCriterion("isPublish is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishEqualTo(Integer value) {
            addCriterion("isPublish =", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotEqualTo(Integer value) {
            addCriterion("isPublish <>", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThan(Integer value) {
            addCriterion("isPublish >", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThanOrEqualTo(Integer value) {
            addCriterion("isPublish >=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThan(Integer value) {
            addCriterion("isPublish <", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThanOrEqualTo(Integer value) {
            addCriterion("isPublish <=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishIn(List<Integer> values) {
            addCriterion("isPublish in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotIn(List<Integer> values) {
            addCriterion("isPublish not in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishBetween(Integer value1, Integer value2) {
            addCriterion("isPublish between", value1, value2, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotBetween(Integer value1, Integer value2) {
            addCriterion("isPublish not between", value1, value2, "isPublish");
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