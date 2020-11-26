package com.xmmems.domain.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseSiteitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseSiteitemExample() {
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

        public Criteria andItemNameIsNull() {
            addCriterion("itemName is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("itemName is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("itemName =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("itemName <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("itemName >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("itemName >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("itemName <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("itemName <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("itemName like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("itemName not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("itemName in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("itemName not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("itemName between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("itemName not between", value1, value2, "itemName");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(BigDecimal value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(BigDecimal value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(BigDecimal value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(BigDecimal value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<BigDecimal> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<BigDecimal> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("isValid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("isValid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(String value) {
            addCriterion("isValid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(String value) {
            addCriterion("isValid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(String value) {
            addCriterion("isValid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(String value) {
            addCriterion("isValid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(String value) {
            addCriterion("isValid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(String value) {
            addCriterion("isValid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLike(String value) {
            addCriterion("isValid like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotLike(String value) {
            addCriterion("isValid not like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<String> values) {
            addCriterion("isValid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<String> values) {
            addCriterion("isValid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(String value1, String value2) {
            addCriterion("isValid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(String value1, String value2) {
            addCriterion("isValid not between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNull() {
            addCriterion("minValue is null");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNotNull() {
            addCriterion("minValue is not null");
            return (Criteria) this;
        }

        public Criteria andMinValueEqualTo(String value) {
            addCriterion("minValue =", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotEqualTo(String value) {
            addCriterion("minValue <>", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThan(String value) {
            addCriterion("minValue >", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThanOrEqualTo(String value) {
            addCriterion("minValue >=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThan(String value) {
            addCriterion("minValue <", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThanOrEqualTo(String value) {
            addCriterion("minValue <=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLike(String value) {
            addCriterion("minValue like", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotLike(String value) {
            addCriterion("minValue not like", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueIn(List<String> values) {
            addCriterion("minValue in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotIn(List<String> values) {
            addCriterion("minValue not in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueBetween(String value1, String value2) {
            addCriterion("minValue between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotBetween(String value1, String value2) {
            addCriterion("minValue not between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNull() {
            addCriterion("maxValue is null");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNotNull() {
            addCriterion("maxValue is not null");
            return (Criteria) this;
        }

        public Criteria andMaxValueEqualTo(String value) {
            addCriterion("maxValue =", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotEqualTo(String value) {
            addCriterion("maxValue <>", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThan(String value) {
            addCriterion("maxValue >", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThanOrEqualTo(String value) {
            addCriterion("maxValue >=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThan(String value) {
            addCriterion("maxValue <", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThanOrEqualTo(String value) {
            addCriterion("maxValue <=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLike(String value) {
            addCriterion("maxValue like", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotLike(String value) {
            addCriterion("maxValue not like", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIn(List<String> values) {
            addCriterion("maxValue in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotIn(List<String> values) {
            addCriterion("maxValue not in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueBetween(String value1, String value2) {
            addCriterion("maxValue between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotBetween(String value1, String value2) {
            addCriterion("maxValue not between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagIsNull() {
            addCriterion("isAutoTag is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagIsNotNull() {
            addCriterion("isAutoTag is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagEqualTo(String value) {
            addCriterion("isAutoTag =", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagNotEqualTo(String value) {
            addCriterion("isAutoTag <>", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagGreaterThan(String value) {
            addCriterion("isAutoTag >", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagGreaterThanOrEqualTo(String value) {
            addCriterion("isAutoTag >=", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagLessThan(String value) {
            addCriterion("isAutoTag <", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagLessThanOrEqualTo(String value) {
            addCriterion("isAutoTag <=", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagLike(String value) {
            addCriterion("isAutoTag like", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagNotLike(String value) {
            addCriterion("isAutoTag not like", value, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagIn(List<String> values) {
            addCriterion("isAutoTag in", values, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagNotIn(List<String> values) {
            addCriterion("isAutoTag not in", values, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagBetween(String value1, String value2) {
            addCriterion("isAutoTag between", value1, value2, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andIsAutoTagNotBetween(String value1, String value2) {
            addCriterion("isAutoTag not between", value1, value2, "isAutoTag");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andLimitNumIsNull() {
            addCriterion("limitNum is null");
            return (Criteria) this;
        }

        public Criteria andLimitNumIsNotNull() {
            addCriterion("limitNum is not null");
            return (Criteria) this;
        }

        public Criteria andLimitNumEqualTo(String value) {
            addCriterion("limitNum =", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumNotEqualTo(String value) {
            addCriterion("limitNum <>", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumGreaterThan(String value) {
            addCriterion("limitNum >", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumGreaterThanOrEqualTo(String value) {
            addCriterion("limitNum >=", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumLessThan(String value) {
            addCriterion("limitNum <", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumLessThanOrEqualTo(String value) {
            addCriterion("limitNum <=", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumLike(String value) {
            addCriterion("limitNum like", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumNotLike(String value) {
            addCriterion("limitNum not like", value, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumIn(List<String> values) {
            addCriterion("limitNum in", values, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumNotIn(List<String> values) {
            addCriterion("limitNum not in", values, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumBetween(String value1, String value2) {
            addCriterion("limitNum between", value1, value2, "limitNum");
            return (Criteria) this;
        }

        public Criteria andLimitNumNotBetween(String value1, String value2) {
            addCriterion("limitNum not between", value1, value2, "limitNum");
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