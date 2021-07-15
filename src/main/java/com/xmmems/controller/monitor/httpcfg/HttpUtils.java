package com.xmmems.controller.monitor.httpcfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @描述 发送请求客户端
 * @创建人 ithxw
 * @创建时间 2021.05.11 11:35
 */
@Component
public class HttpUtils {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RestTemplateConfig config;

    public Boolean postReturnBoolean(String url, Map<String, String> map) {
        if (this.config.isUse()) {
            try {
                System.out.println("同步审批操作");
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("currentReqTime", System.currentTimeMillis() + "");
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        params.add(entry.getKey(), entry.getValue());
                    }
                }
                HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
                return HttpUtils.this.restTemplate.exchange(HttpUtils.this.config.getUrlPrefix() + url, HttpMethod.POST, requestEntity, Boolean.class).getBody();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String postReturnBody(String url, Map<String, String> map) {
        try {
            if (this.config.isUse()) {
                System.out.println("同步打标识");
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("currentReqTime", System.currentTimeMillis() + "");
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        params.add(entry.getKey(), entry.getValue());
                    }
                }
                HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
                ResponseEntity<String> response = HttpUtils.this.restTemplate.exchange(HttpUtils.this.config.getUrlPrefix() + url, HttpMethod.POST, requestEntity, String.class);
                return response.getBody();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
