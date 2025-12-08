package com.artplusplus.contpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public <T> T applyMergePatchNode(T targetBean, JsonNode patch, Class<T> clazz) {
        JsonNode targetNode = objectMapper.valueToTree(targetBean);
        JsonNode patchedNode = mergeNodes(targetNode, patch);
        try {
            return objectMapper.treeToValue(patchedNode, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Could not convert patched JSON to object", e);
        }
    }

    private JsonNode mergeNodes(JsonNode target, JsonNode patch) {
        if (!patch.isObject())
            return patch;
        ObjectNode targetObj = target.deepCopy();
        patch.fields().forEachRemaining(entry -> {
            String field = entry.getKey();
            JsonNode value = entry.getValue();
            if (value.isNull())
                targetObj.remove(field);
            else {
                JsonNode existing = targetObj.get(field);
                if (existing != null && existing.isObject() && value.isObject())
                    targetObj.set(field, mergeNodes(existing, value));
                else
                    targetObj.set(field, value);
            }
        });
        return targetObj;
    }
}
