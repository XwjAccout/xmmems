package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvWarnRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvWarnRecordExample() {
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

        public Criteria andSiteIdIsNull() {
            addCriterion("siteId is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("siteId is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(Integer value) {
            addCriterion("siteId =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(Integer value) {
            addCriterion("siteId <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(Integer value) {
            addCriterion("siteId >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("siteId >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(Integer value) {
            addCriterion("siteId <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("siteId <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<Integer> values) {
            addCriterion("siteId in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<Integer> values) {
            addCriterion("siteId not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(Integer value1, Integer value2) {
            addCriterion("siteId between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("siteId not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdIsNull() {
            addCriterion("excepRecordId is null");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdIsNotNull() {
            addCriterion("excepRecordId is not null");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdEqualTo(Integer value) {
            addCriterion("excepRecordId =", value, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdNotEqualTo(Integer value) {
            addCriterion("excepRecordId <>", value, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdGreaterThan(Integer value) {
            addCriterion("excepRecordId >", value, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("excepRecordId >=", value, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdLessThan(Integer value) {
            addCriterion("excepRecordId <", value, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("excepRecordId <=", value, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdIn(List<Integer> values) {
            addCriterion("excepRecordId in", values, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdNotIn(List<Integer> values) {
            addCriterion("excepRecordId not in", values, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("excepRecordId between", value1, value2, "excepRecordId");
            return (Criteria) this;
        }

        public Criteria andExcepRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("excepRecordId not between", value1, value2, "excepRecordId");
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

        public Criteria andExcepTimeIsNull() {
            addCriterion("excepTime is null");
            return (Criteria) this;
        }

        public Criteria andExcepTimeIsNotNull() {
            addCriterion("excepTime is not null");
            return (Criteria) this;
        }

        public Criteria andExcepTimeEqualTo(Date value) {
            addCriterion("excepTime =", value, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeNotEqualTo(Date value) {
            addCriterion("excepTime <>", value, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeGreaterThan(Date value) {
            addCriterion("excepTime >", value, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("excepTime >=", value, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeLessThan(Date value) {
            addCriterion("excepTime <", value, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeLessThanOrEqualTo(Date value) {
            addCriterion("excepTime <=", value, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeIn(List<Date> values) {
            addCriterion("excepTime in", values, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeNotIn(List<Date> values) {
            addCriterion("excepTime not in", values, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeBetween(Date value1, Date value2) {
            addCriterion("excepTime between", value1, value2, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepTimeNotBetween(Date value1, Date value2) {
            addCriterion("excepTime not between", value1, value2, "excepTime");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdIsNull() {
            addCriterion("excepItemId is null");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdIsNotNull() {
            addCriterion("excepItemId is not null");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdEqualTo(Integer value) {
            addCriterion("excepItemId =", value, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdNotEqualTo(Integer value) {
            addCriterion("excepItemId <>", value, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdGreaterThan(Integer value) {
            addCriterion("excepItemId >", value, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("excepItemId >=", value, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdLessThan(Integer value) {
            addCriterion("excepItemId <", value, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("excepItemId <=", value, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdIn(List<Integer> values) {
            addCriterion("excepItemId in", values, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdNotIn(List<Integer> values) {
            addCriterion("excepItemId not in", values, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdBetween(Integer value1, Integer value2) {
            addCriterion("excepItemId between", value1, value2, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("excepItemId not between", value1, value2, "excepItemId");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameIsNull() {
            addCriterion("excepItemName is null");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameIsNotNull() {
            addCriterion("excepItemName is not null");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameEqualTo(String value) {
            addCriterion("excepItemName =", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameNotEqualTo(String value) {
            addCriterion("excepItemName <>", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameGreaterThan(String value) {
            addCriterion("excepItemName >", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("excepItemName >=", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameLessThan(String value) {
            addCriterion("excepItemName <", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameLessThanOrEqualTo(String value) {
            addCriterion("excepItemName <=", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameLike(String value) {
            addCriterion("excepItemName like", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameNotLike(String value) {
            addCriterion("excepItemName not like", value, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameIn(List<String> values) {
            addCriterion("excepItemName in", values, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameNotIn(List<String> values) {
            addCriterion("excepItemName not in", values, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameBetween(String value1, String value2) {
            addCriterion("excepItemName between", value1, value2, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemNameNotBetween(String value1, String value2) {
            addCriterion("excepItemName not between", value1, value2, "excepItemName");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueIsNull() {
            addCriterion("excepItemValue is null");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueIsNotNull() {
            addCriterion("excepItemValue is not null");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueEqualTo(String value) {
            addCriterion("excepItemValue =", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueNotEqualTo(String value) {
            addCriterion("excepItemValue <>", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueGreaterThan(String value) {
            addCriterion("excepItemValue >", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueGreaterThanOrEqualTo(String value) {
            addCriterion("excepItemValue >=", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueLessThan(String value) {
            addCriterion("excepItemValue <", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueLessThanOrEqualTo(String value) {
            addCriterion("excepItemValue <=", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueLike(String value) {
            addCriterion("excepItemValue like", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueNotLike(String value) {
            addCriterion("excepItemValue not like", value, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueIn(List<String> values) {
            addCriterion("excepItemValue in", values, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueNotIn(List<String> values) {
            addCriterion("excepItemValue not in", values, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueBetween(String value1, String value2) {
            addCriterion("excepItemValue between", value1, value2, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andExcepItemValueNotBetween(String value1, String value2) {
            addCriterion("excepItemValue not between", value1, value2, "excepItemValue");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNull() {
            addCriterion("warnType is null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIsNotNull() {
            addCriterion("warnType is not null");
            return (Criteria) this;
        }

        public Criteria andWarnTypeEqualTo(String value) {
            addCriterion("warnType =", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotEqualTo(String value) {
            addCriterion("warnType <>", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThan(String value) {
            addCriterion("warnType >", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("warnType >=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThan(String value) {
            addCriterion("warnType <", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLessThanOrEqualTo(String value) {
            addCriterion("warnType <=", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeLike(String value) {
            addCriterion("warnType like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotLike(String value) {
            addCriterion("warnType not like", value, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeIn(List<String> values) {
            addCriterion("warnType in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotIn(List<String> values) {
            addCriterion("warnType not in", values, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeBetween(String value1, String value2) {
            addCriterion("warnType between", value1, value2, "warnType");
            return (Criteria) this;
        }

        public Criteria andWarnTypeNotBetween(String value1, String value2) {
            addCriterion("warnType not between", value1, value2, "warnType");
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