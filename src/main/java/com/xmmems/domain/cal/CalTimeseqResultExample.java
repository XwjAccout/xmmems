package com.xmmems.domain.cal;

import java.util.ArrayList;
import java.util.List;

public class CalTimeseqResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CalTimeseqResultExample() {
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

        public Criteria andSeqTimeIsNull() {
            addCriterion("seqTime is null");
            return (Criteria) this;
        }

        public Criteria andSeqTimeIsNotNull() {
            addCriterion("seqTime is not null");
            return (Criteria) this;
        }

        public Criteria andSeqTimeEqualTo(String value) {
            addCriterion("seqTime =", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeNotEqualTo(String value) {
            addCriterion("seqTime <>", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeGreaterThan(String value) {
            addCriterion("seqTime >", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeGreaterThanOrEqualTo(String value) {
            addCriterion("seqTime >=", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeLessThan(String value) {
            addCriterion("seqTime <", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeLessThanOrEqualTo(String value) {
            addCriterion("seqTime <=", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeLike(String value) {
            addCriterion("seqTime like", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeNotLike(String value) {
            addCriterion("seqTime not like", value, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeIn(List<String> values) {
            addCriterion("seqTime in", values, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeNotIn(List<String> values) {
            addCriterion("seqTime not in", values, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeBetween(String value1, String value2) {
            addCriterion("seqTime between", value1, value2, "seqTime");
            return (Criteria) this;
        }

        public Criteria andSeqTimeNotBetween(String value1, String value2) {
            addCriterion("seqTime not between", value1, value2, "seqTime");
            return (Criteria) this;
        }

        public Criteria andPredictionValIsNull() {
            addCriterion("predictionVal is null");
            return (Criteria) this;
        }

        public Criteria andPredictionValIsNotNull() {
            addCriterion("predictionVal is not null");
            return (Criteria) this;
        }

        public Criteria andPredictionValEqualTo(String value) {
            addCriterion("predictionVal =", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValNotEqualTo(String value) {
            addCriterion("predictionVal <>", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValGreaterThan(String value) {
            addCriterion("predictionVal >", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValGreaterThanOrEqualTo(String value) {
            addCriterion("predictionVal >=", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValLessThan(String value) {
            addCriterion("predictionVal <", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValLessThanOrEqualTo(String value) {
            addCriterion("predictionVal <=", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValLike(String value) {
            addCriterion("predictionVal like", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValNotLike(String value) {
            addCriterion("predictionVal not like", value, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValIn(List<String> values) {
            addCriterion("predictionVal in", values, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValNotIn(List<String> values) {
            addCriterion("predictionVal not in", values, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValBetween(String value1, String value2) {
            addCriterion("predictionVal between", value1, value2, "predictionVal");
            return (Criteria) this;
        }

        public Criteria andPredictionValNotBetween(String value1, String value2) {
            addCriterion("predictionVal not between", value1, value2, "predictionVal");
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