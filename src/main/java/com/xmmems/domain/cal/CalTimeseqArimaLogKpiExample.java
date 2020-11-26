package com.xmmems.domain.cal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalTimeseqArimaLogKpiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CalTimeseqArimaLogKpiExample() {
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

        public Criteria andKpiIdIsNull() {
            addCriterion("kpiId is null");
            return (Criteria) this;
        }

        public Criteria andKpiIdIsNotNull() {
            addCriterion("kpiId is not null");
            return (Criteria) this;
        }

        public Criteria andKpiIdEqualTo(Integer value) {
            addCriterion("kpiId =", value, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdNotEqualTo(Integer value) {
            addCriterion("kpiId <>", value, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdGreaterThan(Integer value) {
            addCriterion("kpiId >", value, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kpiId >=", value, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdLessThan(Integer value) {
            addCriterion("kpiId <", value, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdLessThanOrEqualTo(Integer value) {
            addCriterion("kpiId <=", value, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdIn(List<Integer> values) {
            addCriterion("kpiId in", values, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdNotIn(List<Integer> values) {
            addCriterion("kpiId not in", values, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdBetween(Integer value1, Integer value2) {
            addCriterion("kpiId between", value1, value2, "kpiId");
            return (Criteria) this;
        }

        public Criteria andKpiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kpiId not between", value1, value2, "kpiId");
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

        public Criteria andKpiShortNameIsNull() {
            addCriterion("kpiShortName is null");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameIsNotNull() {
            addCriterion("kpiShortName is not null");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameEqualTo(String value) {
            addCriterion("kpiShortName =", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameNotEqualTo(String value) {
            addCriterion("kpiShortName <>", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameGreaterThan(String value) {
            addCriterion("kpiShortName >", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("kpiShortName >=", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameLessThan(String value) {
            addCriterion("kpiShortName <", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameLessThanOrEqualTo(String value) {
            addCriterion("kpiShortName <=", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameLike(String value) {
            addCriterion("kpiShortName like", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameNotLike(String value) {
            addCriterion("kpiShortName not like", value, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameIn(List<String> values) {
            addCriterion("kpiShortName in", values, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameNotIn(List<String> values) {
            addCriterion("kpiShortName not in", values, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameBetween(String value1, String value2) {
            addCriterion("kpiShortName between", value1, value2, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiShortNameNotBetween(String value1, String value2) {
            addCriterion("kpiShortName not between", value1, value2, "kpiShortName");
            return (Criteria) this;
        }

        public Criteria andKpiUnitIsNull() {
            addCriterion("kpiUnit is null");
            return (Criteria) this;
        }

        public Criteria andKpiUnitIsNotNull() {
            addCriterion("kpiUnit is not null");
            return (Criteria) this;
        }

        public Criteria andKpiUnitEqualTo(String value) {
            addCriterion("kpiUnit =", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitNotEqualTo(String value) {
            addCriterion("kpiUnit <>", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitGreaterThan(String value) {
            addCriterion("kpiUnit >", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitGreaterThanOrEqualTo(String value) {
            addCriterion("kpiUnit >=", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitLessThan(String value) {
            addCriterion("kpiUnit <", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitLessThanOrEqualTo(String value) {
            addCriterion("kpiUnit <=", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitLike(String value) {
            addCriterion("kpiUnit like", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitNotLike(String value) {
            addCriterion("kpiUnit not like", value, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitIn(List<String> values) {
            addCriterion("kpiUnit in", values, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitNotIn(List<String> values) {
            addCriterion("kpiUnit not in", values, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitBetween(String value1, String value2) {
            addCriterion("kpiUnit between", value1, value2, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andKpiUnitNotBetween(String value1, String value2) {
            addCriterion("kpiUnit not between", value1, value2, "kpiUnit");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
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