package searchApi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import searchApi.out.SearchRequest;

public class jsonTest {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("age",20);
        json.put("name","max");
        System.out.println(json);
        String s = json.toJSONString();
        System.out.println(s);
        String t = "{'age':20,'name':'max'}";
        user j = JSON.parseObject(t,user.class);
        user c = new user(20,"max");
        System.out.println(c);
        System.out.println(t.equals(c.toString()));
        System.out.println(j.age);
        System.out.println(j.name);
        String str = "{'size':20,'posFrom':0}";
        SearchRequest searchRequest = JSON.parseObject(str,SearchRequest.class);
        System.out.println(searchRequest.size);
    }

}
class user implements java.io.Serializable{
    @Override
    public String toString() {
        return "{'age':" + age + ",'name':'" + name + "'}";
    }

    int age;
    String name;
    user(){}
    user(int a,String n){
        age = a;
        name = n;
    }
}
