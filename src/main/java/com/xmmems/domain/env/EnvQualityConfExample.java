package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.List;

public class EnvQualityConfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvQualityConfExample() {
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

        public Criteria andKpiNameIsNull() {
            addCriterion("kpiName is null");
            return (Criteria) this;
        }

        public Criteria andKpiNameIsNotNull() {
            addCriterion("kpiName is not null");
            return (Criteria) this;
        }

        public Criteria andKpiNameEqualTo(String value) {
            addCriterion("kpiName =", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameNotEqualTo(String value) {
            addCriterion("kpiName <>", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameGreaterThan(String value) {
            addCriterion("kpiName >", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameGreaterThanOrEqualTo(String value) {
            addCriterion("kpiName >=", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameLessThan(String value) {
            addCriterion("kpiName <", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameLessThanOrEqualTo(String value) {
            addCriterion("kpiName <=", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameLike(String value) {
            addCriterion("kpiName like", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameNotLike(String value) {
            addCriterion("kpiName not like", value, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameIn(List<String> values) {
            addCriterion("kpiName in", values, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameNotIn(List<String> values) {
            addCriterion("kpiName not in", values, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameBetween(String value1, String value2) {
            addCriterion("kpiName between", value1, value2, "kpiName");
            return (Criteria) this;
        }

        public Criteria andKpiNameNotBetween(String value1, String value2) {
            addCriterion("kpiName not between", value1, value2, "kpiName");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andMinValIsNull() {
            addCriterion("minVal is null");
            return (Criteria) this;
        }

        public Criteria andMinValIsNotNull() {
            addCriterion("minVal is not null");
            return (Criteria) this;
        }

        public Criteria andMinValEqualTo(String value) {
            addCriterion("minVal =", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValNotEqualTo(String value) {
            addCriterion("minVal <>", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValGreaterThan(String value) {
            addCriterion("minVal >", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValGreaterThanOrEqualTo(String value) {
            addCriterion("minVal >=", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValLessThan(String value) {
            addCriterion("minVal <", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValLessThanOrEqualTo(String value) {
            addCriterion("minVal <=", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValLike(String value) {
            addCriterion("minVal like", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValNotLike(String value) {
            addCriterion("minVal not like", value, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValIn(List<String> values) {
            addCriterion("minVal in", values, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValNotIn(List<String> values) {
            addCriterion("minVal not in", values, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValBetween(String value1, String value2) {
            addCriterion("minVal between", value1, value2, "minVal");
            return (Criteria) this;
        }

        public Criteria andMinValNotBetween(String value1, String value2) {
            addCriterion("minVal not between", value1, value2, "minVal");
            return (Criteria) this;
        }

        public Criteria andMaxValIsNull() {
            addCriterion("maxVal is null");
            return (Criteria) this;
        }

        public Criteria andMaxValIsNotNull() {
            addCriterion("maxVal is not null");
            return (Criteria) this;
        }

        public Criteria andMaxValEqualTo(String value) {
            addCriterion("maxVal =", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValNotEqualTo(String value) {
            addCriterion("maxVal <>", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValGreaterThan(String value) {
            addCriterion("maxVal >", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValGreaterThanOrEqualTo(String value) {
            addCriterion("maxVal >=", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValLessThan(String value) {
            addCriterion("maxVal <", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValLessThanOrEqualTo(String value) {
            addCriterion("maxVal <=", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValLike(String value) {
            addCriterion("maxVal like", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValNotLike(String value) {
            addCriterion("maxVal not like", value, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValIn(List<String> values) {
            addCriterion("maxVal in", values, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValNotIn(List<String> values) {
            addCriterion("maxVal not in", values, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValBetween(String value1, String value2) {
            addCriterion("maxVal between", value1, value2, "maxVal");
            return (Criteria) this;
        }

        public Criteria andMaxValNotBetween(String value1, String value2) {
            addCriterion("maxVal not between", value1, value2, "maxVal");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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