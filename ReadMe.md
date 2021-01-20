#### 项目采用mvvm+jetpack谷歌标准框架
![google.png](https://i.loli.net/2021/01/20/ArXRlbCw5W4heTD.png)  

1. activity/fragment是面向viewModel(liveData)编程
2. viewModel直接调用仓库
3. 仓库调用数据库或者远程服务器获取数据


#### 项目分层详解：    
![dia.png](https://i.loli.net/2021/01/20/m3VPSgR5TjzUvL4.png)
整体项目分（app壳和commonutils）,也可以说是moduler app和modeuler commonUtils  

1. app内部也有各种util,此处utils是服务于app这个module
2. 外部的moduler commonutils是通用utils，可服务于不同moduler
3. 每一个业务模块对应两个ViewModel，一个负责获取数据，另一个负责控制layout


#### 项目流程详解  
![jiagou.png](https://i.loli.net/2021/01/20/B5GscNQp8EIFVLl.png)
  
  
1. layout全部交给databinding管理，然后对应的activity和fragment在绑定databinding
2. 点击事件采用内部类方式，没有封装在databinding中为了更好的获取外部activity/frag环境
3. 发起网络请求RequestViewModel由数据和函数(获取livedata函数+获取仓库数据函数)组成
4. 发起网络请求会把liveData传过去，获取到数据后采用liveData.postValue()方式通知activity的观察者更新ui
5. activity在getLiveData.observe中对数据的可用性进行判断后调用HomeViewModel来改变ui。

#### 优缺点 
databinding不好调试，但是大厂用的多  
  
 
数据驱动方式，不需要设置回调，数据可以直接监听驱动，观察者  
规避了mvp模式接口地狱问题
