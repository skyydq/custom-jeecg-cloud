package org.jeecg.common.constant;

/**
 * @author: huangxutao
 * @date: 2019-06-14
 * @description: 缓存常量
 */
public interface CacheConstant {

	/**
	 * 字典信息缓存
	 */
    public static final String SYS_DICT_CACHE = "sys:cache:dict";
	/**
	 * 表字典信息缓存
	 */
    public static final String SYS_DICT_TABLE_CACHE = "sys:cache:dictTable";

	/**
	 * 数据权限配置缓存
	 */
    public static final String SYS_DATA_PERMISSIONS_CACHE = "sys:cache:permission:datarules";

	/**
	 * 缓存用户信息
	 */
	public static final String SYS_USERS_CACHE = "sys:cache:user";

	/**
	 * 缓存用户jwt
	 */
	public static final String SYS_USERS_CACHE_JWT = "sys:cache:user:jwt";

	/**
	 * 全部部门信息缓存
	 */
	public static final String SYS_DEPARTS_CACHE = "sys:cache:depart:alldata";


	/**
	 * 全部部门ids缓存
	 */
	public static final String SYS_DEPART_IDS_CACHE = "sys:cache:depart:allids";


	/**
	 * 测试缓存key
	 */
	public static final String TEST_DEMO_CACHE = "test:demo";

	/**
	 * 字典信息缓存
	 */
	public static final String SYS_DYNAMICDB_CACHE = "sys:cache:dbconnect:dynamic:";

	/**
	 * gateway路由缓存
	 */
	public static final String GATEWAY_ROUTES = "geteway_routes";


	/**
	 * gateway路由 reload key
	 */
	public static final String ROUTE_JVM_RELOAD_TOPIC = "gateway_jvm_route_reload_topic";

}
