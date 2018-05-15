//First Part
//获取jsonobject对象
JSONObject obj=JSONObject.parseObject(result);
//把对象转换成jsonArray数组
arr=obj.getJSONArray("resultData");
//将数组转化为字符串
String js=JSONObject.toJSONString(arr, SerializerFeature.WriteClassName);
//将字符串转成List集合
List<JmtCase>  collection = JSONObject.parseArray(js, JmtCase.class);


//Second Part
JSONArray array = JSONArray.fromObject("[{'name':'hehe','age':18}]");
List<Person> list1 = JSONArray.toList(array, Person.class);
System.out.println(list.get(0).getName());

List<?> list2 = JSONArray.toList(array, new Person(), new JsonConfig());
Person person = (Person)list2.get(0);
System.out.println(person.getAge());
