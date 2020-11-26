package com.xmmems.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NetWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NetWorkExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSiteIdEqualTo(String value) {
            addCriterion("siteId =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(String value) {
            addCriterion("siteId <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(String value) {
            addCriterion("siteId >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(String value) {
            addCriterion("siteId >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(String value) {
            addCriterion("siteId <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(String value) {
            addCriterion("siteId <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLike(String value) {
            addCriterion("siteId like", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotLike(String value) {
            addCriterion("siteId not like", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<String> values) {
            addCriterion("siteId in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<String> values) {
            addCriterion("siteId not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(String value1, String value2) {
            addCriterion("siteId between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(String value1, String value2) {
            addCriterion("siteId not between", value1, value2, "siteId");
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

        public Criteria andMnIsNull() {
            addCriterion("mn is null");
            return (Criteria) this;
        }

        public Criteria andMnIsNotNull() {
            addCriterion("mn is not null");
            return (Criteria) this;
        }

        public Criteria andMnEqualTo(String value) {
            addCriterion("mn =", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotEqualTo(String value) {
            addCriterion("mn <>", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnGreaterThan(String value) {
            addCriterion("mn >", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnGreaterThanOrEqualTo(String value) {
            addCriterion("mn >=", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLessThan(String value) {
            addCriterion("mn <", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLessThanOrEqualTo(String value) {
            addCriterion("mn <=", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnLike(String value) {
            addCriterion("mn like", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotLike(String value) {
            addCriterion("mn not like", value, "mn");
            return (Criteria) this;
        }

        public Criteria andMnIn(List<String> values) {
            addCriterion("mn in", values, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotIn(List<String> values) {
            addCriterion("mn not in", values, "mn");
            return (Criteria) this;
        }

        public Criteria andMnBetween(String value1, String value2) {
            addCriterion("mn between", value1, value2, "mn");
            return (Criteria) this;
        }

        public Criteria andMnNotBetween(String value1, String value2) {
            addCriterion("mn not between", value1, value2, "mn");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andOnLineIsNull() {
            addCriterion("onLine is null");
            return (Criteria) this;
        }

        public Criteria andOnLineIsNotNull() {
            addCriterion("onLine is not null");
            return (Criteria) this;
        }

        public Criteria andOnLineEqualTo(Integer value) {
            addCriterion("onLine =", value, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineNotEqualTo(Integer value) {
            addCriterion("onLine <>", value, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineGreaterThan(Integer value) {
            addCriterion("onLine >", value, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineGreaterThanOrEqualTo(Integer value) {
            addCriterion("onLine >=", value, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineLessThan(Integer value) {
            addCriterion("onLine <", value, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineLessThanOrEqualTo(Integer value) {
            addCriterion("onLine <=", value, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineIn(List<Integer> values) {
            addCriterion("onLine in", values, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineNotIn(List<Integer> values) {
            addCriterion("onLine not in", values, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineBetween(Integer value1, Integer value2) {
            addCriterion("onLine between", value1, value2, "onLine");
            return (Criteria) this;
        }

        public Criteria andOnLineNotBetween(Integer value1, Integer value2) {
            addCriterion("onLine not between", value1, value2, "onLine");
            return (Criteria) this;
        }

        public Criteria andOffLineIsNull() {
            addCriterion("offLine is null");
            return (Criteria) this;
        }

        public Criteria andOffLineIsNotNull() {
            addCriterion("offLine is not null");
            return (Criteria) this;
        }

        public Criteria andOffLineEqualTo(Integer value) {
            addCriterion("offLine =", value, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineNotEqualTo(Integer value) {
            addCriterion("offLine <>", value, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineGreaterThan(Integer value) {
            addCriterion("offLine >", value, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineGreaterThanOrEqualTo(Integer value) {
            addCriterion("offLine >=", value, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineLessThan(Integer value) {
            addCriterion("offLine <", value, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineLessThanOrEqualTo(Integer value) {
            addCriterion("offLine <=", value, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineIn(List<Integer> values) {
            addCriterion("offLine in", values, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineNotIn(List<Integer> values) {
            addCriterion("offLine not in", values, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineBetween(Integer value1, Integer value2) {
            addCriterion("offLine between", value1, value2, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineNotBetween(Integer value1, Integer value2) {
            addCriterion("offLine not between", value1, value2, "offLine");
            return (Criteria) this;
        }

        public Criteria andOffLineCountIsNull() {
            addCriterion("offLineCount is null");
            return (Criteria) this;
        }

        public Criteria andOffLineCountIsNotNull() {
            addCriterion("offLineCount is not null");
            return (Criteria) this;
        }

        public Criteria andOffLineCountEqualTo(Integer value) {
            addCriterion("offLineCount =", value, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountNotEqualTo(Integer value) {
            addCriterion("offLineCount <>", value, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountGreaterThan(Integer value) {
            addCriterion("offLineCount >", value, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("offLineCount >=", value, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountLessThan(Integer value) {
            addCriterion("offLineCount <", value, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountLessThanOrEqualTo(Integer value) {
            addCriterion("offLineCount <=", value, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountIn(List<Integer> values) {
            addCriterion("offLineCount in", values, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountNotIn(List<Integer> values) {
            addCriterion("offLineCount not in", values, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountBetween(Integer value1, Integer value2) {
            addCriterion("offLineCount between", value1, value2, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andOffLineCountNotBetween(Integer value1, Integer value2) {
            addCriterion("offLineCount not between", value1, value2, "offLineCount");
            return (Criteria) this;
        }

        public Criteria andFlowIsNull() {
            addCriterion("flow is null");
            return (Criteria) this;
        }

        public Criteria andFlowIsNotNull() {
            addCriterion("flow is not null");
            return (Criteria) this;
        }

        public Criteria andFlowEqualTo(Integer value) {
            addCriterion("flow =", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotEqualTo(Integer value) {
            addCriterion("flow <>", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThan(Integer value) {
            addCriterion("flow >", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow >=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThan(Integer value) {
            addCriterion("flow <", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThanOrEqualTo(Integer value) {
            addCriterion("flow <=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowIn(List<Integer> values) {
            addCriterion("flow in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotIn(List<Integer> values) {
            addCriterion("flow not in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowBetween(Integer value1, Integer value2) {
            addCriterion("flow between", value1, value2, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotBetween(Integer value1, Integer value2) {
            addCriterion("flow not between", value1, value2, "flow");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("loginTime is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("loginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("loginTime =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("loginTime <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("loginTime >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loginTime >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("loginTime <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("loginTime <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("loginTime in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("loginTime not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("loginTime between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("loginTime not between", value1, value2, "loginTime");
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