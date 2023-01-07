package me.ulearn;

import java.sql.SQLException;
import java.sql.Statement;

public class Product {
    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private OrderPriority orderPriority;
    private String orderDate;
    private long unitsSold;
    private float totalProfit;

    public Product(String[] array) {
        this.region = array[0];
        this.country = array[1];
        this.itemType = array[2];
        this.salesChannel = array[3];
        this.orderPriority = OrderPriority.valueOf(array[4]);
        this.orderDate = array[5];
        this.unitsSold = Long.parseLong(array[6]);
        this.totalProfit = Float.parseFloat(array[7]);

    }

    public void save(Statement s) throws SQLException {
        var sql = String.format("insert into Products(region,country,itemType,salesChannel,orderPriority,orderDate,unitsSold,totalProfit) values ('%s','%s','%s','%s','%s','%s',%s,%s)",
                region,country,itemType,salesChannel,orderPriority,orderDate,unitsSold,totalProfit);
        System.out.println(sql);
        s.executeUpdate(sql);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public OrderPriority getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(OrderPriority orderPriority) {
        this.orderPriority = orderPriority;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public long getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(long unitsSold) {
        this.unitsSold = unitsSold;
    }

    public float getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", itemType='" + itemType + '\'' +
                ", salesChannel='" + salesChannel + '\'' +
                ", orderPriority=" + orderPriority +
                ", orderDate='" + orderDate + '\'' +
                ", unitsSold=" + unitsSold +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
