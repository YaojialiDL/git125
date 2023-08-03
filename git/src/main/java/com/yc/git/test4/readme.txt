需求:
   原有的DBHelper类的几个缺点分析:
     1. 每调用一次 jdbc操作，开关联接一次,   没有联接池机制.  性能不高
     2. 在查询操作时，我们采用了反射机制封装代码，性能低， 且对一些特殊类型数据 没有做相应的处理.

解决方案:
   对问题一， 重新包装  jdbc的Connection对象， 可以引入联接池机制，对外公开:
           getConnection()方法， 在方法中可以从联接池中取 Connection
           returnConnection() 用完不关闭Connection,只返回到联接池( 用状态来控制即可 )

         class MyConnection
           Connection con;
           boolean statue;  //  true在用  false空闲

         class  MyDataSource implemets DataSource{
                  同步List<MyConnection> pool;

                  //配置后注入      结合属性文件完成注入操作.
                  int coreSize;
                  String username;
                  String password;
                  String url;


                  Connection getConnection(){
                      从联接池pool中随机取一个空闲的Connection
                  }

                  void returnConnection(  Connection  ){
                      此connection对应的  MyConnection设为false.
                  }
         }



   对问题二:  将查询方法重写，对一条ResultSet的处理 提取出来，交由用户来完成即可.
            定义一个RowMapper接口，由用户完成对一行ResultSet数据的处理. 不再用反射完成.

           interface RowMapper{
                public T mapper( ResultSet rs, int i  );
           }


写一个类使用到你上面新定义的JdbcTemplate类，并用 spring组装.

     abstract class JdbcTemplate{
          public List<T> find(  String sql, Object.... params){
                List<T> list=new ArrayList<T>();
                    //1.联接池中获取联接
                       myDataSource.getConnection();
                    //2. 创建语句对象 PreparedStatement
                    //3. 设置参数
                    //4. 查询
                        ResultSet rs=preparedStatement.executeQuery(   );
                    //5. 循环resultSet
                        int i=0;
                         while( rs.next()){
                               T t=mapper(   rs,   i );
                               i++;
                               list.add( t );
                         }
                         return list;
           }
     }


请写一个类，查询银行账户.   用spring组装整个项目.