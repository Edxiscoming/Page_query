# Page_query
分页显示数据库数据
##此次项目中使用到的两个DButil封装结果的对象：
    DbUtils提供的封装结果的一些对象：
    1.	BeanListHandler: 查询返回list集合，集合元素是指定的对象
     // 2）BeanListHandler: 查询返回list集合，集合元素是指定的对象
     public void testQueryMany() throws Exception {
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// 查询全部数据
		List<Admin> list = qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
		System.out.println(list);
		conn.close();
		}
	
    2.	ScalarHandler: 查询返回结果记录的第一行的第一列  (在聚合函数统计的时候用)
    //	5) ScalarHandler 查询返回结果记录的第一行的第一列  (在聚合函数统计的时候用)
    public void testArray() throws Exception {
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		// 查询 
		List<Object[]> list = qr.query(conn, sql, new ArrayListHandler());
    Long num = qr.query(conn, sql, new ScalarHandler<Long>();		
		conn.close();
    }

