// Copyright (C) 2017 Meituan
// All rights reserved
package com.aurora.es;

import com.google.common.net.InetAddresses;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;

import java.io.IOException;
import java.util.Map;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/9/29 下午6:50
 **/
public class ESClient {
    TransportClient transportClient;

    static String index = "website";

    static String type = "blog";

    public ESClient() {
        initClient();
    }

    private void initClient() {

        if (transportClient == null) {
            /**
             * 1:通过 setting对象来指定集群配置信息
             */
            Settings setting = Settings.builder()
                    .put("cluster.name", "aurora.cluster")//指定集群名称
                    .put("client.transport.sniff", true)//启动嗅探功能
                    .build();

            /**
             * 2：创建客户端
             * 通过setting来创建，若不指定则默认链接的集群名为elasticsearch
             * 链接使用tcp协议即9300
             */
            transportClient = TransportClient.builder().settings(setting).build();
            TransportAddress transportAddress = new InetSocketTransportAddress(InetAddresses.forString("127.0.0.1"), 9300);
            transportClient.addTransportAddresses(transportAddress);
        }
    }

    public void close() {
        if (transportClient != null) {
            transportClient.close();
        }
    }

    public String getJson(Map<String, Object> map) throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();

        for(Map.Entry<String, Object> entry : map.entrySet()){
            builder.field(entry.getKey(), entry.getValue());
        }

        builder.endObject();
        return builder.string();
    }

    /**
     * 获取索引库文档总数
     *
     * @return
     */
    public long getDocCount() {
        return transportClient.prepareCount(index).get().getCount();
    }

    public String getDoc(){
        GetResponse getResponse = transportClient.prepareGet(index, type, "AV7NgWk6vawRJir-PH_y").get();
        return getResponse.getSourceAsString();
    }

    public void addDoc(String json){
        IndexResponse indexResponse = transportClient.prepareIndex(index, type).setSource(json).get();
        System.out.println(indexResponse.getVersion());
    }

    public SearchRequestBuilder getSearchRequestBuilder(String index, String type){
        return transportClient.prepareSearch(index).setTypes(type);
    }

    public static void main(String[] args) throws IOException {
        ESClient client = new ESClient();
//        System.out.println(client.getDoc());
//        client.addDoc("{\"title\":\"My blog entry\",\"text\":\"加一个\",\"date\":\"2017/07/16\"}");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("title", "111");
//        map.put("text", "嘻嘻嘻");
//        map.put("date", sdf.format(new Date()));
//        System.out.println(client.getJson(map));
//        client.addDoc(client.getJson(map));
        SearchRequestBuilder searchRequestBuilder = client.getSearchRequestBuilder(index, type);
        SearchResponse myresponse = searchRequestBuilder.setQuery(QueryBuilders.matchPhraseQuery("text", "加一个")).setFrom(0).setSize(10).setExplain(true).execute().actionGet();
        System.out.println(myresponse.getContext());
    }
}
