package com.xmmems.domain.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseRiverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseRiverExample() {
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

        public Criteria andBasinNameIsNull() {
            addCriterion("basinName is null");
            return (Criteria) this;
        }

        public Criteria andBasinNameIsNotNull() {
            addCriterion("basinName is not null");
            return (Criteria) this;
        }

        public Criteria andBasinNameEqualTo(String value) {
            addCriterion("basinName =", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameNotEqualTo(String value) {
            addCriterion("basinName <>", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameGreaterThan(String value) {
            addCriterion("basinName >", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameGreaterThanOrEqualTo(String value) {
            addCriterion("basinName >=", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameLessThan(String value) {
            addCriterion("basinName <", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameLessThanOrEqualTo(String value) {
            addCriterion("basinName <=", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameLike(String value) {
            addCriterion("basinName like", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameNotLike(String value) {
            addCriterion("basinName not like", value, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameIn(List<String> values) {
            addCriterion("basinName in", values, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameNotIn(List<String> values) {
            addCriterion("basinName not in", values, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameBetween(String value1, String value2) {
            addCriterion("basinName between", value1, value2, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinNameNotBetween(String value1, String value2) {
            addCriterion("basinName not between", value1, value2, "basinName");
            return (Criteria) this;
        }

        public Criteria andBasinCodeIsNull() {
            addCriterion("basinCode is null");
            return (Criteria) this;
        }

        public Criteria andBasinCodeIsNotNull() {
            addCriterion("basinCode is not null");
            return (Criteria) this;
        }

        public Criteria andBasinCodeEqualTo(String value) {
            addCriterion("basinCode =", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeNotEqualTo(String value) {
            addCriterion("basinCode <>", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeGreaterThan(String value) {
            addCriterion("basinCode >", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeGreaterThanOrEqualTo(String value) {
            addCriterion("basinCode >=", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeLessThan(String value) {
            addCriterion("basinCode <", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeLessThanOrEqualTo(String value) {
            addCriterion("basinCode <=", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeLike(String value) {
            addCriterion("basinCode like", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeNotLike(String value) {
            addCriterion("basinCode not like", value, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeIn(List<String> values) {
            addCriterion("basinCode in", values, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeNotIn(List<String> values) {
            addCriterion("basinCode not in", values, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeBetween(String value1, String value2) {
            addCriterion("basinCode between", value1, value2, "basinCode");
            return (Criteria) this;
        }

        public Criteria andBasinCodeNotBetween(String value1, String value2) {
            addCriterion("basinCode not between", value1, value2, "basinCode");
            return (Criteria) this;
        }

        public Criteria andRiverNameIsNull() {
            addCriterion("riverName is null");
            return (Criteria) this;
        }

        public Criteria andRiverNameIsNotNull() {
            addCriterion("riverName is not null");
            return (Criteria) this;
        }

        public Criteria andRiverNameEqualTo(String value) {
            addCriterion("riverName =", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameNotEqualTo(String value) {
            addCriterion("riverName <>", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameGreaterThan(String value) {
            addCriterion("riverName >", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("riverName >=", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameLessThan(String value) {
            addCriterion("riverName <", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameLessThanOrEqualTo(String value) {
            addCriterion("riverName <=", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameLike(String value) {
            addCriterion("riverName like", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameNotLike(String value) {
            addCriterion("riverName not like", value, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameIn(List<String> values) {
            addCriterion("riverName in", values, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameNotIn(List<String> values) {
            addCriterion("riverName not in", values, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameBetween(String value1, String value2) {
            addCriterion("riverName between", value1, value2, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverNameNotBetween(String value1, String value2) {
            addCriterion("riverName not between", value1, value2, "riverName");
            return (Criteria) this;
        }

        public Criteria andRiverCodeIsNull() {
            addCriterion("riverCode is null");
            return (Criteria) this;
        }

        public Criteria andRiverCodeIsNotNull() {
            addCriterion("riverCode is not null");
            return (Criteria) this;
        }

        public Criteria andRiverCodeEqualTo(String value) {
            addCriterion("riverCode =", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeNotEqualTo(String value) {
            addCriterion("riverCode <>", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeGreaterThan(String value) {
            addCriterion("riverCode >", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeGreaterThanOrEqualTo(String value) {
            addCriterion("riverCode >=", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeLessThan(String value) {
            addCriterion("riverCode <", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeLessThanOrEqualTo(String value) {
            addCriterion("riverCode <=", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeLike(String value) {
            addCriterion("riverCode like", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeNotLike(String value) {
            addCriterion("riverCode not like", value, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeIn(List<String> values) {
            addCriterion("riverCode in", values, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeNotIn(List<String> values) {
            addCriterion("riverCode not in", values, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeBetween(String value1, String value2) {
            addCriterion("riverCode between", value1, value2, "riverCode");
            return (Criteria) this;
        }

        public Criteria andRiverCodeNotBetween(String value1, String value2) {
            addCriterion("riverCode not between", value1, value2, "riverCode");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("createAt is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("createAt is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("createAt =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("createAt <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("createAt >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("createAt >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("createAt <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("createAt <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("createAt in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("createAt not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("createAt between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("createAt not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("updateAt is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("updateAt is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("updateAt =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("updateAt <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("updateAt >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updateAt >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("updateAt <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("updateAt <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("updateAt in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("updateAt not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("updateAt between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("updateAt not between", value1, value2, "updateAt");
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