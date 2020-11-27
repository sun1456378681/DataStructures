package com.paogu.pool;

/**
 * 自定义连接池类 getInstance()，返回Pool的唯一实例，第一次调用时将执行构造函数
 * 构造函数Pool()调用驱动装在loadDrivers（）函数，createPool（）函数创建连接池，loadDrivers（）装载驱动
 * getConnection（）返回一个连接池示例，getConnection（long time）添加时间限制
 * freeConnection（Connection con）将con连接实例返回连接池，getNum（）返回空闲连接数
 * getNumActive（）返回当前使用的连接数
 *
 *
 * @author eric
 * @since 2020/11/11 9:34
 */
public class Pool {
}
