package com.xu.hasee.livewhere;


import android.util.Log;

import com.xu.hasee.livewhere.home.MyEntity_hotelInfo;
import com.xu.hasee.livewhere.home.MyEntity_location;
import com.xu.hasee.livewhere.home.hotel_detile.MyEntity_hotel;
import com.xu.hasee.livewhere.home.hotel_detile.MyEntity_list_item;
import com.xu.hasee.livewhere.home.hotel_detile.MyEntity_plans;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.ChildEntity;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.GroupEntity;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.MyEntity_comments;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.MyEntity_content;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.MyEntity_hotelintroinfo;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.MyEntity_traffic;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_photo.MyEntity_photo;
import com.xu.hasee.livewhere.home.hotel_recommend.Fragment2_1Bottom_entitys;
import com.xu.hasee.livewhere.home.hotel_recommend.Fragment2_1_entitys;
import com.xu.hasee.livewhere.home.hotel_recommend.HaoRecommend_entitys;
import com.xu.hasee.livewhere.home.hotel_recommend.RF1Bottoms_entitys;
import com.xu.hasee.livewhere.home.hotel_recommend.RF1Top_entitys;
import com.xu.hasee.livewhere.home.hotel_recommend.Recommend_entitys;
import com.xu.hasee.livewhere.home.hotel_recommend.Txt_pics_entitys;
import com.xu.hasee.livewhere.home.small_strategy.SmallStrategyEntitys2;
import com.xu.hasee.livewhere.home.small_strategy.SmallStrategyEntitys;
import com.xu.hasee.livewhere.home.near_hotel.entity.NearItem;
import com.xu.hasee.livewhere.home.timehotel.TimeHotelEntitys;
import com.xu.hasee.livewhere.home.timehotel.TimeHotelInfoEntitys;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/5/11.
 */
public class JsonUtis {


    private static String picture;

    public static List<MyEntity_location> PareJson(String data) {

        List<MyEntity_location> list = new ArrayList<>();
        MyEntity_location myEntity = new MyEntity_location();
        try {
            JSONObject object = new JSONObject(data);
            JSONObject result = object.getJSONObject("result");
            String address = result.getString("address");
            String ecityid = result.getString("ecityid");
            String zcityid = result.getString("zcityid");
            String cname = result.getString("cname");
			//bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
            String pname = result.getString("pname");
            String short_address = result.getString("short_address");
            list.add(new MyEntity_location(address, zcityid, ecityid, short_address, cname));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<MyEntity_hotelInfo> PaseJsonHoTelInfo(String str) {
        List<MyEntity_hotelInfo> list = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(str);
            JSONObject result = obj.getJSONObject("result");
            JSONArray hotels = result.getJSONArray("hotels");
            for (int i = 0; i < hotels.length(); i++) {
                JSONObject data = hotels.getJSONObject(i);
                String id = data.getString("id");
                String hotelname = data.getString("hotelname");
                // Log.d("xyc", "PaseJsonHoTelInfo: "+hotelname);
                String comment_scores = data.getString("comment_scores");
                String comment_count = data.getString("comment_count");
                String xingji = data.getString("xingji");
                String esdname = data.getString("esdname");
                String min_jiage = data.getString("min_jiage");
                String pic153 = data.getString("pic153");
                list.add(new MyEntity_hotelInfo(pic153, min_jiage, hotelname, comment_scores, comment_count, xingji, esdname, id));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<MyEntity_list_item> PaseJsonListview(String str) {

        // List<MyEntity_zid> myEntity_zid_list=new ArrayList<>();
        List<MyEntity_list_item> list = new ArrayList<>();
        JSONObject obj = null;
        try {
            obj = new JSONObject(str);
            JSONObject result = obj.getJSONObject("result");
            JSONArray rooms = result.getJSONArray("rooms");
            String zid = result.getString("zid");

            for (int i = 0; i < rooms.length(); i++) {
                JSONObject data = rooms.getJSONObject(i);
                String title = data.getString("title");

                String adsl = data.getString("adsl");

                String rid = data.getString("rid");

                String bed = data.getString("bed");

                String area = data.getString("area");
                String floor = data.getString("floor");
                JSONArray img = data.getJSONArray("img");
                JSONObject imgobj = img.getJSONObject(0);
                String spic = imgobj.getString("spic");

                JSONArray plans = data.getJSONArray("plans");
                List<MyEntity_plans> myEntity_planses_list = new ArrayList<>();
                JSONObject plansobj = plans.getJSONObject(0);
                String planname = plansobj.getString("planname");
                String totalprice = plansobj.getString("totalprice");
                String jiangjin = plansobj.getString("jiangjin");
                list.add(new MyEntity_list_item(title, bed, area, adsl, floor, rid, spic, planname, totalprice, jiangjin));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<MyEntity_hotel> PasejsonHoltel(String str) {
        List<MyEntity_hotel> list = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(str);
            JSONObject result = obj.getJSONObject("result");
            String hotelname = result.getString("hotelname");
            String address = result.getString("address");
            String comment_scores = result.getString("comment_scores");
            String xingji = result.getString("xingji");
            String zhuangxiu = result.getString("zhuangxiu");
            String comment_count = result.getString("comment_count");
            JSONArray pictures = result.getJSONArray("pictures");
            String[] picArray = new String[3];
            for (int i = 0; i < pictures.length(); i++) {
                picArray[i] = pictures.get(i).toString();
                Log.d("xyc", "PasejsonHoltel: " + picArray[i]);
            }
            Log.d("xyc", "PasejsonHoltel: " + picArray.toString());
            MyEntity_hotel myEntity_hotel = new MyEntity_hotel(hotelname, address, comment_scores, comment_count, xingji, zhuangxiu, picArray);
            list.add(myEntity_hotel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<MyEntity_comments> PaseJsonComments(String str) {
        List<MyEntity_comments> comments_list = new ArrayList<>();
        List<MyEntity_content> contents_list = new ArrayList<>();
        try {

            JSONObject obj = new JSONObject(str);
            JSONObject result = obj.getJSONObject("result");
            String total = result.getString("total");
            String haopings = result.getString("haopings");
            String badcnts = result.getString("badcnts");
            String midcnts = result.getString("midcnts");
            String piccnts = result.getString("piccnts");
            JSONArray list = result.getJSONArray("list");
            for (int i = 0; i < list.length(); i++) {
                MyEntity_content myEntity_content = new MyEntity_content();
                JSONObject listobj = list.getJSONObject(i);
                String time = listobj.getString("time");
                myEntity_content.setTime(time);
                String username = listobj.getString("username");
                myEntity_content.setUsername(username);
                String content = listobj.getString("content");
                myEntity_content.setContent(content);
                contents_list.add(myEntity_content);
            }
            comments_list.add(new MyEntity_comments(total, haopings, badcnts, midcnts, piccnts, contents_list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return comments_list;
    }

    public static List<GroupEntity> PaseJsonNearby(String str) {
        List<ChildEntity> child_list1 = new ArrayList<>();
        List<ChildEntity> child_list2 = new ArrayList<>();
        List<ChildEntity> child_list3 = new ArrayList<>();
        List<GroupEntity> group_list = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(str);
            JSONObject result = obj.getJSONObject("result");
            JSONArray shop = result.getJSONArray("购物");
            ChildEntity childEntity = null;
            String parent_name = null;
            for (int i = 0; i < shop.length(); i++) {
                JSONObject data = shop.getJSONObject(i);
                String name = data.getString("name");
                String address = data.getString("address");
                String telphone = data.getString("telphone");
                parent_name = data.getString("parent_name");
                String distance = data.getString("distance");
                String picture = data.getString("picture");
                childEntity = new ChildEntity(name, address, distance, picture, telphone);
                child_list1.add(childEntity);
            }
            group_list.add(new GroupEntity(parent_name, child_list1));
            JSONArray food = result.getJSONArray("美食推荐");
            for (int i = 0; i < shop.length(); i++) {
                JSONObject data2 = food.getJSONObject(i);
                String name = data2.getString("name");
                String address = data2.getString("address");
                String telphone = data2.getString("telphone");
                parent_name = data2.getString("parent_name");
                String distance = data2.getString("distance");
                String picture = data2.getString("picture");
                childEntity = new ChildEntity(name, address, distance, picture, telphone);
                child_list2.add(childEntity);
            }
            group_list.add(new GroupEntity(parent_name, child_list2));
            JSONArray play = result.getJSONArray("休闲娱乐");
            for (int i = 0; i < shop.length(); i++) {
                JSONObject data3 = play.getJSONObject(i);
                String name = data3.getString("name");
                String address = data3.getString("address");
                String telphone = data3.getString("telphone");
                parent_name = data3.getString("parent_name");
                String distance = data3.getString("distance");
                String picture = data3.getString("picture");
                childEntity = new ChildEntity(name, address, distance, picture, telphone);
                child_list3.add(childEntity);
            }
            group_list.add(new GroupEntity(parent_name, child_list3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return group_list;
    }

    public static List<MyEntity_hotelintroinfo> PaseJsonintra(String str) {
        List<MyEntity_hotelintroinfo> list = new ArrayList<>();
        List<MyEntity_traffic> myEntityTrafficList=new ArrayList<>();
        JSONObject obj = null;

        try {
            obj = new JSONObject(str);
            JSONObject result = obj.getJSONObject("result");
            JSONArray base = result.getJSONArray("base");
            String[] basestr = new String[base.length()];
            for (int i = 0; i < base.length(); i++) {
                basestr[i] = base.getString(i);
            }
            String hotelservice = result.getString("hotelservice");
            String content = result.getString("content");
            JSONArray traffics = result.getJSONArray("traffics");
            for(int j=0;j<traffics.length();j++){
                JSONObject data=traffics.getJSONObject(j);
                String distance_km=data.getString("distance_km");
                String time_minute=data.getString("time_minute");
                String dayPrice_yuan=data.getString("dayPrice_yuan");
                String traffic_name=data.getString("traffic_name");
               myEntityTrafficList.add(new MyEntity_traffic(distance_km,time_minute,dayPrice_yuan,traffic_name));
            }
            list.add(new MyEntity_hotelintroinfo(basestr,hotelservice,content,myEntityTrafficList));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<MyEntity_photo> PaseJsonPhoto(String str) {
        List<MyEntity_photo> list = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(str);
            JSONObject result = obj.getJSONObject("result");
            JSONArray array = result.getJSONArray("list");
            for (int i = 0; i < array.length(); i++) {
                JSONObject picobj = array.getJSONObject(i);
                String picsmall = picobj.getString("picsmall");
                String title = picobj.getString("title");
               list.add(new MyEntity_photo(title,picsmall));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Recommend_entitys> PaseJsonRecommend(String str) {
        List<Recommend_entitys> list = null;
        try {
            list = new ArrayList<>();
            JSONObject jo = new JSONObject(str);
            JSONArray result = jo.getJSONArray("result");
            for (int i = 0; i < result.length(); i++) {
                JSONObject data1 = result.getJSONObject(i);
                String cityid = data1.getString("cityid");
                String cityname = data1.getString("cityname");
                String reason = data1.getString("reason");
                String picture = data1.getString("picture");
                list.add(new Recommend_entitys(cityid, picture, cityname, reason));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<HaoRecommend_entitys> ParseJsonHaoRecommend(String str) {
        List<HaoRecommend_entitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(str);
            JSONObject result = jo.getJSONObject("result");
            JSONArray list1 = result.getJSONArray("list");
            for (int i = 0; i < list1.length(); i++) {
                int hotelid = list1.getJSONObject(i).getInt("hotelid");
                String hotelname = list1.getJSONObject(i).getString("hotelname");
                String title = list1.getJSONObject(i).getString("title");
                String pic = list1.getJSONObject(i).getString("pic");
                list.add(new HaoRecommend_entitys(hotelid, hotelname, title, pic));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<RF1Top_entitys> ParseJsonRF1(String s) {
        List<RF1Top_entitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(s);
            JSONObject result = jo.getJSONObject("result");
            String picture = result.getString("picture");
            String ctiyname = result.getString("ctiyname");
            long ctrip_dp_num = result.getLong("ctrip_dp_num");
            String descption = result.getString("descption");
            list.add(new RF1Top_entitys(picture, ctiyname, ctrip_dp_num, descption));
            Log.d("Main", "list集合的数据为" + list.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<RF1Bottoms_entitys> ParseJsonRF1Bottoms(String s) {
        List<RF1Bottoms_entitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(s);
            JSONObject result = jo.getJSONObject("result");
            JSONArray cbd_list = result.getJSONArray("cbd_list");
            for (int i = 0; i < cbd_list.length(); i++) {
                JSONObject jo2 = cbd_list.getJSONObject(i);
                String cbd_name = jo2.getString("cbd_name");
                float choosehere = (float) jo2.getInt("choosehere");
                String descption = jo2.getString("descption");
                JSONArray label_list = jo2.getJSONArray("label_list");
                for (int j = 0; j < label_list.length(); j++) {
                    picture = label_list.getJSONObject(i).getString("picture");
                }
                list.add(new RF1Bottoms_entitys(cbd_name, choosehere * 100, descption, picture));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Fragment2_1_entitys> ParseJsonFrgment2_1(String s) {
        List<Fragment2_1_entitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(s);
            JSONObject result = jo.getJSONObject("result");
            String hotelname = result.getString("hotelname");
            String pic = result.getString("pic");
            String content = result.getString("content");
            list.add(new Fragment2_1_entitys(hotelname, pic, content));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Fragment2_1Bottom_entitys> ParseJsonFrgment2_1Bottom(String s) {
        List<Fragment2_1Bottom_entitys> list = new ArrayList<>();
        try {
            String s1 = null;
            JSONObject jo = new JSONObject(s);
            JSONObject result = jo.getJSONObject("result");
            JSONArray list1 = result.getJSONArray("list");
            for (int i = 0; i < list1.length(); i++) {
                JSONObject jo1 = list1.getJSONObject(i);
                String hotel_section_type_name = jo1.getString("hotel_section_type_name");
                JSONArray hotel_section = jo1.getJSONArray("hotel_section");
                for (int j = 0; j < hotel_section.length(); j++) {
                    JSONObject jo2 = hotel_section.getJSONObject(i);
                    JSONArray pics = jo2.getJSONArray("pics");
                    for (int k = 0; k < pics.length(); k++) {
                        s1 = pics.get(0).toString();
                    }
                }
                list.add(new Fragment2_1Bottom_entitys(hotel_section_type_name, s1));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<SmallStrategyEntitys> ParseJsonSmall(String s) {
        List<SmallStrategyEntitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(s);
            JSONObject result = jo.getJSONObject("result");
            JSONArray chuxing = result.getJSONArray("chuxing");
            for (int i = 0; i < chuxing.length(); i++) {
                JSONObject jo2 = chuxing.getJSONObject(i);
                String name = jo2.getString("name");
                String subname = jo2.getString("subname");
                String pic = jo2.getString("pic");
                String kid = jo2.getString("kid");
                list.add(new SmallStrategyEntitys(name, pic, subname, kid));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<SmallStrategyEntitys2> ParseJsonSmall2(String s) {
        List<SmallStrategyEntitys2> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(s);
            JSONObject result = jo.getJSONObject("result");
            JSONArray list1 = result.getJSONArray("list");
            for (int i = 0; i < list1.length(); i++) {
                String title = list1.getJSONObject(i).getString("title");
                String pic = list1.getJSONObject(i).getString("pic");
                list.add(new SmallStrategyEntitys2(title, pic));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;

    }

	  public static List<NearItem> ParseNearHotelItem(String jsonpath){
        List<NearItem>list=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonpath);
            JSONObject result = jsonObject.getJSONObject("result");
            JSONArray array = result.getJSONArray("hotels");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String id=object.getString("id");
                String  picture=object.getString("pic153");
                String hotelname=object.getString("hotelname");
                String type_xingji=object.getString("xingji");
                String esdname=object.getString("esdname");
                String comment_count=object.getString("comment_count");
                String comment_scores=object.getString("comment_scores");
                String price=object.getString("min_jiage");
                String juli=object.getString("juli");

                list.add(new NearItem(comment_count,comment_scores,esdname,hotelname,id,juli,price,picture,type_xingji));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    /* private String hid;
    private String pic153;
    private String hotelname;
    private String comment_scores;
    private int comment_count;
    private String xingji;
    private String price;
    private String unit;*/
    public static List<TimeHotelEntitys> ParseJsonTimeHotel(String str) {
        List<TimeHotelEntitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(str);
            JSONObject result = jo.getJSONObject("result");
            JSONArray hotels = result.getJSONArray("hotels");
            for (int i = 0; i < hotels.length(); i++) {
                JSONObject jo2 = hotels.getJSONObject(i);
                String hid = jo2.getString("hid");
                String esdname=jo2.getString("esdname");
                String pic153 = jo2.getString("pic153");
                String hotelname = jo2.getString("hotelname");
                String comment_scores = jo2.getString("comment_scores");
                int comment_count = jo2.getInt("comment_count");
                String xingji = jo2.getString("xingji");
                String price = jo2.getString("price");
                String unit = jo2.getString("unit");
                list.add(new TimeHotelEntitys(hid, pic153, hotelname, comment_scores, comment_count, xingji, price, unit,esdname));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<TimeHotelInfoEntitys> ParseJsonTimeHotelInfo(String str) {
        List<TimeHotelInfoEntitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(str);
            JSONObject result = jo.getJSONObject("result");
            JSONArray list1 = result.getJSONArray("list");
            for (int i = 0; i < list1.length(); i++) {
                String picsmall = list1.getJSONObject(i).getString("picsmall");
                list.add(new TimeHotelInfoEntitys(picsmall));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<TimeHotelEntitys> ParseAbstraJson(String str){
        List<TimeHotelEntitys> list = new ArrayList<>();
        try {
            JSONObject jo = new JSONObject(str);
            JSONObject result = jo.getJSONObject("result");
            JSONArray hotels = result.getJSONArray("hotels");
            for (int i = 0; i < hotels.length(); i++) {
                JSONObject jo2 = hotels.getJSONObject(i);
                String pic153 = jo2.getString("pic153");
                String hotelname = jo2.getString("hotelname");
                String esdname=jo2.getString("esdname");
                String comment_scores = jo2.getString("comment_scores");
                int comment_count = jo2.getInt("comment_count");
                String xingji = jo2.getString("xingji");
                String price = jo2.getString("min_jiage");
                list.add(new TimeHotelEntitys(pic153, hotelname, comment_scores, comment_count, xingji, price,esdname));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;

    }

}
