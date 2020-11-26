package com.xmmems.domain;

import java.util.ArrayList;
import java.util.List;

public class QualityControlSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QualityControlSetExample() {
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

        public Criteria andStandardValueIsNull() {
            addCriterion("StandardValue is null");
            return (Criteria) this;
        }

        public Criteria andStandardValueIsNotNull() {
            addCriterion("StandardValue is not null");
            return (Criteria) this;
        }

        public Criteria andStandardValueEqualTo(String value) {
            addCriterion("StandardValue =", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotEqualTo(String value) {
            addCriterion("StandardValue <>", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueGreaterThan(String value) {
            addCriterion("StandardValue >", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueGreaterThanOrEqualTo(String value) {
            addCriterion("StandardValue >=", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueLessThan(String value) {
            addCriterion("StandardValue <", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueLessThanOrEqualTo(String value) {
            addCriterion("StandardValue <=", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueLike(String value) {
            addCriterion("StandardValue like", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotLike(String value) {
            addCriterion("StandardValue not like", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueIn(List<String> values) {
            addCriterion("StandardValue in", values, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotIn(List<String> values) {
            addCriterion("StandardValue not in", values, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueBetween(String value1, String value2) {
            addCriterion("StandardValue between", value1, value2, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotBetween(String value1, String value2) {
            addCriterion("StandardValue not between", value1, value2, "standardValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueIsNull() {
            addCriterion("SpanValue is null");
            return (Criteria) this;
        }

        public Criteria andSpanValueIsNotNull() {
            addCriterion("SpanValue is not null");
            return (Criteria) this;
        }

        public Criteria andSpanValueEqualTo(String value) {
            addCriterion("SpanValue =", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueNotEqualTo(String value) {
            addCriterion("SpanValue <>", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueGreaterThan(String value) {
            addCriterion("SpanValue >", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueGreaterThanOrEqualTo(String value) {
            addCriterion("SpanValue >=", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueLessThan(String value) {
            addCriterion("SpanValue <", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueLessThanOrEqualTo(String value) {
            addCriterion("SpanValue <=", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueLike(String value) {
            addCriterion("SpanValue like", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueNotLike(String value) {
            addCriterion("SpanValue not like", value, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueIn(List<String> values) {
            addCriterion("SpanValue in", values, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueNotIn(List<String> values) {
            addCriterion("SpanValue not in", values, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueBetween(String value1, String value2) {
            addCriterion("SpanValue between", value1, value2, "spanValue");
            return (Criteria) this;
        }

        public Criteria andSpanValueNotBetween(String value1, String value2) {
            addCriterion("SpanValue not between", value1, value2, "spanValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueIsNull() {
            addCriterion("ZeroStandardValue is null");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueIsNotNull() {
            addCriterion("ZeroStandardValue is not null");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueEqualTo(String value) {
            addCriterion("ZeroStandardValue =", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueNotEqualTo(String value) {
            addCriterion("ZeroStandardValue <>", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueGreaterThan(String value) {
            addCriterion("ZeroStandardValue >", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueGreaterThanOrEqualTo(String value) {
            addCriterion("ZeroStandardValue >=", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueLessThan(String value) {
            addCriterion("ZeroStandardValue <", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueLessThanOrEqualTo(String value) {
            addCriterion("ZeroStandardValue <=", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueLike(String value) {
            addCriterion("ZeroStandardValue like", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueNotLike(String value) {
            addCriterion("ZeroStandardValue not like", value, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueIn(List<String> values) {
            addCriterion("ZeroStandardValue in", values, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueNotIn(List<String> values) {
            addCriterion("ZeroStandardValue not in", values, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueBetween(String value1, String value2) {
            addCriterion("ZeroStandardValue between", value1, value2, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andZeroStandardValueNotBetween(String value1, String value2) {
            addCriterion("ZeroStandardValue not between", value1, value2, "zeroStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueIsNull() {
            addCriterion("SpanStandardValue is null");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueIsNotNull() {
            addCriterion("SpanStandardValue is not null");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueEqualTo(String value) {
            addCriterion("SpanStandardValue =", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueNotEqualTo(String value) {
            addCriterion("SpanStandardValue <>", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueGreaterThan(String value) {
            addCriterion("SpanStandardValue >", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueGreaterThanOrEqualTo(String value) {
            addCriterion("SpanStandardValue >=", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueLessThan(String value) {
            addCriterion("SpanStandardValue <", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueLessThanOrEqualTo(String value) {
            addCriterion("SpanStandardValue <=", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueLike(String value) {
            addCriterion("SpanStandardValue like", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueNotLike(String value) {
            addCriterion("SpanStandardValue not like", value, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueIn(List<String> values) {
            addCriterion("SpanStandardValue in", values, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueNotIn(List<String> values) {
            addCriterion("SpanStandardValue not in", values, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueBetween(String value1, String value2) {
            addCriterion("SpanStandardValue between", value1, value2, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andSpanStandardValueNotBetween(String value1, String value2) {
            addCriterion("SpanStandardValue not between", value1, value2, "spanStandardValue");
            return (Criteria) this;
        }

        public Criteria andToPersonIsNull() {
            addCriterion("ToPerson is null");
            return (Criteria) this;
        }

        public Criteria andToPersonIsNotNull() {
            addCriterion("ToPerson is not null");
            return (Criteria) this;
        }

        public Criteria andToPersonEqualTo(String value) {
            addCriterion("ToPerson =", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonNotEqualTo(String value) {
            addCriterion("ToPerson <>", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonGreaterThan(String value) {
            addCriterion("ToPerson >", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonGreaterThanOrEqualTo(String value) {
            addCriterion("ToPerson >=", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonLessThan(String value) {
            addCriterion("ToPerson <", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonLessThanOrEqualTo(String value) {
            addCriterion("ToPerson <=", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonLike(String value) {
            addCriterion("ToPerson like", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonNotLike(String value) {
            addCriterion("ToPerson not like", value, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonIn(List<String> values) {
            addCriterion("ToPerson in", values, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonNotIn(List<String> values) {
            addCriterion("ToPerson not in", values, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonBetween(String value1, String value2) {
            addCriterion("ToPerson between", value1, value2, "toPerson");
            return (Criteria) this;
        }

        public Criteria andToPersonNotBetween(String value1, String value2) {
            addCriterion("ToPerson not between", value1, value2, "toPerson");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNull() {
            addCriterion("isvalid is null");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNotNull() {
            addCriterion("isvalid is not null");
            return (Criteria) this;
        }

        public Criteria andIsvalidEqualTo(Integer value) {
            addCriterion("isvalid =", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotEqualTo(Integer value) {
            addCriterion("isvalid <>", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThan(Integer value) {
            addCriterion("isvalid >", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("isvalid >=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThan(Integer value) {
            addCriterion("isvalid <", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThanOrEqualTo(Integer value) {
            addCriterion("isvalid <=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidIn(List<Integer> values) {
            addCriterion("isvalid in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotIn(List<Integer> values) {
            addCriterion("isvalid not in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidBetween(Integer value1, Integer value2) {
            addCriterion("isvalid between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotBetween(Integer value1, Integer value2) {
            addCriterion("isvalid not between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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