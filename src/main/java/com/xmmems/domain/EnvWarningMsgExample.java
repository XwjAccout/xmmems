package com.xmmems.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvWarningMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvWarningMsgExample() {
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

        public Criteria andPhoneNumIsNull() {
            addCriterion("phoneNum is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phoneNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phoneNum =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phoneNum <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phoneNum >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNum >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phoneNum <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phoneNum <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phoneNum like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phoneNum not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phoneNum in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phoneNum not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phoneNum between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phoneNum not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeIsNull() {
            addCriterion("templateCode is null");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeIsNotNull() {
            addCriterion("templateCode is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeEqualTo(String value) {
            addCriterion("templateCode =", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotEqualTo(String value) {
            addCriterion("templateCode <>", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeGreaterThan(String value) {
            addCriterion("templateCode >", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("templateCode >=", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeLessThan(String value) {
            addCriterion("templateCode <", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeLessThanOrEqualTo(String value) {
            addCriterion("templateCode <=", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeLike(String value) {
            addCriterion("templateCode like", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotLike(String value) {
            addCriterion("templateCode not like", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeIn(List<String> values) {
            addCriterion("templateCode in", values, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotIn(List<String> values) {
            addCriterion("templateCode not in", values, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeBetween(String value1, String value2) {
            addCriterion("templateCode between", value1, value2, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotBetween(String value1, String value2) {
            addCriterion("templateCode not between", value1, value2, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateParamIsNull() {
            addCriterion("templateParam is null");
            return (Criteria) this;
        }

        public Criteria andTemplateParamIsNotNull() {
            addCriterion("templateParam is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateParamEqualTo(String value) {
            addCriterion("templateParam =", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamNotEqualTo(String value) {
            addCriterion("templateParam <>", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamGreaterThan(String value) {
            addCriterion("templateParam >", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamGreaterThanOrEqualTo(String value) {
            addCriterion("templateParam >=", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamLessThan(String value) {
            addCriterion("templateParam <", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamLessThanOrEqualTo(String value) {
            addCriterion("templateParam <=", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamLike(String value) {
            addCriterion("templateParam like", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamNotLike(String value) {
            addCriterion("templateParam not like", value, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamIn(List<String> values) {
            addCriterion("templateParam in", values, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamNotIn(List<String> values) {
            addCriterion("templateParam not in", values, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamBetween(String value1, String value2) {
            addCriterion("templateParam between", value1, value2, "templateParam");
            return (Criteria) this;
        }

        public Criteria andTemplateParamNotBetween(String value1, String value2) {
            addCriterion("templateParam not between", value1, value2, "templateParam");
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

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNull() {
            addCriterion("bizId is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("bizId is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(String value) {
            addCriterion("bizId =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(String value) {
            addCriterion("bizId <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(String value) {
            addCriterion("bizId >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(String value) {
            addCriterion("bizId >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(String value) {
            addCriterion("bizId <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(String value) {
            addCriterion("bizId <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLike(String value) {
            addCriterion("bizId like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotLike(String value) {
            addCriterion("bizId not like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(List<String> values) {
            addCriterion("bizId in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(List<String> values) {
            addCriterion("bizId not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(String value1, String value2) {
            addCriterion("bizId between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(String value1, String value2) {
            addCriterion("bizId not between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receiveTime is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receiveTime is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receiveTime =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receiveTime <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receiveTime >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receiveTime >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receiveTime <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receiveTime <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receiveTime in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receiveTime not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receiveTime between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receiveTime not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNull() {
            addCriterion("errCode is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNotNull() {
            addCriterion("errCode is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeEqualTo(String value) {
            addCriterion("errCode =", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotEqualTo(String value) {
            addCriterion("errCode <>", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThan(String value) {
            addCriterion("errCode >", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("errCode >=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThan(String value) {
            addCriterion("errCode <", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThanOrEqualTo(String value) {
            addCriterion("errCode <=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLike(String value) {
            addCriterion("errCode like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotLike(String value) {
            addCriterion("errCode not like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIn(List<String> values) {
            addCriterion("errCode in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotIn(List<String> values) {
            addCriterion("errCode not in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeBetween(String value1, String value2) {
            addCriterion("errCode between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotBetween(String value1, String value2) {
            addCriterion("errCode not between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andOutIdIsNull() {
            addCriterion("outId is null");
            return (Criteria) this;
        }

        public Criteria andOutIdIsNotNull() {
            addCriterion("outId is not null");
            return (Criteria) this;
        }

        public Criteria andOutIdEqualTo(String value) {
            addCriterion("outId =", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotEqualTo(String value) {
            addCriterion("outId <>", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThan(String value) {
            addCriterion("outId >", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThanOrEqualTo(String value) {
            addCriterion("outId >=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThan(String value) {
            addCriterion("outId <", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThanOrEqualTo(String value) {
            addCriterion("outId <=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLike(String value) {
            addCriterion("outId like", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotLike(String value) {
            addCriterion("outId not like", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdIn(List<String> values) {
            addCriterion("outId in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotIn(List<String> values) {
            addCriterion("outId not in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdBetween(String value1, String value2) {
            addCriterion("outId between", value1, value2, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotBetween(String value1, String value2) {
            addCriterion("outId not between", value1, value2, "outId");
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