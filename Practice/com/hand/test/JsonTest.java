package com.hand.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hand.model.Address;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		
		//jsonArray和json互相转换
		javaArrayAndJsonInterChange();
		System.out.println("----------First----------");
		//javaList和json互相转换
		javaListAndJsonInterChange();
		System.out.println("----------Second----------");
		//javaMap和json互相转换
		javaMapAndJsonInterChange();
		System.out.println("----------Third----------");
		//javaObject和jsonObject互相转换
		javaobjectAndJsonInterChange();
		System.out.println("----------End----------");
		
	}
	
	//jsonArray和json互相转换
	public static void javaArrayAndJsonInterChange() {
		boolean[] boolArray = new boolean[] {true, false, true};
		JSONArray jsonArray = JSONArray.fromObject(boolArray);
		String s = jsonArray.toString();
		System.out.println(s);
		
		//通过json获取数组中的数据
		String result = readJson("configdata");
		
		JSONArray jsonR = JSONArray.fromObject(result);
		int size = jsonR.size();
		for (int i = 0; i < size; i++) {
			System.out.println(jsonR.get(i));
		}
	}
	
	//javaList和json互相转换
	public static void javaListAndJsonInterChange() {
		List<Object> list = new ArrayList<Object>();
		list.add(new Integer(1));
		list.add(new Boolean(true));
		list.add(new Character('j'));
		list.add(new char[] {'j','s','o','n'});
		list.add(null);
		list.add("json");
		list.add(new String[] {"json","-","lib"});
		
		//list to JSONArray
		JSONArray jsArr = JSONArray.fromObject(list);
		System.out.println(jsArr.toString(4));
		
		//从JSON串到JSONArray
		jsArr = JSONArray.fromObject(jsArr.toString());
		System.out.println(((JSONArray) jsArr.get(6)).get(0));
	}
	
	//javaMap和json互相转换
	public static void javaMapAndJsonInterChange() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("integer", new Integer(1));  
        map.put("boolean", new Boolean(true));  
        map.put("char", new Character('j'));  
        map.put("charArr", new char[] { 'j', 's', 'o', 'n' });  
        // 注:不能以null为键名，否则运行报net.sf.json.JSONException:  
        // java.lang.NullPointerException:JSON keys must not be null nor the 'null' string.  
        map.put("nullAttr", null);  
        map.put("str", "json");  
        map.put("strArr", new String[] { "json", "-", "lib" });  
        map.put("jsonFunction", new JSONFunction(new String[] { "i" },"alert(i)"));  
        map.put("address", new Address("P.O BOX 54534", "Seattle, WA", 42452,"561-832-3180"));  
        
        // map转JSONArray  
        JSONObject jsObj = JSONObject.fromObject(map);  
        System.out.println(jsObj.toString(4));  
          
        // 从JSON串到JSONObject  
        jsObj = JSONObject.fromObject(jsObj.toString());  
  
        //第一种方式：从JSONObject里读取  
        System.out.println(jsObj.get("str"));  
        System.out.println("address.city = " + ((JSONObject) jsObj.get("address")).get("city"));    
  
          
        //第二种方式：从动态Bean里读取数据，由于不能转换成具体的Bean，感觉没有多大用处  
        MorphDynaBean mdBean = (MorphDynaBean) JSONObject.toBean(jsObj);  
        System.out.println(mdBean.get("str"));  
        System.out.println("address.city = " + ((MorphDynaBean) mdBean.get("address")).get("city"));  
	}

	//javaObject和jsonObject互相转换
	public static void javaobjectAndJsonInterChange() {
		Address address=new Address("P.O BOX 54534", "Seattle, WA", 42452,"561-832-3180");  
        //object转JSONObject  
        JSONObject jsObj = JSONObject.fromObject(address);  
        System.out.println(jsObj.toString(4));  
          
        //JsonObject转java Object  
        Address addressResult=(Address) JSONObject.toBean(jsObj, Address.class);  
        System.out.println("address.city = "+ addressResult.getCity());  
        System.out.println("address.street="+addressResult.getStreet());  
        System.out.println("address.tel = "+ addressResult.getTel());  
        System.out.println("address.zip="+addressResult.getZip());
	}
	
	private static String readJson(String fileName) {
		String result = null;  
        try {  
            File myFile = new File("./resources/" + fileName + ".json");  
            FileReader fr = new FileReader(myFile);  
            char[] contents = new char[(int) myFile.length()];  
            fr.read(contents, 0, (int) myFile.length());  
            result = new String(contents);  
            fr.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  

}
