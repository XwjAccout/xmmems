package com.xmmems.domain;

import java.util.ArrayList;
import java.util.List;

public class OperationVehicleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationVehicleExample() {
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

        public Criteria andUnitIDIsNull() {
            addCriterion("unitID is null");
            return (Criteria) this;
        }

        public Criteria andUnitIDIsNotNull() {
            addCriterion("unitID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIDEqualTo(Integer value) {
            addCriterion("unitID =", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDNotEqualTo(Integer value) {
            addCriterion("unitID <>", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDGreaterThan(Integer value) {
            addCriterion("unitID >", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("unitID >=", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDLessThan(Integer value) {
            addCriterion("unitID <", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDLessThanOrEqualTo(Integer value) {
            addCriterion("unitID <=", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDIn(List<Integer> values) {
            addCriterion("unitID in", values, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDNotIn(List<Integer> values) {
            addCriterion("unitID not in", values, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDBetween(Integer value1, Integer value2) {
            addCriterion("unitID between", value1, value2, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDNotBetween(Integer value1, Integer value2) {
            addCriterion("unitID not between", value1, value2, "unitID");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLicenceIsNull() {
            addCriterion("licence is null");
            return (Criteria) this;
        }

        public Criteria andLicenceIsNotNull() {
            addCriterion("licence is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceEqualTo(String value) {
            addCriterion("licence =", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotEqualTo(String value) {
            addCriterion("licence <>", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceGreaterThan(String value) {
            addCriterion("licence >", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("licence >=", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLessThan(String value) {
            addCriterion("licence <", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLessThanOrEqualTo(String value) {
            addCriterion("licence <=", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLike(String value) {
            addCriterion("licence like", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotLike(String value) {
            addCriterion("licence not like", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceIn(List<String> values) {
            addCriterion("licence in", values, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotIn(List<String> values) {
            addCriterion("licence not in", values, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceBetween(String value1, String value2) {
            addCriterion("licence between", value1, value2, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotBetween(String value1, String value2) {
            addCriterion("licence not between", value1, value2, "licence");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIsNull() {
            addCriterion("responsiblePerson is null");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIsNotNull() {
            addCriterion("responsiblePerson is not null");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonEqualTo(String value) {
            addCriterion("responsiblePerson =", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotEqualTo(String value) {
            addCriterion("responsiblePerson <>", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonGreaterThan(String value) {
            addCriterion("responsiblePerson >", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonGreaterThanOrEqualTo(String value) {
            addCriterion("responsiblePerson >=", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLessThan(String value) {
            addCriterion("responsiblePerson <", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLessThanOrEqualTo(String value) {
            addCriterion("responsiblePerson <=", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLike(String value) {
            addCriterion("responsiblePerson like", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotLike(String value) {
            addCriterion("responsiblePerson not like", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIn(List<String> values) {
            addCriterion("responsiblePerson in", values, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotIn(List<String> values) {
            addCriterion("responsiblePerson not in", values, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonBetween(String value1, String value2) {
            addCriterion("responsiblePerson between", value1, value2, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotBetween(String value1, String value2) {
            addCriterion("responsiblePerson not between", value1, value2, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerIsNull() {
            addCriterion("telephoneNumer is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerIsNotNull() {
            addCriterion("telephoneNumer is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerEqualTo(String value) {
            addCriterion("telephoneNumer =", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerNotEqualTo(String value) {
            addCriterion("telephoneNumer <>", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerGreaterThan(String value) {
            addCriterion("telephoneNumer >", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerGreaterThanOrEqualTo(String value) {
            addCriterion("telephoneNumer >=", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerLessThan(String value) {
            addCriterion("telephoneNumer <", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerLessThanOrEqualTo(String value) {
            addCriterion("telephoneNumer <=", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerLike(String value) {
            addCriterion("telephoneNumer like", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerNotLike(String value) {
            addCriterion("telephoneNumer not like", value, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerIn(List<String> values) {
            addCriterion("telephoneNumer in", values, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerNotIn(List<String> values) {
            addCriterion("telephoneNumer not in", values, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerBetween(String value1, String value2) {
            addCriterion("telephoneNumer between", value1, value2, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andTelephoneNumerNotBetween(String value1, String value2) {
            addCriterion("telephoneNumer not between", value1, value2, "telephoneNumer");
            return (Criteria) this;
        }

        public Criteria andUseYearIsNull() {
            addCriterion("useYear is null");
            return (Criteria) this;
        }

        public Criteria andUseYearIsNotNull() {
            addCriterion("useYear is not null");
            return (Criteria) this;
        }

        public Criteria andUseYearEqualTo(String value) {
            addCriterion("useYear =", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotEqualTo(String value) {
            addCriterion("useYear <>", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearGreaterThan(String value) {
            addCriterion("useYear >", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearGreaterThanOrEqualTo(String value) {
            addCriterion("useYear >=", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLessThan(String value) {
            addCriterion("useYear <", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLessThanOrEqualTo(String value) {
            addCriterion("useYear <=", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearLike(String value) {
            addCriterion("useYear like", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotLike(String value) {
            addCriterion("useYear not like", value, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearIn(List<String> values) {
            addCriterion("useYear in", values, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotIn(List<String> values) {
            addCriterion("useYear not in", values, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearBetween(String value1, String value2) {
            addCriterion("useYear between", value1, value2, "useYear");
            return (Criteria) this;
        }

        public Criteria andUseYearNotBetween(String value1, String value2) {
            addCriterion("useYear not between", value1, value2, "useYear");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andProductionIsNull() {
            addCriterion("production is null");
            return (Criteria) this;
        }

        public Criteria andProductionIsNotNull() {
            addCriterion("production is not null");
            return (Criteria) this;
        }

        public Criteria andProductionEqualTo(String value) {
            addCriterion("production =", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotEqualTo(String value) {
            addCriterion("production <>", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionGreaterThan(String value) {
            addCriterion("production >", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionGreaterThanOrEqualTo(String value) {
            addCriterion("production >=", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionLessThan(String value) {
            addCriterion("production <", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionLessThanOrEqualTo(String value) {
            addCriterion("production <=", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionLike(String value) {
            addCriterion("production like", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotLike(String value) {
            addCriterion("production not like", value, "production");
            return (Criteria) this;
        }

        public Criteria andProductionIn(List<String> values) {
            addCriterion("production in", values, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotIn(List<String> values) {
            addCriterion("production not in", values, "production");
            return (Criteria) this;
        }

        public Criteria andProductionBetween(String value1, String value2) {
            addCriterion("production between", value1, value2, "production");
            return (Criteria) this;
        }

        public Criteria andProductionNotBetween(String value1, String value2) {
            addCriterion("production not between", value1, value2, "production");
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