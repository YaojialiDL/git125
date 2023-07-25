用spring组装一个biz层+dao层操作:
1. Dao接口 + JdbcDao实现类
     public interface UserDao{
              public void add(   String uname );
    }
2. Biz接口 + Biz实现类
    public interface UserBiz{
            public void addUser( String name);
   }

   Biz实现类  里面必须有  Dao层的依赖.
3. 写一个测试类，用spring组装以上的代码 .
