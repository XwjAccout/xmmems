package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.List;

public class EnvWarningRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvWarningRuleExample() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("typeId <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("typeName is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("typeName is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("typeName =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("typeName <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("typeName >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("typeName >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("typeName <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("typeName <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("typeName like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("typeName not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("typeName in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("typeName not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("typeName between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("typeName not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdIsNull() {
            addCriterion("rangeTypeId is null");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdIsNotNull() {
            addCriterion("rangeTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdEqualTo(Integer value) {
            addCriterion("rangeTypeId =", value, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdNotEqualTo(Integer value) {
            addCriterion("rangeTypeId <>", value, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdGreaterThan(Integer value) {
            addCriterion("rangeTypeId >", value, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rangeTypeId >=", value, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdLessThan(Integer value) {
            addCriterion("rangeTypeId <", value, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("rangeTypeId <=", value, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdIn(List<Integer> values) {
            addCriterion("rangeTypeId in", values, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdNotIn(List<Integer> values) {
            addCriterion("rangeTypeId not in", values, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("rangeTypeId between", value1, value2, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rangeTypeId not between", value1, value2, "rangeTypeId");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameIsNull() {
            addCriterion("rangeTypeName is null");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameIsNotNull() {
            addCriterion("rangeTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameEqualTo(String value) {
            addCriterion("rangeTypeName =", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameNotEqualTo(String value) {
            addCriterion("rangeTypeName <>", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameGreaterThan(String value) {
            addCriterion("rangeTypeName >", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("rangeTypeName >=", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameLessThan(String value) {
            addCriterion("rangeTypeName <", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameLessThanOrEqualTo(String value) {
            addCriterion("rangeTypeName <=", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameLike(String value) {
            addCriterion("rangeTypeName like", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameNotLike(String value) {
            addCriterion("rangeTypeName not like", value, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameIn(List<String> values) {
            addCriterion("rangeTypeName in", values, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameNotIn(List<String> values) {
            addCriterion("rangeTypeName not in", values, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameBetween(String value1, String value2) {
            addCriterion("rangeTypeName between", value1, value2, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeTypeNameNotBetween(String value1, String value2) {
            addCriterion("rangeTypeName not between", value1, value2, "rangeTypeName");
            return (Criteria) this;
        }

        public Criteria andRangeMinIsNull() {
            addCriterion("rangeMin is null");
            return (Criteria) this;
        }

        public Criteria andRangeMinIsNotNull() {
            addCriterion("rangeMin is not null");
            return (Criteria) this;
        }

        public Criteria andRangeMinEqualTo(String value) {
            addCriterion("rangeMin =", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinNotEqualTo(String value) {
            addCriterion("rangeMin <>", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinGreaterThan(String value) {
            addCriterion("rangeMin >", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinGreaterThanOrEqualTo(String value) {
            addCriterion("rangeMin >=", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinLessThan(String value) {
            addCriterion("rangeMin <", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinLessThanOrEqualTo(String value) {
            addCriterion("rangeMin <=", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinLike(String value) {
            addCriterion("rangeMin like", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinNotLike(String value) {
            addCriterion("rangeMin not like", value, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinIn(List<String> values) {
            addCriterion("rangeMin in", values, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinNotIn(List<String> values) {
            addCriterion("rangeMin not in", values, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinBetween(String value1, String value2) {
            addCriterion("rangeMin between", value1, value2, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMinNotBetween(String value1, String value2) {
            addCriterion("rangeMin not between", value1, value2, "rangeMin");
            return (Criteria) this;
        }

        public Criteria andRangeMaxIsNull() {
            addCriterion("rangeMax is null");
            return (Criteria) this;
        }

        public Criteria andRangeMaxIsNotNull() {
            addCriterion("rangeMax is not null");
            return (Criteria) this;
        }

        public Criteria andRangeMaxEqualTo(String value) {
            addCriterion("rangeMax =", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxNotEqualTo(String value) {
            addCriterion("rangeMax <>", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxGreaterThan(String value) {
            addCriterion("rangeMax >", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxGreaterThanOrEqualTo(String value) {
            addCriterion("rangeMax >=", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxLessThan(String value) {
            addCriterion("rangeMax <", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxLessThanOrEqualTo(String value) {
            addCriterion("rangeMax <=", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxLike(String value) {
            addCriterion("rangeMax like", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxNotLike(String value) {
            addCriterion("rangeMax not like", value, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxIn(List<String> values) {
            addCriterion("rangeMax in", values, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxNotIn(List<String> values) {
            addCriterion("rangeMax not in", values, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxBetween(String value1, String value2) {
            addCriterion("rangeMax between", value1, value2, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRangeMaxNotBetween(String value1, String value2) {
            addCriterion("rangeMax not between", value1, value2, "rangeMax");
            return (Criteria) this;
        }

        public Criteria andRepeatNumIsNull() {
            addCriterion("repeatNum is null");
            return (Criteria) this;
        }

        public Criteria andRepeatNumIsNotNull() {
            addCriterion("repeatNum is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatNumEqualTo(Integer value) {
            addCriterion("repeatNum =", value, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumNotEqualTo(Integer value) {
            addCriterion("repeatNum <>", value, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumGreaterThan(Integer value) {
            addCriterion("repeatNum >", value, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("repeatNum >=", value, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumLessThan(Integer value) {
            addCriterion("repeatNum <", value, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumLessThanOrEqualTo(Integer value) {
            addCriterion("repeatNum <=", value, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumIn(List<Integer> values) {
            addCriterion("repeatNum in", values, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumNotIn(List<Integer> values) {
            addCriterion("repeatNum not in", values, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumBetween(Integer value1, Integer value2) {
            addCriterion("repeatNum between", value1, value2, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andRepeatNumNotBetween(Integer value1, Integer value2) {
            addCriterion("repeatNum not between", value1, value2, "repeatNum");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNull() {
            addCriterion("isUsed is null");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNotNull() {
            addCriterion("isUsed is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsedEqualTo(String value) {
            addCriterion("isUsed =", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotEqualTo(String value) {
            addCriterion("isUsed <>", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThan(String value) {
            addCriterion("isUsed >", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThanOrEqualTo(String value) {
            addCriterion("isUsed >=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThan(String value) {
            addCriterion("isUsed <", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThanOrEqualTo(String value) {
            addCriterion("isUsed <=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLike(String value) {
            addCriterion("isUsed like", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotLike(String value) {
            addCriterion("isUsed not like", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedIn(List<String> values) {
            addCriterion("isUsed in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotIn(List<String> values) {
            addCriterion("isUsed not in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedBetween(String value1, String value2) {
            addCriterion("isUsed between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotBetween(String value1, String value2) {
            addCriterion("isUsed not between", value1, value2, "isUsed");
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