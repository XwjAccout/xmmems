package com.xmmems.domain;

import java.util.ArrayList;
import java.util.List;

public class EvaluationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluationExample() {
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

        public Criteria andWaterQualityLevelIsNull() {
            addCriterion("waterQualityLevel is null");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelIsNotNull() {
            addCriterion("waterQualityLevel is not null");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelEqualTo(String value) {
            addCriterion("waterQualityLevel =", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelNotEqualTo(String value) {
            addCriterion("waterQualityLevel <>", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelGreaterThan(String value) {
            addCriterion("waterQualityLevel >", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelGreaterThanOrEqualTo(String value) {
            addCriterion("waterQualityLevel >=", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelLessThan(String value) {
            addCriterion("waterQualityLevel <", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelLessThanOrEqualTo(String value) {
            addCriterion("waterQualityLevel <=", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelLike(String value) {
            addCriterion("waterQualityLevel like", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelNotLike(String value) {
            addCriterion("waterQualityLevel not like", value, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelIn(List<String> values) {
            addCriterion("waterQualityLevel in", values, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelNotIn(List<String> values) {
            addCriterion("waterQualityLevel not in", values, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelBetween(String value1, String value2) {
            addCriterion("waterQualityLevel between", value1, value2, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andWaterQualityLevelNotBetween(String value1, String value2) {
            addCriterion("waterQualityLevel not between", value1, value2, "waterQualityLevel");
            return (Criteria) this;
        }

        public Criteria andLevelStandardIsNull() {
            addCriterion("levelStandard is null");
            return (Criteria) this;
        }

        public Criteria andLevelStandardIsNotNull() {
            addCriterion("levelStandard is not null");
            return (Criteria) this;
        }

        public Criteria andLevelStandardEqualTo(String value) {
            addCriterion("levelStandard =", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardNotEqualTo(String value) {
            addCriterion("levelStandard <>", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardGreaterThan(String value) {
            addCriterion("levelStandard >", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardGreaterThanOrEqualTo(String value) {
            addCriterion("levelStandard >=", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardLessThan(String value) {
            addCriterion("levelStandard <", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardLessThanOrEqualTo(String value) {
            addCriterion("levelStandard <=", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardLike(String value) {
            addCriterion("levelStandard like", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardNotLike(String value) {
            addCriterion("levelStandard not like", value, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardIn(List<String> values) {
            addCriterion("levelStandard in", values, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardNotIn(List<String> values) {
            addCriterion("levelStandard not in", values, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardBetween(String value1, String value2) {
            addCriterion("levelStandard between", value1, value2, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andLevelStandardNotBetween(String value1, String value2) {
            addCriterion("levelStandard not between", value1, value2, "levelStandard");
            return (Criteria) this;
        }

        public Criteria andMainPollutantIsNull() {
            addCriterion("mainPollutant is null");
            return (Criteria) this;
        }

        public Criteria andMainPollutantIsNotNull() {
            addCriterion("mainPollutant is not null");
            return (Criteria) this;
        }

        public Criteria andMainPollutantEqualTo(String value) {
            addCriterion("mainPollutant =", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantNotEqualTo(String value) {
            addCriterion("mainPollutant <>", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantGreaterThan(String value) {
            addCriterion("mainPollutant >", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantGreaterThanOrEqualTo(String value) {
            addCriterion("mainPollutant >=", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantLessThan(String value) {
            addCriterion("mainPollutant <", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantLessThanOrEqualTo(String value) {
            addCriterion("mainPollutant <=", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantLike(String value) {
            addCriterion("mainPollutant like", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantNotLike(String value) {
            addCriterion("mainPollutant not like", value, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantIn(List<String> values) {
            addCriterion("mainPollutant in", values, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantNotIn(List<String> values) {
            addCriterion("mainPollutant not in", values, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantBetween(String value1, String value2) {
            addCriterion("mainPollutant between", value1, value2, "mainPollutant");
            return (Criteria) this;
        }

        public Criteria andMainPollutantNotBetween(String value1, String value2) {
            addCriterion("mainPollutant not between", value1, value2, "mainPollutant");
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