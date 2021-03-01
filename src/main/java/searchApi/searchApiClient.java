package searchApi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import searchApi.out.*;


public class searchApiClient {
    private final String host = "172.20.176.212";
    private final int port = 6692;
    @Autowired
    SearchService.Client client;
    @Autowired
    Context context;
    @Autowired
    CommonRequest commonRequest;
    public void searchApi() throws TException {
        String str = "{'size':20,'posFrom':0,'query':'上海'}";
        SearchRequest searchRequest = JSON.parseObject(str,SearchRequest.class);
        SearchResponse response = client.search(context,searchRequest,commonRequest);
        System.out.println(response);
    }

    public static void main(String[] args){
        try {
            new searchApiClient().searchApi();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public SearchService.Client getClient(){
        Context context = new Context();
        CommonRequest commonRequest = new CommonRequest();
        TTransport transport = new TSocket(host,port);
        TProtocol tProtocol = new TBinaryProtocol(transport);
        SearchService.Client.Factory factory = new SearchService.Client.Factory();
        SearchService.Client client = factory.getClient(tProtocol);
        return client;
    }

    @Bean
    public Context getContext(){
        return new Context();
    }

    @Bean
    public CommonRequest getCommonRequest(){
        return new CommonRequest();
    }

}
