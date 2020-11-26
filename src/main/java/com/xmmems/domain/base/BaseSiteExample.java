package com.xmmems.domain.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseSiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseSiteExample() {
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

        public Criteria andOperCompanyIsNull() {
            addCriterion("operCompany is null");
            return (Criteria) this;
        }

        public Criteria andOperCompanyIsNotNull() {
            addCriterion("operCompany is not null");
            return (Criteria) this;
        }

        public Criteria andOperCompanyEqualTo(String value) {
            addCriterion("operCompany =", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyNotEqualTo(String value) {
            addCriterion("operCompany <>", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyGreaterThan(String value) {
            addCriterion("operCompany >", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("operCompany >=", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyLessThan(String value) {
            addCriterion("operCompany <", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyLessThanOrEqualTo(String value) {
            addCriterion("operCompany <=", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyLike(String value) {
            addCriterion("operCompany like", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyNotLike(String value) {
            addCriterion("operCompany not like", value, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyIn(List<String> values) {
            addCriterion("operCompany in", values, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyNotIn(List<String> values) {
            addCriterion("operCompany not in", values, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyBetween(String value1, String value2) {
            addCriterion("operCompany between", value1, value2, "operCompany");
            return (Criteria) this;
        }

        public Criteria andOperCompanyNotBetween(String value1, String value2) {
            addCriterion("operCompany not between", value1, value2, "operCompany");
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

        public Criteria andSectionCodeIsNull() {
            addCriterion("sectionCode is null");
            return (Criteria) this;
        }

        public Criteria andSectionCodeIsNotNull() {
            addCriterion("sectionCode is not null");
            return (Criteria) this;
        }

        public Criteria andSectionCodeEqualTo(String value) {
            addCriterion("sectionCode =", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotEqualTo(String value) {
            addCriterion("sectionCode <>", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeGreaterThan(String value) {
            addCriterion("sectionCode >", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sectionCode >=", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeLessThan(String value) {
            addCriterion("sectionCode <", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeLessThanOrEqualTo(String value) {
            addCriterion("sectionCode <=", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeLike(String value) {
            addCriterion("sectionCode like", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotLike(String value) {
            addCriterion("sectionCode not like", value, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeIn(List<String> values) {
            addCriterion("sectionCode in", values, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotIn(List<String> values) {
            addCriterion("sectionCode not in", values, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeBetween(String value1, String value2) {
            addCriterion("sectionCode between", value1, value2, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionCodeNotBetween(String value1, String value2) {
            addCriterion("sectionCode not between", value1, value2, "sectionCode");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNull() {
            addCriterion("sectionName is null");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNotNull() {
            addCriterion("sectionName is not null");
            return (Criteria) this;
        }

        public Criteria andSectionNameEqualTo(String value) {
            addCriterion("sectionName =", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotEqualTo(String value) {
            addCriterion("sectionName <>", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThan(String value) {
            addCriterion("sectionName >", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("sectionName >=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThan(String value) {
            addCriterion("sectionName <", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThanOrEqualTo(String value) {
            addCriterion("sectionName <=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLike(String value) {
            addCriterion("sectionName like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotLike(String value) {
            addCriterion("sectionName not like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameIn(List<String> values) {
            addCriterion("sectionName in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotIn(List<String> values) {
            addCriterion("sectionName not in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameBetween(String value1, String value2) {
            addCriterion("sectionName between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotBetween(String value1, String value2) {
            addCriterion("sectionName not between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("provinceCode is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("provinceCode is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("provinceCode =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("provinceCode <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("provinceCode >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("provinceCode >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("provinceCode <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("provinceCode <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("provinceCode like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("provinceCode not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("provinceCode in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("provinceCode not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("provinceCode between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("provinceCode not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("provinceName is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("provinceName is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("provinceName =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("provinceName <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("provinceName >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("provinceName >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("provinceName <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("provinceName <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("provinceName like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("provinceName not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("provinceName in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("provinceName not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("provinceName between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("provinceName not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("cityCode is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("cityCode is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("cityCode =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("cityCode <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("cityCode >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cityCode >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("cityCode <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("cityCode <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("cityCode like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("cityCode not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("cityCode in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("cityCode not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("cityCode between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("cityCode not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("cityName is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("cityName is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("cityName =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("cityName <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("cityName >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("cityName >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("cityName <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("cityName <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("cityName like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("cityName not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("cityName in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("cityName not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("cityName between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("cityName not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIsNull() {
            addCriterion("countyCode is null");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIsNotNull() {
            addCriterion("countyCode is not null");
            return (Criteria) this;
        }

        public Criteria andCountyCodeEqualTo(String value) {
            addCriterion("countyCode =", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotEqualTo(String value) {
            addCriterion("countyCode <>", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeGreaterThan(String value) {
            addCriterion("countyCode >", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("countyCode >=", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLessThan(String value) {
            addCriterion("countyCode <", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLessThanOrEqualTo(String value) {
            addCriterion("countyCode <=", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLike(String value) {
            addCriterion("countyCode like", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotLike(String value) {
            addCriterion("countyCode not like", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIn(List<String> values) {
            addCriterion("countyCode in", values, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotIn(List<String> values) {
            addCriterion("countyCode not in", values, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeBetween(String value1, String value2) {
            addCriterion("countyCode between", value1, value2, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotBetween(String value1, String value2) {
            addCriterion("countyCode not between", value1, value2, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyNameIsNull() {
            addCriterion("countyName is null");
            return (Criteria) this;
        }

        public Criteria andCountyNameIsNotNull() {
            addCriterion("countyName is not null");
            return (Criteria) this;
        }

        public Criteria andCountyNameEqualTo(String value) {
            addCriterion("countyName =", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameNotEqualTo(String value) {
            addCriterion("countyName <>", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameGreaterThan(String value) {
            addCriterion("countyName >", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameGreaterThanOrEqualTo(String value) {
            addCriterion("countyName >=", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameLessThan(String value) {
            addCriterion("countyName <", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameLessThanOrEqualTo(String value) {
            addCriterion("countyName <=", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameLike(String value) {
            addCriterion("countyName like", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameNotLike(String value) {
            addCriterion("countyName not like", value, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameIn(List<String> values) {
            addCriterion("countyName in", values, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameNotIn(List<String> values) {
            addCriterion("countyName not in", values, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameBetween(String value1, String value2) {
            addCriterion("countyName between", value1, value2, "countyName");
            return (Criteria) this;
        }

        public Criteria andCountyNameNotBetween(String value1, String value2) {
            addCriterion("countyName not between", value1, value2, "countyName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSiteTypeIsNull() {
            addCriterion("siteType is null");
            return (Criteria) this;
        }

        public Criteria andSiteTypeIsNotNull() {
            addCriterion("siteType is not null");
            return (Criteria) this;
        }

        public Criteria andSiteTypeEqualTo(String value) {
            addCriterion("siteType =", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotEqualTo(String value) {
            addCriterion("siteType <>", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeGreaterThan(String value) {
            addCriterion("siteType >", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("siteType >=", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeLessThan(String value) {
            addCriterion("siteType <", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeLessThanOrEqualTo(String value) {
            addCriterion("siteType <=", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeLike(String value) {
            addCriterion("siteType like", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotLike(String value) {
            addCriterion("siteType not like", value, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeIn(List<String> values) {
            addCriterion("siteType in", values, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotIn(List<String> values) {
            addCriterion("siteType not in", values, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeBetween(String value1, String value2) {
            addCriterion("siteType between", value1, value2, "siteType");
            return (Criteria) this;
        }

        public Criteria andSiteTypeNotBetween(String value1, String value2) {
            addCriterion("siteType not between", value1, value2, "siteType");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNull() {
            addCriterion("contactPerson is null");
            return (Criteria) this;
        }

        public Criteria andContactPersonIsNotNull() {
            addCriterion("contactPerson is not null");
            return (Criteria) this;
        }

        public Criteria andContactPersonEqualTo(String value) {
            addCriterion("contactPerson =", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotEqualTo(String value) {
            addCriterion("contactPerson <>", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThan(String value) {
            addCriterion("contactPerson >", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonGreaterThanOrEqualTo(String value) {
            addCriterion("contactPerson >=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThan(String value) {
            addCriterion("contactPerson <", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLessThanOrEqualTo(String value) {
            addCriterion("contactPerson <=", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonLike(String value) {
            addCriterion("contactPerson like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotLike(String value) {
            addCriterion("contactPerson not like", value, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonIn(List<String> values) {
            addCriterion("contactPerson in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotIn(List<String> values) {
            addCriterion("contactPerson not in", values, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonBetween(String value1, String value2) {
            addCriterion("contactPerson between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactPersonNotBetween(String value1, String value2) {
            addCriterion("contactPerson not between", value1, value2, "contactPerson");
            return (Criteria) this;
        }

        public Criteria andContactTelsIsNull() {
            addCriterion("contactTels is null");
            return (Criteria) this;
        }

        public Criteria andContactTelsIsNotNull() {
            addCriterion("contactTels is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelsEqualTo(String value) {
            addCriterion("contactTels =", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsNotEqualTo(String value) {
            addCriterion("contactTels <>", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsGreaterThan(String value) {
            addCriterion("contactTels >", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsGreaterThanOrEqualTo(String value) {
            addCriterion("contactTels >=", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsLessThan(String value) {
            addCriterion("contactTels <", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsLessThanOrEqualTo(String value) {
            addCriterion("contactTels <=", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsLike(String value) {
            addCriterion("contactTels like", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsNotLike(String value) {
            addCriterion("contactTels not like", value, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsIn(List<String> values) {
            addCriterion("contactTels in", values, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsNotIn(List<String> values) {
            addCriterion("contactTels not in", values, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsBetween(String value1, String value2) {
            addCriterion("contactTels between", value1, value2, "contactTels");
            return (Criteria) this;
        }

        public Criteria andContactTelsNotBetween(String value1, String value2) {
            addCriterion("contactTels not between", value1, value2, "contactTels");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateIsNull() {
            addCriterion("createStationDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateIsNotNull() {
            addCriterion("createStationDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateEqualTo(Date value) {
            addCriterion("createStationDate =", value, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateNotEqualTo(Date value) {
            addCriterion("createStationDate <>", value, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateGreaterThan(Date value) {
            addCriterion("createStationDate >", value, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("createStationDate >=", value, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateLessThan(Date value) {
            addCriterion("createStationDate <", value, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateLessThanOrEqualTo(Date value) {
            addCriterion("createStationDate <=", value, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateIn(List<Date> values) {
            addCriterion("createStationDate in", values, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateNotIn(List<Date> values) {
            addCriterion("createStationDate not in", values, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateBetween(Date value1, Date value2) {
            addCriterion("createStationDate between", value1, value2, "createStationDate");
            return (Criteria) this;
        }

        public Criteria andCreateStationDateNotBetween(Date value1, Date value2) {
            addCriterion("createStationDate not between", value1, value2, "createStationDate");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andIsvalidEqualTo(String value) {
            addCriterion("isvalid =", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotEqualTo(String value) {
            addCriterion("isvalid <>", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThan(String value) {
            addCriterion("isvalid >", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThanOrEqualTo(String value) {
            addCriterion("isvalid >=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThan(String value) {
            addCriterion("isvalid <", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThanOrEqualTo(String value) {
            addCriterion("isvalid <=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLike(String value) {
            addCriterion("isvalid like", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotLike(String value) {
            addCriterion("isvalid not like", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidIn(List<String> values) {
            addCriterion("isvalid in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotIn(List<String> values) {
            addCriterion("isvalid not in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidBetween(String value1, String value2) {
            addCriterion("isvalid between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotBetween(String value1, String value2) {
            addCriterion("isvalid not between", value1, value2, "isvalid");
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