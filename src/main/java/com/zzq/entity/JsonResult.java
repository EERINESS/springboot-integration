package com.zzq.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * @author zzq
 * @createTime 2018/3/21
 */
public class JsonResult {
    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    private String ok;

    public static JsonResult build(Integer status, String msg, Object data) {
        return  new JsonResult(status, msg, data);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok(){
        return new JsonResult(null);
    }

    public static JsonResult errorMsg(String msg){
        return new JsonResult(500, msg, null);
    }

    public static JsonResult errorMap(Object data){
        return new JsonResult(501, "error", data);
    }

    public static JsonResult errorTokenMsg(String msg){
        return new JsonResult(555, msg, null);
    }

    public JsonResult(){}

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.data = data;
        this.msg = "OK";
        this.status = 200;
    }

    public Boolean isOK(){
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    /**
     * @Description:  将 json 结果集转换为 JsonResult 对象，需要转换的为一个类
     *
     * @param jsonData
     * @param clazz
     * @return
     */
    public static JsonResult formatToPojo(String jsonData, Class<?> clazz){
        try {
            if(clazz == null){
                return MAPPER.readValue(jsonData, JsonResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object object = null;
            if (clazz != null){
                if (data.isObject()){
                    object = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()){
                    object = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), object);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * @没有 object 对象的转化
     * @param json
     * @return
     */
    public static JsonResult format(String json){
        try {
            return MAPPER.readValue(json, JsonResult.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description:  Object 是集合转化
     *              需要转化的对象是一个 list
     *
     * @param jsonData
     * @param clazz
     * @return
     */
    public static JsonResult formatToList(String jsonData, Class<?> clazz){
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object object = null;
            if (data.isArray() && data.size() > 0){
                object = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), object);
        }catch (Exception e){
            return null;
        }
    }
}
