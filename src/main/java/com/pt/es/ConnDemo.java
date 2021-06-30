package com.pt.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author nate-pt
 * @date 2021/6/29 16:52
 * @Since 1.8
 * @Description 测试java链接es
 */
public class ConnDemo {


    public static void main(String[] args) throws UnknownHostException {
        // 设置es的集群信息
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();

        // 设置链接的地址和端口信息
        // 此处通过netty进行tcp链接 应该设置配置文件中的tcp对应的端口号
        TransportClient transportClient = new PreBuiltTransportClient(settings).
                addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300));

        // 获取所有的节点
        List<DiscoveryNode> discoveryNodes = transportClient.connectedNodes();

        discoveryNodes.forEach(System.out::println);

    }


}
