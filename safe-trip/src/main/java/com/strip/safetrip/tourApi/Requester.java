package com.strip.safetrip.tourApi;

import com.strip.safetrip.domain.Travel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Requester {

    private String key = "RoJyTgUWpMDgJ39gZdvmM3+fYKo9E5r7GnXNGk7yHs/TqCbVCKcB6Ucuqc4fUVtoI5yBL2vHsdBCBlUk02GsEw==";

    public List<Travel> getAreaBasedList(String listYN, String arrange, int contentTypeId, int sigunguCode) throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/

        String myKey = "RoJyTgUWpMDgJ39gZdvmM3+fYKo9E5r7GnXNGk7yHs/TqCbVCKcB6Ucuqc4fUVtoI5yBL2vHsdBCBlUk02GsEw==";
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(key, "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("SafeTrip", "UTF-8")); /*서비스명=어플명*/

        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*지역코드*/
        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode(listYN, "UTF-8")); /*목록 구분 (Y=목록, N=개수)*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode(arrange, "UTF-8")); /*A=제목순*/
        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode(String.valueOf(contentTypeId), "UTF-8")); /*관광 타입*/
        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode(String.valueOf(sigunguCode), "UTF-8")); /*시군구코드*/
        urlBuilder.append("&_type=json");

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        String line;
        Pattern p = Pattern.compile("(\"title\":\"[^\"]+\")");
        StringBuilder sb = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }

        rd.close();
        conn.disconnect();

        String jsonString = sb.toString();
        JSONObject jObject = new JSONObject(jsonString).getJSONObject("response")
                .getJSONObject("body").getJSONObject("items");
        JSONArray jArray = jObject.getJSONArray("item");

        List<Travel> list = new ArrayList<>();

        for (int i = 0; i < jArray.length(); i++) {
            JSONObject obj = jArray.getJSONObject(i);
            String title = obj.getString("title");
            Long id = obj.getLong("contentid");
            Travel t = new Travel();
            t.setName(title);
            t.setTravel_no(id);
            t.setField_no(sigunguCode);
            if (contentTypeId == 12) {
                t.setInside(false);
            } else {
                t.setInside(true);
            }
            list.add(t);
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        new Requester().getAreaBasedList("Y", "A", 14, 1);
    }
}
