//获取jsonobject对象
JSONObject obj=JSONObject.parseObject(result);
//把对象转换成jsonArray数组
arr=obj.getJSONArray("resultData");
//将数组转化为字符串
String js=JSONObject.toJSONString(arr, SerializerFeature.WriteClassName);
//将字符串转成List集合
List<JmtCase>  collection = JSONObject.parseArray(js, JmtCase.class);
