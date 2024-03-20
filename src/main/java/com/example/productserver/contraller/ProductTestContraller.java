package com.example.productserver.contraller;

import com.example.productserver.vo.User;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("/productTestContraller")
public class ProductTestContraller {

    private static Log log= LogFactory.getLog(ProductTestContraller.class);

    @GetMapping("/updateStore")
    public String updateStore(String productNo){
        System.out.println("8083======");
        log.info("product-updateStore-----------");
        //尽量使用自动锁代替手写锁
        //设置锁的超时时间。防止对象一直占有锁，造成死锁
        //降低锁的使用粒度，尽量不要多个功能使用同一把锁

        //解决死锁
        //使用jstack工具检测死锁，打印处死锁的线程的堆栈信息，从而找出造成死锁的原因，想办法解决死锁。

        //java的序列化是将对象的状态保存在内存中，并且可以把保存的对象状态读取出来

        //java中需要进行序列化的情况
        //1.需要把内存中的对象状态保存到一个文件中或者数据库中
        //2.需要使用套接字进行远程传输的时候
        //3.在进行远程方法调用的时候

        //spring注入的3种方式
        //1.注解注入
        //2.set方法注入
        //3.构造方法注入

        //springboot自动配置的原理
        //在springboot项目的启动类上配置@springbootApplication或者配置EnableAutoConfigration
        //然后程序会自动去maven中获取所有starter中的spring.factories文件，该文件中就可以获取到所有spring容器中的所有Bean
        //springboot集成mybatis
        //1.在pom文件中引入mybatis
        //2.在项启动类上配置组件扫描注解，扫描Mapper包下的内容
        //3.在Mapper包下编写Mapper
        //4.创建mybatis的映射xml文件，在该文件中配置namespace为对应的Mapper的路径，并且编写sql语句的id需要和Mapper中对应的接口方法要一致

        //简历索引的原则
        //1.表的主外键上需要简历索引
        //2.数据量小的表一般不建索引
        //3.在小字段上建立索引，大字段不建立索引
        //4.一般先存数据，再建立索引，因为建索引后，插入数据会慢
        //5.在查询操作频繁使用的字段上建立索引

        //sql优化
        //1.避免使用select *
        //2.能批量操作的地方尽量批量操作
        //3.in中的值不要太多
        //4.join的表不要过多
        //5.索引的控制
        //6.索引的优化
        //7.能使用limit的地方尽量使用
        //8.字段类型的选择

        //索引失效的情况
        //1.查询条件中使用了or，即使部分条件使用了索引也会失效
        //2.查询条件中使用了like的时候，以%开头
        //3.索引列类型为字符串时，该列的值没有用引号时，索引会失效
        //4.索引列参与了函数计算
        //5.违背了最左匹配原则

        //sql语句包含了哪几部分
        //DDL DML DCL DQL
        //DDL 数据定义  create drop
        //DML 数据操纵 delete insert
        //DCL 数据控制 grant revoke
        //DQL 数据查询 select

        return "调用product应用成功！";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }


    public static void main(String[] str){
        StringBuffer sb = new StringBuffer();
        sb.append("abcd");
        System.out.println(sb.reverse());

        Map map = new HashMap();
        map.put(null,null);
        map.put("name","value");
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        User user = new User();
        user.setUser_no("1111");
        user.setUser_name("zhangsan");
        user.setUser_female("0");

        byte[] b = SerializationUtils.serialize(user);
        System.out.println(b);
        User u = SerializationUtils.deserialize(b);
        System.out.println(u.getUser_name());

        System.out.println(user.getUser_age());

        Integer i ;
        Character c;
        String ss = "";
        ss.length();
        String[] strss = new String[5];
        int ll = strss.length;
        List list = new ArrayList<String>();
        list.size();

    }
}
