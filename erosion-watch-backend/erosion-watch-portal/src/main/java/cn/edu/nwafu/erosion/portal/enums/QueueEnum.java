package cn.edu.nwafu.erosion.portal.enums;

/**
 * @author Huang Z.Y.
 */
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_EXCEL_UPDATE("erosion.excel.direct", "erosion.excel.update", "erosion.excel.update"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_EXCEL_UPDATE("erosion.excel.direct.ttl", "erosion.excel.update.ttl",
            "erosion.excel.update.ttl");

    private final String exchange;
    /**
     * 队列名称
     */
    private final String name;
    /**
     * 路由键
     */
    private final String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getName() {
        return name;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
    