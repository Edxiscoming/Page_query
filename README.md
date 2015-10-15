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
    
##这次项目的总结：
1.此次项目主要是从数据库得到数据，使用DBUtil组件的QueryRunner对象的query（）方法。其中涉及到对QueryRunner的熟练使用，还非常欠缺。
2.建立PageBean工具。以这个对象保存从页面传过来的几个参数，比如当前页、显示的数据、共有多少页面等等，全部都放在这个对象里。
3.项目参与三层结构jsp->servlet->service->dao。。三层结构我不够熟练，所以操作起来非常缓慢。
4.前端展示那块自己也非常欠缺，之前的看的视频没有效果。
