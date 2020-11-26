package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvSiteInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvSiteInfoExample() {
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

        public Criteria andSiteMNameIsNull() {
            addCriterion("siteMName is null");
            return (Criteria) this;
        }

        public Criteria andSiteMNameIsNotNull() {
            addCriterion("siteMName is not null");
            return (Criteria) this;
        }

        public Criteria andSiteMNameEqualTo(String value) {
            addCriterion("siteMName =", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameNotEqualTo(String value) {
            addCriterion("siteMName <>", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameGreaterThan(String value) {
            addCriterion("siteMName >", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameGreaterThanOrEqualTo(String value) {
            addCriterion("siteMName >=", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameLessThan(String value) {
            addCriterion("siteMName <", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameLessThanOrEqualTo(String value) {
            addCriterion("siteMName <=", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameLike(String value) {
            addCriterion("siteMName like", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameNotLike(String value) {
            addCriterion("siteMName not like", value, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameIn(List<String> values) {
            addCriterion("siteMName in", values, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameNotIn(List<String> values) {
            addCriterion("siteMName not in", values, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameBetween(String value1, String value2) {
            addCriterion("siteMName between", value1, value2, "siteMName");
            return (Criteria) this;
        }

        public Criteria andSiteMNameNotBetween(String value1, String value2) {
            addCriterion("siteMName not between", value1, value2, "siteMName");
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

        public Criteria andAreaCodeIsNull() {
            addCriterion("areaCode is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("areaCode is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("areaCode =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("areaCode <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("areaCode >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("areaCode >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("areaCode <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("areaCode <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("areaCode like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("areaCode not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("areaCode in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("areaCode not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("areaCode between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("areaCode not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("areaName is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("areaName is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("areaName =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("areaName <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("areaName >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("areaName >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("areaName <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("areaName <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("areaName like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("areaName not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("areaName in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("areaName not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("areaName between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("areaName not between", value1, value2, "areaName");
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

        public Criteria andStationTypeIsNull() {
            addCriterion("stationType is null");
            return (Criteria) this;
        }

        public Criteria andStationTypeIsNotNull() {
            addCriterion("stationType is not null");
            return (Criteria) this;
        }

        public Criteria andStationTypeEqualTo(String value) {
            addCriterion("stationType =", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeNotEqualTo(String value) {
            addCriterion("stationType <>", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeGreaterThan(String value) {
            addCriterion("stationType >", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("stationType >=", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeLessThan(String value) {
            addCriterion("stationType <", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeLessThanOrEqualTo(String value) {
            addCriterion("stationType <=", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeLike(String value) {
            addCriterion("stationType like", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeNotLike(String value) {
            addCriterion("stationType not like", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeIn(List<String> values) {
            addCriterion("stationType in", values, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeNotIn(List<String> values) {
            addCriterion("stationType not in", values, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeBetween(String value1, String value2) {
            addCriterion("stationType between", value1, value2, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeNotBetween(String value1, String value2) {
            addCriterion("stationType not between", value1, value2, "stationType");
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

        public Criteria andReportNumIsNull() {
            addCriterion("reportNum is null");
            return (Criteria) this;
        }

        public Criteria andReportNumIsNotNull() {
            addCriterion("reportNum is not null");
            return (Criteria) this;
        }

        public Criteria andReportNumEqualTo(Integer value) {
            addCriterion("reportNum =", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumNotEqualTo(Integer value) {
            addCriterion("reportNum <>", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumGreaterThan(Integer value) {
            addCriterion("reportNum >", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("reportNum >=", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumLessThan(Integer value) {
            addCriterion("reportNum <", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumLessThanOrEqualTo(Integer value) {
            addCriterion("reportNum <=", value, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumIn(List<Integer> values) {
            addCriterion("reportNum in", values, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumNotIn(List<Integer> values) {
            addCriterion("reportNum not in", values, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumBetween(Integer value1, Integer value2) {
            addCriterion("reportNum between", value1, value2, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportNumNotBetween(Integer value1, Integer value2) {
            addCriterion("reportNum not between", value1, value2, "reportNum");
            return (Criteria) this;
        }

        public Criteria andReportTelsIsNull() {
            addCriterion("reportTels is null");
            return (Criteria) this;
        }

        public Criteria andReportTelsIsNotNull() {
            addCriterion("reportTels is not null");
            return (Criteria) this;
        }

        public Criteria andReportTelsEqualTo(String value) {
            addCriterion("reportTels =", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsNotEqualTo(String value) {
            addCriterion("reportTels <>", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsGreaterThan(String value) {
            addCriterion("reportTels >", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsGreaterThanOrEqualTo(String value) {
            addCriterion("reportTels >=", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsLessThan(String value) {
            addCriterion("reportTels <", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsLessThanOrEqualTo(String value) {
            addCriterion("reportTels <=", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsLike(String value) {
            addCriterion("reportTels like", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsNotLike(String value) {
            addCriterion("reportTels not like", value, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsIn(List<String> values) {
            addCriterion("reportTels in", values, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsNotIn(List<String> values) {
            addCriterion("reportTels not in", values, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsBetween(String value1, String value2) {
            addCriterion("reportTels between", value1, value2, "reportTels");
            return (Criteria) this;
        }

        public Criteria andReportTelsNotBetween(String value1, String value2) {
            addCriterion("reportTels not between", value1, value2, "reportTels");
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

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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