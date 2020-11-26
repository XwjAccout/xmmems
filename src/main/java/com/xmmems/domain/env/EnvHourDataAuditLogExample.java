package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvHourDataAuditLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvHourDataAuditLogExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("itemId is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("itemId is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("itemId =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("itemId <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("itemId >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemId >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("itemId <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("itemId <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("itemId in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("itemId not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("itemId between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("itemId not between", value1, value2, "itemId");
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

        public Criteria andGenTimeIsNull() {
            addCriterion("genTime is null");
            return (Criteria) this;
        }

        public Criteria andGenTimeIsNotNull() {
            addCriterion("genTime is not null");
            return (Criteria) this;
        }

        public Criteria andGenTimeEqualTo(Date value) {
            addCriterion("genTime =", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeNotEqualTo(Date value) {
            addCriterion("genTime <>", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeGreaterThan(Date value) {
            addCriterion("genTime >", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("genTime >=", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeLessThan(Date value) {
            addCriterion("genTime <", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeLessThanOrEqualTo(Date value) {
            addCriterion("genTime <=", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeIn(List<Date> values) {
            addCriterion("genTime in", values, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeNotIn(List<Date> values) {
            addCriterion("genTime not in", values, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeBetween(Date value1, Date value2) {
            addCriterion("genTime between", value1, value2, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeNotBetween(Date value1, Date value2) {
            addCriterion("genTime not between", value1, value2, "genTime");
            return (Criteria) this;
        }

        public Criteria andOriginValueIsNull() {
            addCriterion("originValue is null");
            return (Criteria) this;
        }

        public Criteria andOriginValueIsNotNull() {
            addCriterion("originValue is not null");
            return (Criteria) this;
        }

        public Criteria andOriginValueEqualTo(String value) {
            addCriterion("originValue =", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueNotEqualTo(String value) {
            addCriterion("originValue <>", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueGreaterThan(String value) {
            addCriterion("originValue >", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueGreaterThanOrEqualTo(String value) {
            addCriterion("originValue >=", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueLessThan(String value) {
            addCriterion("originValue <", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueLessThanOrEqualTo(String value) {
            addCriterion("originValue <=", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueLike(String value) {
            addCriterion("originValue like", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueNotLike(String value) {
            addCriterion("originValue not like", value, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueIn(List<String> values) {
            addCriterion("originValue in", values, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueNotIn(List<String> values) {
            addCriterion("originValue not in", values, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueBetween(String value1, String value2) {
            addCriterion("originValue between", value1, value2, "originValue");
            return (Criteria) this;
        }

        public Criteria andOriginValueNotBetween(String value1, String value2) {
            addCriterion("originValue not between", value1, value2, "originValue");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modifyTime is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modifyTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modifyTime =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modifyTime <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modifyTime >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifyTime >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modifyTime <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modifyTime <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modifyTime in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modifyTime not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modifyTime between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modifyTime not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyFlagIsNull() {
            addCriterion("modifyFlag is null");
            return (Criteria) this;
        }

        public Criteria andModifyFlagIsNotNull() {
            addCriterion("modifyFlag is not null");
            return (Criteria) this;
        }

        public Criteria andModifyFlagEqualTo(String value) {
            addCriterion("modifyFlag =", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagNotEqualTo(String value) {
            addCriterion("modifyFlag <>", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagGreaterThan(String value) {
            addCriterion("modifyFlag >", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("modifyFlag >=", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagLessThan(String value) {
            addCriterion("modifyFlag <", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagLessThanOrEqualTo(String value) {
            addCriterion("modifyFlag <=", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagLike(String value) {
            addCriterion("modifyFlag like", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagNotLike(String value) {
            addCriterion("modifyFlag not like", value, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagIn(List<String> values) {
            addCriterion("modifyFlag in", values, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagNotIn(List<String> values) {
            addCriterion("modifyFlag not in", values, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagBetween(String value1, String value2) {
            addCriterion("modifyFlag between", value1, value2, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andModifyFlagNotBetween(String value1, String value2) {
            addCriterion("modifyFlag not between", value1, value2, "modifyFlag");
            return (Criteria) this;
        }

        public Criteria andPersionIsNull() {
            addCriterion("persion is null");
            return (Criteria) this;
        }

        public Criteria andPersionIsNotNull() {
            addCriterion("persion is not null");
            return (Criteria) this;
        }

        public Criteria andPersionEqualTo(String value) {
            addCriterion("persion =", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionNotEqualTo(String value) {
            addCriterion("persion <>", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionGreaterThan(String value) {
            addCriterion("persion >", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionGreaterThanOrEqualTo(String value) {
            addCriterion("persion >=", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionLessThan(String value) {
            addCriterion("persion <", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionLessThanOrEqualTo(String value) {
            addCriterion("persion <=", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionLike(String value) {
            addCriterion("persion like", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionNotLike(String value) {
            addCriterion("persion not like", value, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionIn(List<String> values) {
            addCriterion("persion in", values, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionNotIn(List<String> values) {
            addCriterion("persion not in", values, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionBetween(String value1, String value2) {
            addCriterion("persion between", value1, value2, "persion");
            return (Criteria) this;
        }

        public Criteria andPersionNotBetween(String value1, String value2) {
            addCriterion("persion not between", value1, value2, "persion");
            return (Criteria) this;
        }

        public Criteria andModifyReasonIsNull() {
            addCriterion("modifyReason is null");
            return (Criteria) this;
        }

        public Criteria andModifyReasonIsNotNull() {
            addCriterion("modifyReason is not null");
            return (Criteria) this;
        }

        public Criteria andModifyReasonEqualTo(String value) {
            addCriterion("modifyReason =", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonNotEqualTo(String value) {
            addCriterion("modifyReason <>", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonGreaterThan(String value) {
            addCriterion("modifyReason >", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonGreaterThanOrEqualTo(String value) {
            addCriterion("modifyReason >=", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonLessThan(String value) {
            addCriterion("modifyReason <", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonLessThanOrEqualTo(String value) {
            addCriterion("modifyReason <=", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonLike(String value) {
            addCriterion("modifyReason like", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonNotLike(String value) {
            addCriterion("modifyReason not like", value, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonIn(List<String> values) {
            addCriterion("modifyReason in", values, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonNotIn(List<String> values) {
            addCriterion("modifyReason not in", values, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonBetween(String value1, String value2) {
            addCriterion("modifyReason between", value1, value2, "modifyReason");
            return (Criteria) this;
        }

        public Criteria andModifyReasonNotBetween(String value1, String value2) {
            addCriterion("modifyReason not between", value1, value2, "modifyReason");
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