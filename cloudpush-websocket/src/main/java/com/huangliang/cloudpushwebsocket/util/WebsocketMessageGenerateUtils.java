package com.huangliang.cloudpushwebsocket.util;

import com.alibaba.fastjson.JSONObject;
import com.huangliang.api.constants.Constants;
import com.huangliang.api.entity.WebsocketMessage;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 消息对象构建类
 */
public class WebsocketMessageGenerateUtils {

    public static WebsocketMessage generateWebsocketMessage(String channelId, JSONObject msgJson){
        return generateWebsocketMessage(channelId,null,null,msgJson);
    }

    public static WebsocketMessage generateWebsocketMessage(String channelId, String requestId, JSONObject msgJson){
        return generateWebsocketMessage(channelId,requestId,null,msgJson);
    }

    //根据mq中的内容构建发送消息
//    public static WebsocketMessage generateWebsocketMessage(MessageExt msg){
//        return generateWebsocketMessage(msg.getTags(),null,null,new String(msg.getBody()));
//    }

    //根据请求中的参数构建发送消息
    public static WebsocketMessage generateWebsocketMessage(String channelId,String requestId,String msgId,JSONObject msgJson){
        WebsocketMessage websocketMsg = new WebsocketMessage(
                msgId,
                WebsocketMessage.Type.BUSSINESS.code,
                channelId,
                msgJson,
                Constants.SYSTEM,
                WebsocketMessage.Trigger.HTTP.code
        );
        return websocketMsg;
    }
}
