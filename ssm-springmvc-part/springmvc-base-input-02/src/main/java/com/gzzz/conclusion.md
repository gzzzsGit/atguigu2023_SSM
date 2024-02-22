# springmvc接收参数总结
---
### 一、路径设置
> @RequestMapping(value="地址",method="方法")
> @GetMapping @PostMapping 
### 二、接收参数
1. param接收
> 直接接收 handler(类型 形参名) 形参名 = 请求参数名 
> 注解指定 handler(@RequestParam(name="请求参数名",required=true,defaultValue="默认值"))
> 一名多值 handler(@RequestParam List key)
> 实体接收 handler(实体 对象)  要求：对象的属性名=请求参数名
2. 路径参数
> 设置动态路径和标识 /{key}/info/{key}
> 接收路径 handler(@PathVariable("动态路径key) 类型 形参名)
3. json接收       
> 数据接收 handler(@RequestBody 实体类 对象)
> 需要做的准备工作: 1. 导入jackson依赖 2.@EnableWebMvc(加入了handlerMapping 加入了handlerAdapter 给handlerAdapter配置了json处理器)
### 三、cookie接收
> handler(@CookieValue("cookie的名字"))
### 四、请求头获取
> handler(@RequestHeader("请求头字段的名字""))
### 五、原生api获取
> handler(HttpServletRequest,response,session)
> ServletContext -> ioc ->声明全局变量@AutoWired即可
### 六、共享域获取
> 使用原生api方式即可