package com.rongdu.common.utils.json;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 反序列化适配
 *
 * @author wl_code@163.com
 * @version 1.0
 * @date 2018/12/3
 */
public class NaturalDeserializer implements JsonDeserializer<Object> {

    /**
     * 反序列化
     *
     * @param json
     * @param typeOfT
     * @param context
     * @return
     * @throws JsonParseException
     */
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonNull())
            return null;
        else if (json.isJsonPrimitive())
            return handlePrimitive(json.getAsJsonPrimitive());
        else if (json.isJsonArray())
            return handleArray(json.getAsJsonArray(), context);
        else
            return handleObject(json.getAsJsonObject(), context);
    }

    private Object handlePrimitive(JsonPrimitive json) {
        if (json.isBoolean())
            return json.getAsBoolean();
        else if (json.isString())
            return json.getAsString();
        else {
            BigDecimal bigDec = json.getAsBigDecimal();
            // Find out if it is an int type
            try {
                bigDec.toBigIntegerExact();
                try {
                    return bigDec.intValueExact();
                } catch (ArithmeticException e) {
                }
                return bigDec.longValue();
            } catch (ArithmeticException e) {
            }
            // Just return it as a double
            return bigDec.doubleValue();
        }
    }

    /**
     * array
     *
     * @param json
     * @param context
     * @return
     */
    private Object handleArray(JsonArray json, JsonDeserializationContext context) {
        Object[] array = new Object[json.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = context.deserialize(json.get(i), Object.class);
        return array;
    }

    /**
     * object
     *
     * @param json
     * @param context
     * @return
     */
    private Object handleObject(JsonObject json, JsonDeserializationContext context) {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : json.entrySet())
            map.put(entry.getKey(), context.deserialize(entry.getValue(), Object.class));
        return map;
    }


}
