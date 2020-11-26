package com.xmmems.domain;

import java.util.ArrayList;
import java.util.List;

public class CounterchargeLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CounterchargeLogExample() {
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

        public Criteria andQNIsNull() {
            addCriterion("QN is null");
            return (Criteria) this;
        }

        public Criteria andQNIsNotNull() {
            addCriterion("QN is not null");
            return (Criteria) this;
        }

        public Criteria andQNEqualTo(String value) {
            addCriterion("QN =", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNNotEqualTo(String value) {
            addCriterion("QN <>", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNGreaterThan(String value) {
            addCriterion("QN >", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNGreaterThanOrEqualTo(String value) {
            addCriterion("QN >=", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNLessThan(String value) {
            addCriterion("QN <", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNLessThanOrEqualTo(String value) {
            addCriterion("QN <=", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNLike(String value) {
            addCriterion("QN like", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNNotLike(String value) {
            addCriterion("QN not like", value, "QN");
            return (Criteria) this;
        }

        public Criteria andQNIn(List<String> values) {
            addCriterion("QN in", values, "QN");
            return (Criteria) this;
        }

        public Criteria andQNNotIn(List<String> values) {
            addCriterion("QN not in", values, "QN");
            return (Criteria) this;
        }

        public Criteria andQNBetween(String value1, String value2) {
            addCriterion("QN between", value1, value2, "QN");
            return (Criteria) this;
        }

        public Criteria andQNNotBetween(String value1, String value2) {
            addCriterion("QN not between", value1, value2, "QN");
            return (Criteria) this;
        }

        public Criteria andCNNameIsNull() {
            addCriterion("CNName is null");
            return (Criteria) this;
        }

        public Criteria andCNNameIsNotNull() {
            addCriterion("CNName is not null");
            return (Criteria) this;
        }

        public Criteria andCNNameEqualTo(String value) {
            addCriterion("CNName =", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameNotEqualTo(String value) {
            addCriterion("CNName <>", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameGreaterThan(String value) {
            addCriterion("CNName >", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameGreaterThanOrEqualTo(String value) {
            addCriterion("CNName >=", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameLessThan(String value) {
            addCriterion("CNName <", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameLessThanOrEqualTo(String value) {
            addCriterion("CNName <=", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameLike(String value) {
            addCriterion("CNName like", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameNotLike(String value) {
            addCriterion("CNName not like", value, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameIn(List<String> values) {
            addCriterion("CNName in", values, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameNotIn(List<String> values) {
            addCriterion("CNName not in", values, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameBetween(String value1, String value2) {
            addCriterion("CNName between", value1, value2, "CNName");
            return (Criteria) this;
        }

        public Criteria andCNNameNotBetween(String value1, String value2) {
            addCriterion("CNName not between", value1, value2, "CNName");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("RealName is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("RealName is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("RealName =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("RealName <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("RealName >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("RealName >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("RealName <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("RealName <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("RealName like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("RealName not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("RealName in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("RealName not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("RealName between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("RealName not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRCTimeIsNull() {
            addCriterion("RCTime is null");
            return (Criteria) this;
        }

        public Criteria andRCTimeIsNotNull() {
            addCriterion("RCTime is not null");
            return (Criteria) this;
        }

        public Criteria andRCTimeEqualTo(String value) {
            addCriterion("RCTime =", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeNotEqualTo(String value) {
            addCriterion("RCTime <>", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeGreaterThan(String value) {
            addCriterion("RCTime >", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeGreaterThanOrEqualTo(String value) {
            addCriterion("RCTime >=", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeLessThan(String value) {
            addCriterion("RCTime <", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeLessThanOrEqualTo(String value) {
            addCriterion("RCTime <=", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeLike(String value) {
            addCriterion("RCTime like", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeNotLike(String value) {
            addCriterion("RCTime not like", value, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeIn(List<String> values) {
            addCriterion("RCTime in", values, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeNotIn(List<String> values) {
            addCriterion("RCTime not in", values, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeBetween(String value1, String value2) {
            addCriterion("RCTime between", value1, value2, "RCTime");
            return (Criteria) this;
        }

        public Criteria andRCTimeNotBetween(String value1, String value2) {
            addCriterion("RCTime not between", value1, value2, "RCTime");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andQnRtnIsNull() {
            addCriterion("QnRtn is null");
            return (Criteria) this;
        }

        public Criteria andQnRtnIsNotNull() {
            addCriterion("QnRtn is not null");
            return (Criteria) this;
        }

        public Criteria andQnRtnEqualTo(Integer value) {
            addCriterion("QnRtn =", value, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnNotEqualTo(Integer value) {
            addCriterion("QnRtn <>", value, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnGreaterThan(Integer value) {
            addCriterion("QnRtn >", value, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnGreaterThanOrEqualTo(Integer value) {
            addCriterion("QnRtn >=", value, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnLessThan(Integer value) {
            addCriterion("QnRtn <", value, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnLessThanOrEqualTo(Integer value) {
            addCriterion("QnRtn <=", value, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnIn(List<Integer> values) {
            addCriterion("QnRtn in", values, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnNotIn(List<Integer> values) {
            addCriterion("QnRtn not in", values, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnBetween(Integer value1, Integer value2) {
            addCriterion("QnRtn between", value1, value2, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andQnRtnNotBetween(Integer value1, Integer value2) {
            addCriterion("QnRtn not between", value1, value2, "qnRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnIsNull() {
            addCriterion("ExrRtn is null");
            return (Criteria) this;
        }

        public Criteria andExrRtnIsNotNull() {
            addCriterion("ExrRtn is not null");
            return (Criteria) this;
        }

        public Criteria andExrRtnEqualTo(Integer value) {
            addCriterion("ExrRtn =", value, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnNotEqualTo(Integer value) {
            addCriterion("ExrRtn <>", value, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnGreaterThan(Integer value) {
            addCriterion("ExrRtn >", value, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExrRtn >=", value, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnLessThan(Integer value) {
            addCriterion("ExrRtn <", value, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnLessThanOrEqualTo(Integer value) {
            addCriterion("ExrRtn <=", value, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnIn(List<Integer> values) {
            addCriterion("ExrRtn in", values, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnNotIn(List<Integer> values) {
            addCriterion("ExrRtn not in", values, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnBetween(Integer value1, Integer value2) {
            addCriterion("ExrRtn between", value1, value2, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andExrRtnNotBetween(Integer value1, Integer value2) {
            addCriterion("ExrRtn not between", value1, value2, "exrRtn");
            return (Criteria) this;
        }

        public Criteria andCPDataIsNull() {
            addCriterion("CPData is null");
            return (Criteria) this;
        }

        public Criteria andCPDataIsNotNull() {
            addCriterion("CPData is not null");
            return (Criteria) this;
        }

        public Criteria andCPDataEqualTo(String value) {
            addCriterion("CPData =", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataNotEqualTo(String value) {
            addCriterion("CPData <>", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataGreaterThan(String value) {
            addCriterion("CPData >", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataGreaterThanOrEqualTo(String value) {
            addCriterion("CPData >=", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataLessThan(String value) {
            addCriterion("CPData <", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataLessThanOrEqualTo(String value) {
            addCriterion("CPData <=", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataLike(String value) {
            addCriterion("CPData like", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataNotLike(String value) {
            addCriterion("CPData not like", value, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataIn(List<String> values) {
            addCriterion("CPData in", values, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataNotIn(List<String> values) {
            addCriterion("CPData not in", values, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataBetween(String value1, String value2) {
            addCriterion("CPData between", value1, value2, "CPData");
            return (Criteria) this;
        }

        public Criteria andCPDataNotBetween(String value1, String value2) {
            addCriterion("CPData not between", value1, value2, "CPData");
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