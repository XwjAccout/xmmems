package com.xmmems.domain.cal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalTimeseqLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CalTimeseqLogExample() {
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

        public Criteria andKpiIsNull() {
            addCriterion("kpi is null");
            return (Criteria) this;
        }

        public Criteria andKpiIsNotNull() {
            addCriterion("kpi is not null");
            return (Criteria) this;
        }

        public Criteria andKpiEqualTo(String value) {
            addCriterion("kpi =", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiNotEqualTo(String value) {
            addCriterion("kpi <>", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiGreaterThan(String value) {
            addCriterion("kpi >", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiGreaterThanOrEqualTo(String value) {
            addCriterion("kpi >=", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiLessThan(String value) {
            addCriterion("kpi <", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiLessThanOrEqualTo(String value) {
            addCriterion("kpi <=", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiLike(String value) {
            addCriterion("kpi like", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiNotLike(String value) {
            addCriterion("kpi not like", value, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiIn(List<String> values) {
            addCriterion("kpi in", values, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiNotIn(List<String> values) {
            addCriterion("kpi not in", values, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiBetween(String value1, String value2) {
            addCriterion("kpi between", value1, value2, "kpi");
            return (Criteria) this;
        }

        public Criteria andKpiNotBetween(String value1, String value2) {
            addCriterion("kpi not between", value1, value2, "kpi");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("modelType is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("modelType is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(String value) {
            addCriterion("modelType =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(String value) {
            addCriterion("modelType <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(String value) {
            addCriterion("modelType >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("modelType >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(String value) {
            addCriterion("modelType <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(String value) {
            addCriterion("modelType <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLike(String value) {
            addCriterion("modelType like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotLike(String value) {
            addCriterion("modelType not like", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<String> values) {
            addCriterion("modelType in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<String> values) {
            addCriterion("modelType not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(String value1, String value2) {
            addCriterion("modelType between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(String value1, String value2) {
            addCriterion("modelType not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andCalCodeIsNull() {
            addCriterion("calCode is null");
            return (Criteria) this;
        }

        public Criteria andCalCodeIsNotNull() {
            addCriterion("calCode is not null");
            return (Criteria) this;
        }

        public Criteria andCalCodeEqualTo(String value) {
            addCriterion("calCode =", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeNotEqualTo(String value) {
            addCriterion("calCode <>", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeGreaterThan(String value) {
            addCriterion("calCode >", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("calCode >=", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeLessThan(String value) {
            addCriterion("calCode <", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeLessThanOrEqualTo(String value) {
            addCriterion("calCode <=", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeLike(String value) {
            addCriterion("calCode like", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeNotLike(String value) {
            addCriterion("calCode not like", value, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeIn(List<String> values) {
            addCriterion("calCode in", values, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeNotIn(List<String> values) {
            addCriterion("calCode not in", values, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeBetween(String value1, String value2) {
            addCriterion("calCode between", value1, value2, "calCode");
            return (Criteria) this;
        }

        public Criteria andCalCodeNotBetween(String value1, String value2) {
            addCriterion("calCode not between", value1, value2, "calCode");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("startTime =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("startTime <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("startTime in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("endTime <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andHandleUserIsNull() {
            addCriterion("handleUser is null");
            return (Criteria) this;
        }

        public Criteria andHandleUserIsNotNull() {
            addCriterion("handleUser is not null");
            return (Criteria) this;
        }

        public Criteria andHandleUserEqualTo(String value) {
            addCriterion("handleUser =", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserNotEqualTo(String value) {
            addCriterion("handleUser <>", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserGreaterThan(String value) {
            addCriterion("handleUser >", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserGreaterThanOrEqualTo(String value) {
            addCriterion("handleUser >=", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserLessThan(String value) {
            addCriterion("handleUser <", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserLessThanOrEqualTo(String value) {
            addCriterion("handleUser <=", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserLike(String value) {
            addCriterion("handleUser like", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserNotLike(String value) {
            addCriterion("handleUser not like", value, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserIn(List<String> values) {
            addCriterion("handleUser in", values, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserNotIn(List<String> values) {
            addCriterion("handleUser not in", values, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserBetween(String value1, String value2) {
            addCriterion("handleUser between", value1, value2, "handleUser");
            return (Criteria) this;
        }

        public Criteria andHandleUserNotBetween(String value1, String value2) {
            addCriterion("handleUser not between", value1, value2, "handleUser");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("filePath is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("filePath is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("filePath =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("filePath <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("filePath >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("filePath >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("filePath <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("filePath <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("filePath like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("filePath not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("filePath in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("filePath not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("filePath between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("filePath not between", value1, value2, "filePath");
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