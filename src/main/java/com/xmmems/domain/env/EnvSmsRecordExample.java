package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvSmsRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvSmsRecordExample() {
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

        public Criteria andSendStatusIsNull() {
            addCriterion("sendStatus is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("sendStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(String value) {
            addCriterion("sendStatus =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(String value) {
            addCriterion("sendStatus <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(String value) {
            addCriterion("sendStatus >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sendStatus >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(String value) {
            addCriterion("sendStatus <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(String value) {
            addCriterion("sendStatus <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLike(String value) {
            addCriterion("sendStatus like", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotLike(String value) {
            addCriterion("sendStatus not like", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<String> values) {
            addCriterion("sendStatus in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<String> values) {
            addCriterion("sendStatus not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(String value1, String value2) {
            addCriterion("sendStatus between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(String value1, String value2) {
            addCriterion("sendStatus not between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("addTime <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("sendTime =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("sendTime <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("sendTime >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendTime >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("sendTime <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("sendTime <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("sendTime in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("sendTime not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("sendTime between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("sendTime not between", value1, value2, "sendTime");
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

        public Criteria andWarnRecordIdIsNull() {
            addCriterion("warnRecordId is null");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdIsNotNull() {
            addCriterion("warnRecordId is not null");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdEqualTo(Integer value) {
            addCriterion("warnRecordId =", value, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdNotEqualTo(Integer value) {
            addCriterion("warnRecordId <>", value, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdGreaterThan(Integer value) {
            addCriterion("warnRecordId >", value, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("warnRecordId >=", value, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdLessThan(Integer value) {
            addCriterion("warnRecordId <", value, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("warnRecordId <=", value, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdIn(List<Integer> values) {
            addCriterion("warnRecordId in", values, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdNotIn(List<Integer> values) {
            addCriterion("warnRecordId not in", values, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("warnRecordId between", value1, value2, "warnRecordId");
            return (Criteria) this;
        }

        public Criteria andWarnRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("warnRecordId not between", value1, value2, "warnRecordId");
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