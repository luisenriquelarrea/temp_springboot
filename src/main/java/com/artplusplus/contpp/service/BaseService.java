package com.artplusplus.contpp.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface BaseService {
    <T> T applyMergePatchNode(T targetBean, JsonNode patch, Class<T> clazz);
}
